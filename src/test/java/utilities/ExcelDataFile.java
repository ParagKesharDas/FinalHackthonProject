package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataFile {
	
	public String path;
	public FileInputStream fileIn;
	public FileOutputStream fileOut;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public ExcelDataFile(String path) {
		this.path = path;
		try {
			fileIn = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileIn);
			sheet = workbook.getSheetAt(0);
			fileIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean addSheet(String sheetName) {
		try {
			fileOut = new FileOutputStream(path);
			sheet = workbook.createSheet(sheetName);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean removeSheet(String sheetName) {
		if(!isSheetExist(sheetName)) {
			return false;
		}
		
		try {
			fileOut = new FileOutputStream(path);
			ZipSecureFile.setMinInflateRatio(0);
			workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public boolean isSheetExist(String sheetName) {
		ZipSecureFile.setMinInflateRatio(0);
		int index = workbook.getSheetIndex(sheetName);
		if(index == -1) {
			return false;
		}
		return true;
	}
	public int getRowCount(String sheetName) throws IOException 
	{
		fileIn=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIn);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fileIn.close();
		return rowcount;		
	}
	
	//for a particular row how many cell are there
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fileIn=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIn);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fileIn.close();
		return cellcount;
	}
	
	//reading cell data 
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fileIn=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIn);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			//when cell does not have any data, it will throw exception
			data="";
			
		}
		workbook.close();
		fileIn.close();
		return data;
	}
	
	public boolean setCellData(String sheetName, int colNum, int rowNum, String data) {
		try {
			fileIn = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileIn);
			ZipSecureFile.setMinInflateRatio(0);
			
			if(rowNum <= 0)
				return false;
			
			if(colNum <= 0)
				return false;
			
			if(!isSheetExist(sheetName))
				return false;
			
			sheet = workbook.getSheetAt(workbook.getSheetIndex(sheetName));
			sheet.autoSizeColumn(colNum - 1);

			row = sheet.getRow(rowNum - 1);
			if(row == null)
				row = sheet.createRow(rowNum - 1);
			
			cell = row.getCell(colNum - 1);
			if(cell == null)
				cell = row.createCell(colNum - 1);
			
			CellStyle cs = workbook.createCellStyle();
			cs.setWrapText(true);
			cell.setCellStyle(cs);
//			cell.setCellType(CellType.STRING);
			cell.setCellValue(data);
			
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fileIn=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIn);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		CellStyle style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);
		workbook.write(fileOut);
		workbook.close();
		fileIn.close();
		fileOut.close();
	}
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fileIn=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIn);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		CellStyle style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);
		workbook.write(fileOut);
		workbook.close();
		fileIn.close();
		fileOut.close();
	}

}