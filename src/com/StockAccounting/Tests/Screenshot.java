package com.StockAccounting.Tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Screenshot {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 WebDriver dr=new FirefoxDriver();
 dr.get("http://gmail.com");
 
 
 
 
 File srcfile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
 FileUtils.copyFile(srcfile, new File("D:\\scrshot.jpg"));
 
	}

}
