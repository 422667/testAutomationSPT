package com.sc.sym.glue;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;
import com.sc.sym.pages.LoginPage;
import com.sc.sym.pages.OrderconfirmationPage;
import com.sc.sym.pages.QuotationPage;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderconfirmationPage_Definition {

	OrderconfirmationPage page = new OrderconfirmationPage(driver);
	WrapperMethods wpm = new WrapperMethods(driver);
	String jdbc_url = "jdbc:mysql://http://10.251.140.9/:3306/boot6pm";
	String Username_db = "root";
	String Password_db ="Jet123!@";

	public String Loading_Spinner = "//div[@class='loading-spinner ng-tns-c4-0 ng-star-inserted']";
	  
	@Then("^I record the order details for the submitted order$")
	  public void i_provide_DB_Connection() throws Throwable {
		 Connection con = DriverManager.getConnection(jdbc_url,Username_db,Password_db);
		 Class.forName("com.mysql.jdbc.Driver");
		 Statement stmt = con.createStatement();	
		 
		 if(QuotationPage.Order_Status.contains("Completed"))
			{
		
			
			for (int i = 0; i <= QuotationPage_Definition.servs.length; i++) {

				if (i != 0) {
				
		
		 stmt.executeQuery("UPDATE test_scenario_tab as ts SET scena_regression_details = QuotationPage_Definition.servs[i] WHERE ts.testcase_id_col = LoginPage_Definition.TC_ID");
		 }
				
			
			}
			 stmt.executeQuery("UPDATE test_scenario_tab as ts SET scena_regression_details = QuotationPage_Definition.Order_no WHERE ts.testcase_id_col = LoginPage_Definition.TC_ID");
				
			}
		 else 
		 {
			 stmt.executeQuery("UPDATE test_scenario_tab as ts SET scena_regression_details = 'Failed' WHERE ts.testcase_id_col = LoginPage_Definition.TC_ID");
				
		 }
	}

	@Then("^I confirm the order by selecting the \"([^\"]*)\" along with billing contact details$")
	public void i_provide_biling_account(String arg1) throws Throwable {

		page.Order_Confirmation(arg1);

	}

	@Then("^I confirm the GPON order by selecting the \"([^\"]*)\" along with billing contact details$")
	public void i_provide_GPON_biling_account(String arg1) throws Throwable {

		page.GPON_Order_Confirmation(arg1);

	}

	@Then("^I confirm the order by selecting the \"([^\"]*)\" along with billing contact details for \"([^\"]*)\" site order$")
	public void i_provide_biling_account_2_site(String arg1, String arg2) throws Throwable {

		page.Order_Confirmation_multiline(arg1, arg2);

	}

	@Then("^I take a screenshot$")
	public void i_take_a_screenshot() throws Throwable {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Hooks.scenario.embed(screenshot, "image/jpeg");
	}

	@Then("^I should see the order submitted successfully$")
	public void Order_submitted_successfuly() throws Throwable {
		wpm.waitTillElementDisappear(page.loading_Spinner_CSportal);
		Assert.assertTrue("unable to submit the order",
				page.Confirm_order_page.getText().equalsIgnoreCase("Order created"));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(page.Order_close_popup);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// wpm.scrollToElement(driver.findElement(By.xpath("//span[text()='Resources']")));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrollToElement(driver.findElement(By.xpath("//button[text()='View Order ']")));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	@Then("^I should see the order submitted successfully via staff Portal$")
	public void Order_submitted_successfuly_staff() throws Throwable {
		wpm.waitTillElementDisappear(Loading_Spinner);

		Assert.assertTrue("unable to submit the order",
				page.Confirm_order_page.getText().equalsIgnoreCase("Order created"));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(page.Order_close_popup);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.waitTillElementDisappear(Loading_Spinner);
		WebElement Complete_Order_Refresh = driver.findElement(By.xpath("//button[text()=' Refresh ']"));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Complete_Order_Refresh);
		wpm.waitTillElementDisappear(Loading_Spinner);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	// And I verify the connect order at the Nokia - Order Management System

	@Then("^I should see the order confirmation page$")
	public void i_should_see_the_order_confirmation_page() throws Throwable {

		wpm.waitTillElementDisappear(page.loading_Spinner_CSportal);
		Assert.assertTrue("confirmation page displayed", page.Order_confirmation.getText().equalsIgnoreCase("Confirm"));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_select_the_appointments_for(String arg1, String arg2, String arg3) throws Throwable {

		page.Site_survey(arg1);
		page.wire_survey(arg2);
		page.installation(arg3);

	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and Cloud Connect RFS Date$")
	public void i_select_the_appointments_for_RFS_Date(String arg1, String arg2, String arg3) throws Throwable {

		page.Site_survey(arg1);
		page.wire_survey(arg2);
		page.installation(arg3);
		page.RFS_Cloud_connect();

	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\"$")
	public void i_select_the_appointments_for_auto(String arg2, String arg3) throws Throwable {

		// page.Site_survey(arg1);
		page.wire_survey_auto(arg2);
		page.installation_auto(arg3);

	}

	@When("^I select the appointments for GPON \"([^\"]*)\",\"([^\"]*)\" for site1,site2$")
	public void i_select_the_appointments_for_site1_site2_GPON(String arg2, String arg3) throws Throwable {

		page.wire_survey_site1_auto(arg2);
		page.installation_site1(arg3);
		// page.Site2_survey_P2P(arg1);
		page.wire_survey_site2_GPON(arg2);
		page.installation_site2(arg3);

	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\" for 2 GPON sites$")
	public void i_select_the_appointments_for_site1_site_multilines(String arg2, String arg3) throws Throwable {

		page.wire_survey_site1_auto(arg2);
		page.installation_site1_GPON(arg3);
		// page.Site2_survey_P2P(arg1);
		page.wire_survey_site2_GPON(arg2);
		page.installation_site2_GPON(arg3);

	}

	@When("^I select the appointments for \"([^\"]*)\"$")
	public void i_select_the_appointments_for(String arg3) throws Throwable {

		page.installation_DCI(arg3);
		page.installation_DCI_2(arg3);

	}

	@When("^I select the appointments for RFS \"([^\"]*)\"$")
	public void i_select_the_appointments_for_RFS(String arg3) throws Throwable {

		page.installation_RFS(arg3);

	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" for site1,site2$")
	public void i_select_the_appointments_for_site1_site2(String arg1, String arg2, String arg3) throws Throwable {

		page.Site1_survey_P2P(arg1);
		page.wire_survey_site1(arg2);
		page.installation_site1(arg3);
		page.Site2_survey_P2P(arg1);
		page.wire_survey_site2(arg2);
		page.installation_site2(arg3);

	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" for site1,site2 and Cloud Connect RFS Date$")
	public void i_select_the_appointments_for_site1_site2_cloud_connect(String arg1, String arg2, String arg3)
			throws Throwable {

		page.Site1_survey_P2P(arg1);
		page.wire_survey_site1(arg2);
		page.installation_site1(arg3);
		page.Site2_survey_P2P(arg1);
		page.wire_survey_site2(arg2);
		page.installation_site2(arg3);
		page.RFS_Cloud_connect();

	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" for 2 sites$")
	public void i_select_the_appointments_for_site1_site_multilines(String arg1, String arg2, String arg3)
			throws Throwable {

		page.Site1_survey_P2P_multiline(arg1);
		page.wire_survey_site1(arg2);
		page.installation_site1(arg3);
		page.Site2_survey_P2P_multiline(arg1);
		page.wire_survey_site2_multiline(arg2);
		page.installation_site2_multiline(arg3);

	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" for staff portal$")
	public void i_select_the_appointments_for_for_staff_portal(String arg1, String arg2, String arg3) throws Throwable {

		page.Site_survey_staff(arg1);
		page.wire_survey_staff(arg2);
		page.installation_staff(arg3);
	}

	@When("^I select the appointments for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" for two sites for staff portal$")
	public void i_select_the_appointments_for_two_sites_for_staff_portal(String arg1, String arg2, String arg3)
			throws Throwable {

		page.Site_survey_staff(arg1);
		page.wire_survey_staff(arg2);
		page.installation_staff_site_1(arg3);
		page.Site_survey_staff_site_2(arg1);
		page.wire_survey_staff_site_2(arg2);
		page.installation_staff_site_2(arg3);

	}

	@When("^I select the \"([^\"]*)\" along with billing contact details for staff portal$")
	public void i_confirm_the_order_by_selecting_the_along_with_billing_contact_details_for_staff_portal(String arg1)
			throws Throwable {

		page.Order_Confirmation_Staff(arg1);
	}

	@When("^I select the \"([^\"]*)\" along with billing contact details for two sites for staff portal$")
	public void i_confirm_the_order_by_selecting_the_along_with_billing_contact_details_for_two_sites_for_staff_portal(
			String arg1) throws Throwable {

		page.Order_Confirmation_Staff(arg1);
		page.Order_Confirmation_Staff_site_2(arg1);
	}

	@Then("^I verify \"([^\"]*)\" calculated correctly$")
	public void i_verify_calculated_correctly(String arg1) throws Throwable {
		page.verify_RFS();

	}

}