package cn.edu.scnu.service;
import java.util.List;

import cn.edu.scnu.pojo.Product;
import cn.edu.scnu.vo.EasyUIResult;
public interface ProductService {
	public EasyUIResult allProductQuery();
	Product selectProdById(String productId);
	List<Product> selectProdByName(String productName);
}