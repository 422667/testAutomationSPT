package com.sc.sym.glue;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.properties;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sc.sym.pages.LoginPage;
import com.sc.sym.pages.QuotationPage;
import com.sc.sym.pages.RegistrationPage;
import com.sc.sym.pages.WorkforceManagemetPage;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class WorkforceManagementPage_Definition {

   // RegistrationPage page = new RegistrationPage(driver);
	
	
	WorkforceManagemetPage page = new WorkforceManagemetPage(driver);
	WrapperMethods wpm = new WrapperMethods(driver);

	
	
	@Then("^I create manaul work order for the selected appointments$")
	  public void I_create_manaul_work_order() throws Throwable {
		 page.create_work_order();
		
	  }

   
	
	@Then("^I assign manaul work order for the available techinician$")
	  public void I_assign_manaul_work_order() throws Throwable {
		 page.work_order_assignment();
		
	  }
}