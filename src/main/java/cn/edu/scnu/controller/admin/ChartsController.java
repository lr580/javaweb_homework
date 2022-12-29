package easymall.controller.admin;

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
			model.addAttribute("msg","导出成功！");
		} catch (Exception e) {
			model.addAttribute("msg","导出失败！请检查路径及表格后缀名是否正确！");
		}
		return "echarts";
	}
	public void goExport(String mypath) throws Exception{
				Workbook workbook=new XSSFWorkbook();
				Sheet sheet=workbook.createSheet("销售榜单");
				FileOutputStream fout=new FileOutputStream(mypath);
				List<MySales> salesList=salesDao.allSales();
				Row row=sheet.createRow(0);
				Cell cell=row.createCell(0);
				cell.setCellValue("类型");
				Cell cell1=row.createCell(1);
				cell1.setCellValue("销量（个）");
				Cell cell2=row.createCell(2);
				cell2.setCellValue("销量（元）");
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
		//1.创建workbook工作簿
		Workbook workbook=new XSSFWorkbook();
		//2.创建表单sheet
		Sheet sheet=workbook.createSheet("sheet1");
		//3.文件流
		FileOutputStream fout=new FileOutputStream("D:\\test1.xlsx");
		//4.创建行对象，下标从0开始
		Row row=sheet.createRow(0);
		//5.创建单元格
		Cell cell=row.createCell(0);
		cell.setCellValue("GG思密达");
		//6.创建单元格样式
		CellStyle cellStyle=workbook.createCellStyle();
		//设置边框(top,bottom,left,right)
		cellStyle.setBorderTop(BorderStyle.DOUBLE);
		//设置字体
		Font font=workbook.createFont();
		font.setFontName("华文细黑");//具体可以打开excel字体查看
		font.setFontHeightInPoints((short) 32);//设置字体大小
		cellStyle.setFont(font);
		//跨行跨列
		CellRangeAddress region=new CellRangeAddress(0,3,0,2);//(firstRow,lastRow,firstCol,lastCol)
		sheet.addMergedRegion(region);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
		//应用样式
		cell.setCellStyle(cellStyle);
		//7.绘制图片
		//FileInputStream fin=new FileInputStream();
		//输出表格
		workbook.write(fout);
		fout.close();
	}
}
