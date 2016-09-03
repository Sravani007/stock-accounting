package com.StockAccounting.Master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom {
	
	
	WebDriver dr;
	@BeforeTest
	public void expom()
	{
	dr=new FirefoxDriver();
	dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	dr.get("http://webapp.qedgetech.com");
	String res;
	loginpage lp=PageFactory.initElements(dr, loginpage.class);
	res=lp.adminlogin("admin", "master");
	System.out.println(res);
	homepage hp=PageFactory.initElements(dr, homepage.class);
	hp.supp();
	
	/*hp.stkitem();
	hp.purchas();
	
	hp.cat(dr);
	hp.uom(dr); */
	}
	@Test(dataProvider="sdata")
	public void SpCreation(String s,String a,String c,String cty,String cp,String pn,String em,String mn,String nots)
	{
	Supplierpage sp=PageFactory.initElements(dr, Supplierpage.class);
	sp.suppcreation(s, a, c, cty, cp, pn, em, mn, nots);
		System.out.println(s+" "+ a+"  "+ c+"  "+ cty+"   "+ cp+"   "+pn+"  "+em+"   "+ mn+"   "+ nots);
	}
	
	@DataProvider
	public Object[][] sdata() throws IOException
	{
		int i,j,rc,cc;
		FileInputStream fi1=new FileInputStream("D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Testdata\\Sdata.xlsx");
		XSSFWorkbook wb1=new XSSFWorkbook(fi1);
		XSSFSheet ws=wb1.getSheet("Supplierdata");
		rc=ws.getLastRowNum();
		System.out.println(rc);
		Object[][] obj = null;
		
		obj=new Object[rc][9];
		
		
		for (i = 1; i <=rc; i++)
		{
			XSSFRow r=ws.getRow(i);
			cc=r.getLastCellNum();
			System.out.println(rc+"      "+cc);
			
			//obj=new Object[rc][cc];
			
			
			for ( j = 0; j <cc; j++) 
			{
		
				//obj=new Object[i][j];
				
				String data=r.getCell(j).getStringCellValue();
				
				obj[i-1][j]=data;
			}
			
			
		}
		
		
		return obj;
		
		
		
	}
	

}
