package cn.edu.scnu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.scnu.po.Cart;
import cn.edu.scnu.po.User;
import cn.edu.scnu.pojo.MyCart;
import cn.edu.scnu.service.CartService;

@Controller("cartController")
@RequestMapping("/cart")
public class CartController extends BaseController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/addCart")
	public String addcart(String pid, Integer buyNum, HttpSession session) {
		User user = (User)session.getAttribute("user");
		Cart cart = new Cart(user.getId(), pid, buyNum);
		Cart _cart = cartService.findCart(cart);
		if (_cart == null) {
			cartService.addCart(cart);
		} else {
			cart.setCartID(_cart.getCartID());
			cartService.updateCart(cart);
		}
		return "redirect:/cart/showcart";
	}
	
	@RequestMapping("/showcart")
	public String showcart(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		List<MyCart> carts = cartService.showcart(user.getId());
		model.addAttribute("carts", carts);
		return "cart";
	}
	
	@RequestMapping("/updateBuyNum")
	public void updateBuyNum(Integer cartID, Integer buyNum) {
		Cart newcart = new Cart();
		newcart.setCartID(cartID);
		newcart.setNum(buyNum);
		cartService.updateBuyNum(newcart);
	}
	
	@RequestMapping("/delCart")
	public void delCart(Integer cartID) {
		cartService.delCart(cartID);
	}
}
