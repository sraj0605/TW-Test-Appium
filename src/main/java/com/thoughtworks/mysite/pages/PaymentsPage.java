package com.thoughtworks.mysite.pages;

import com.thoughtworks.mysite.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class PaymentsPage {

	// Below element id's are presumption data for the given app to build automation framework	
	BaseTest base;

	@AndroidFindBy(id ="orderSummary")	private MobileElement orderSummaryText;
	@AndroidFindBy(id ="add") 			private MobileElement incrementItemValuesBtn;
	@AndroidFindBy(id ="subtract") 		private MobileElement decrementItemValuesBtn;
	@AndroidFindBy(id ="amount") 		private MobileElement amountText;
	@AndroidFindBy(xpath= "//*[contains=[text(), 'itemName']") private MobileElement itemNameText;
	@AndroidFindBy(id= "name") 			private MobileElement NameInAddressEditText;
	@AndroidFindBy(id= "address") 		private MobileElement addressEditText;
	@AndroidFindBy(id= "contact") 		private MobileElement contactEditText;
	@AndroidFindBy(id ="OTP") 			private MobileElement OTPBtn;
	@AndroidFindBy(id ="pay") 			private MobileElement payBtn;
	@AndroidFindBy(id ="submit") 		private MobileElement submitBtn;


	//Click on the '+' item button to increment nos.,
	public PaymentsPage pressAddItemButton() {
		base.click(incrementItemValuesBtn);
		return this;
	}

	//Click on the '-' item button to decrement nos.,
	public PaymentsPage pressSubtractItemButton() {
		base.click(decrementItemValuesBtn);
		return this;
	}

	// Get Order text for verification
	public String getOrderSummaryText() {
		return base.getText(orderSummaryText);		
	}

	// Get itemName for verification
	public String getItemNameValue() {
		return base.getText(itemNameText);		
	}

	// Get Amount value for verification
	public String getAmountValue() {
		return base.getText(amountText);		
	}


	//Enter Name for order
	public PaymentsPage enterNameInAddress(String name) {
		base.sendKeys(NameInAddressEditText,name);	
		return this;
	}

	//Enter Mobile number for order
	public PaymentsPage enterMobileNumber(String phoneNo) {
		base.sendKeys(contactEditText,phoneNo);	
		return this;
	}

	//Enter Address for order
	public PaymentsPage enterAddress(String address) {
		base.sendKeys(addressEditText,address);	
		return this;
	}


	//Click on the 'OTP' item button
	public PaymentsPage pressOTPButton() {
		base.click(OTPBtn);
		return this;
	}
	//Click on the pay button
	public PaymentsPage pressPayButton() {
		base.click(payBtn);
		return this;
	}
	//Click on the submit button to complete Order
	public CompleteOrderPage pressSubmitButton() {
		base.click(submitBtn);
		return new CompleteOrderPage();
	}


}
