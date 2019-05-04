package com.dunkin;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestA {
	@Test(dataProvider="datas")
	public void loginTest(String b) {
		
		if(checkInteger(b)) {
			System.out.println(b);
			
			int a = 10;
			Integer ab = new Integer(5);
			ab.equals(5);
		}
		//Assert.assertTrue(true);
	}
	
	public boolean checkInteger(String d) {
		try {
			Integer.parseInt(d);
			return true;
		} catch(Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	@DataProvider(name="datas")
	public Object[] datas(){
		Object[] a = new Object[4];
		a[0] = "0";
		a[1] = "234abc";
		a[2] = "cds";
		a[3] = "234";
		return a;
	}
}
