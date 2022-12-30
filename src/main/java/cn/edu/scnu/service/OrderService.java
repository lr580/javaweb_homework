package cn.edu.scnu.service;

import java.util.List;

import cn.edu.scnu.po.OrderItem;
import cn.edu.scnu.po.Orders;

public interface OrderService {
	public void addOrder(String cartIds, Orders myOrder);
	public List<Orders> findOrderByUserId(Integer user_id);
	public List<OrderItem> orderitem(String order_id);
	public void delorder(String id);
	public void payorder(String id);
//	��ѯorders��������ж�����Ϣ
	public List<Orders> findOrder();
//	��������
	public void sendorder(String id);
//	ȷ���ջ�
	public void confirm(String id);
}
