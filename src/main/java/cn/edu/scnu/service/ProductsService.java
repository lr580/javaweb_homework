package easymall.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import easymall.po.Category;
import easymall.po.Products;
import easymall.pojo.MyCategory;
import easymall.pojo.MyProducts;

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
