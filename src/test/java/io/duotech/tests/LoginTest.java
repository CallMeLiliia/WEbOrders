package io.duotech.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.duotech.pages.LoginPage;
import io.duothech.utils.ConfigReader;

public class LoginTest extends TestBase {


	@Test
	public void loginPOMPattern() {
		logger = reporter.createTest("Positive Login Test");
		
		
		LoginPage loginPage = new LoginPage();
		logger.info("Loggin in by entering correct crefentials");
		loginPage.positiveLogin();
		logger.info("Verifying the title contains Web Orders");
		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//div[@class='login_info']")).getText().contains("Welcome, Tester!"));
		
		logger.pass("Verified that the Title containes \"Web Orders\"");
	}

	@Test
	public void loginPOMPatternNegative() {
		
		logger = reporter.createTest("Negative Login Test");
		LoginPage loginPage = new LoginPage();
		loginPage.usernameField
				.sendKeys(new StringBuilder(ConfigReader.getConfiguration("username")).reverse().toString());
		loginPage.passwordField
				.sendKeys(new StringBuilder(ConfigReader.getConfiguration("password")).reverse().toString());
		loginPage.loginButton.click();
		String errorMessage = "Invalid Login or Password.";
		AssertJUnit.assertEquals(loginPage.errorMEssage.getText(), errorMessage);
		logger.pass("Verified that the Title containes \"Invalid Login or Password\"");
	}

}
