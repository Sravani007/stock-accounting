package com.StockAccounting.Master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class execatry extends baseng
{
	@Test(dataProvider="sdata")
public void scatgry(String scategory)
{
	sl.Stockcatcreation(scategory);
}

	@DataProvider
	public Object[][] sdata()
	{
		Object[][] obj=new Object[3][1];
		obj[0][0]="m1";
		obj[1][0]="m2";
		obj[2][0]="m3";
		return obj;
	}
}
