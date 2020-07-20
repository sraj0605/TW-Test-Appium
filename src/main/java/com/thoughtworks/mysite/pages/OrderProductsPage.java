package com.thoughtworks.mysite.pages;

import com.thoughtworks.mysite.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrderProductsPage {
	BaseTest base;
	// Below element id's are presumption data for the given app to build automation framework	
	@AndroidFindBy(xpath ="searchProductName[index id]") private MobileElement searchproductEditText;
	@AndroidFindBy(id ="productName") private MobileElement productName;
	@AndroidFindBy(id ="productNos") private MobileElement productCountEditText;
	@AndroidFindBy(id ="add") private MobileElement incrementItemValuesBtn;
	@AndroidFindBy(id ="subtract") private MobileElement decrementItemValuesBtn;
	@AndroidFindBy(id ="checkOut") private MobileElement checkOutBtn;

	//Search for a product
	public OrderProductsPage enterSearchproduct(String itemName) {
		base.sendKeys(searchproductEditText,itemName);
		return this;	
	}

	//Click on the product name/link
	public OrderProductsPage pressProductName() {
		base.click(productName);
		return this;
	}

	//Enter Product Count on the product name/link
	public OrderProductsPage enterProductCount(String count) {
		base.sendKeys(productCountEditText,count);
		return this;
	}

	//Click on the '+' item button to increment nos.,
	public OrderProductsPage pressAddItemButton() {
		base.click(incrementItemValuesBtn);
		return this;
	}

	//Click on the '-' item button to decrement nos.,
	public OrderProductsPage pressSubtractItemButton() {
		base.click(decrementItemValuesBtn);
		return this;
	}

	//Click on the checkout button 
	public PaymentsPage pressCheckOutButton() {
		base.click(checkOutBtn);
		return new PaymentsPage();
	}


}