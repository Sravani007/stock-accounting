package com.StockAccounting.Master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Uomnotepad {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		String res;
		Stocklib sl=new Stocklib();
		res=sl.OpenApp("http://webapp.qedgetech.com");
		System.out.println(res);
		res=sl.AdminLogin("admin", "master");
		System.out.println(res);
//Filepath
		String Fpath="D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Testdata\\Uom.txt";
		//Creating text file for results
		String Rpath="D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Results\\Uomres.txt";
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
			String sr[]=sd.split("###");
			String uid=sr[0];
			System.out.println(uid);
			String udesc=sr[1];
			System.out.println(udesc);
			res=sl.UimCreation(uid, udesc);
			System.out.println(res);
			bw.write(uid+"###"+udesc+"@@@" +res);
			bw.newLine();
		}
		bw.close();
		br.close();


	}

}
