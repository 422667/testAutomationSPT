package com.sc.sym.pages;

import static com.sc.sym.utility.WrapperElements.properties;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import com.cucumber.listener.Reporter;
import com.sc.sym.glue.Hooks;
import com.sc.sym.utility.FetchTestData;

import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;


public class LoginPage extends Hooks{
	WrapperMethods wpm;
	WebDriver driver;
	static String UserName=null;
	
	 	@FindBy(id = "userNameInput")
	    WebElement Username;
	 	
	 	@FindBy(xpath = "//input[@id='passwordInput']")
	    WebElement Password;
	 	
	 	@FindBy(id = "submitButton")
	    WebElement Login;
	 	
	 	@FindBy(xpath = "//*[name()='svg']/*[name()='g']/*[name()='g']/*[name()='path']")
	 	WebElement chatbot_button;
	 	
	 	//"//*[name()='svg']/*[name()='g']"
	 	
		@FindBy(xpath = "//button/span[text()='Start a Conversation']")
	 	WebElement start_conversation;
	 	
		@FindBy(id = "message-input__text-field")
	    WebElement input;
		
		@FindBy(id = "message-input__send-message-btn")
	    WebElement send;
		
		@FindBy(xpath = "//span[contains(text(),'Active Directory')]")
	    WebElement click_active_directory;
		
		@FindBy(xpath = "//input[@placeholder='6-digits OTP']")
	    WebElement OTP;
	 	
		@FindBy(xpath = "//span[text()='Sign in']")
	    WebElement click_Sign_in;
		
		@FindBy(xpath = "//div[contains(text(),'OTP in the next 2 minutes')]")
	    public WebElement OTP_Page;
		
		
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
			wpm = new WrapperMethods(driver);
	
		}
		
		public void launchurl() throws IOException
		{
			String Symphony_URL = properties.getProperty("Symphony_Staff_URL");
	        this.driver.get(Symphony_URL);
	 
	        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}
		
		public void cslaunchurl() throws IOException
		{
			String Symphony_Cust_URL = properties.getProperty("Symphony_Cust_URL");
	        this.driver.get(Symphony_Cust_URL);
	       
	     wpm.getScreenshot();
	        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}
		public void stafflaunchurl() throws IOException
		{
			String Symphony_Staff_Reg_URL = properties.getProperty("Symphony_Staff_URL");
	        this.driver.get(Symphony_Staff_Reg_URL);
	 
	        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}
	 public void login(String username) throws Exception {
		 Staff_Customer_Data rm = Staff_Customer_Portal.getData(username);
		 	//click_active_directory.click();
		 UserName = System.getProperty("CSPORTALUSERNAME");
	        Username.sendKeys(UserName);
	        System.out.println(System.getProperty("CSPORTALPASSWORD"));
	       // wpm.ngClick(Password);
	        

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].value='"+System.getProperty("CSPORTALPASSWORD")+"';",Password);
	        //Password.sendKeys(rm.Password);

	       Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// HTMLReporter.reportStep();
	        wpm.ngClick(Login);
	        //Login.click();
	  }
	 
	 public void login_admin(String Salesadmin) throws Exception {
		 Staff_Customer_Data rm = Staff_Customer_Portal.getData(Salesadmin);
		 	//click_active_directory.click();
		// UserName = System.getProperty("CSPORTAL-USERNAME");
	        Username.sendKeys(Salesadmin);
	       // System.out.println(System.getProperty("CSPORTAL-PASSWORD"));
	       // wpm.ngClick(Password);
	        

	        JavascriptExecutor jse = (JavascriptExecutor)driver;
	        jse.executeScript("arguments[0].value='"+rm.Password +"';",Password);
	        //Password.sendKeys(rm.Password);

	        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	        //HTMLReporter.reportStep();
	        wpm.ngClick(Login);
	        //Login.click();
	  }
	 public void chatbot(String arg1, String arg2,String arg3) throws Exception {
		 //Staff_Customer_Data rm = Staff_Customer_Portal.getData(username);
	 String arg = null;
	 // Thread.sleep(30000);
	 driver.switchTo().frame("wbe-sdw-bot");
	 Actions actions = new Actions(driver);
	 actions.moveToElement(chatbot_button);
	 actions.click().build().perform();
	 driver.switchTo().defaultContent();
	 driver.switchTo().frame("wbe-sdw-window");
		 start_conversation.click();
		// for (int i = 1; i <4; i++) {
			
		//	 driver.findElement(By.xpath("//p[contains(@class,'MuiTypography')][" + i + "]")).getText().contains(arg+" + i + ");
			 
	//	}
		 input.sendKeys("hi");
		 send.click();
		 FetchTestData FTD = new FetchTestData(driver);
		 FTD.fetch_testdata_from_chatbot();
		 
	 }
	 
	 public void OTP_Key_In() throws IOException, InterruptedException
	 {
		 try {
			Thread.sleep(3000);
			 wpm.ngClick(OTP);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('passwordInput').setAttribute('value', '123456')");
			// OTP.sendKeys("12345678");
			 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			 wpm.ngClick(click_Sign_in);
			// click_Sign_in.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
	 
	 
	 
}
