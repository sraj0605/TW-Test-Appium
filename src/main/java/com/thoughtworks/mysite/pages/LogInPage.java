package com.thoughtworks.mysite.pages;


import com.thoughtworks.mysite.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LogInPage {
	BaseTest base;

	// Below element id's are presumption data for the given app to build automation framework
	@AndroidFindBy(id ="logIn") private MobileElement loginId;
	@AndroidFindBy(id ="password") private MobileElement logInPassword;
	@AndroidFindBy(id ="errorText") private MobileElement errMsg;
	@AndroidFindBy(xpath ="//*[@class='button' and contains(text(),'login']") private MobileElement logInBtn;

	// For Test environment, Captcha values are usually disabled in our product/app testing.
	// There are mechanisms to send a default image text for test apk / test environment to sanity captcha value.
	// There are OCR image capture readers available to automate which I haven't tried.

	// Login user id/email
	public LogInPage enterEmailId (String emailId) {
		base.sendKeys(loginId,emailId);
		return this;

	}
	// Login password
	public LogInPage enterPassword (String password) {
		base.sendKeys(logInPassword,password);
		return this;

	}
	// clear the field before entering data to ensure there is no cache data available when script is executed multiple times.
	public LogInPage clearText (String inputText) {
		base.clear(loginId);
		return this;

	}
	// Log in Button
	public OrderProductsPage pressLogInButton () {
		base.click(logInBtn);
		return new OrderProductsPage();

	}
	// Capture Error Text for assertion
	public String getErrMsg () {
		return base.getText(errMsg);

	}

	// Method for Login with valid user name and password
	public void logIn(String username,String password) {
		enterEmailId(username);
		enterPassword(password);
		pressLogInButton();
	}
}