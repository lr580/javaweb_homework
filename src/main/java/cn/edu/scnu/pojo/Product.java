package cn.edu.scnu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName(value = "t_product")

public class Product {
	//根据驼峰命名定义属性
	@TableId(value = "product_id")
	private String  productId;
	private String  productName;
	//封装类完成基本类型的使用
	//满足业务意义
	private Double  productPrice;
	private String  productCategory;
	private String  productImgurl;
	private Integer productNum;
	private String  productDescription;
}
