package com.StockAccounting.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class homepage {
@FindBy  (xpath=".//*[@id='mi_a_suppliers']/a")
WebElement supplier;
@FindBy (xpath=".//*[@id='mi_a_purchases']/a")
WebElement purchases;
@FindBy (xpath=".//*[@id='mi_a_stock_items']/a")
WebElement stockitems;

@FindBy (xpath=".//*[@id='mi_a_stock_categories']/a")
WebElement stockcat;
@FindBy (xpath=".//*[@id='mi_a_unit_of_measurement']/a")
WebElement Unitom;



public void supp()
{
	supplier.click();
}
public void purchas()
{
	purchases.click();
}
	public void stkitem()
	{
		stockitems.click();
	}
	
	public void cat(WebDriver d)
	{
		
		Actions act=new Actions(d);
		act.moveToElement(stockitems).build().perform();
		
		stockcat.click();
		
	}
	public void uom(WebDriver d)
	{
		Actions act=new Actions(d);
		act.moveToElement(stockitems).build().perform();
		Unitom.click();
	}

}
