package io.duotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.duothech.utils.ConfigReader;
import io.duothech.utils.Driver;

public class LoginPage {
	
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this); 
	}
	
	@FindBy(id = "ctl00_MainContent_username")
	public WebElement usernameField;
	@FindBy(id="ctl00_MainContent_password")
	public WebElement passwordField;
	@FindBy(id="ctl00_MainContent_login_button")
	public WebElement loginButton;
	
	@FindBy(id = "ctl00_MainContent_status")
	public WebElement errorMEssage;
	
	public void positiveLogin() {
		usernameField.sendKeys(ConfigReader.getConfiguration("username"));
		passwordField.sendKeys(ConfigReader.getConfiguration("password"));
		loginButton.click();
	}
	

}
