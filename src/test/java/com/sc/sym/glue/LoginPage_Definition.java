package com.sc.sym.glue;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.sc.sym.pages.LoginPage;
import com.sc.sym.utility.CsvDataReader;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WebDriverFactory;
import com.sc.sym.utility.WrapperMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginPage_Definition {

	LoginPage page = new LoginPage(driver);
	  WrapperMethods wpm = new WrapperMethods(driver);
	  
	  public static String TC_ID = null;
	 
	  @Given("^I logged in to the staff portal with \"([^\"]*)\"$")
    public void loginasstaff(String arg1) throws Throwable {
		  if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
		  wpm.clearcache();
	  }
    	page.launchurl();
    	//page.chatbot(arg1,arg2,arg3);
    	page.login(arg1);
    }
	  
	  @Given("^I as a requestor logged in to Staff portal with \"([^\"]*)\"$")
	    public void logina_staff(String arg1) throws Throwable {
		  if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
		  wpm.clearcache();
	  }
		  page.launchurl();
		        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	    	page.login(arg1);
	    }
	      
	  @Given("^I as a Sales admin logged in to Staff portal$")
	    public void logina_admin() throws Throwable {
		  if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
		  wpm.clearcache();
	  }
		  page.launchurl();
		        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	    	//page.login("SPT\\nnicholas.lin2".replaceAll("nn","n"));
		        
		        page.login_admin("pccwscrm.spsales@spt.local");
	    }
	  
	  @Given("^I as a Sales_admin logged in to Staff portal$")
	    public void loginaadmin() throws Throwable {
		  if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
		  wpm.clearcache();
	  }
		  page.launchurl();
		        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	    	page.login_admin("SPT\\nnicholas.lin2".replaceAll("nn","n"));
		        
		        //page.login("pccwscrm.spsales@spt.local");
	    }
	  
	  @Given("^I as a BRM_admin logged in to Staff portal$")
	    public void loginbrmadmin() throws Throwable {
		  if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
			  wpm.clearcache();
		  }
			  page.launchurl();
			        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		    	//page.login("SPT\\nnicholas.lin2".replaceAll("nn","n"));
			        
			        page.login_admin("pccwscrm.spsales@spt.local");
		        //page.login("pccwscrm.spsales@spt.local");
	    }
	  
	  
	  @Given("^I logged in to the customer portal with \"([^\"]*)\" to verify \"([^\"]*)\"$")
	    public void loginascustomer(String arg1,String arg2) throws Throwable {
		  if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
		  if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
			  
			  TC_ID =  arg2;
			  
			  
		  wpm.clearcache();
	  }
	  }
	    	page.cslaunchurl();
	    	//page.chatbot(arg1,arg2,arg3);
	    	page.login(arg1);
	    }
        
	  @Given("^I launched customer portal Registration URL$")
	    public void Launch_cs_registration_url(String arg1) throws Throwable {
		    driver.manage().deleteAllCookies();Thread.sleep(7000);
		    driver.get("chrome://settings/clearBrowserData");
		    driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		    if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
		  wpm.clearcache();
	  }
	    	page.cslaunchurl();
	    	page.login(arg1);
	    	
	    	
	    }
	  @Given("^I logged in to the staff portal with Approver as \"([^\"]*)\"$")
	    public void Quotation_Approver(String arg1) throws Throwable {
	
			page.launchurl();
	    	page.login(arg1);
	    
		
	    	
	    }
	  
	  @Given("^I click the sign in button upon enter the OTP for customer portal login$")
	    public void Sign_in_Csportal() throws Throwable {
	    	page.OTP_Key_In();
	    }
	  
	  @Given("^I launched staff portal URL$")
	    public void Launch_staff_New_Subscription_url(String arg1) throws Throwable {
	    	page.stafflaunchurl();
	    	//page.chatbot(arg1,arg2,arg3);
	    	
	    }
	  @Then("^I should see the \"([^\"]*)\" page$")
	  public void i_should_see_the_page(String arg1) throws Throwable {
	     try {
			Assert.assertTrue("OTP Page is displayed",page.OTP_Page.getText().contains(arg1));
			 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	 
   
    

}