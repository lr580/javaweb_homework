package cn.edu.scnu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import cn.edu.scnu.po.Category;
import cn.edu.scnu.po.Products;

@Repository
@Mapper
public interface ProductsDao {
	public List<Category> allcategories();
	public List<Products> prodlist(Map<String,Object> map);
	
	public Products oneProduct(String product_id);
	public Category oneCategory(Integer id);
	public List<Products> prodclass(String category);
	public Object findByImgurl(String imgurl);
	public void save(Products products);
	public void saveCategory(Category category);
	public void updateCategory(Map<String,Object> map);
	public void updateProd(Map<String,Object> map);
	public void updateSaleStatus(Map<String,Object> map);
	public List<Products> allprods();
	public List<Products> allProds();
	public List<Products> salelist();
	public List<Products> chartlist();
	public void updateSoldNum(Map<String,Object> map);
	
}
