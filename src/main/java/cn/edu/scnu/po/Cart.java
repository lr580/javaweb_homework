package cn.edu.scnu.po;

public class Cart {
	
	private Integer cartID;
	private Integer user_id;
	private String pid;
	private Integer num;
	
	public Cart(){}
	public Cart(Integer user_id, String pid, Integer num) {
		this.user_id = user_id;
		this.pid = pid;
		this.num = num;
	}
	
	public Integer getCartID() {
		return cartID;
	}
	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
