package com.thoughtworks.mysite.testcases;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thoughtworks.mysite.base.BaseTest;
import com.thoughtworks.mysite.pages.LogInPage;
import com.thoughtworks.mysite.pages.OrderProductsPage;
import com.thoughtworks.mysite.pages.PaymentsPage;

public class OrderProductsTest extends BaseTest {

	BaseTest base;
	InputStream datais;
	JSONObject testData;
	LogInPage logInPage;
	OrderProductsPage orderProductsPage;
	PaymentsPage paymentsPage;

	@BeforeClass
	public void beforeClass() {

	}

	@AfterClass
	public void afterClass() {  
		base.quitDriver();;
	}

	@BeforeMethod
	public void beforeMethod(Method m) {  
		System.out.println("******* Executing Tests *******" +m.getName()+"/n");
	}
	
	@Test   
	public void searchProduct() {
		logInPage.logIn(testData.getJSONObject("validLogIn").getString("userOremailid"), testData.getJSONObject("validLogIn").getString("password"));
		orderProductsPage.enterSearchproduct(testData.getJSONObject("itemName").getString("productName"));
		orderProductsPage=orderProductsPage.pressProductName();
	}

	@Test   
	public void createOrderWithIncrementItemCount() {
		logInPage.logIn(testData.getJSONObject("validLogIn").getString("userOremailid"), testData.getJSONObject("validLogIn").getString("password"));
		orderProductsPage.enterSearchproduct(testData.getJSONObject("itemName").getString("productName"));
		orderProductsPage.pressProductName();
		orderProductsPage.enterProductCount(testData.getJSONObject("itemName").getString("add"));
		orderProductsPage.pressAddItemButton();
		paymentsPage=orderProductsPage.pressCheckOutButton();
	}


	@Test  
	public void createOrderWithDecrementItemCount() {
		logInPage.logIn(testData.getJSONObject("validLogIn").getString("userOremailid"), testData.getJSONObject("validLogIn").getString("password"));
		orderProductsPage.enterSearchproduct(testData.getJSONObject("itemName").getString("productName"));
		orderProductsPage.pressProductName();
		orderProductsPage.enterProductCount(testData.getJSONObject("itemName").getString("sub"));
		orderProductsPage.pressSubtractItemButton();
		paymentsPage=orderProductsPage.pressCheckOutButton();
	}


	@AfterMethod
	public void afterMethod() {	  
		base.closeDriver();
	}

}
