package com.StockAccounting.Master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class Stocklib {
	public static Properties pr;
	public static FileInputStream fi;
	
	public static WebDriver dr;
	public static String expval,actval;
	public String OpenApp(String Url) throws IOException
	{
		dr=new FirefoxDriver();
		dr.get("http://webapp.qedgetech.com");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pr=new Properties();
		fi=new FileInputStream("D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\properities\\Rep.properties");
		pr.load(fi);
		expval="Login";
		actval=dr.findElement(By.id(pr.getProperty("Login"))).getText();
		if(expval.equalsIgnoreCase(actval))
		{
			return "Application opened ";
		}
		else
		{
			return "Fail";
		}
	}
	public String AdminLogin(String Un,String Pwd)
	{
		dr.findElement(By.id(pr.getProperty("Reset"))).click();
		dr.findElement(By.id(pr.getProperty("Uname"))).sendKeys(Un);
		dr.findElement(By.id(pr.getProperty("Pwd"))).sendKeys(Pwd);
		dr.findElement(By.id(pr.getProperty("Login"))).click();
		if(dr.findElement(By.linkText(pr.getProperty("Logout"))).isDisplayed())
		{
			return "Login pass";
			
		}
		else
		{
			return " Login Fail";
		}
	}
	public String SuppCreation(String Sname,String Add,String city,String Country,String Cp,String Phnum,String Email,String Mobno,String Notes)
	{
		expval="Add succeeded";
		dr.findElement(By.linkText(pr.getProperty("Supplier"))).click();
		Sleeper.sleepTightInSeconds(2);
		dr.findElement(By.xpath(pr.getProperty("addsupp"))).click();
		dr.findElement(By.id(pr.getProperty("supname"))).sendKeys(Sname);
		dr.findElement(By.id(pr.getProperty("supaddress"))).sendKeys(Add);
		dr.findElement(By.id(pr.getProperty("supcity"))).sendKeys(city);
		dr.findElement(By.id(pr.getProperty("supcountry"))).sendKeys(Country);
		dr.findElement(By.id(pr.getProperty("supcontactperson"))).sendKeys(Cp);
		dr.findElement(By.id(pr.getProperty("supphnum"))).sendKeys(Phnum);
		dr.findElement(By.id(pr.getProperty("supemail"))).sendKeys(Email);
		dr.findElement(By.id(pr.getProperty("supmbno"))).sendKeys(Mobno);
		
		dr.findElement(By.id(pr.getProperty("supnotes"))).sendKeys(Notes);
		
		dr.findElement(By.id(pr.getProperty("supadd"))).click();
		Sleeper.sleepTightInSeconds(2);
		dr.findElement(By.xpath(pr.getProperty("supaddconfirm"))).click();
		Sleeper.sleepTightInSeconds(2);
		String acval=dr.findElement(By.xpath(pr.getProperty("supaddsuccessed"))).getText();
		dr.findElement(By.xpath(pr.getProperty("supadded"))).click();
		if(expval.equalsIgnoreCase(acval))
		{
			return "Supplier created";
		}
		else
		{
            return "Supplier creation failed";

		}
	}

		
		public String Stockcatcreation(String Scname)
		{
			Actions act=new Actions(dr);
			act.moveToElement(dr.findElement(By.linkText(pr.getProperty("Stockitem")))).build().perform();
			 expval="Add succeeded";
			dr.findElement(By.linkText(pr.getProperty("Stockcategory"))).click();
			Sleeper.sleepTightInSeconds(2);
			dr.findElement(By.xpath(pr.getProperty("addstockcategory"))).click();
			Sleeper.sleepTightInSeconds(2);
			dr.findElement(By.id(pr.getProperty("Scname"))).sendKeys(Scname);
			dr.findElement(By.id(pr.getProperty("Scadd"))).click();
			dr.findElement(By.xpath(pr.getProperty("Scaddconfirm"))).click();
			String actval=dr.findElement(By.xpath(pr.getProperty("Scaddsuccessed"))).getText();
			dr.findElement(By.xpath(pr.getProperty("Scadded"))).click();
			if(expval.equalsIgnoreCase(actval))
			{
				return "Stock Category creation pass";
			}
			else
			{
				return "Stock Category creation Fail";
			}
			
		}
		public String UimCreation(String Uid,String Udesc)
		{
			Actions act1=new Actions(dr);
			String expval="Add succeeded";
			act1.moveToElement(dr.findElement(By.linkText(pr.getProperty("Stockitem1")))).build().perform();
			dr.findElement(By.linkText(pr.getProperty("Uom"))).click();
			dr.findElement(By.xpath(pr.getProperty("addUom"))).click();
			dr.findElement(By.id(pr.getProperty("UomId"))).sendKeys(Uid);
			dr.findElement(By.id(pr.getProperty("Uomdesc"))).sendKeys(Udesc);
			dr.findElement(By.id(pr.getProperty("Uomadd"))).click();
			Sleeper.sleepTightInSeconds(2);
			dr.findElement(By.xpath(pr.getProperty("Uomaddconfirm"))).click();
			Sleeper.sleepTightInSeconds(2);
			String actval=dr.findElement(By.xpath(pr.getProperty("Uomaddsuccessed"))).getText();
			dr.findElement(By.xpath(pr.getProperty("Uomadded"))).click();
			if(expval.equalsIgnoreCase(actval))
			{
                return "Unit Of Measurement Creation pass";

			}
			else
			{
				 return "Unit Of Measurement Creation Fail";
			}
			
			
		}
		public String StockitemCreation(String Scategory,String supnum,String stkname,int Uom,String purchaseprice,String Saleprice,String Notes)
		{
			dr.findElement(By.linkText(pr.getProperty("Stockitems"))).click();
			String expval="Add succeeded";
			dr.findElement(By.xpath(pr.getProperty("addStockitem"))).click();
			Select sclist=new Select(dr.findElement(By.id(pr.getProperty("SStockcategory"))));
			sclist.selectByVisibleText(Scategory);
			Select splist=new Select(dr.findElement(By.id(pr.getProperty("Suppnum"))));
			splist.selectByVisibleText(supnum);
			dr.findElement(By.id(pr.getProperty("Stockname"))).sendKeys(stkname);
			Sleeper.sleepTightInSeconds(2);
			Select umlist=new Select(dr.findElement(By.id(pr.getProperty("SUom"))));
			umlist.selectByIndex(Uom);
			dr.findElement(By.id(pr.getProperty("Purchaseprice"))).sendKeys(purchaseprice);
			dr.findElement(By.id(pr.getProperty("Sellingprice"))).sendKeys(Saleprice);
			dr.findElement(By.id(pr.getProperty("Snotes"))).sendKeys(Notes);
			dr.findElement(By.id(pr.getProperty("Stkitemadd"))).click();
			dr.findElement(By.xpath(pr.getProperty("Stkitemaddconfirm"))).click();
			Sleeper.sleepTightInSeconds(2);
			String actval=dr.findElement(By.xpath(pr.getProperty("Stkitemaddsuccessed"))).getText();
			dr.findElement(By.xpath(pr.getProperty("Stkitemadded"))).click();
			if(expval.equalsIgnoreCase(actval))
			{
				return "Stock Item Creation Pass";
			}
			else
			{
				return "Stock Item Creation Fail";
			}
			
		}
		public String logout()
		{
			dr.findElement(By.xpath(pr.getProperty("logout"))).click();
			Sleeper.sleepTightInSeconds(2);
			List<WebElement> els=dr.findElements(By.xpath(pr.getProperty("logoutok")));
			for (int i = 0; i <els.size(); i++)
			{
				if (els.get(i).getText().equalsIgnoreCase("OK!"))
				{
					els.get(i).click();
					break;
					
				}
				
			}
			
			//dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
			expval="Login";
			actval=dr.findElement(By.id(pr.getProperty("Login"))).getText();
			
			if(expval.equalsIgnoreCase(actval))
			{
				return "logout pass";
			}
			else
			{
				return "logout fail";
			}
		}
		public void CloseApp()
		{
			dr.quit();
		}
		public String purchasecreation(String Suppid,String notes,String Suppnum,String Stkitem,String Purquantity,String totpaymnt)
		{
			String expval="Add succeeded";
			dr.findElement(By.linkText(pr.getProperty("purchases"))).click();
			dr.findElement(By.xpath(pr.getProperty("addPurchase"))).click();
			dr.findElement(By.xpath(pr.getProperty("pr2del"))).click();
			dr.findElement(By.xpath(pr.getProperty("pr3del"))).click();
			Select spplist=new Select(dr.findElement(By.id(pr.getProperty("psuppid"))));
			spplist.selectByVisibleText(Suppid);
			dr.findElement(By.id(pr.getProperty("pnotes"))).sendKeys(notes);
			Sleeper.sleepTightInSeconds(5);
			Select spp1list=new Select(dr.findElement(By.id(pr.getProperty("psuppnum"))));
			spp1list.selectByVisibleText(Suppnum);
			Select sckilist=new Select(dr.findElement(By.id(pr.getProperty("pstkitem"))));
			sckilist.selectByVisibleText(Stkitem);
			Sleeper.sleepTightInSeconds(3);
			dr.findElement(By.id(pr.getProperty("purchasequantity"))).sendKeys(Purquantity);
			dr.findElement(By.id(pr.getProperty("purchasequantity"))).click();
			
			Sleeper.sleepTightInSeconds(10);
			dr.findElement(By.id(pr.getProperty("totalpayment"))).sendKeys(totpaymnt);
			
			Sleeper.sleepTightInSeconds(5);
			
			dr.findElement(By.id(pr.getProperty("purchaseadd"))).click();
			
			dr.findElement(By.xpath(pr.getProperty("Purchaseaddconfirm"))).click();
			Sleeper.sleepTightInSeconds(2);
			String actval=dr.findElement(By.xpath(pr.getProperty("Purchaseaddsuccessed"))).getText();
			dr.findElement(By.xpath(pr.getProperty("purchaseadded"))).click();
			if(expval.equalsIgnoreCase(actval))
			{
                    return "Purchases Creation Pass";
			}
			else
			{
				return "Purchases Creation Fail";
			}
			
		}
		public String Customercreation(String cname,String cadd,String ccity,String Ccountry,String Ccp,String CPhnum,String CEmail,String CMobno,String CNotes )
		{
			String expval="Add succeeded";
			dr.findElement(By.linkText(pr.getProperty("customer"))).click();
			dr.findElement(By.xpath(pr.getProperty("addcust"))).click();
			dr.findElement(By.id(pr.getProperty("x_Customer_Name"))).sendKeys(cname);
			dr.findElement(By.id(pr.getProperty("x_Address"))).sendKeys(cadd);
			dr.findElement(By.id("x_City")).sendKeys(ccity);
			dr.findElement(By.id("x_Country")).sendKeys(Ccountry);
			dr.findElement(By.id("x_Contact_Person")).sendKeys(Ccp);
			dr.findElement(By.id("x_Phone_Number")).sendKeys(CPhnum);
			dr.findElement(By.id("x__Email")).sendKeys(CEmail);
			dr.findElement(By.id("x_Mobile_Number")).sendKeys(CMobno);
			dr.findElement(By.id("x_Notes")).sendKeys(CNotes);
			dr.findElement(By.id("btnAction" )).click();
			dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
			Sleeper.sleepTightInSeconds(2);
			String actval=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
			dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
			if(expval.equalsIgnoreCase(actval))
			{
				return "Customer Creation Pass";
			}
			else
			{
				return "Customer Creation Fail";
			}
			
		}
		public String Salescreation(String CustId,String Suppnum,String Stkitem,String Salesquantity,String Discper,String Taxperc,String TotalPaymnt)
		{
			String expval="Add succeeded";
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
			clist.selectByVisibleText(CustId);
			Select supplist=new Select(dr.findElement(By.id("x1_Supplier_Number")));
			supplist.selectByVisibleText(Suppnum);
			Sleeper.sleepTightInSeconds(5);
			Select sckilist1=new Select(dr.findElement(By.id("x1_Stock_Item")));
			sckilist1.selectByVisibleText(Stkitem);
			dr.findElement(By.id("x1_Sales_Quantity")).sendKeys(Salesquantity);
			dr.findElement(By.id("x1_Sales_Quantity")).click();
			
			dr.findElement(By.xpath(".//*[@id='x1_Purchasing_Price']")).click();
			dr.findElement(By.xpath(".//*[@id='x1_Sales_Price']")).click();
			
		       dr.findElement(By.xpath(".//*[@id='x1_Sales_Total_Amount']")).click();
		       
			Sleeper.sleepTightInSeconds(10);
			dr.findElement(By.id("x_Discount_Percentage")).sendKeys(Discper);
			dr.findElement(By.id("x_Tax_Percentage")).sendKeys(Taxperc);
			
			dr.findElement(By.xpath(".//*[@id='x_Total_Payment']")).sendKeys(TotalPaymnt);
			Sleeper.sleepTightInSeconds(5);
			dr.findElement(By.id("btnAction")).click();
			dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
			Sleeper.sleepTightInSeconds(2);
			String actval=dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
			dr.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
			if(expval.equalsIgnoreCase(actval))
			{
				return "Sales Creation pass";
			}
			else
			{
				return "Sales Creation fail";
			}
			
		}
	

}
