package cn.edu.scnu.service;
import cn.edu.scnu.pojo.Product;
import cn.edu.scnu.vo.EasyUIResult;
public interface ProductService {
	public EasyUIResult allProductQuery();
	Product selectProdById(String productId);
}