package cn.edu.scnu.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.scnu.po.OrderItem;
import cn.edu.scnu.po.Orders;
import cn.edu.scnu.po.Products;
import cn.edu.scnu.po.User;
import cn.edu.scnu.pojo.MyCart;
import cn.edu.scnu.pojo.OrderInfo;
import cn.edu.scnu.service.CartService;
import cn.edu.scnu.service.OrderService;
import cn.edu.scnu.service.ProductsService;

@Controller("orderController")
@RequestMapping("/order")
public class OrderController extends BaseController{
	
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductsService productsService;
	
	@RequestMapping("/order_add")
	public String order_add(String cartIds, Model model) {
		// 1.�����ﳵ������ѡ����Ʒ��cartID����������ַ������Ϊ����
		String[] arrCartIds = cartIds.split(",");
		
		List<MyCart> carts = new ArrayList<MyCart>();
		// 2.�������飬����cartID��Ų��ҹ��ﳵ����ӵ�carts��
		for (String cid : arrCartIds) {
			Integer cartID = Integer.parseInt(cid);
			MyCart cart = cartService.findByCartID(cartID);
			carts.add(cart);
		}
		model.addAttribute("carts", carts);
		model.addAttribute("cartIds", cartIds);
		return ("order_add");
	}
	
	@RequestMapping("/addOrder")
	public String addOrder(String receiverinfo, String cartIds, HttpSession session) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		Timestamp timeStamp = Timestamp.valueOf(time);
		User user = (User)session.getAttribute("user");
		String orderId = UUID.randomUUID().toString();
		Orders myOrder = new Orders(orderId, null, receiverinfo, 0, timeStamp, user.getId(),0,0);	// paystateĬ����0����ʾδ֧��
		orderService.addOrder(cartIds, myOrder);
		return "forward:/order/showorder";
	}
	
	@RequestMapping("/showorder")
	public String showorder(HttpSession session, Model model) {
		// 1.��ȡ��ǰ��¼�û�
		User user = (User)session.getAttribute("user");
		// 2.�����û�id��ѯ���û������ж�����Ϣ����ѯorders��
		List<OrderInfo> orderInfoList = findOrderInfoByUserId(user.getId());
		// 3.�����û������ж�����Ϣ��list���ϴ���request���У�ת����order_list.jsp����ʾ
		model.addAttribute("orderInfos", orderInfoList);
		return "order_list";
	}
	
	private List<OrderInfo> findOrderInfoByUserId(Integer userId) {
		List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
		// 1.�����û�id��ѯ���û������ж�����Ϣ����ѯorders��
		List<Orders> orderList = orderService.findOrderByUserId(userId);
		// 2.����ÿһ��������ͨ������id��ѯ��ǰ�����а��������ж�������Ϣ
		for (Orders order : orderList) {
			// �����û�order_id��ѯ�ö����ŵ����ж�������Ϣ����ѯorderitem��
			List<OrderItem> orderitems = orderService.orderitem(order.getId());
			// 3.����ÿһ�������ͨ���������ȡ��Ʒ��Ϣ����Ʒ�Ĺ�������
			Map<Products, Integer> map = new HashMap<Products, Integer>();
			for (OrderItem orderItem : orderitems) {
				// 3.1.��ȡ��Ʒid��ͨ����Ʒid��ѯ��Ʒ��Ϣ������Product����
				Products product = productsService.oneProduct(orderItem.getProduct_id());
				// 3.2.����Ʒ��Ϣ�͹�����������map��
				map.put(product, orderItem.getBuynum());
			}
			// 4.��������Ϣ�����еĶ�������Ϣ����OrderInfo��
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrder(order);
			orderInfo.setMap(map);
			// 5.��һ�������Ķ�����Ϣ����List������
			orderInfoList.add(orderInfo);
		}
		return orderInfoList;
	}
	
	@RequestMapping("/delorder")
	public String delorder(String id, Model model) {
		orderService.delorder(id);
		return "redirect:/order/showorder";
	}
	
	@RequestMapping("/payorder")
	public String payorder(String id, Model model) {
		orderService.payorder(id);
		return "redirect:/order/showorder";
	}
	
	@RequestMapping("/confirm")
	public String confirm(String id, Model model) {
		orderService.confirm(id);
		return "redirect:/order/showorder";
	}

}
