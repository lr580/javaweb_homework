package cn.edu.scnu.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.edu.scnu.pojo.Product;
import cn.edu.scnu.vo.EasyUIResult;
import cn.edu.scnu.mapper.ProductMapper;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	public EasyUIResult allProductQuery() {
		// 1.创建一个返回的对象,将查询数据set进去然后返回
		EasyUIResult result = new EasyUIResult();
		// 2封装第一个属性 total 的数量
		QueryWrapper<Product> productQueryWrapper=new QueryWrapper<Product>();
		Integer total = productMapper.selectCount(productQueryWrapper);
		// 3封装第二个属性List<Product> pList
		List<Product> pList = productMapper.selectList(productQueryWrapper);
		// 4封装对象属性
		result.setTotal(total);
		result.setRows(pList);
		return result;
	}

	public Product selectProdById(String productId) {
		return productMapper.selectById(productId);
	}

	@Override
	public List<Product> selectProdByName(String productName) {
		// TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("product_Name",productName);
		return productMapper.selectByMap(map);
	}
}