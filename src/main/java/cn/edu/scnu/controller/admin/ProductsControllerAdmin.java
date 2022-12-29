package easymall.controller.admin;

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

import easymall.po.Category;
import easymall.po.OrderItem;
import easymall.po.Orders;
import easymall.po.Products;
import easymall.po.User;
import easymall.pojo.MyCategory;
import easymall.pojo.MyProducts;
import easymall.pojo.OrderInfo;
import easymall.service.OrderService;
import easymall.service.ProductsService;

@Controller("productsControllerAdmin")
@RequestMapping("/admin")
public class ProductsControllerAdmin {

	@Autowired
	private ProductsService productsService;
	@Autowired
	private OrderService orderService;
//	添加商品
	@RequestMapping("/addprod")
	public String addprod(Model model) {
		// 查找商品表中所有的商品列表
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		model.addAttribute("myproducts", new MyProducts());
		return "admin/add_prod";
	}
//	添加商品类别
	@RequestMapping("/addcategory")
	public String addcategory(Model model) {
		// 查找商品表中所有的商品列表
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		return "admin/add_category";
	}
//	保存添加的商品
	@RequestMapping("/savecategory")
	public String savecategory(@Valid @ModelAttribute MyCategory mycategory, Model model) throws Exception {
		String msg = productsService.savecategory(mycategory);
		model.addAttribute("msg", msg);
		return "redirect:/admin/addcategory";
	}
//	保存添加的商品类别
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute MyProducts myproducts, HttpServletRequest request, Model model) throws Exception {
		String msg = productsService.save(myproducts, request);
		model.addAttribute("msg", msg);
		return "redirect:/admin/addprod";
	}
	
//	修改商品
	@RequestMapping("/update")
	public String update(@Valid @ModelAttribute MyProducts myproducts, HttpServletRequest request, Model model,String pid) throws Exception {
		String msg = productsService.update(pid,myproducts, request);
		model.addAttribute("msg", msg);
		return "redirect:/admin/prodlist";
	}
	
//	修改商品类别
	@RequestMapping("/updateCategory")
	public String updateCategory(@Valid @ModelAttribute MyCategory mycategory, Model model,Integer pid) throws Exception {
		String msg = productsService.updateCategory(pid,mycategory);
		model.addAttribute("msg", msg);
		return "redirect:/admin/categorylist";
	}
	
//	商品管理  返回prod_list
	@RequestMapping("/prodlist")
	public String prodlist(Model model) {
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		// 创建map 用于存放查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("minPrice", 0);
		map.put("maxPrice", 999999999);
		// 根据条件查询符合条件的商品信息
		List<Products> products = productsService.prodlist(map);
		// 查询结果暴露给前端
		model.addAttribute("products", products);
		return "admin/prod_list";
		
	}
//	商品管理  删除商品
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
	
//	商品类别管理 categorylist
	@RequestMapping("/categorylist")
	public String categorylist(Model model) {
		// 查找所有的商品种类
		List<Category> categorys = productsService.allcategorys();
		// 查询结果暴露给前端
		model.addAttribute("categorys", categorys);
		return "admin/category_list";
	}
	
//	商品类别管理  删除商品类别
	@RequestMapping("/delcategory")
	public String delcategory(String id,Model model) {
		productsService.deletecategory(id);
		return "redirect:/admin/categorylist";
	}
	
//	订单管理 orderlist,此处为显示
	@RequestMapping("/orderlist")
	public String showorder(Model model) {
		// 1. 查询orders表里的所有订单信息
		List<OrderInfo> orderInfoList = findOrderInfo();
		// 2.将所有订单信息的list集合存入request域中，转发到order_list.jsp中显示
		model.addAttribute("orderInfos", orderInfoList);
		return "admin/order_list";
	}
	
	private List<OrderInfo> findOrderInfo() {
		List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
		// 1.查询orders表里的所有订单信息
		List<Orders> orderList = orderService.findOrder();
		// 2.遍历每一个订单，通过订单id查询当前订单中包含的所有订单项信息
		for (Orders order : orderList) {
			// 根据用户order_id查询该订单号的所有订单项信息，查询orderitem表
			List<OrderItem> orderitems = orderService.orderitem(order.getId());
			// 3.遍历每一个订单项，通过订单项获取商品信息及商品的购买数量
			Map<Products, Integer> map = new HashMap<Products, Integer>();
			for (OrderItem orderItem : orderitems) {
				// 3.1.获取商品id，通过商品id查询商品信息，返回Product对象
				Products product = productsService.oneProduct(orderItem.getProduct_id());
				// 3.2.将商品信息和购买数量存入map中
				map.put(product, orderItem.getBuynum());
			}
			// 4.将订单信息和所有的订单项信息存入OrderInfo中
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrder(order);
			orderInfo.setMap(map);
			// 5.将一个完整的订单信息存入List集合中
			orderInfoList.add(orderInfo);
		}
		return orderInfoList;
	}
	
//	发货
	@RequestMapping("/sendorder")
	public String sendorder(String id, Model model) {
		orderService.sendorder(id);
		return "redirect:/admin/orderlist";
	}
	
}
