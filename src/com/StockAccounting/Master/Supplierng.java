package com.StockAccounting.Master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Supplierng extends baseng
{
	@Test(dataProvider="sdata")
	public void supplier(String Sname,String Add,String city,String Country,String Cp,String Phnum,String Email,String Mobno,String notes)
	{
		sl.SuppCreation(Sname, Add, city, Country, Cp, Phnum, Email, Mobno, notes);
	}
	
	@DataProvider
	public Object[][] sdata()
	{
		Object[][] obj=new Object[2][9];
		obj[0][0]="nani";
		obj[0][1]="dsnr";
		obj[0][2]="hyd";
		obj[0][3]="india";
		obj[0][4]="nan";
		obj[0][5]="0124512";
		obj[0][6]="na@gmail.com";
		obj[0][7]="98563214";
		obj[0][8]="mobiles";
		
		obj[1][0]="nanidg";
		obj[1][1]="dsngr";
		obj[1][2]="hyded";
		obj[1][3]="india";
		obj[1][4]="nandfg";
		obj[1][5]="01245124";
		obj[1][6]="na@gmail.com";
		obj[1][7]="9851263214";
		obj[1][8]="mobiles";
		
		return obj;
	}

}
