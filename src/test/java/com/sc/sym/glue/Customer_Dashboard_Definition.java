package com.sc.sym.glue;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.sc.sym.pages.Customer_Dashboard;
import com.sc.sym.pages.LoginPage;
import com.sc.sym.pages.QuotationPage;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Customer_Dashboard_Definition {

	Customer_Dashboard page = new Customer_Dashboard(driver);
	  WrapperMethods wpm = new WrapperMethods(driver);

        
	  @Given("^I click on the Explore by Product button under the Explore menu$")
	    public void Quotation_Create_Click() throws Throwable {
	    	page.Explore_By_product();
	    }
	  
	  @When("^I choose the Product offering as \"([^\"]*)\" for the product catalogue \"([^\"]*)\"$")
	  public void i_choose_the_Product_offering_as_for_the_product_under_product_catalogue(String arg1, String arg2) throws Throwable {
		  
		  page.Add_to_cart(arg1,arg2);
	  }

	  @Then("^I should see the customer portal \"([^\"]*)\" page$")
	  public void i_should_see_the_page(String arg1) throws Throwable {
		  
		 wpm.waitTillElementDisappear(page.loading_Spinner_CSportal);
		 //wpm.waitTillElementClickable(page.CS_Dash_board);
		 
	     Assert.assertTrue("Dashboard Page is displayed",page.CS_Dash_board.getText().contains(arg1));
	     Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	  }

	  
	  @Then("^I should see product offering \"([^\"]*)\" added to the cart$")
	  public void i_should_see_product_offering_added_to_the_cart(String arg1) throws Throwable {
		 // page.Add_to_cart_offering();
		 // Assert.assertTrue("Product offering "+arg1+" added to the cart",driver.findElement(By.xpath("//ul[text()='"+ arg1 +"']")).getText().contains(arg1));

	  }
	  
	  @Then("^I click on the Proceed to Quote button in the add to cart page$")
	  public void i_click_proceed_Quote() throws Throwable {
		page.click_proceed_Quote();
	  }
	  
	  

    

}