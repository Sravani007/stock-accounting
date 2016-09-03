package com.StockAccounting.Master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class grid {
 DesiredCapabilities cap=null;
 @Parameters("browser")
 @Test
 public void exe(String br) throws MalformedURLException
 {
	 if(br.equalsIgnoreCase("firefox"))
	 {
		 cap=new DesiredCapabilities();
		 cap.setBrowserName("firefox");
		 cap.setPlatform(Platform.WINDOWS);
	 }
	 else if(br.equalsIgnoreCase("chrome"))
	 {
		 cap=new DesiredCapabilities();
		 cap.setBrowserName("chrome");
		 cap.setPlatform(Platform.WINDOWS);
	 }
	 else if(br.equalsIgnoreCase("ie"))
	 {
		 cap=new DesiredCapabilities();
		 cap.setBrowserName("iexplore");
		 cap.setPlatform(Platform.WINDOWS);
	 }
	 
	 RemoteWebDriver dr=new RemoteWebDriver(new URL("http://10.0.0.215:4444/wd/hub"), cap);
	 dr.get("http://webapp.qedgetech.com");
	 loginpage lp=PageFactory.initElements(dr, loginpage.class);
		lp.adminlogin("admin", "master");
 }
}
