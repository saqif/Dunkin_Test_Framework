package com.dunkin.shadman.onlineStore.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dunkin.shadman.onlineStore.helper.javascript.JavaScriptHelper;
import com.dunkin.shadman.onlineStore.testBase.TestBase;

public class TestScreenShot extends TestBase {
	@Test
	public void testScreen() throws InterruptedException {
		driver.get("http://facebook.com");
//		WebElement e = driver.findElement(By.xpath("//*[@id=\"globalSearchInputField\"]"));
//		e.click();
//		e.sendKeys("shirt");
//		new JavaScriptHelper(driver).executeScript("document.getElementById(\"autosuggest\").style.display = \"block\";");
//		Thread.sleep(5000);
//		e.clear();
//		e.sendKeys("Men");
		
		captureScreen("facebookSceenShot");
	}
}
