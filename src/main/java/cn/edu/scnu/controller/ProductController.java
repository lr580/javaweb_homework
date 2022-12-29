package cn.edu.scnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.edu.scnu.pojo.Product;
import cn.edu.scnu.pojo.User;
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
	@RequestMapping("/products/search")
	public List<Product> productSearch(@PathVariable String productName){
		System.out.println("查询商品：");
		System.out.println(productService.selectProdByName(productName));
		return productService.selectProdByName(productName);
	}
}