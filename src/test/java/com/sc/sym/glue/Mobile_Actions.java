package com.sc.sym.glue;


import static com.sc.sym.utility.WrapperElements.properties;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sc.sym.pages.CustomerPage;
import com.sc.sym.pages.InventoryPage;
import com.sc.sym.pages.LoginPage;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Mobile_Actions {

	 WrapperMethods wpm ;

	@Then("^I as a Filed Engineer logged in to Staff portal$")
	public void customer_account_should_be_created_successfuly() throws Throwable {
		// wpm.waitTillElementDisappear("//android.widget.Button[contains[@text='log in
		// SIGN IN']");
		
		DesiredCapabilities capabilities = new
				 DesiredCapabilities();
				 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
				  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				  "Nexus 6 - Marshallow - Android 6");
				  capabilities.setCapability(MobileCapabilityType.UDID,
				  "emulator-5554"); //
				  //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, //
				  //AutomationName.IOS_XCUI_TEST);
				  capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
				  capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
				  capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
				  capabilities.setCapability("appActivity","com.pccw.dwfmmobileclient.MainActivity");
				  capabilities.setCapability("appPackage", "com.pccw.dwfmmobileclient"); 
				  AndroidDriver<MobileElement> driver = new AndroidDriver<>(new
				  URL(getHubUrl()), capabilities); 
				  // driver = ((AppiumDriver<WebElement>)
				
				 // wpm = new WrapperMethods(driver1);
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[1]/"
						+ "android.view.View/android.view.View[1]/android.view.View[2]" + "/android.widget.EditText"))
				.sendKeys("dchoo");

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[1]/android.view.View/"
						+ "android.view.View[1]/android.view.View[2]/" + "android.widget.EditText"))
				.sendKeys("dchoo");

		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'SIGN IN')]")).click();

		driver.findElement(By.xpath("//android.view.View[contains(@text,'3316')]")).click();

		/*
		 * driver.findElement(By.xpath(
		 * "//android.widget.Button[contains(@text,'START')]")).click();
		 * 
		 * driver.findElement(By.
		 * xpath("//android.widget.Button[contains(@text,'Call Now')]")).click();
		 * 
		 * driver.findElement(By.xpath(
		 * "//android.widget.ImageButton[@bounds='[608,2042][832,2266]']")).click();
		 * 
		 * 
		 * driver.findElement(By.xpath(
		 * "//android.widget.Button[contains(@text,'Confirm')]")).click();
		 */
	

		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'ARRIVED')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Confirm')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Confirm')]")).click();
		
	}
	
	
static String getHubUrl() {
    String driverHost = System.getProperty("driverHost") != null ? System
            .getProperty("driverHost") : "127.0.0.1";
    String driverPort = System.getProperty("driverPort") != null ? System
            .getProperty("driverPort") : "4723";
    return "http://" + driverHost + ":" + driverPort + "/wd/hub";
}
}
