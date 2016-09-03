package com.StockAccounting.Master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Stockitemng extends baseng
{
	@Test(dataProvider="sdata")
public void stockitem(String scat,String suppno,String stockname,int uom,String purprice,String sellprice,String notes)
{
	sl.StockitemCreation(scat, suppno, stockname, uom, purprice, sellprice, notes);
}
@DataProvider
public Object[][] sdata()
{
	Object[][] obj=new Object[2][7];
	obj[0][0]="m1";
	obj[0][1]="nani";
	obj[0][2]="lenovo";
	obj[0][3]=6;
	obj[0][4]="10000";
	obj[0][5]="15000";
	obj[0][6]="mobiles";
	
	obj[1][0]="m2";
	obj[1][1]="nanidg";
	obj[1][2]="nokia220";
	obj[1][3]=7;
	obj[1][4]="15000";
	obj[1][5]="20000";
	obj[1][6]="mobiles";
	
	return obj;
}
}
