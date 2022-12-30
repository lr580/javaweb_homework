package cn.edu.scnu.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.edu.scnu.po.Category;
import cn.edu.scnu.po.Products;
import cn.edu.scnu.pojo.MyCategory;
import cn.edu.scnu.pojo.MyProducts;

public interface ProductsService {
	// ������Ʒ���
	public List<Category> allcategorys();
	// ������Ʒ
	public List<Products> prodlist(Map<String, Object> map);
	// ����pid���ҵ�����Ʒ
	public Products oneProduct(String pid);
//	����pid���ҵ�����Ʒ���
	public Category oneCategory(String pid);
	// ���ݷ��������Ʒ
	public List<Products> proclass(Integer category);
	// �����Ʒ
	public String save(MyProducts myproducts, HttpServletRequest request);
//	ɾ����Ʒ
	public void deleteproduct(String pid);
//	ɾ����Ʒ���
	public void deletecategory(String id);
	
//	�����Ʒ���
	public String savecategory(MyCategory mycategory);
//	�޸���Ʒ
	public String update(String pid,MyProducts myproducts,HttpServletRequest request);
//	�޸���Ʒ���
	public String updateCategory(Integer pid,MyCategory mycategory);
}
