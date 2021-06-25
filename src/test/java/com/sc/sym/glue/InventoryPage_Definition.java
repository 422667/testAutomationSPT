package com.sc.sym.glue;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.properties;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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


public class InventoryPage_Definition {

   InventoryPage page = new InventoryPage(driver);
	  WrapperMethods wpm;
	
        
    @Then ("^I created SKU  using the Resource_type as \"([^\"]*)\"$")
  	public void created_account(String username) throws Throwable {
    	
    	page.Stock_Creation(username);
  	}


@Then("^SKU should be created successfuly$")
public void customer_account_should_be_created_successfuly() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
 
}



@Then("^I created Resourcetype using the reuired details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
public void I_created_Resourcetype_using_the_reuired_details(String Resource_Type,String Resource_Name,String specification,String classification,String Description) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
 page.Resource_Type_Creation(Resource_Type, Resource_Name, specification, classification, Description);
}

@When("^I create Resourcetype using the required details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
public void i_created_Resourcetype_using_the_required_details(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
	page.Resource_Type_Creation(arg1, arg2, arg3, arg4, arg5);
}


@Then("^I click on Resource Type option under Inventory menu$")
public void I_click_on_Resource_Type_option_under_Inventory_menu() throws Throwable {
   page.Click_Resource_Type();
 
}

@Then("^Resourcetype should be created successfully$")
public void Resource_type_should_be_created_successfuly() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	page.save_resource_type();
 
}


}