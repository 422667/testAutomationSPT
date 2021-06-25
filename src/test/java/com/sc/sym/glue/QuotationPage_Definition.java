package com.sc.sym.glue;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.properties;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

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


public class QuotationPage_Definition{

	QuotationPage page = new QuotationPage(driver);
	WrapperMethods wpm = new WrapperMethods(driver);
	
	public static String[] servs;
	
	
	public static String Order_no = null;

      public String Quotation_ID = null;  
	  @Given("^I clicked quote creation under sales menu$")
	    public void Quotation_Create_Click() throws Throwable {
	    	page.Quotation_Create_Click();
	    	
	    }
	  
	  @Given("^I clicked quote search under sales menu$")
	    public void Quotation_search() throws Throwable {
	    	page.Quotation_Search_Click();
	    	
	    }
	  
	  @Given("^I verify the billing details at the BRM$")
	    public void BRM_Billing_details() throws Throwable {
	    	page.Billing_care_Click();
	    	
	    }
	  
	  
	  @Given("^I clicked order search under sales menu$")
	    public void Order_search() throws Throwable {
	    	page.Order_Search_Click();
	    	
	    }
	  
	  
	  @Then ("^I complete the CRM order by keying the required paramaters$")
			public void Order_Complete() throws Throwable {
			//page.Order_Search_Click();
			//page.order_Search_result(Order_no);
			//page.track_monitor();
		page.order_completion();
			  
		}

	  
	  
	  @Given("^I click on the View Order button at the Thank you pagee$")
	    public void click_view_orderr() throws Throwable {
	    
	   //   Order_no = page.order_no.getText().trim();
	    //  System.out.println(Order_no);
	//	  page.View_Order.click();
		  
		
		  driver.findElement(By.xpath("//span[text()='My Order']")).click();
		  wpm.waitTillElementDisappear(page.Loading_Spinner);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
			
			List<WebElement> elements =	driver.findElements(By.xpath("//h5[text()='ORDER219491']/../../../../../div[2]/div[1]/div/crmx-datatable/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/crmx-icon-link/button/span[2]/span"));
			
			//h5[text()='ORDER219463']/../../../../../div[2]/div[1]/div/crmx-datatable/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/crmx-icon-link/button/span[2]/span
			
			System.out.println(elements.size());
			
			servs= new String[elements.size()];
			
			for(int i = 0; i < elements.size(); i++) 
			{
				System.out.println(elements.get(i));
				servs[i] = elements.get(i).getText();
			}
			
	    }
	  

	  
	  @Given("^I click on the View Order button at the Thank you page$")
	    public void click_view_order() throws Throwable {
	    
	      Order_no = page.order_no.getText().trim();
	      System.out.println(Order_no);
		  page.View_Order.click();
		  wpm.waitTillElementDisappear(page.Loading_Spinner);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
			
			List<WebElement> elements =	driver.findElements(By.xpath("//h5[text()='"+Order_no+"']/../../../../../div[2]/div[1]/div/crmx-datatable/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[2]/div/span"));
			
			//h5[text()='ORDER219463']/../../../../../div[2]/div[1]/div/crmx-datatable/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/crmx-icon-link/button/span[2]/span
			
			System.out.println(elements.size());
			
			servs= new String[elements.size()];
			
			for(int i = 0; i < elements.size(); i++) 
			{
				System.out.println(elements.get(i));
				servs[i] = elements.get(i).getText();
			}
			
	    }
	  
	  @Given("^I should see newly created order at the My order page$")
	    public void new_order_view() throws Throwable {
		  
	    
		  for (WebElement iterable_element : page.Ordernos_MyOrder) {
			wpm.scrollToElement(iterable_element); 
			Assert.assertTrue(iterable_element.getText().contains(Order_no));
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
		}
		  	
		 
		  wpm.waitTillElementDisappear(page.Loading_Spinner);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	    }
	  
	  
	   
	  
	  
	  @Given("^I search for customer order submitted from CS portal$")
	    public void submitted_order_search() throws Throwable {
		  
		  
	    	page.order_Search_result(Order_no);
	    	
	    }
	  
	  
	  
	  @Given("^I verify the details at the Track and Monitor page$")
	    public void Track_and_Monitor_page() throws Throwable {
		  
		 // page.order_Search_result(Order_no);
	      page.track_monitor();
	    	
	    }
	  
	  
	  @Given("^I verify the reserved appointments at the DWFM$")
	    public void reserved_appointments  () throws Throwable {
		  
		  
	    	page.verify_appointments();
	    	
	    }
	  
	  
	
	  @Given("^I search for Quotation submitted for approval$")
	    public void Quotation_submitted_approval() throws Throwable {
		  
		  
	    	page.Quotation_Search_result(Quotation_ID);
	    	
	    }
	  
	  @Given("^I search for approved Quotation$")
	    public void Quotation_approval_search() throws Throwable {
		  
		  
	    	page.Quotation_Search_result(Quotation_ID);
	    	
	    }
	  @Given("^I search for accepted Quotation$")
	    public void Quotation_accepted_search() throws Throwable {
		  
		  //need to chnage later
	    	page.Quotation_Search_result(Quotation_ID);
	    	
	    }
	  
	  @Given("^I navigate to order confirm page by verifying the requestor acceptance$")
	    public void Quotation_to_order_conformation() throws Throwable {
		  
		  
	    	page.Sales_admin_verification_acceptance();
	    	
	    }
	  
	  
	  
	  
	  
	  
	  
	  @Given("^I should see as Quotation submitted for approval$")
	    public void Quotation_submitted() throws Throwable {
		  Assert.assertTrue("Quote approval not displayed", page.Approve_Quotation.isDisplayed());
		  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		  wpm.scrollToElement(page.Focus);
		   Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		  
		  // page.Submit_for_Acceptance.click();
	    	
	    }
	  @Given("^I approve the Quotation submitted for approval$")
	  public void approve_Quote() throws IOException, InterruptedException
	  {
		  //wpm.scrollToElement(page.Approve_Quotation);
		  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 wpm.ngClick(page.Approve_Quotation);
	 // page.Approve_Quotation.click();
	   wpm.waitTillElementDisappear(page.Loading_Spinner);
	  // page.Quote_approval_popup_close.click();
	  // wpm.waitTillElementDisappear(page.Loading_Spinner);
	   Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	   Quotation_ID = page.QuotationID.getText();
	   wpm.scrollToElement(page.Quote_approval_Req_comments);
	   page.Quote_approval_Req_comments.sendKeys("Approved");
	   wpm.scrollToElement(page.Aprrove_button);
	   Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	   wpm.ngClick(page.Aprrove_button);
	  // page.Aprrove_button.click();
	   Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	   wpm.ngClick(page.Quote_approval_popup_close);
	   
	   Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	   wpm.scrollToElement(page.Focus);
	   
	   
	  }
	  @Given("^I submit the Quotation for acceptance$")
	    public void Quotation_for_acceptance() throws Throwable {
		  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		  
		  wpm.scrollToElement(page.Focus);
		
		  page.Submit_for_Acceptance.click();
		  wpm.waitTillElementDisappear(page.Loading_Spinner);
		  //Assert.assertTrue("Submit_for_Acceptance screen not displayed", page.submit_for_appoval.getText().contains("submitted for approval"));
		   Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		
	    	
	    }
		 
	  @Given("^I proceed Quotation for accept_onbehalf$")
	    public void Quotation_proceed_acceptance() throws Throwable {
		  
		
		  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		/*
		 * try { driver.findElement(By.
		 * xpath("//span[text()='Assign To']/../crmx-icon-link/button/span[2]")).click()
		 * ; Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 * wpm.waitTillElementDisappear(page.Loading_Spinner);
		 * wpm.ngClick(page.Customer_Select); } catch (Exception e) { // TODO
		 * Auto-generated catch block WebElement wm =
		 * driver.findElement(By.xpath("(//crmx-button/button[text()='Cancel'])[4]"));
		 * wpm.ngClick(wm);
		 * 
		 * 
		 * }
		 */
		  
		 wpm.scrollToElement(page.Proceed); 
		 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 page.Proceed.click();
		 wpm.waitTillElementDisappear(page.Loading_Spinner);
		 wpm.ngClick(page.Quote_approval_popup_close);
		 wpm.waitTillElementDisappear(page.Loading_Spinner);
		 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		
		 
		 
		 // wpm.waitTillElementDisappear(page.Loading_Spinner);
		// Thread.sleep(40000);
		 wpm.scrollToElement(page.Accept_onbehaf);
		 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 
		 wpm.ngClick(page.Accept_onbehaf);
		
		  wpm.waitTillElementDisappear(page.Loading_Spinner);
		 // Assert.assertTrue("Submit_for_Acceptance screen not displayed", page.submit_for_appoval.getText().contains("submitted for approval"));
		  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		
	    }
	  
	  
	  @Given("^I accept the Quotation by uploading acceptance document$")
	    public void Quotation_doc_upload() throws Throwable {
		  
		  page.Quotaion_doc_upload();
		
	    	
	    }
	
	  
	  
	  @When("^I key in the product config details Network_Name as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" and bandwidth details for CSportal$")
	  public void i_key_in_the_product_config_details_Network_Name_as_postal_code_as_Burstable_bandwidth_as_for_CSportal(String arg1, String arg2) throws Throwable {
	     
	  	page.Product_config_CSPortal(arg1, arg2);
	  	
	  }  

	  @When("^I key in the product config details Network_Name as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" and bandwidth details more than 1G for CSportal$")
	  public void i_key_in_the_product_config_details_Network_Name_as_postal_code_as_Burstable_bandwidth_as_more_than_for_CSportal(String arg1, String arg2) throws Throwable {
	     
	  	page.Product_config_CSPortal_More_than_1G(arg1, arg2);
	  	
	  }  
@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" and bandwidth details for CSportal$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as_for_CSportal(String arg1, String arg2, String arg3) throws Throwable {
   
	page.Product_config_CSPortal_topo(arg1, arg2, arg3);
	
}


	/*
	 * @When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" and bandwidth details for more than 1G CSportal$"
	 * ) public void
	 * i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as_for_CSportal_more_than_1G
	 * (String arg1, String arg2, String arg3) throws Throwable {
	 * 
	 * page.Product_config_CSPortal_topo_more_than_1G(arg1, arg2, arg3);
	 * 
	 * }
	 */
@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" and bandwidth details for more than 1G CSportal$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as_for_CSportal_for_more_than_1G(String arg1, String arg2, String arg3) throws Throwable {
   
	page.Product_config_CSPortal_topo_morethan_1G(arg1, arg2, arg3);
	
}

@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" ,contract_duration as \"([^\"]*)\" and bandwidth details for more than 1G staffportal$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as__for_more_than_1G_staff_portal(String arg1, String arg2, String arg3, String arg4) throws Throwable {
   
	page.Product_config_topo_morethan_1G_staff(arg1, arg2, arg3 ,arg4);
	
}

@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" ,IPVersion as IPV4 and bandwidth details for more than 1G CSportal$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as_for_CSportal_for_more_than_1G_IPV4(String arg1, String arg2, String arg3) throws Throwable {
   
	page.Product_config_CSPortal_topo_morethan_1G_IPV4(arg1, arg2, arg3);
	
}

@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,Protocol as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" and bandwidth details for more than 1G CSportal$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as_for_CSportal_for_more_than_1G(String arg1, String arg2, String arg3,String arg4) throws Throwable {
   
	page.Product_config_CSPortal_topo_morethan_1G(arg1, arg2, arg3, arg4);
	
}

@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,Protocol as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" ,IPVersion as \"([^\"]*)\" and bandwidth details for more than 1G CSportal$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as_for_CSportal_for_more_than_1G_BGP_IPV4(String arg1, String arg2, String arg3,String arg4,String arg5) throws Throwable {
   
	page.Product_config_CSPortal_topo_morethan_1G(arg1, arg2, arg3, arg4,arg5);
	
}

@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,Site_location_A as \"([^\"]*)\" ,Site_location_B as \"([^\"]*)\" and bandwidth details for CSportal DCI$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as_for_CSportal_DCI(String arg1, String arg2, String arg3, String arg4) throws Throwable {
   
	page.Product_config_CSPortal_DCI(arg1, arg2, arg3, arg4);
	
}
@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,Template as \"([^\"]*)\" ,Child_offer as \"([^\"]*)\" ,Child_offer_Template as \"([^\"]*)\" ,Site_location as \"([^\"]*)\" for CSportal IoT$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code__as_for_CSportal_IoT(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
   
	page.Product_config_CSPortal_IOT(arg1, arg2, arg3, arg4, arg5,  arg6);
	
}


@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" ,bandwidth details and VAS as \"([^\"]*)\" for CSportal$")
public void i_key_in_the_product_config_details_Network_Name_as_topoplogy_postal_code_as_Burstable_bandwidth_as_for_CSportal_VAS(String arg1, String arg2, String arg3, String arg4) throws Throwable {
   
	page.Product_config_CSPortal_topo_VAS(arg1, arg2, arg3, arg4);
	
}

@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,postal_code_1 as \"([^\"]*)\" ,postal_code_2 as \"([^\"]*)\" and bandwidth details for CSportal$")
public void i_keyed_in_the_product_config_details_Network_Name_as_postal_code_as_Burstable_bandwidth_as_for_CSportall(String arg1, String arg2, String arg3) throws Throwable {
   
	page.Product_config_CSPortal(arg1, arg2, arg3);
	
}

@When("^I key in the product config details Network_Name as \"([^\"]*)\" ,postal_code_1 as \"([^\"]*)\" ,postal_code_2 as \"([^\"]*)\" and bandwidth details for more than 1G CSportal$")
public void i_keyed_in_the_product_config_details_Network_Name_as_postal_code_as_Burstable_bandwidth_as_for_CSportall_more_than_1G(String arg1, String arg2, String arg3) throws Throwable {
   
	page.Product_config_CSPortal_morethan_1G(arg1, arg2, arg3);
	
}

@When("^I click on the Availbility Check button at the Product configure page$")
public void i_click_on_the_Availbility_Check_button_at_the_Product_configure_page() throws Throwable {
  
	page.Availability_check();
	
}



@When("^I Verify the feasibility at the Nokia - Order Management System$")
public void i_Verify_the_feasibility_at_the_Nokia_Order_Management_System() throws Throwable {
    page.feasibility_verification_order_management();
}


@When("^I should see the system recommendation to GPON offering$")
public void i_should_see_recommendation_to_GPON_offering() throws Throwable {
	
	
    page.apply_click();
}


@When("^I reconfigure the quotaion for recommended GPON offering$")
public void i_reconfigure_recommended_GPON_offering() throws Throwable {
   page.Product_Reconfig_CSPortal_Auto();
}


@When("^I reconfigure the quotaion for recommended GPON offering including \"([^\"]*)\"$")
public void i_reconfigure_recommended_GPON_offering_Multiline(String arg2) throws Throwable {
   page.Product_Reconfig_CSPortal_Auto_multiline(arg2);
}

@When("^I verify the Reservation of resources at the Nokia - Order Management System$")
public void I_verify_the_Reservation_of_resources() throws Throwable {
    page.reservation_verification_order_management();
}


@Given("^I configure the cloud connect offer in Quote configuration provider as \"([^\"]*)\" and DC as \"([^\"]*)\"$")
public void i_configure_the_cloud_connect_offer_in_Quote_configuration_provider_as_and_DC_as(String arg1, String arg2) throws Throwable {
   page.Product_config_CSPortal_Cloud_connect(arg1, arg2);
}





@When("^I click quote by key in contract_duration as \"([^\"]*)\" for CSPortal$")
public void i_key_in_contract_duration_as_for_CSPortal(String arg1) throws Throwable {
   
	page.click_quote_CSportal(arg1);
}
	    
	    
	  @When("^I created quote using Quote_Type as \"([^\"]*)\" ,Quote_Description as \"([^\"]*)\" ,Quote_Order_Type as \"([^\"]*)\" ,Quote_Currency as \"([^\"]*)\" ,Customer_Name as \"([^\"]*)\" ,Postal_Code as \"([^\"]*)\"$")
	  public void i_created_quote_using(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
	     
		  page.Quotation_Creation(arg1,arg2,arg3,arg4,arg5,arg6);
	  }

	  
	  @When("^I choose the Product offering as \"([^\"]*)\" for the product \"([^\"]*)\" under product catalogue \"([^\"]*)\"$")
	  public void i_choose_the_Product_offering_as_for_the_product_under_product_catalogue(String arg1, String arg2, String arg3) throws Throwable {
	     page.product_selection(arg1, arg2, arg3);
	  }

	  @Then("^I should see the product config page for product offering \"([^\"]*)\"$")
	  public void i_should_see_the_product_config_page_for_product_offering(String arg1) throws Throwable {
		  Customer_Dashboard.product_offering = arg1;
		  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	   
	  }
	  
	/*
	 * @When("^I key in the product config details Network_Name as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" ,Burstable_bandwidth as \"([^\"]*)\" ,contract_duration as \"([^\"]*)\" for CSPortal$"
	 * ) public void i_key_in_the_product_config_details_in_CSPortal(String arg1,
	 * String arg2, String arg3, String arg4) throws Throwable {
	 * page.Product_config_CSPortal(arg1, arg2, arg3, arg4); }
	 */
	  
	  @When("^I key in the product config details Network_Name as \"([^\"]*)\" ,Topology as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" ,Bandwidth details ,contract_duration as \"([^\"]*)\"$")
	  public void i_key_in_the_product_config_details_as_topology(String arg1, String arg2,String arg5,String arg6) throws Throwable {
	     page.Product_config_topology(arg1, arg2, arg5, arg6);
	  }
	
	  @When("^I key in the product config details Network_Name as \"([^\"]*)\" ,postal_code as \"([^\"]*)\" ,Bandwidth details ,contract_duration as \"([^\"]*)\"$")
	  public void i_key_in_the_product_config_details_as(String arg1, String arg2,String arg5) throws Throwable {
	     page.Product_config(arg1, arg2,arg5);
	  }
	 
	  @When("^I add the \"([^\"]*)\", Protocol as \"([^\"]*)\" for \"([^\"]*)\" for CSPortal$")
	  public void i_key_add_new_locatyion(String arg1, String arg2, String arg3) throws Throwable {
		  
	     page.ADD_NEW_LOCATION(arg1, arg2, arg3);
	  }
	  

	  @When("^I add the Diversepath offering as \"([^\"]*)\", Protocol as \"([^\"]*)\" for \"([^\"]*)\" for CSPortal for less than 1G$")
	  public void i_key_add_diverse_path_lessthan_1G(String arg1, String arg2,String arg3) throws Throwable {
		  
	     page.ADD_NEW_LOCATION_lessthan_1G(arg1, arg2, arg3);
	  }
	  
	  @When("^I add the Diversepath offering as \"([^\"]*)\", Protocol as \"([^\"]*)\" for \"([^\"]*)\" for CSPortal$")
	  public void i_key_add_diverse_path(String arg1, String arg2,String arg3) throws Throwable {
		  
	     page.ADD_NEW_LOCATION(arg1, arg2, arg3);
	  }
	  
	  @When("^I add the Diversepath offering as \"([^\"]*)\", Protocol as \"([^\"]*)\" for \"([^\"]*)\" for staffPortal$")
	  public void i_key_add_diverse_path_staff(String arg1, String arg2,String arg3) throws Throwable {
		  
	     page.ADD_NEW_LOCATION_STAFF(arg1, arg2, arg3);
	  }
	  
	  @When("^I key in the product config details Network_Name as \"([^\"]*)\" ,postal_code_1 as \"([^\"]*)\" ,postal_code_2 as \"([^\"]*)\" ,Bandwidth details ,contract_duration as \"([^\"]*)\"$")
	  public void i_key_in_the_product_config_details_as(String arg1, String arg2, String arg3,String arg5,String arg6,String arg7) throws Throwable {
	     page.Product_config_P2P_Staff(arg1, arg2, arg3,arg5, arg6, arg7);
	  }

	  @Then("^I accept the quotation by placing the signature and verifying the terms and conditions$")
	  public void i_place_signature() throws Throwable {
		  
	   page.Terms_Conditions_by_placing_signature();
	   
	  }
	  
	  @Then("^I should see the Product configure page$")
	  public void i_should_see_configure() throws Throwable {
		  
	   Assert.assertTrue("product configure page is displayed", page.product_configure.getText().contains("Configure"));
	   Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	  }
	  
	  
	  @Given("^I click on generate upon selecting the template as SPTel Quotaion document$")
	  public void i_click_on_generate_upon_selecting_the_template_as_SPTel_Quotaion_document() throws Throwable {
	     	  
		  
	  page.Quote_template_generation();
	 
	  }
	  
	  @Given("^I reject the quote by key in the rejection reason$")
	  public void I_reject_the_quote_by_key_in_the_rejection_reason() throws Throwable {
	     	  
		  
	  page.reject_quote();
	 
	  }
	  
	  @Given("^I should see the Quotation status as \"([^\"]*)\" at the My Quote screen$")
	  public void I_should_see_Quotation_status(String arg1) throws Throwable {
	     	  
		  
	  page.verify_quote_myquotes(arg1);
	 
	  }
	  
	  

	  @Then("^I should see the error message as \"([^\"]*)\"$")
	  public void i_should_see_error_message_is_displayed(String arg1) throws Throwable {
	  
		Assert.assertTrue("feasibility error message not displayed", driver.findElement(By.xpath("(//div[@class='modal-body-msg'])[1]")).getText().contains(arg1));
		  
	  }

	  @Then("^I should see \"([^\"]*)\" message is displayed$")
	  public void i_should_see_message_is_displayed(String arg1) throws Throwable {
	  
		Assert.assertTrue("Quote generation successful", driver.findElement(By.xpath("(//div[text()='"+arg1+"'])[2]")).getText().contains(arg1));
		  
	  }
	  

@When("^I click on the Finalize Quotation$")
public void i_click_on_the_Finalize_Quotation() throws Throwable {
	page.Finalize_quote();
}

@When("^I should see the Quotation \"([^\"]*)\"$")
public void i_should_see_the_Quotation(String arg1) throws Throwable {
	Assert.assertTrue("Quote not submitted for approval", driver.findElement(By.xpath("(//div[contains(text(),'"+arg1+"')])[2]")).getText().contains(arg1));
	 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	 wpm.ngClick(page.Close_popup_Quotaion_generation);
	 wpm.waitTillElementDisappear(page.Loading_Spinner);
	 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	// page.Close_popup_Quotaion_generation.click();
	wpm.scrollToElement(page.Focus); 
	 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	 Quotation_ID = page.QuotationID.getText();

	//wpm.clearcache();

}

	  @Then("^I should see the Quotation \"([^\"]*)\" message is displayed$")
	  public void i_should_submitted_for_approval_is_displayed(String arg1) throws Throwable {
	  
		 Assert.assertTrue("Quote not submitted for approval", driver.findElement(By.xpath("//button[contains(text(),'"+arg1+"')]")).getText().contains(arg1));
		 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 page.Close_popup_Quotaion_generation.click();
		 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 Quotation_ID = page.QuotationID.getText();
	  }
	  
	  
	 

	  
}