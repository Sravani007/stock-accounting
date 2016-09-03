package com.StockAccounting.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Launching Application
		
WebDriver dr=new FirefoxDriver();
dr.get("http://webapp.qedgetech.com");
dr.manage().window().maximize();
dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
if(dr.findElement(By.id("btnsubmit")).isDisplayed())
{
	System.out.println("Application Launched Successfully");
}
else
{
	System.out.println("Application not launched");
}

//Admin Login

dr.findElement(By.id("btnreset")).click();
dr.findElement(By.id("username")).sendKeys("admin");
dr.findElement(By.id("password")).sendKeys("master");
dr.findElement(By.id("btnsubmit")).click();
if(dr.findElement(By.linkText("Logout")).isDisplayed())
{
	System.out.println("Admin login Successfully");
	
}
else
{
	System.out.println("Admin login failed");
}

//Supplier Creation

String expval="Add succeeded";
dr.findElement(By.linkText("Suppliers")).click();
Sleeper.sleepTightInSeconds(10);
dr.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
dr.findElement(By.xpath(".//*[@id='x_Supplier_Name']")).sendKeys("Ranamobiles");
dr.findElement(By.id("x_Address")).sendKeys("Bowenpally");
dr.findElement(By.id("x_City")).sendKeys("Hyderabad");
dr.findElement(By.id("x_Country")).sendKeys("India");
dr.findElement(By.id("x_Contact_Person")).sendKeys("Ramu");
dr.findElement(By.id("x_Phone_Number")).sendKeys("0402589631");
dr.findElement(By.id("x__Email")).sendKeys("raki@gmail.com");
dr.findElement(By.id("x_Mobile_Number")).sendKeys("9856321452");

dr.findElement(By.id("x_Notes")).sendKeys("mobiles");

dr.findElement(By.id("btnAction")).click();
Sleeper.sleepTightInSeconds(2);
dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
Sleeper.sleepTightInSeconds(2);
String acval=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
if(expval.equalsIgnoreCase(acval))
{
	System.out.println("Supplier added successfully");
}
else
{
	System.out.println("Supplier not added successfully");
}

dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();


//Stock Category Creation
	
	Actions act=new Actions(dr);
	act.moveToElement(dr.findElement(By.linkText("Stock Items"))).build().perform();
	String expval1="Add succeeded";
	dr.findElement(By.linkText("Stock Categories")).click();
	Sleeper.sleepTightInSeconds(2);
	dr.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	Sleeper.sleepTightInSeconds(5);
	dr.findElement(By.id("x_Category_Name")).sendKeys("Screenguard");
	dr.findElement(By.id("btnAction")).click();
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	String actval1=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
	if(expval1.equalsIgnoreCase(actval1))
	{
		System.out.println("Stock category added successfully");
	}
	else
	{
		System.out.println("Stock category not added");
	}
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).click();
	
	//Unit of Measurement Creation
	
	Actions act1=new Actions(dr);
	String expval2="Add succeeded";
	act1.moveToElement(dr.findElement(By.linkText("Stock Items"))).build().perform();
	dr.findElement(By.linkText("Unit of Measurement")).click();
	dr.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	dr.findElement(By.id("x_UOM_ID")).sendKeys("ktont");
	dr.findElement(By.id("x_UOM_Description")).sendKeys("1000kgs");
	dr.findElement(By.id("btnAction")).click();
	Sleeper.sleepTightInSeconds(2);
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	Sleeper.sleepTightInSeconds(2);
	String actval2=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
	if(expval2.equalsIgnoreCase(actval2))
	{
		System.out.println("Unit of Measurement added successfully");
	}
	else
	{
		System.out.println("Unit of Measurement not added");
	}
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).click();
	
	//Stock Items Creation
	
	dr.findElement(By.linkText("Stock Items")).click();
	String expval3="Add succeeded";
	dr.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	Select sclist=new Select(dr.findElement(By.id("x_Category")));
	sclist.selectByVisibleText("Screenguard");
	Select splist=new Select(dr.findElement(By.id("x_Supplier_Number")));
	splist.selectByVisibleText("Rammobiles");
	dr.findElement(By.id("x_Stock_Name")).sendKeys("nokia202");
	Select umlist=new Select(dr.findElement(By.id("x_Unit_Of_Measurement")));
	umlist.selectByIndex(6);
	dr.findElement(By.id("x_Purchasing_Price")).sendKeys("10,000");
	dr.findElement(By.id("x_Selling_Price")).sendKeys("15,000");
	dr.findElement(By.id("x_Notes")).sendKeys("nokia");
	dr.findElement(By.id("btnAction")).click();
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	Sleeper.sleepTightInSeconds(2);
	String actval3=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
	if(expval3.equalsIgnoreCase(actval3))
	{
		System.out.println("Stock Item added successfully");
	}
	else
	{
		System.out.println("Stock Item not added");
	}
	dr.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	
	//Purchasers Creation
	String expval4="Add succeeded";
	dr.findElement(By.linkText("Purchases")).click();
	dr.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[2]/div/a")).click();
	dr.findElement(By.xpath(".//*[@id='r2_a_purchases_detail']/td[1]/div/a")).click();
	dr.findElement(By.xpath(".//*[@id='r3_a_purchases_detail']/td[1]/div/a")).click();
	Select spplist=new Select(dr.findElement(By.id("x_Supplier_ID")));
	spplist.selectByVisibleText("Rammobiles");
	dr.findElement(By.id("x_Notes")).sendKeys("mobiles");
	Sleeper.sleepTightInSeconds(5);
	Select spp1list=new Select(dr.findElement(By.id("x1_Supplier_Number")));
	spp1list.selectByVisibleText("Rammobiles");
	Select sckilist=new Select(dr.findElement(By.id("x1_Stock_Item")));
	sckilist.selectByVisibleText("nokia202");
	Sleeper.sleepTightInSeconds(3);
	dr.findElement(By.id("x1_Purchasing_Quantity")).sendKeys("10");
	dr.findElement(By.id("x1_Purchasing_Quantity")).click();
	
	Sleeper.sleepTightInSeconds(10);
	dr.findElement(By.id("x_Total_Payment")).sendKeys("1000");
	
	Sleeper.sleepTightInSeconds(5);
	//dr.findElement(By.xpath(".//*[@id='r2_a_purchases_detail']/td[1]/div/a")).click();
	//dr.findElement(By.xpath(".//*[@id='r3_a_purchases_detail']/td[1]/div/a")).click();
	dr.findElement(By.id("btnAction")).click();
	//dr.findElement(By.id("btnAction")).click();
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	Sleeper.sleepTightInSeconds(2);
	String actval4=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
	if(expval4.equalsIgnoreCase(actval4))
	{
		System.out.println("Purchases added successfully");
	}
	else
	{
		System.out.println("Purchases not added");
	}
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
	
	//Customer Creation
	String expval5="Add succeeded";
	dr.findElement(By.linkText("Customers")).click();
	dr.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	dr.findElement(By.id("x_Customer_Name")).sendKeys("sandeep");
	dr.findElement(By.id("x_Address")).sendKeys("SRnagar");
	dr.findElement(By.id("x_City")).sendKeys("Secunderabad");
	dr.findElement(By.id("x_Country")).sendKeys("India");
	dr.findElement(By.id("x_Contact_Person")).sendKeys("sandeep");
	dr.findElement(By.id("x_Phone_Number")).sendKeys("0402563214");
	dr.findElement(By.id("x__Email")).sendKeys("san@gmail.com");
	dr.findElement(By.id("x_Mobile_Number")).sendKeys("9856231452");
	dr.findElement(By.id("x_Notes")).sendKeys("Regularcustomer");
	dr.findElement(By.id("btnAction" )).click();
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	Sleeper.sleepTightInSeconds(2);
	String actval5=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
	if(expval5.equalsIgnoreCase(actval5))
	{
		System.out.println("Customer added successfully");
	}
	else
	{
		System.out.println("Customer not added");
	}
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
	
	//Sales Creation
	String expval6="Add succeeded";
	dr.findElement(By.linkText("Sales")).click();
	dr.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	Sleeper.sleepTightInSeconds(5);
	dr.findElement(By.xpath(".//*[@id='r5_a_sales_detail']/td[1]/div/a")).click();
	Sleeper.sleepTightInSeconds(2);
	dr.findElement(By.xpath(".//*[@id='r4_a_sales_detail']/td[1]/div/a")).click();
	Sleeper.sleepTightInSeconds(2);
	dr.findElement(By.xpath(".//*[@id='r3_a_sales_detail']/td[1]/div/a")).click();
	Sleeper.sleepTightInSeconds(2);
	dr.findElement(By.xpath(".//*[@id='r2_a_sales_detail']/td[1]/div/a")).click();
	
	
	Select clist=new Select(dr.findElement(By.id("x_Customer_ID")));
	clist.selectByVisibleText("sandeep");
	Select supplist=new Select(dr.findElement(By.id("x1_Supplier_Number")));
	supplist.selectByVisibleText("Rammobiles");
	Sleeper.sleepTightInSeconds(4);
	Select sckilist1=new Select(dr.findElement(By.id("x1_Stock_Item")));
	sckilist1.selectByVisibleText("nokia202");
	dr.findElement(By.id("x1_Sales_Quantity")).sendKeys("8");
	dr.findElement(By.id("x1_Sales_Quantity")).click();
	
	dr.findElement(By.xpath(".//*[@id='x1_Purchasing_Price']")).click();
	dr.findElement(By.xpath(".//*[@id='x1_Sales_Price']")).click();
	
       dr.findElement(By.xpath(".//*[@id='x1_Sales_Total_Amount']")).click();
       
	Sleeper.sleepTightInSeconds(10);
	dr.findElement(By.id("x_Discount_Percentage")).sendKeys("2");
	dr.findElement(By.id("x_Tax_Percentage")).sendKeys("1");
	
	dr.findElement(By.xpath(".//*[@id='x_Total_Payment']")).sendKeys("50000");
	Sleeper.sleepTightInSeconds(5);
	dr.findElement(By.id("btnAction")).click();
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	Sleeper.sleepTightInSeconds(2);
	String actval6=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
	if(expval6.equalsIgnoreCase(actval6))
	{
		System.out.println("Sales added successfully");
	}
	else
	{
		System.out.println("Sales not added");
	}
	dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
}

}
