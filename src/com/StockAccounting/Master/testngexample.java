package com.StockAccounting.Master;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testngexample 
{
@org.testng.annotations.Test(priority=3)
public void xyz()
{
	Assert.assertEquals("Gmail", "Gmail");
}
@Test(priority=1)
public void abc()
{
	Assert.assertEquals("facebook", "facebook");
}
@Test(priority=2)
public void ghj()
{
	Assert.assertEquals("twitter", "twitter");
}



}


