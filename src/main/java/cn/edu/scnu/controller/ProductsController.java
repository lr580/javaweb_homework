package cn.edu.scnu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.scnu.po.Category;
import cn.edu.scnu.po.Products;
import cn.edu.scnu.service.ProductsService;

@Controller("productsController")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@RequestMapping("/prodlist")
	public String prodlist(String name, Integer category, String minprice, String maxprice, Model model) {
		// ������Ʒ�������е���Ʒ���
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		
		// Ϊ������������Ĭ��ֵ ����������Ƿ�Ϸ�
		// Ĭ��0�����ֵ
		double _minPrice = 0;
		Double _maxPrice = Double.MAX_VALUE;
		
		// ֻ����������
		String reg = "^\\d+$";
		if (minprice != null && !"".equals(minprice.trim()) && minprice.matches(reg)) {
			_minPrice = Double.parseDouble(minprice);
		}
		if (maxprice != null && !"".equals(maxprice.trim()) && maxprice.matches(reg)) {
			// ��߼۸�������ڵ�����ͼ۸�
			if (Double.parseDouble(maxprice) >= _minPrice) {
				_maxPrice = Double.parseDouble(maxprice);
			}
		}
		// ����map ���ڴ�Ų�ѯ����
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("category", category);
		map.put("minPrice", _minPrice);
		map.put("maxPrice", _maxPrice);
		// ����������ѯ������������Ʒ��Ϣ
		List<Products> products = productsService.prodlist(map);
		// �����ѯ����
		model.addAttribute("name", name);
		model.addAttribute("minPrice", _minPrice);
		model.addAttribute("maxPrice", _maxPrice);
		// ��ѯ�����¶��ǰ��
		model.addAttribute("products", products);
		// ���ص�/WEB-INF/jsp/prod_list.jsp
		return "prod_list";
	}
	
	@RequestMapping("prodInfo")
	public String prodInfo(String pid, Model model) {
		Products product = productsService.oneProduct(pid);
		model.addAttribute("product", product);
		// ���ص�/WEB-INF/jsp/prod_list.jsp
		return "prod_info";
	}
	
	@RequestMapping(value="/prodclass/{proclass}", method=RequestMethod.GET)
	public String prodclass(@PathVariable Integer proclass, Model model) {
		List<Products> products = productsService.proclass(proclass);
		model.addAttribute("products", products);
		// ���ص�/WEB-INF/jsp/prod_info.jsp
		return "forward:/WEB-INF/jsp/prod_list.jsp";
	}

}
