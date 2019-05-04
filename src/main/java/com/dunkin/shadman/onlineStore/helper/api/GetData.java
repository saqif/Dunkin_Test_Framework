package com.dunkin.shadman.onlineStore.helper.api;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	String s = "fsf";
	
	StringBuffer sb = new StringBuffer(s);
	
	public void get() {
		s = "fsff";
	}
	
	@Test(priority=1)
	public void test1() {
		get();
		System.out.println(s);
	}
	
	@Test(priority=2)
	public void test2() {
		sb.append("saqif");
		s = s.concat("rihad");
		
		System.out.println(sb);
		System.out.println(s);
		int b = 4;
		
		switch(b) {
		case 1: 
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		case 4:
			System.out.println("4");
			break;
		case 5:
			System.out.println("5");
			break;
		default:
			System.out.println("default");
			break;
		}
		//int i = 0;
		int[] a = {1,6,3,2,7};
		//Arrays.sort(a);
		int[] a1 = new int[a.length];
		int i = 0;
		for(int bc:a) {
			//System.out.println(bc);
			a1[i] = bc;
			i++;
		}
		
		System.out.println("=======");
		int[] c = a;
		
		
	}
	
	
//	final static int ab = 50;
//	@Test
//	public void getResponseCode(){
//		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
//		int code = response.getStatusCode();
//		
//		System.out.println("code is : "+code);
//		Assert.assertEquals(code, 200);
//	}
//	
//	@Test
//	public void getResponseBody(){
//		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
//		String code = response.asString();
//		
//		System.out.println("Data is : " + code);
//		System.out.println("ResponseTime : " + response.getTime());
//		
//	}
//	
//	@Test
//	public void testString() {
//		String a = new StringBuffer("Saqif").reverse().toString();
//		System.out.println(a);
//		
//		for(int i =a.length()-1; i>=0; i--) {
//			System.out.println(a.charAt(i));
//		}
//		int abc = 49;
//		System.out.println(ab);
//	}
//	
//	//single dimension
//	@DataProvider(name="loginData")
//	public Object[] setData() {
//		Object[] a = new Object[3];
//		a[0] = 1;
//		a[1] = 2;
//		a[2] = 3;
//		
//		return a;
//	}
//	
//	@Test(dataProvider="loginData")
//	public void main2(int a) throws Exception {
//		System.out.println(a);
//    }
//	
//	//double dimension
//	@DataProvider(name="doubleData")
//	public Object[][] setDoubleData(){
//		Object a[][] = new Object[3][2];
//		for(int i=0; i<3; i++) {
//			for(int j=0; j<2; j++) {
//				a[i][j] = i+j;
//				//System.out.println(i+" " +j);
//			}
//		}
//		
//		return a;
//	}
//	
//	@Test(dataProvider="doubleData")
//	public void doubleDatab(int a, int b) {
//		System.out.println(a+" "+b);
//	}
//	
//	@Test
//	public void takeScreen(ITestResult result) {
//		WebDriver dr = new ChromeDriver();
//		try {
//			File destination = null;
//			TakesScreenshot ts = (TakesScreenshot)dr;
//			File source = ts.getScreenshotAs(OutputType.FILE);
//			Files.copy(source, destination);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(result.getStatus()==ITestResult.FAILURE) {
//			
//		}
//	}
}
