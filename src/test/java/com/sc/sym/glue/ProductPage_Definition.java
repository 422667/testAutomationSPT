package com.sc.sym.glue;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.properties;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sc.sym.pages.CustomerPage;
import com.sc.sym.pages.LoginPage;
import com.sc.sym.pages.ProductPage;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ProductPage_Definition {

	ProductPage page = new ProductPage(driver);
	  WrapperMethods wpm;
	
        


    @Then("^I click on the Product Catalogue under the Product menu$")
    public void I_click_on_the_Product_Catalogue_under_the_Product_menu() throws Throwable {
    	
    		page.click_product_catalogue();	
    }
    
    @Then("^I should see \"([^\"]*)\"level2 should be displayed$")
    public void level2_should_be_displayed(String family) throws Throwable {
    	
    		page.Product_family_validaion(family);
    }
  
    


}