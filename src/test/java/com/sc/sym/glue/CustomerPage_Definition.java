package com.sc.sym.glue;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.properties;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sc.sym.pages.CustomerPage;
import com.sc.sym.pages.LoginPage;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CustomerPage_Definition {

   CustomerPage page = new CustomerPage(driver);
	  WrapperMethods wpm;
	
        
    @Then ("^I create a customer profile on behalf$")
  	public void created_account(String username) throws Throwable {
    	page.customer_Creation();
  	}


@Then("^Customer account should be created successfuly$")
public void customer_account_should_be_created_successfuly() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
 
}


}