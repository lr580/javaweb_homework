package cn.edu.scnu.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.scnu.dao.ProductsDao;
import cn.edu.scnu.po.Category;
import cn.edu.scnu.po.Products;
import cn.edu.scnu.pojo.MyCategory;
import cn.edu.scnu.pojo.MyProducts;

@Service("productsService")
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<Category> allcategorys() {
		return productsDao.allcategorys();
	}

	@Override
	public List<Products> prodlist(Map<String, Object> map) {
		return productsDao.prodlist(map);
	}

	@Override
	public Products oneProduct(String pid) {
		return productsDao.oneProduct(pid);
	}
	
	@Override
	public Category oneCategory(String pid) {
		return productsDao.oneCategory(pid);
	}

	@Override
	public List<Products> proclass(Integer proclass) {
		return productsDao.proclass(proclass);
	}

	@Override
	public String save(MyProducts myproducts, HttpServletRequest request) {
		// 1.�жϺ�׺�Ƿ�Ϸ�
		// ��ȡͼ���ƣ���׺����
		String originName = myproducts.getImgurl().getOriginalFilename();

		// ��ȡ��׺substring split (".png" ".jpg")
		String extName = originName.substring(originName.lastIndexOf("."));

		if (!(extName.equalsIgnoreCase(".jpg") || extName.equalsIgnoreCase(".png")
				|| extName.equalsIgnoreCase(".gif"))) { // ͼƬ��׺���Ϸ�
			return "ͼƬ��׺���Ϸ���";
		}

		// �ж�ľ��java�����ж��Ƿ���ͼƬ���ԣ�Ҳ�������������jar���жϣ�
		try {
			BufferedImage bufImage = ImageIO.read(myproducts.getImgurl().getInputStream());
			bufImage.getHeight();
			bufImage.getWidth();
		} catch (Exception e) {
			return "���ļ�����ͼƬ��";
		}

		// 2.����upload��ʼ��һ��·��
		// ���ɶ༶·��
		String imgurl = "";
		// /a/2/e/a/2/3/j/p
		for (int i = 0; i < 8; i++) {
			imgurl += "/" + Integer.toHexString(new Random().nextInt(16));
		}
		String realpath = request.getServletContext().getRealPath("/WEB-INF");
		realpath += "/upload";
		// D:\java\Workspace\.metadata\.plugins\org.eclipse.wst.server.core
		// \tmp0\wtpwebapps\EasyMall18\WEB-INF/upload/2/6/2/7/2/d/2/1
		System.out.println(realpath + imgurl);
		File file = new File(realpath + imgurl, originName);
		if (!file.exists()) {
			file.mkdirs();
		}
		// �ϴ��ļ�
		try {
			myproducts.getImgurl().transferTo(file);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ƴ��ͼƬ�������ݿ��·��
		imgurl = "/upload" + imgurl + "/" + originName;
		String id = UUID.randomUUID().toString();
		Products products = new Products();
		products.setId(id);
		products.setName(myproducts.getName());
		products.setCategory(myproducts.getCategory());
		products.setPrice(myproducts.getPrice());
		products.setPnum(myproducts.getPnum());
		products.setImgurl(imgurl);
		products.setDescription(myproducts.getDescription());
		if (productsDao.findByImgurl(products.getImgurl()) == null) {
			productsDao.save(products);
		} else {
			String fname = imgurl.substring(0, imgurl.lastIndexOf("."));
			imgurl = fname + System.currentTimeMillis() + extName;
			products.setImgurl(imgurl);
			System.out.println(products.getImgurl());
			productsDao.save(products);
		}
		return "��Ʒ��ӳɹ�";
	}

	@Override
	public void deleteproduct(String pid) {
		// TODO Auto-generated method stub
		productsDao.deleteproduct(pid);
	}

	@Override
	public void deletecategory(String id) {
		// TODO Auto-generated method stub
		productsDao.deletecategory(id);
	}

	@Override
	public String savecategory(MyCategory mycategory) {
		Random rd = new Random();
		Integer id = rd.nextInt(100);
		Category category = new Category();
		category.setId(id);
		category.setName(mycategory.getName());
		category.setDescription(mycategory.getDescription());
		productsDao.savecategory(category);
		return "��Ʒ�����ӳɹ�";
	}

	@Override
	public String update(String pid,MyProducts myproducts, HttpServletRequest request) {
		// 1.�жϺ�׺�Ƿ�Ϸ�
				// ��ȡͼ���ƣ���׺����
				String originName = myproducts.getImgurl().getOriginalFilename();

				// ��ȡ��׺substring split (".png" ".jpg")
				String extName = originName.substring(originName.lastIndexOf("."));

				if (!(extName.equalsIgnoreCase(".jpg") || extName.equalsIgnoreCase(".png")
						|| extName.equalsIgnoreCase(".gif"))) { // ͼƬ��׺���Ϸ�
					return "ͼƬ��׺���Ϸ���";
				}

				// �ж�ľ��java�����ж��Ƿ���ͼƬ���ԣ�Ҳ�������������jar���жϣ�
				try {
					BufferedImage bufImage = ImageIO.read(myproducts.getImgurl().getInputStream());
					bufImage.getHeight();
					bufImage.getWidth();
				} catch (Exception e) {
					return "���ļ�����ͼƬ��";
				}

				// 2.����upload��ʼ��һ��·��
				// ���ɶ༶·��
				String imgurl = "";
				// /a/2/e/a/2/3/j/p
				for (int i = 0; i < 8; i++) {
					imgurl += "/" + Integer.toHexString(new Random().nextInt(16));
				}
				String realpath = request.getServletContext().getRealPath("/WEB-INF");
				realpath += "/upload";
				// D:\java\Workspace\.metadata\.plugins\org.eclipse.wst.server.core
				// \tmp0\wtpwebapps\EasyMall18\WEB-INF/upload/2/6/2/7/2/d/2/1
				System.out.println(realpath + imgurl);
				File file = new File(realpath + imgurl, originName);
				if (!file.exists()) {
					file.mkdirs();
				}
				// �ϴ��ļ�
				try {
					myproducts.getImgurl().transferTo(file);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				// ƴ��ͼƬ�������ݿ��·��
				imgurl = "/upload" + imgurl + "/" + originName;
//				String id = UUID.randomUUID().toString();
				Products products = new Products();
				products.setId(pid);
				products.setName(myproducts.getName());
				products.setCategory(myproducts.getCategory());
				products.setPrice(myproducts.getPrice());
				products.setPnum(myproducts.getPnum());
				products.setImgurl(imgurl);
				products.setDescription(myproducts.getDescription());
				if (productsDao.findByImgurl(products.getImgurl()) == null) {
					productsDao.update(products);
				} else {
					String fname = imgurl.substring(0, imgurl.lastIndexOf("."));
					imgurl = fname + System.currentTimeMillis() + extName;
					products.setImgurl(imgurl);
					System.out.println(products.getImgurl());
					productsDao.update(products);
				}
				return "��Ʒ�޸ĳɹ�";
	}

	@Override
	public String updateCategory(Integer pid,MyCategory mycategory) {
		Category category = new Category();
		category.setId(pid);
		category.setName(mycategory.getName());
		category.setDescription(mycategory.getDescription());
		productsDao.updateCategory(category);
		return null;
	}

}
