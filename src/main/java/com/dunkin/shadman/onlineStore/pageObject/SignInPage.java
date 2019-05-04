package com.dunkin.shadman.onlineStore.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dunkin.shadman.onlineStore.helper.assertion.VerificationHelper;
import com.dunkin.shadman.onlineStore.helper.browserConfiguration.config.ObjectReader;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;
import com.dunkin.shadman.onlineStore.helper.wait.WaitHelper;
import com.dunkin.shadman.onlineStore.testBase.TestBase;

public class SignInPage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(SignInPage.class);
	private WaitHelper waitHelper;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/section/div/div/div[2]/h1[1]/span")
	WebElement acountSignInText;
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailAddress;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div[2]/section/div/div[1]/form/div[1]/a")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div[2]/section/div/div[1]/form/div[1]/div[3]/div/input")
	WebElement signInButton;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div[2]/section/div/div[3]/div/a")
	WebElement signUpButton;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div[2]/section/div/div[1]/form/div[1]")
	WebElement errorMsg;
	
	public SignInPage(WebDriver driver) {
		log.info("SignInPage initializing...");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(acountSignInText, ObjectReader.reader.getExplicitWait(), 500);
		log.info("pagefactory for SignInPage loaded... SignInPage initialized.");
		new TestBase().getNavigationScreen(driver,"SignInPage");
	}
	
	public void fillingUpSignInFormAndSubmit() {
		log.info("putting username");
		emailAddress.sendKeys(ObjectReader.reader.getUserName());
		log.info("putting password");
		password.sendKeys(ObjectReader.reader.getPassword());
		log.info("clicking on sign in button");
		signInButton.click();
	}
	
	public void fillingUpSignInFormAndSubmit(String username, String pass) {
		log.info("putting username");
		emailAddress.sendKeys(username);
		log.info("putting password");
		password.sendKeys(pass);
		log.info("clicking on sign in button");
		signInButton.click();
		log.info("clicked");
	}
	
	public boolean verifySignInPage() {
		return new VerificationHelper(driver).isDiplayed(acountSignInText);
	}
	
	public boolean verifySignInPageError() {
		return new VerificationHelper(driver).isDiplayed(errorMsg);
	}
	
	
	
	
	
	
}
