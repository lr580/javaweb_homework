package easymall.pojo;

import org.springframework.web.multipart.MultipartFile;

public class MyProducts {

//	private String id;
	private String name;
	private Double price;
	private Integer category;
	private Integer pnum;
	private MultipartFile imgurl;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public MultipartFile getImgurl() {
		return imgurl;
	}
	public void setImgurl(MultipartFile imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
