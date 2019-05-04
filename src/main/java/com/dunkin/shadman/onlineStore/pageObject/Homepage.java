package com.dunkin.shadman.onlineStore.pageObject;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.dunkin.shadman.onlineStore.helper.browserConfiguration.config.ObjectReader;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;
import com.dunkin.shadman.onlineStore.helper.wait.WaitHelper;
import com.dunkin.shadman.onlineStore.testBase.TestBase;

public class Homepage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(Homepage.class);
	private WaitHelper waitHelper;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/nav/ul[2]/li/a")
	WebElement DDperksImage;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div[3]/div[2]/div[2]/a")
	WebElement signInLinkOnTop;
	
	@FindBy(xpath="//*[@id=\"global-nav-nonperks\"]/nav/div[2]/div/a[1]")
	WebElement signInButtonAfterClickingDDperksImage;
	
	@FindBy(xpath="//*[@id=\"global-nav-nonperks\"]/nav/div[2]/div/a[2]")
	WebElement learnMoreButtonAfterClickingDDperksImage;
	
	public Homepage(WebDriver driver) {
		log.info("Homepage initializing...");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(DDperksImage, ObjectReader.reader.getExplicitWait(),1);
		log.info("pagefactory for homepage loaded... Homepage initialized.");
		new TestBase().getNavigationScreen(driver,"Homepage");
	}
	
	public SignInPage clickOnSignInLinkOnTop() {
		log.info("Clicking on SignInLinkOnTop");
		new WaitHelper(driver).waitForElement(signInLinkOnTop, ObjectReader.reader.getExplicitWait(),1);
		TestBase.test.log(Status.INFO, "Clicking on "+signInLinkOnTop.getText());
		signInLinkOnTop.click();
		log.info("Clicked");
		return new SignInPage(driver);
	}
	
	public void clickOnDDperksImage() {
		log.info("Clicking on DDperksImage");
		DDperksImage.click();
		log.info("Clicked");
		
		TestBase.test.log(Status.INFO, "Clicking on "+DDperksImage.getText());
	}
	
	public SignInPage clickOnSignInButtonAfterClickingDDperksImage() {
		log.info("Clicking on signInButtonAfterClickingDDperksImage");
		signInButtonAfterClickingDDperksImage.click();
		log.info("Clicked");
		TestBase.test.log(Status.INFO, "Clicking on "+signInButtonAfterClickingDDperksImage.getText());
		return new SignInPage(driver);
	}
	
	public void clickOnLearnMoreButtonAfterClickingDDperksImage() {
		log.info("Clicking on learnMoreButtonAfterClickingDDperksImage");
		learnMoreButtonAfterClickingDDperksImage.click();
		log.info("Clicked");
		TestBase.test.log(Status.INFO, "Clicking on "+learnMoreButtonAfterClickingDDperksImage.getText());
	}
	
}
