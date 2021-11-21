package Data;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;


	public  ExcelDataConfig(String excelpath) {
		
		try {
			File src=new File(excelpath);
			FileInputStream fis=new FileInputStream(src);	
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	public String getData(int sheetno,int row,int column)
	{
	sheet1=	wb.getSheetAt(sheetno);
	String data = sheet1.getRow(row).getCell(column).getStringCellValue();
	return data;
	
	}
	
	public  int getRowCount(int sheetindex)
	{
	int row = wb.getSheetAt(sheetindex).getLastRowNum();
	row=row+1;
	return row;
	}

	

}
