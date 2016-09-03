package com.StockAccounting.Master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage
{
	@FindBy (id="username")
	WebElement Uname;
	@FindBy (id="password")
	WebElement Pwd;
	@FindBy (id="btnsubmit")
	WebElement login;
	@FindBy (id="btnreset")
	WebElement reset;
	@FindBy (id="logout")
	WebElement logout;
	
	public String adminlogin(String Un,String pwd)
	{
		reset.click();
		Uname.sendKeys(Un);
		Pwd.sendKeys(pwd);
		login.click();
		if(logout.isDisplayed())
		{
			return "Login pass";
		}
		else
		{
			return "Login fail";
		}
	}

}
