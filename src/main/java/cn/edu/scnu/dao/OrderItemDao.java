package cn.edu.scnu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import cn.edu.scnu.po.OrderItem;

@Repository("orderItemDao")
@Mapper
public interface OrderItemDao {
	void addOrderItem(OrderItem orderItem);
	List<OrderItem> orderitem(String order_id);
	public void delorderitem(String id);
}
