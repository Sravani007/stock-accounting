package com.StockAccounting.Master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Scategorynotepad {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String res;
		Stocklib sl=new Stocklib();
		res=sl.OpenApp("http://webapp.qedgetech.com");
		System.out.println(res);
		res=sl.AdminLogin("admin", "master");
		System.out.println(res);
//Filepath
		String Fpath="D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Testdata\\Scategory.txt";
		//Creating text file for results
		String Rpath="D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Results\\scategoryres.txt";
		String sd;
		FileReader fr=new FileReader(Fpath);
		BufferedReader br=new BufferedReader(fr);
		String sread=br.readLine();
		System.out.println(sread);
		FileWriter fw=new FileWriter(Rpath);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(sread+"###"+ "Results");
		bw.newLine();
		while((sd=br.readLine())!=null)
		{
			System.out.println(sd);
			String Scategory=sd;
			res=sl.Stockcatcreation(Scategory);
			System.out.println(res);
			bw.write(sd+"%%%"+res);
			bw.newLine();
			}
		bw.close();
		br.close();
	}

}
