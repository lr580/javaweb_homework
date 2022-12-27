package cn.edu.scnu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.scnu.pojo.Product;
import cn.edu.scnu.service.ProductService;
import cn.edu.scnu.vo.EasyUIResult;
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/products/pageManage")
	public EasyUIResult productPageQuery() {
		EasyUIResult result = productService.allProductQuery();
		return result;
	}
	@RequestMapping("/products/item/{productId}")
	public Product productInfo(@PathVariable String productId){
		return productService.selectProdById(productId);
	}
}