package easymall.service;

import java.util.List;

import easymall.po.OrderItem;
import easymall.po.Orders;

public interface OrderService {
	public void addOrder(String cartIds, Orders myOrder);
	public List<Orders> findOrderByUserId(Integer user_id);
	public List<OrderItem> orderitem(String order_id);
	public void delorder(String id);
	public void payorder(String id);
//	查询orders表里的所有订单信息
	public List<Orders> findOrder();
//	发货处理
	public void sendorder(String id);
//	确认收货
	public void confirm(String id);
}
