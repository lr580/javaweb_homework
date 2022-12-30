package cn.edu.scnu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import cn.edu.scnu.po.Cart;
import cn.edu.scnu.pojo.MyCart;
@Repository
@Mapper
public interface CartDao {
	public Cart findCart(Cart cart);
	public void addCart(Cart cart);
	public void updateCart(Cart cart);
	public List<MyCart> showcart(Integer user_id);
	public void updateBuyNum(Cart cart);
	public void delCart(Integer cartID);
	public MyCart findByCartID(Integer cartID);
}
