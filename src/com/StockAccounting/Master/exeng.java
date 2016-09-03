package com.StockAccounting.Master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exeng extends baseng

{
	@Test(dataProvider="Udata")
public void uom(String uid,String udes)
{
	sl.UimCreation(uid,udes);
}
	@DataProvider
	public Object[][] Udata()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="dump1";
		obj[0][1]="dumpdata";
		
		obj[1][0]="dump2";
		obj[1][1]="dummydata";
		
		obj[2][0]="dump3";
		obj[2][1]="dummydata";
		
		return obj;
	
		
	}
}
