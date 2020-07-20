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
import com.thoughtworks.mysite.pages.LogInPage;
import com.thoughtworks.mysite.pages.OrderProductsPage;

public class LogInTest extends BaseTest{

	BaseTest base;
	InputStream datais;
	JSONObject testData;
	LogInPage logInPage;
	OrderProductsPage orderProductsPage;

	@BeforeClass
	@Parameters({"emulator","platformName","platformVersion","udid","deviceName"})
	public void beforeClass(String emulator,String platformName,String platformVersion,String udid,String deviceName) throws Exception {


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
	public void inValidUserNameSignIn() {

		logInPage.clearText("");
		logInPage.enterEmailId(testData.getJSONObject("inValidUserId").getString("userOremailid"));
		logInPage.enterPassword(testData.getJSONObject("inValidUserId").getString("password"));
		logInPage.pressLogInButton();
		String actualErrorMsg = logInPage.getErrMsg();
		String expectedErrorMsg = strings.get("error_msg");
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("actual is - " +actualErrorMsg+ "expected is " +expectedErrorMsg);	  
	}

	@Test
	public void inValidPasswordSignIn() {

		logInPage.clearText("");
		logInPage.enterEmailId(testData.getJSONObject("inValidPassword").getString("userOremailid"));
		logInPage.enterPassword(testData.getJSONObject("inValidPassword").getString("password"));
		logInPage.pressLogInButton();
		String actualErrorMsg = logInPage.getErrMsg();
		String expectedErrorMsg = strings.get("error_msg");
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("actual is - " +actualErrorMsg+ "expected is " +expectedErrorMsg);

	}

	@Test   
	public void validSignIn() {

		logInPage.enterEmailId(testData.getJSONObject("validLogIn").getString("userOremailid"));
		logInPage.enterPassword(testData.getJSONObject("validLogIn").getString("password"));
		orderProductsPage = logInPage.pressLogInButton();	    

	}

	@AfterMethod
	public void afterMethod() {	  
		base.closeDriver();

	}

}
