package com.StockAccounting.Master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exestock {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
String res;
Stocklib sl=new Stocklib();
res=sl.OpenApp("http://webapp.qedgetech.com");
System.out.println(res);
res=sl.AdminLogin("admin", "master");
System.out.println(res);
/*res=sl.SuppCreation("ananyamobiles", "SRnagar", "Hyderabad", "India", "anand", "0401234567", "anan@gmail.com", "9856321452", "mobiles");
System.out.println(res);
res=sl.Stockcatcreation("pouch1");
System.out.println(res);
res=sl.UimCreation("kaleros", "10kgs");
System.out.println(res);

res=sl.StockitemCreation("pouch1", "anandmobiles", "samsung201", 6, "10,000", "15,000", "mobiles");
System.out.println(res);

res=sl.purchasecreation("anandmobiles", "mobiles", "anandmobiles", "samsung200", "10", "10000");
System.out.println(res);
res=sl.Customercreation("ramana", "dsnr", "hyd", "India","Ramana", "0401257896", "ra@gmail.com", "8956231452", "Regularcustomer");
System.out.println(res);

res=sl.Salescreation("ramana", "anandmobiles", "samsung500", "10", "2", "1", "20000");
System.out.println(res);
res=sl.Customercreation("ramana", "dsnr", "hyd", "India","Ramana", "0401257896", "ra@gmail.com", "8956231452", "Regularcustomer");
System.out.println(res);
res=sl.logout();
System.out.println(res);
sl.CloseApp();*/
/*FileInputStream fi=new FileInputStream("D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Testdata\\Uom.xlsx");
XSSFWorkbook wb=new XSSFWorkbook(fi);
XSSFSheet ws=wb.getSheet("Uomdata");
int rc=ws.getLastRowNum();
System.out.println(rc);
for (int i = 1; i <=rc; i++)
{
	
	XSSFRow wr=ws.getRow(i);
	XSSFCell wc1=wr.getCell(0);
	XSSFCell wc2=wr.getCell(1);
	XSSFCell wc3=wr.createCell(2);
	
	String uid=wc1.getStringCellValue();
	String Udes=wc2.getStringCellValue();
	res=sl.UimCreation(uid, Udes);
	System.out.println(res);
	wc3.setCellValue(res);
CellStyle passtyle=wb.createCellStyle();
passtyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
passtyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
wc3.setCellStyle(passtyle);


	
}
FileOutputStream fo=new FileOutputStream("D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Results\\Uomresult.xlsx");
wb.write(fo);
wb.close();*/

FileInputStream fi1=new FileInputStream("D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Testdata\\Stockcategorydata.xlsx");
XSSFWorkbook wb1=new XSSFWorkbook(fi1);
XSSFSheet ws1=wb1.getSheet("Scdata");
XSSFSheet ws2=wb1.getSheet("Stockitemdata");
XSSFSheet ws3=wb1.getSheet("Supplierdata");
int rc1=ws1.getLastRowNum();
int rc2=ws2.getLastRowNum();
int rc3=ws3.getLastRowNum();
System.out.println(rc1);
for (int i = 1; i <=rc1; i++)
{
	
	XSSFRow wr1=ws1.getRow(i);
	XSSFCell wc1=wr1.getCell(0);

	XSSFCell wc2=wr1.createCell(1);
	
	String Scategory=wc1.getStringCellValue();
	
	res=sl.Stockcatcreation(Scategory);
	System.out.println(res);
	wc2.setCellValue(res);
CellStyle passtyle=wb1.createCellStyle();
passtyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
passtyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
wc2.setCellStyle(passtyle);


	
}
for (int i = 1; i <=rc2; i++)
{
	
	XSSFRow wr1=ws2.getRow(i);
	XSSFCell wc1=wr1.getCell(0);
	
	XSSFCell wc2=wr1.getCell(1);

	XSSFCell wc3=wr1.getCell(2);

	XSSFCell wc4=wr1.getCell(3);
	XSSFCell wc5=wr1.getCell(4);

	XSSFCell wc6=wr1.getCell(5);

	XSSFCell wc7=wr1.getCell(6);


	XSSFCell wc8=wr1.createCell(7);
	
	String Scategory=wc1.getStringCellValue();
	String Suppnum=wc2.getStringCellValue();
	String Stkname=wc3.getStringCellValue();
	String Uom=wc4.getStringCellValue();
	int Uomid=Integer.parseInt(Uom);
	String Purprice=wc5.getStringCellValue();
	String Sellprice=wc6.getStringCellValue();
	String notes=wc7.getStringCellValue();
	
	res=sl.StockitemCreation(Scategory, Suppnum, Stkname, Uomid, Purprice, Sellprice, notes);
	System.out.println(res);
	wc8.setCellValue(res);
CellStyle passtyle=wb1.createCellStyle();
passtyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
passtyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
wc8.setCellStyle(passtyle);


	
}
for (int j = 1; j<=rc3; j++)
{
	XSSFRow r1=ws3.getRow(j);
	XSSFCell c1=r1.getCell(0);
	XSSFCell c2=r1.getCell(1);
	XSSFCell c3=r1.getCell(2);
	XSSFCell c4=r1.getCell(3);
	XSSFCell c5=r1.getCell(4);
	XSSFCell c6=r1.getCell(5);
	XSSFCell c7=r1.getCell(6);
	XSSFCell c8=r1.getCell(7);
	XSSFCell c9=r1.getCell(8);
	XSSFCell c10=r1.createCell(9);
	String supname=c1.getStringCellValue();
	String add=c2.getStringCellValue();
	String City=c3.getStringCellValue();
	String country=c4.getStringCellValue();
	String cp=c5.getStringCellValue();
	String phnum=c6.getStringCellValue();
	String email=c7.getStringCellValue();
	String mobno=c8.getStringCellValue();
	String notes=c9.getStringCellValue();
	res=sl.SuppCreation(supname, add, City, country, cp, phnum, email, mobno, notes);
	System.out.println(res);
	c10.setCellValue(res);
	
	CellStyle passtyle=wb1.createCellStyle();
	passtyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	passtyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	c10.setCellStyle(passtyle);

	
}

FileOutputStream fo1=new FileOutputStream("D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Results\\Stockcategoryresult.xlsx");
wb1.write(fo1);
wb1.close();

	}

}
