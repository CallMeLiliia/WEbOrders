package io.duotech.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.duotech.pages.ListOFAllOrdersPage;
import io.duotech.pages.LoginPage;
import io.duotech.pages.OrderPage;

public class OrderTests extends TestBase {
	
	@BeforeMethod
	public void loginAndGoToOrderPage() {
		LoginPage loginPage = new LoginPage();
		loginPage.positiveLogin();
		Assert.assertTrue(driver.getTitle().contains("Web Orders"));

		ListOFAllOrdersPage allOrders = new ListOFAllOrdersPage();
		allOrders.orderLink.click();
	}

	@Test
	public void verifyQuantityErrorMessage() {

		OrderPage orderPage = new OrderPage();
		orderPage.processButton.click();
		String expected = "Quantity must be greater than zero.";
		String actual = orderPage.quantityErrMessage.getText();
		Assert.assertEquals(actual, expected);
	}

}
