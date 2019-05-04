package com.dunkin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestC {
	int i = 2;
	
	@Test
	public void loginTestC() {
		if(i == 2) {
			System.out.println("this");

			String s = new String("a");
			s = new String("B");
			System.out.println(s);
			Assert.assertTrue(true);
		} else {
			i++;
			Assert.assertTrue(false);
			
		}
	}
}
