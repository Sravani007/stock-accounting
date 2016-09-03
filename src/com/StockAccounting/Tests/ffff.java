package com.StockAccounting.Tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ffff {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fi1=new FileInputStream("C:\\Users\\sravani08.QEDGE\\Desktop\\data.xlsx");
		XSSFWorkbook wb1=new XSSFWorkbook(fi1);
		XSSFSheet ws=wb1.getSheet("Sheet1");
		int rc=ws.getLastRowNum();
		Row r=ws.getRow(1);
		int cc=r.getLastCellNum();
		
		System.out.println(rc+"    "+cc);

	}

}
