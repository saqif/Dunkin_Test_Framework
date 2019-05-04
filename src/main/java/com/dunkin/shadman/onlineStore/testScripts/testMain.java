package com.dunkin.shadman.onlineStore.testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testMain {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("/Users/shadmanshahriyar/Downloads/test.xlsx");
		
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet1 = workbook.getSheetAt(0);
		
		int rowcount = sheet1.getLastRowNum()+1;
		System.out.println("total row "+rowcount);
		
		int columncount = sheet1.getRow(1).getLastCellNum();
		System.out.println("total column "+columncount);
		
		
		Object[][] data = new Object [rowcount][columncount];
		
		for(int i=0; i<rowcount; i++) {
			
			for(int j=0;j<columncount; j++) {
				//System.out.println(i+" "+j);
				data[i][j] = sheet1.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
			
			
		}
	}
	
	
	public void something(String[] args) {
		
		
		ArrayList al = runArrayList();
		System.out.println(al);
		System.out.println("");
		
		for(Object a:al) {
			System.out.println(a);
		}
		
		System.out.println("");
		
		Iterator i = al.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		ArrayList al1 = whatEver(al);
		Iterator it = al1.iterator();
		
		System.out.println("");
		for(Object a2:al) {
			System.out.println(a2);
		}
		
		while(it.hasNext()) {
			int num = (Integer) it.next();
			if(num%2 == 0) {
				it.remove();
				//al.add(9);
			}
		}
		
		System.out.println("");
		for(Object a2:al) {
			System.out.println(a2);
		}
		
	}
	
	public static void myListIterator() {
		ArrayList l = new ArrayList();
		l.add(8);
		l.add(9);
		ListIterator li = l.listIterator();
		while(li.hasNext()) {
			int a = (Integer)li.next();
			if(a%2==0) {
				System.out.println(a);
			} else if(a%3==0) {
				
			}
		}
	}
	
	public static ArrayList runArrayList() {
		ArrayList al = new ArrayList(); //we can store any kind of data
		//we have to follow generic concept like ArrayList<ReferenceDataType>
		ArrayList<Integer> arrInt = new ArrayList<Integer>(); // we have to use reference dataType like Integer which is wrapper class, we can not use primitive dataType like int.
		al.add(8);
		al.add(7);
		al.add(7);
		al.add(6);
		
		arrInt.add(null);
		arrInt.add(7);
		arrInt.add(7);
		arrInt.add(6);
		
		return al;
	}
	
	public static ArrayList whatEver(ArrayList a) {
		Iterator it = a.iterator();
		while(it.hasNext()) {
			int ab = (Integer) it.next();
			if(ab==6) {
				it.remove();
			}
		}
		return a;
	}
}
