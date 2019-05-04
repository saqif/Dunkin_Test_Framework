package com.dunkin.shadman.onlineStore.testScripts.homepage;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dunkin.shadman.onlineStore.helper.assertion.AssertionHelper;
import com.dunkin.shadman.onlineStore.helper.browserConfiguration.config.ObjectReader;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;
import com.dunkin.shadman.onlineStore.pageObject.Homepage;
import com.dunkin.shadman.onlineStore.pageObject.SignInPage;
import com.dunkin.shadman.onlineStore.testBase.TestBase;

import io.restassured.internal.assertion.Assertion;

public class SignInTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(SignInTest.class);
	Homepage hp;
	SignInPage sp;
	
	@DataProvider(name="logindata")
	public Object[][] loginCredentials(){
		return getExcelData("workbook.xlsx", "login");
	}
	
	@Test(description = "Going to login page from Homepage", priority=1)
	public void goingToSignInPage() {
		get(ObjectReader.reader.getUrl());
		hp = new Homepage(driver);
		sp = hp.clickOnSignInLinkOnTop();
		AssertionHelper.updateTestStatus(sp.verifySignInPage());
	}
	
	@Test(dataProvider="logindata", description="input the username and password", priority=2)
	public void testWithLoginCredentials(String username, String password) {
		sp.fillingUpSignInFormAndSubmit(username, password);
		if(sp.verifySignInPageError()) {
			AssertionHelper.makeFalse("Error: incorrect credentials -> " + username + " | " + password);
		} else {
			AssertionHelper.makeTrue("Success: correct credentials -> " + username + " | " + password);
		}
		
	}
	
	
}
