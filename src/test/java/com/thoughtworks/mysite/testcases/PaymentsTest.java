package com.thoughtworks.mysite.testcases;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.mysite.base.BaseTest;
import com.thoughtworks.mysite.pages.CompleteOrderPage;
import com.thoughtworks.mysite.pages.LogInPage;
import com.thoughtworks.mysite.pages.OrderProductsPage;
import com.thoughtworks.mysite.pages.PaymentsPage;

public class PaymentsTest extends BaseTest {

	BaseTest base = new BaseTest();	;
	LogInPage logInPage;
	OrderProductsPage orderProductsPage;
	PaymentsPage paymentsPage;
	CompleteOrderPage completeOrderPage;
	InputStream datais;
	JSONObject testData;	

	@BeforeClass
	public void beforeClass() {   

	}

	@AfterClass
	public void afterClass() {  
		base.quitDriver();
	}

	@BeforeMethod
	public void beforeMethod(Method m) {	
		System.out.println("******* Executing Tests *******" +m.getName()+"/n");
	}	 

	@Test   
	public void completeOrder() {
		logInPage.logIn(testData.getJSONObject("validLogIn").getString("userOremailid"), testData.getJSONObject("validLogIn").getString("password"));
		orderProductsPage.enterSearchproduct(testData.getJSONObject("itemName").getString("productName"));
		orderProductsPage.pressProductName();
		orderProductsPage.enterProductCount(testData.getJSONObject("itemName").getString("add"));
		orderProductsPage.pressAddItemButton();
		paymentsPage			=orderProductsPage.pressCheckOutButton();

		String actualOrderMsg 	=paymentsPage.getOrderSummaryText();
		String expectedOrderMsg =strings.get("order");
		Assert.assertEquals(actualOrderMsg, expectedOrderMsg);	

		String actualItemName 	=paymentsPage.getItemNameValue();
		String expectedItemName =strings.get("itemName");
		Assert.assertEquals(actualItemName, expectedItemName);

		String actualAmount		=paymentsPage.getAmountValue();
		String expectedAmount 	=strings.get("itemAmt");
		Assert.assertEquals(actualAmount, expectedAmount);

		paymentsPage.enterNameInAddress(testData.getJSONObject("userData").getString("userName"));
		paymentsPage.enterMobileNumber(testData.getJSONObject("userData").getString("mobileNo"));
		paymentsPage.enterAddress(testData.getJSONObject("userData").getString("address"));

		paymentsPage.pressAddItemButton();
		paymentsPage.pressSubtractItemButton();
		paymentsPage.pressOTPButton();
		paymentsPage.pressPayButton();
		completeOrderPage		=paymentsPage.pressSubmitButton();
	}


	@AfterMethod
	public void afterMethod() {
		base.closeDriver();

	}

}
