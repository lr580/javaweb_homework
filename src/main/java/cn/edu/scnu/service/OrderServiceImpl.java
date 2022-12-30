package cn.edu.scnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.scnu.dao.CartDao;
import cn.edu.scnu.dao.OrderDao;
import cn.edu.scnu.dao.OrderItemDao;
import cn.edu.scnu.dao.ProductsDao;
import cn.edu.scnu.dao.SalesDao;
import cn.edu.scnu.po.OrderItem;
import cn.edu.scnu.po.Orders;
import cn.edu.scnu.po.Products;
import cn.edu.scnu.pojo.MyCart;
import cn.edu.scnu.pojo.MySales;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CartDao cartDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductsDao productsDao; 
	@Autowired
	private SalesDao salesDao;
	
	@Override
	public void addOrder(String cartIds, Orders myOrder) {
		String[] arrCartIds = cartIds.split(",");
		Double sum = 0.0;
		int sum1=0;
		for (String cartID : arrCartIds) {
			Integer cid = Integer.parseInt(cartID);
			MyCart mycart = cartDao.findByCartID(cid);
			String pid = mycart.getPid();
			int buynum = mycart.getNum();
			Double price = mycart.getPrice();
			sum += buynum * price;
			sum1 += buynum * price;
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder_id(myOrder.getId());
			orderItem.setProduct_id(pid);
			orderItem.setBuynum(buynum);
			orderItemDao.addOrderItem(orderItem);
			cartDao.delCart(cid);
			Products products=productsDao.oneProduct(pid);
			MySales mySales=new MySales();
			mySales.setId(products.getCategory());
			mySales.setSales_num(sum1);
			mySales.setNum(buynum);
			salesDao.sales(mySales);
		}
		myOrder.setMoney(sum);
		orderDao.addOrder(myOrder);
	}

	@Override
	public List<Orders> findOrderByUserId(Integer user_id) {
		return orderDao.findOrderByUserId(user_id);
	}

	@Override
	public List<OrderItem> orderitem(String order_id) {
		return orderItemDao.orderitem(order_id);
	}

	@Override
	public void delorder(String id) {
		orderItemDao.delorderitem(id);
		orderDao.delorder(id);
	}

	@Override
	public void payorder(String id) {
		orderDao.payorder(id);
	}

//	��ѯorders��������ж�����Ϣ
	@Override
	public List<Orders> findOrder() {
		// TODO Auto-generated method stub
		return orderDao.findOrder();
	}

	@Override
	public void sendorder(String id) {
		// TODO Auto-generated method stub
		orderDao.sendorder(id);
	}

	@Override
	public void confirm(String id) {
		orderDao.confirm(id);
		
	}

}
