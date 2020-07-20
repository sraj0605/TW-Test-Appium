package com.thoughtworks.mysite.base;

import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.InputStream;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.thoughtworks.mysite.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseTest {
	protected static AppiumDriver driver;	
	protected static Properties props;
	public HashMap<String,String> strings = new HashMap<String,String>();
	InputStream inputStream;
	InputStream stringsis;
	TestUtils utils;


	public BaseTest() {
		System.out.println("Driver is " +driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}


	@Parameters({"emulator","platformName","platformVersion","deviceName","udid"})
	@BeforeTest
	public void beforeTest(String emulator,String platformName,String platformVersion,String deviceName,String udid) throws Exception {
		try {
			props =new Properties();
			String propFileName = "config.properties";
			String xmlFileName ="strings/strings.xml";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);

			stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
			utils = new TestUtils();
			strings = utils.parseStringXML(stringsis);

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("platformVersion", platformVersion);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));

			desiredCapabilities.setCapability("appPackage",props.getProperty("androidAppPackage"));
			desiredCapabilities.setCapability("appActivity",props.getProperty("androidAppActivity"));
			desiredCapabilities.setCapability("avd","Pixel_3");

			URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
			desiredCapabilities.setCapability("app", appUrl);

			if (emulator.equalsIgnoreCase("true")) {
				desiredCapabilities.setCapability("platformVersion", platformVersion);
				desiredCapabilities.setCapability("avd",deviceName);
			}
			else
			{
				desiredCapabilities.setCapability("udid",udid);
			}


			URL url = new URL(props.getProperty("appiumURL"));

			driver = new AppiumDriver(url,desiredCapabilities);	
			String sessionId=driver.getSessionId().toString();

		}

		catch (Exception e ){
			e.printStackTrace();
			throw e;
		}
		finally {
			if(inputStream!=null) {
				inputStream.close();
			}
			if(stringsis!=null) {
				stringsis.close();
			}
		}	
	}

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver,TestUtils.wait);

		wait.until(ExpectedConditions.visibilityOf(e));

	}

	public void click (MobileElement e) {
		waitForVisibility(e);
		e.click();
	}

	public void clear (MobileElement e) {
		waitForVisibility(e);
		e.clear();
	}

	public void sendKeys(MobileElement e,String text) {

		waitForVisibility(e);
		e.sendKeys(text);
	}

	public String getText(MobileElement e) {
		waitForVisibility(e);
		return e.getText();
	}

	public void quitDriver() {
		driver.quit();
	}

	public void closeDriver() {
		driver.closeApp();
	}

	public void launchDriver() {
		driver.launchApp();
	}

}
