package com.StockAccounting.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class sales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		dr.findElement(By.linkText("Suppliers")).click();
	
		/*String expval6="Add succeeded";
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
		dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();*/
	}

}
