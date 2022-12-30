package cn.edu.scnu.controller.admin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import easymall.dao.SalesDao;
import easymall.po.Category;
import easymall.pojo.MySales;
import easymall.service.ProductsService;

@Controller("chartsController")
@RequestMapping("/charts")
public class ChartsController {
	@Autowired
	private ProductsService productsService;
	@Autowired
	private SalesDao salesDao;
	@RequestMapping("/sales")
	public String sales() {
		return "echarts";
	}
	@RequestMapping("/testJson")
	@ResponseBody
	public List<Category> testJson() {
		List<Category> categories=productsService.allcategorys();
		return categories;
	}
	@RequestMapping("/salesNum")
	@ResponseBody
	public List<MySales> salesNum() {
		List<MySales> salesList=salesDao.allSales();
		return salesList;
	}
	@RequestMapping("/export")
	public String exportCharts(String mypath,Model model) {
		try {
			goExport(mypath);
			model.addAttribute("msg","�����ɹ���");
		} catch (Exception e) {
			model.addAttribute("msg","����ʧ�ܣ�����·��������׺���Ƿ���ȷ��");
		}
		return "echarts";
	}
	public void goExport(String mypath) throws Exception{
				Workbook workbook=new XSSFWorkbook();
				Sheet sheet=workbook.createSheet("���۰�");
				FileOutputStream fout=new FileOutputStream(mypath);
				List<MySales> salesList=salesDao.allSales();
				Row row=sheet.createRow(0);
				Cell cell=row.createCell(0);
				cell.setCellValue("����");
				Cell cell1=row.createCell(1);
				cell1.setCellValue("����������");
				Cell cell2=row.createCell(2);
				cell2.setCellValue("������Ԫ��");
				for(int i=0;i<salesList.size();i++) {
					Row tempRow=sheet.createRow(i+1);
					Cell tempCell=tempRow.createCell(0);
					tempCell.setCellValue(salesList.get(i).getName());
					Cell tempCell1=tempRow.createCell(1);
					tempCell1.setCellValue(salesList.get(i).getNum());
					Cell tempCell2=tempRow.createCell(2);
					tempCell2.setCellValue(salesList.get(i).getSales_num());
				}
				workbook.write(fout);
				fout.close();
	}
	@Test
	public void test1() throws Exception{
		//1.����workbook������
		Workbook workbook=new XSSFWorkbook();
		//2.������sheet
		Sheet sheet=workbook.createSheet("sheet1");
		//3.�ļ���
		FileOutputStream fout=new FileOutputStream("D:\\test1.xlsx");
		//4.�����ж����±��0��ʼ
		Row row=sheet.createRow(0);
		//5.������Ԫ��
		Cell cell=row.createCell(0);
		cell.setCellValue("GG˼�ܴ�");
		//6.������Ԫ����ʽ
		CellStyle cellStyle=workbook.createCellStyle();
		//���ñ߿�(top,bottom,left,right)
		cellStyle.setBorderTop(BorderStyle.DOUBLE);
		//��������
		Font font=workbook.createFont();
		font.setFontName("����ϸ��");//������Դ�excel����鿴
		font.setFontHeightInPoints((short) 32);//���������С
		cellStyle.setFont(font);
		//���п���
		CellRangeAddress region=new CellRangeAddress(0,3,0,2);//(firstRow,lastRow,firstCol,lastCol)
		sheet.addMergedRegion(region);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);//ˮƽ����
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//��ֱ����
		//Ӧ����ʽ
		cell.setCellStyle(cellStyle);
		//7.����ͼƬ
		//FileInputStream fin=new FileInputStream();
		//������
		workbook.write(fout);
		fout.close();
	}
}
