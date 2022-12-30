package cn.edu.scnu.pojo;

import java.util.Map;

import cn.edu.scnu.po.Orders;
import cn.edu.scnu.po.Products;

public class OrderInfo {
	
	private Orders orders;	// ������Ϣ
	private Map<Products, Integer> map;		// �ö����е����ж�������Ϣ
	
	public Orders getOrder() {
		return orders;
	}
	public void setOrder(Orders order) {
		this.orders = order;
	}
	public Map<Products, Integer> getMap() {
		return map;
	}
	public void setMap(Map<Products, Integer> map) {
		this.map = map;
	}
	
}
