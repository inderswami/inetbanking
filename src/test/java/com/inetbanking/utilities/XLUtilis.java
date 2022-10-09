package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class XLUtilis {

	public String path;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	private static XSSFWorkbook wb;
	private static XSSFSheet ws;
	private static XSSFRow row;
	private static XSSFCell cell;

	// returns the row count in a sheet
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;

	}

	// returns the column count in a sheet
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;

	}

	// returns the data from a cell
	public static String getCellData(String xlfile, String xlsheet, int rowNum, int colnum) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colnum);
		String data = "";
		try {
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);
			data = data + celldata;
		}

		catch (Exception e) {
			data = "";
		}

		wb.close();
		fi.close();
		return data;

	}
	

	// returns the data from a cell
	public static String setCellData(String xlfile, String xlsheet, int rowNum, int colnum, String data)
			throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);

		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		return data;

	}
	
	

	
	public static void main(String[] args) throws IOException {
		
		XLUtilis x = new XLUtilis();
		
		String xlFile = "./src/test/resources/testData/LoginData.xlsx";
		
		String xlSheet = "one";
		int rowNo = XLUtilis.getRowCount(xlFile, xlSheet);
		int colNo = XLUtilis.getCellCount(xlFile, xlSheet, rowNo);
		
		for(int i = 0; i <= rowNo; i ++) {
			
			for(int j = 0; j < colNo; j++) {
				String data = XLUtilis.getCellData(xlFile, xlSheet, i, j);
				System.out.print("  " + data );
			}
			System.out.println();
		}
 }
}

