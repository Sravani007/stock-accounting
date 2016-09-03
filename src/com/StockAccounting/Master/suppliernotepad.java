package com.StockAccounting.Master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class suppliernotepad {

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
		String Fpath="D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Testdata\\supdata.txt";
		//Creating text file for results
		String Rpath="D:\\sravaniselprograms\\StockAccounting\\src\\com\\StockAccounting\\Results\\supplierres.txt";
		String sd;
		FileReader fr=new FileReader(Fpath);
		BufferedReader br=new BufferedReader(fr);
		String sread=br.readLine();
		System.out.println(sread);
		FileWriter fw=new FileWriter(Rpath);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(sread+"***"+ "Results");
		bw.newLine();
		while((sd=br.readLine())!=null)
		{
			System.out.println(sd);
			String sr[]=sd.split("##");
			String sname=sr[0];
			String add=sr[1];
			
			String City=sr[2];
			String country=sr[3];
			String cp=sr[4];
			String phno=sr[5];
			String email=sr[6];
			String mbno=sr[7];
			String notes=sr[8];
			
			res=sl.SuppCreation(sname, add, City, country, cp, phno, email, mbno, notes);
			System.out.println(res);
			bw.write(sname+"###"+add+"@@@"+City+"@@@"+country+"###"+cp+"&&&"+phno+"%%%"+email+"***"+mbno+"&&&"+notes+"###"+res);
			bw.newLine();
		}
		bw.close();
		br.close();

	}

}
