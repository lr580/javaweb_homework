package cn.edu.scnu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import cn.edu.scnu.po.Orders;

@Repository("orderDao")
@Mapper
public interface OrderDao {
	void addOrder(Orders myOrder);
	List<Orders> findOrderByUserId(Integer user_id);	
	public void delorder(String id);
	public void payorder(String id);
	public void sendorder(String id);
	public void recorder(String id);
}
