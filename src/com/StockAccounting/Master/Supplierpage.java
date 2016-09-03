package com.StockAccounting.Master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

public class Supplierpage {
	
	@FindBy (xpath=".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")
	WebElement suppadd;
	@FindBy (id="x_Supplier_Name")
	WebElement suppname;
	@FindBy (id="x_Address")
	WebElement add;
	@FindBy (id="x_City")
	WebElement city;
	@FindBy (id="x_Country")
	WebElement country;
	@FindBy (id="x_Contact_Person")
	WebElement cp;
	@FindBy (id="x_Phone_Number")
	WebElement phnum;
	@FindBy (id="x__Email")
	WebElement email;
	@FindBy (id="x_Mobile_Number")
	WebElement mobno;
	@FindBy (id="x_Notes")
	WebElement notes;
	@FindBy (id="btnAction")
	WebElement btnadd;
	@FindBy (xpath="html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")
	WebElement confirm;
	@FindBy (xpath="html/body/div[.]/div[2]/div/div[4]/div[2]/button")
	WebElement addok;
	@FindBy (xpath="html/body/div[.]/div[2]/div/div[3]/div/div")
	WebElement addsuccess;
	
	public String suppcreation(String sname,String sadd,String scity,String scountry,String scp,String sphnum,String semail,String smobno,String snotes)
	{
		String expval="Add succeeded";
		Sleeper.sleepTightInSeconds(2);
		suppadd.click();
		suppname.sendKeys(sname);
		add.sendKeys(sadd);
		city.sendKeys(scity);
		country.sendKeys(scountry);
		cp.sendKeys(scp);
		phnum.sendKeys(sphnum);
		email.sendKeys(semail);
		mobno.sendKeys(smobno);
		notes.sendKeys(snotes);
		btnadd.click();
		Sleeper.sleepTightInSeconds(2);
		confirm.click();
		Sleeper.sleepTightInSeconds(3);
		addok.click();
		String actval=addsuccess.getText();
		if(expval.equalsIgnoreCase(actval))
		{
			return "Supplier creation pass";
		}
		else
		{
			return "Supplier creation fail";
		}
		}

}
