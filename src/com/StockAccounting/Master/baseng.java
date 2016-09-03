package com.StockAccounting.Master;




import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class baseng {
	Stocklib sl=new Stocklib();
	
  
  @BeforeTest
  public void beforeTest() 
  {
	  sl.AdminLogin("admin", "master");
	  
  }

  @AfterTest
  public void afterTest() {
	  sl.logout();
	  
  }

  @BeforeSuite
  public void beforeSuite() throws IOException 
  {
	  sl.OpenApp("http://webapp.qedgetech.com");
	 
  }

  @AfterSuite
  public void afterSuite() {
	  sl.CloseApp();
  }

}
