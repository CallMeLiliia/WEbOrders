package io.duotech.tests;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.duotech.pages.ListOFAllOrdersPage;
import io.duotech.pages.LoginPage;
import io.duothech.utils.BrowserUtilities;

public class AllOrdersTests extends TestBase {
	@BeforeMethod
	public void setUpTest() {
		LoginPage login = new LoginPage();
		login.positiveLogin();
		Assert.assertTrue(driver.getTitle().contains("Web Orders"));
	}

	@Test

	public void verifyCheckBoxes() throws IOException {

		ListOFAllOrdersPage allOrders = new ListOFAllOrdersPage();
		allOrders.checkAllButton.click();

		BrowserUtilities.takeFullScreenshot("Clicked Check All");

		for (WebElement e : allOrders.checkBoxes) {

//			actions.moveToElement(e).click().build().perform();
			Assert.assertTrue(e.isSelected());

		}

	}

	@Test
	public void verifyUncheckBoxes() {

		ListOFAllOrdersPage allOrders = new ListOFAllOrdersPage();
		allOrders.checkAllButton.click();
		allOrders.uncheckAllButton.click();

		for (WebElement e : allOrders.checkBoxes) {
			Assert.assertFalse(e.isSelected());

		}

	}

	@Test
	public void verifyMessageAfterDeleteAll() {
		ListOFAllOrdersPage allOrdersPage = new ListOFAllOrdersPage();
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertTrue(driver.getTitle().contains("Web Orders"), "Title is not correct");

		softAssert.assertTrue(allOrdersPage.welcomeMessage.getText().contains("Wlcome, Tester"));
		System.out.println("After Hard Assertion");

		allOrdersPage.checkAllButton.click();
		allOrdersPage.deleteSelectedButton.click();

		softAssert.assertTrue(allOrdersPage.orderEmtyMessage.getText()
				.contains("List of orders is empty. In order to add new order use"));
softAssert.assertAll();
		
	}

}
