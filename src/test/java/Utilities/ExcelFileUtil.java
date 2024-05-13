package Utilities;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.InvalidElementStateException;

public class ExcelFileUtil {
	XSSFWorkbook wb;

	public ExcelFileUtil(String excelpath) throws Throwable {
		FileInputStream fi = new FileInputStream(excelpath);
		wb = new XSSFWorkbook(fi);
	}

	public int rowcount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}

	public String getcelldata(String sheetname, int row, int coumn) {
		String data;
		if (wb.getSheet(sheetname).getRow(row).getCell(coumn).getCellType() == CellType.NUMERIC) {
			int celldata = (int) wb.getSheet(sheetname).getRow(row).getCell(coumn).getNumericCellValue();
			data = String.valueOf(celldata);
		} else {
			data = wb.getSheet(sheetname).getRow(row).getCell(coumn).getStringCellValue();
		}
		return data;
	}

	public void setCellData(String SheetName, int row, int column, String status, String writeExcel) throws Throwable {
		XSSFSheet ws = wb.getSheet(SheetName);
		XSSFRow rownum = ws.getRow(row);
		XSSFCell cell = rownum.createCell(column);
		cell.setCellValue(status);
		if (status.equalsIgnoreCase("pass")) {
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(row).getCell(column).setCellStyle(style);
		} else if (status.equalsIgnoreCase("Fail")) {
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(row).getCell(column).setCellStyle(style);
		} else if (status.equalsIgnoreCase("Blocked")) {
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(row).getCell(column).setCellStyle(style);
		}
		FileOutputStream fo = new FileOutputStream(writeExcel);
		wb.write(fo);
	}
}
