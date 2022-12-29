package easymall.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import easymall.po.Category;
import easymall.po.Products;
import easymall.pojo.MyCategory;
import easymall.pojo.MyProducts;

public interface ProductsService {
	// 查找商品类别
	public List<Category> allcategorys();
	// 查找商品
	public List<Products> prodlist(Map<String, Object> map);
	// 根据pid查找单个商品
	public Products oneProduct(String pid);
//	根据pid查找单个商品类别
	public Category oneCategory(String pid);
	// 根据分类查找商品
	public List<Products> proclass(Integer category);
	// 添加商品
	public String save(MyProducts myproducts, HttpServletRequest request);
//	删除商品
	public void deleteproduct(String pid);
//	删除商品类别
	public void deletecategory(String id);
	
//	添加商品类别
	public String savecategory(MyCategory mycategory);
//	修改商品
	public String update(String pid,MyProducts myproducts,HttpServletRequest request);
//	修改商品类别
	public String updateCategory(Integer pid,MyCategory mycategory);
}
