package cn.edu.scnu.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.scnu.po.Category;
import cn.edu.scnu.po.OrderItem;
import cn.edu.scnu.po.Orders;
import cn.edu.scnu.po.Products;
import cn.edu.scnu.po.User;
import cn.edu.scnu.pojo.MyCategory;
import cn.edu.scnu.pojo.MyProducts;
import cn.edu.scnu.pojo.OrderInfo;
import cn.edu.scnu.service.OrderService;
import cn.edu.scnu.service.ProductsService;

@Controller("productsControllerAdmin")
@RequestMapping("/admin")
public class ProductsControllerAdmin {

	@Autowired
	private ProductsService productsService;
	@Autowired
	private OrderService orderService;
//	�����Ʒ
	@RequestMapping("/addprod")
	public String addprod(Model model) {
		// ������Ʒ�������е���Ʒ�б�
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		model.addAttribute("myproducts", new MyProducts());
		return "admin/add_prod";
	}
//	�����Ʒ���
	@RequestMapping("/addcategory")
	public String addcategory(Model model) {
		// ������Ʒ�������е���Ʒ�б�
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		return "admin/add_category";
	}
//	������ӵ���Ʒ
	@RequestMapping("/savecategory")
	public String savecategory(@Valid @ModelAttribute MyCategory mycategory, Model model) throws Exception {
		String msg = productsService.savecategory(mycategory);
		model.addAttribute("msg", msg);
		return "redirect:/admin/addcategory";
	}
//	������ӵ���Ʒ���
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute MyProducts myproducts, HttpServletRequest request, Model model) throws Exception {
		String msg = productsService.save(myproducts, request);
		model.addAttribute("msg", msg);
		return "redirect:/admin/addprod";
	}
	
//	�޸���Ʒ
	@RequestMapping("/update")
	public String update(@Valid @ModelAttribute MyProducts myproducts, HttpServletRequest request, Model model,String pid) throws Exception {
		String msg = productsService.update(pid,myproducts, request);
		model.addAttribute("msg", msg);
		return "redirect:/admin/prodlist";
	}
	
//	�޸���Ʒ���
	@RequestMapping("/updateCategory")
	public String updateCategory(@Valid @ModelAttribute MyCategory mycategory, Model model,Integer pid) throws Exception {
		String msg = productsService.updateCategory(pid,mycategory);
		model.addAttribute("msg", msg);
		return "redirect:/admin/categorylist";
	}
	
//	��Ʒ����  ����prod_list
	@RequestMapping("/prodlist")
	public String prodlist(Model model) {
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		// ����map ���ڴ�Ų�ѯ����
		Map<String, Object> map = new HashMap<>();
		map.put("minPrice", 0);
		map.put("maxPrice", 999999999);
		// ����������ѯ������������Ʒ��Ϣ
		List<Products> products = productsService.prodlist(map);
		// ��ѯ�����¶��ǰ��
		model.addAttribute("products", products);
		return "admin/prod_list";
		
	}
//	��Ʒ����  ɾ����Ʒ
	@RequestMapping("/delprod")
	public String delprod(String pid,Model model) {
		productsService.deleteproduct(pid);
		return "redirect:/admin/prodlist";
	}
	
	@RequestMapping("/upprod")
	public String upprod(String pid,Model model) {
		Products product = productsService.oneProduct(pid);
		model.addAttribute("product", product);
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		return "admin/update_prod";
	}
	
	@RequestMapping("/upcate")
	public String upcate(String pid,Model model) {
		Category category = productsService.oneCategory(pid);
		model.addAttribute("category", category);
		return "admin/update_category";
	}
	
//	��Ʒ������ categorylist
	@RequestMapping("/categorylist")
	public String categorylist(Model model) {
		// �������е���Ʒ����
		List<Category> categorys = productsService.allcategorys();
		// ��ѯ�����¶��ǰ��
		model.addAttribute("categorys", categorys);
		return "admin/category_list";
	}
	
//	��Ʒ������  ɾ����Ʒ���
	@RequestMapping("/delcategory")
	public String delcategory(String id,Model model) {
		productsService.deletecategory(id);
		return "redirect:/admin/categorylist";
	}
	
//	�������� orderlist,�˴�Ϊ��ʾ
	@RequestMapping("/orderlist")
	public String showorder(Model model) {
		// 1. ��ѯorders��������ж�����Ϣ
		List<OrderInfo> orderInfoList = findOrderInfo();
		// 2.�����ж�����Ϣ��list���ϴ���request���У�ת����order_list.jsp����ʾ
		model.addAttribute("orderInfos", orderInfoList);
		return "admin/order_list";
	}
	
	private List<OrderInfo> findOrderInfo() {
		List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
		// 1.��ѯorders��������ж�����Ϣ
		List<Orders> orderList = orderService.findOrder();
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
	
//	����
	@RequestMapping("/sendorder")
	public String sendorder(String id, Model model) {
		orderService.sendorder(id);
		return "redirect:/admin/orderlist";
	}
	
}
