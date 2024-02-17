package com.hexaware.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonValues {

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	public WebElement textSearch;
	
	@FindBy(xpath="//input[@name=\'addCreditCardNumber\']")
	public WebElement cardNumber;
	
	public AmazonValues(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void enterSearch(String str) {
		textSearch.sendKeys(str);
	}
	
	public void enterCardNumber(String str) {
		cardNumber.sendKeys(str);
	}
}
