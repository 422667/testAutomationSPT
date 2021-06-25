package com.sc.sym.pages;

import static com.sc.sym.utility.WrapperElements.properties;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.sikuli.script.FindFailed;

import com.cucumber.listener.Reporter;
import com.sc.sym.glue.Hooks;
import com.sc.sym.glue.QuotationPage_Definition;
import com.sc.sym.utility.WrapperMethods;

import junit.framework.Assert;

public class QuotationPage extends Hooks {
	WrapperMethods wpm;
	WebDriver driver;

	@FindBy(id = "username")
	WebElement username;

	String feasibiliy_order_ID = null;
	String feasibiliy_order_ID_1 = null;
	String feasibiliy_order_ID_2 = null;

	String Reservation_order_ID = null;

	public static String Service_ID = null;

	@FindBy(xpath = "(//div[@class='card-header-container'])[2]")
	public WebElement Focus;

	public static String product_offering = null;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "(//div[@class='flex-grow-1 pr-3']/../div[2]/div[2])[2]")
	public WebElement order_no;

	@FindBy(xpath = "//button[text()='View Order ']")
	public WebElement View_Order;

	@FindBy(xpath = "//span[@class='align-self-center']/h5 - orders")
	public List<WebElement> Ordernos_MyOrder;
	// span[@class='align-self-center']/h5 - orders

	@FindBy(xpath = "(//div[@class='jumbotron-header']/div/span[2])[1]")
	public WebElement QuotationID;

	@FindBy(xpath = "//button[text()='Approve Quotation']")
	public WebElement Approve_Quotation;

	@FindBy(xpath = "//button[contains(text(),'LOG IN')]")
	WebElement order_management_login;

	@FindBy(id = "top_monitoring")
	WebElement Monitoring;

	@FindBy(xpath = "//a[@href='Requests.jsp?searchForm=true']")
	WebElement search_form;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement feasibility_alert;

	@FindBy(xpath = "//input[@id='fromDatepicker']")
	WebElement Datepicker;

	@FindBy(xpath = "//table[@id='searchForm']/tbody/tr[4]/td[4]/input")
	WebElement Order_id;

	@FindBy(xpath = "(//table[@class='action-panel']/tbody/tr/td[2]/button)[1]")
	WebElement Search;

	@FindBy(xpath = "//table[@class='table-basic requests']/tbody/tr/td[10]")
	List<WebElement> Basic_requests;

	@FindBy(xpath = "//table[@class='table-basic requests']/tbody/tr/td/table/tbody/tr/td/a")
	WebElement Basic_request;

	@FindBy(xpath = "(//table[@class='table-basic details'])[2]/tbody/tr/td[contains(text(),'Failed')]/../td[2]")
	WebElement Basic_request_failure_task;

	public String Quote_value = null;
	
	public static String Order_Status = null;

	@FindBy(xpath = "//i[@class='icon-coin-dollar']/../span")
	WebElement Sales;

	@FindBy(xpath = "//i[@class='icon-arrow-right13']")
	WebElement Sales_Right_Arrow;

	@FindBy(xpath = "//i[@class='icon-cube3']/../span")
	WebElement Application;

	@FindBy(xpath = "//i[@class='icon-cash3']/../span[text()='BRM Billing care']")
	WebElement Billing_Care;

	@FindBy(xpath = "//span[text()='Search']")
	WebElement Billing_Accnt_Search;

	@FindBy(xpath = "//input[@title='Service ID']")
	WebElement Service_ID_BRM;

	@FindBy(xpath = "//i[@class='icon-fire']/../span")
	WebElement DWFM;

	@FindBy(xpath = "//a[@href='/staff/dwfm/appointment']/span")
	WebElement Appointment_submenu;

	@FindBy(xpath = "//a[@href='/staff/dwfm/workOrder']/span")
	WebElement workorder_submenu;

	@FindBy(xpath = "(//div[@class='position-relative flex-grow-1 inpput-wrapper']/input)[1]")
	WebElement Appointment_Ref;

	@FindBy(xpath = "//button[@type='button' and @class='btn btn-primary' and text()='Search']")
	WebElement Appointment_Search;

	@FindBy(xpath = "//span[text()='Details']")
	WebElement Appointment_Details;

	public String Loading_Spinner = "//div[@class='loading-spinner ng-tns-c4-0 ng-star-inserted']";

	public String loading_Spinner_CSportal = "//div[@class='loading-wrapper ng-tns-c7-1 ng-star-inserted']";

	@FindBy(xpath = "//a[@href='/staff/quote/create']/span")
	WebElement Quote_Create;

	@FindBy(xpath = "//a[@href='/staff/quote/search']/span")
	WebElement Quote_Search;

	@FindBy(xpath = "//a[@href='/staff/order/search']/span")
	WebElement Order_Search;

	@FindBy(xpath = "(//div[@class='position-relative flex-grow-1 inpput-wrapper']/input)[1]")
	WebElement Quote_ID;

	@FindBy(xpath = "//button[text()='Apply']")
	public WebElement Re_config_apply;

	@FindBy(xpath = "(//button[@type='submit' and @class='btn btn-primary'])[3]")
	WebElement Quote_ID_Search;

	@FindBy(xpath = "//span[text()='View']")
	WebElement Quote_View;

	@FindBy(id = "formly_4_formly-select_quoteType_0")
	WebElement Quote_Type;

	@FindBy(xpath = "(//div[@class='input-group']/textarea)[1]")
	WebElement Quote_Description;

	@FindBy(xpath = "//select[contains(@id,'formly-select_orderType_0')]")
	WebElement Quote_Order_Type;

	@FindBy(xpath = "//select[contains(@id,'ormly-select_currency_1')]")
	WebElement Quote_Currency;

	@FindBy(xpath = "//textarea[@class='form-control ng-untouched ng-pristine ng-invalid ng-star-inserted']")
	public WebElement Quote_approval_Req_comments;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-primary') and @type ='button']/i[contains(@class,'icon-search')])[1]/..")
	WebElement Customer;

	// input[@class='form-control no-append no-prepend ng-pristine ng-valid
	// ng-star-inserted ng-touched']
	@FindBy(xpath = "//input[@placeholder='Value']")
	WebElement Customer_Name;

	@FindBy(xpath = "//formly-crmx-button/crmx-button/button[@class='btn btn-primary']")
	WebElement Customer_Search;

	@FindBy(xpath = "//crmx-icon-link/button[@class='btn crmx-icon-link']/span[2]/span[text()='Select']")
	public WebElement Customer_Select;

	@FindBy(xpath = "(//input[@class= 'form-control no-append no-prepend ng-untouched ng-pristine ng-valid ng-star-inserted' and @type = 'text'])[2]")
	WebElement Postal_code;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-primary') and @type ='button']/i[contains(@class,'icon-search')])[2]")
	WebElement Postal_code_search;

	@FindBy(xpath = "//crmx-icon-link/button/span/i[@class='icon-select2']")
	WebElement Company_Contact;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement Contact_Selection;

	@FindBy(xpath = "(//button[@class='btn btn-primary' and @type='button'])[4]")
	WebElement Contact_Selection_click;

	@FindBy(xpath = "(//button[@type='submit'])[3]")
	WebElement Submit;

	@FindBy(xpath = "//button[text()=' Close ']")
	WebElement Close;

	@FindBy(xpath = "//input[@placeholder='Network Group / Service Name']")
	WebElement Network_Name;

	@FindBy(xpath = "(//input[@type='text' and @class='form-control no-append no-prepend ng-untouched ng-pristine ng-valid ng-star-inserted'])[2]")
	WebElement Postal_code_Config;
	@FindBy(xpath = "(//input[@type='text' and @class='form-control no-append no-prepend ng-untouched ng-pristine ng-valid ng-star-inserted'])[2]")
	WebElement Postal_code_Config_csportal;

	@FindBy(xpath = "(//input[@type='text' and @class='form-control no-append no-prepend ng-untouched ng-pristine ng-valid ng-star-inserted'])[3]")
	WebElement Postal_code_Config_csportal_multiline;

	@FindBy(xpath = "(//input[@type='text' and @class='form-control no-append no-prepend ng-untouched ng-pristine ng-valid ng-star-inserted'])[3]")
	WebElement Postal_code_Config_02;

	@FindBy(xpath = "//button[contains(@class,'btn btn-primary') and @type ='button']/i[contains(@class,'icon-search4')]")
	WebElement Postal_code_Config_Search;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-primary') and @type ='button']/i[contains(@class,'icon-search4')])[2]")
	WebElement Postal_code_Config_Search_multilin;

	@FindBy(xpath = "(//button[text()='Availability Check'])[1]")
	WebElement Availability;

	@FindBy(xpath = "(//button[text()=' Close '])[3]")
	WebElement Availability_close;

	@FindBy(xpath = "//crmx-form-input-numeric/div/div/div/following::input[1]")
	WebElement OTC_Override;

	@FindBy(xpath = "//crmx-form-input-numeric/div/div/div/following::input[2]")
	WebElement MRC_Override;

	@FindBy(xpath = "//button[contains(@class,'btn-info')]")
	WebElement Finalize;

	@FindBy(xpath = "(//div[@ng-reflect-klass='crmx-select-dropdown flex-grow'])[3]")
	WebElement Contract_tenure;

	@FindBy(xpath = "//div[@class='position-relative text-nowrap text-truncate crmx-select-value-wrapper']")
	List<WebElement> Contract_tenure_ipvpn;

	@FindBy(xpath = "//button[text()='Quote ']")
	WebElement Quote;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkbox_terms_CSportal;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox_terms_CSportal_IPVPN;

	@FindBy(xpath = "//canvas[@style='touch-action: none;']")
	WebElement Digi_Signature_CSportal;

	@FindBy(xpath = "//button[text()='Accept ']")
	WebElement Accept_CSportal;

	@FindBy(xpath = "//span[text()=' Configure ']")
	public WebElement product_configure;

	@FindBy(xpath = "//a[text()='Terms and Conditions.']")
	public WebElement Terms_conditions;

	@FindBy(xpath = "(//button[text()='Close'])[2]")
	public WebElement Terms_conditions_popup;

	@FindBy(xpath = "//span[text()='Select Template']")
	public WebElement select_template;

	@FindBy(xpath = "(//i[contains(@class,'icon-arrow-down12')])[5]")
	public WebElement template_dropdown;

	@FindBy(xpath = "(//a[contains(text(),' SPTelQuotationDocument')])[1]")
	public WebElement Quotation_document;

	@FindBy(xpath = "//button[text()='Preview Document']")
	public WebElement Quotation_Generation;

	@FindBy(xpath = "(//button[text()=' Close '])[1]")
	public WebElement Close_popup_Quotaion_generation;

	@FindBy(xpath = "(//button[text()=' Close '])[2]")
	public WebElement Quote_approval_popup_close;

	@FindBy(xpath = "(//div[contains(text(),'submitted for approval')])[2]")
	public WebElement submit_for_appoval;

	@FindBy(xpath = "//button[text()='Proceed']")
	public WebElement Proceed;

	@FindBy(xpath = "//button[text()='Approve']")
	public WebElement Aprrove_button;

	@FindBy(xpath = "//button[text()='Accept on Behalf']")
	public WebElement Accept_onbehaf;

	@FindBy(xpath = "//button[text()='Submit for Acceptance']")
	public WebElement Submit_for_Acceptance;

	@FindBy(xpath = "//div[@class='custom-control custom-radio']/input")
	public WebElement Approver_Radio;

	@FindBy(xpath = "//span[text()='Upload']")
	public WebElement Quote_upload;

	@FindBy(xpath = "//button[text()='Verify Acceptance']")
	public WebElement Verify_acceptance;

	@FindBy(xpath = "//span[text()='Cloud Connect Fixed Rate']/../../../../../div[2]/crmx-button/button")
	public WebElement Cloud_connect_Add;

	@FindBy(xpath = "//span[text()='Cloud Provider']/../../../../div[2]/div/a")
	public WebElement Cloud_connect_Provider;

	@FindBy(xpath = "//span[text()='Data Center']/../../../../div[2]/div/a")
	public WebElement Data_Center;
	// span[text()='Cloud
	// Provider']/../../../../div[2]/div/div/a[contains(text(),'Alibaba Cloud')]

	@FindBy(xpath = "//span[text()='IP Version']/../../../../div/div/a")
	public WebElement IP_Version;
	

	@FindBy(xpath = "(//span[text()='IP Version']/../../../../div/div/a)[2]")
	public WebElement Cloud_Connect_IP_Version;

	@FindBy(xpath = "(//span[text()='IP Version']/../../../../div/../div[2]/div/div/a)[2]")
	public WebElement IPV6_Select;

	@FindBy(xpath = "(//span[text()='IP Version']/../../../../div/../div[2]/div/div/a)[1]")
	public WebElement IPV4_Select;

	public String Install_Appointment = null;

	public String Wiring_Appointment = null;

	public String Service_test_Appointment = null;

	public String Site_survey_Appointment = null;

	public QuotationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		wpm = new WrapperMethods(driver);

	}

	public void Quotation_Create_Click() throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(Loading_Spinner);
		Sales.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Quote_Create.click();
	}

	public void Quotation_Search_Click() throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(Loading_Spinner);
		Sales.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Quote_Search.click();
	}

	public void Order_Search_Click() throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(Loading_Spinner);
		Sales.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Order_Search.click();
	}
	public void Billing_care_Click() throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(Loading_Spinner);
		wpm.ngClick(Sales_Right_Arrow);
		wpm.ngClick(Sales_Right_Arrow);
		wpm.ngClick(Application);
		wpm.ngClick(Billing_Care);
		// Billing_Care.click();
		wpm.Switch_to_another();
		try {
			Billing_Accnt_Search.click();
		} catch (Exception e) {
			driver.navigate().refresh();
			Billing_Accnt_Search.click();

		}

		for (int i = 0; i < QuotationPage_Definition.servs.length; i++) {

			if (i != 0) {
				WebElement wm1 = driver.findElement(By.xpath("//span[text()='Search']"));
				wpm.ngClick(wm1);

				WebElement wm2 = driver.findElement(By.xpath("//a[text()='Reset']"));
				wpm.ngClick(wm2);

			}
			wpm.waitTillElementAppeared(Service_ID_BRM);

			Service_ID_BRM.sendKeys(QuotationPage_Definition.servs[i]);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			WebElement wm = driver.findElement(By.xpath("//a[@id='searchAcc']"));
			wpm.ngClick(wm);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement wm1 = driver.findElement(By.xpath("//a[text()='Open']"));
			wpm.waitTillElementClickable(wm1);
			wpm.ngClick(wm1);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrolldown();

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			try {
				WebElement wm2 = driver.findElement(By.xpath("//span[@id='serviceLoginName0']"));

				Assert.assertTrue("Service ID not Found ", wm2.getText().contains(QuotationPage_Definition.servs[i]));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void Quotation_Search_result(String QuoteID) throws IOException, InterruptedException {
		Quote_ID.sendKeys(QuoteID.split("-")[0]);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Quote_ID_Search.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		wpm.scrollToElement(Quote_View);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Quote_View);
		// Quote_View.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void order_Search_result(String Order) throws IOException {
		try {
			Quote_ID.sendKeys(Order);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			Quote_ID_Search.click();
			wpm.waitTillElementDisappear(Loading_Spinner);
			wpm.scrollToElement(Quote_View);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.ngClick(Quote_View);
			// Quote_View.click();
			wpm.waitTillElementDisappear(Loading_Spinner);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void track_monitor() throws IOException {

		WebElement wm = driver.findElement(By.xpath("//span[text()='Order Items']"));
		wpm.ngClick(wm);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrolldown();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm1 = driver.findElement(By.xpath("//span[text()='Contact']"));
		wpm.ngClick(wm1);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrolldown();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm2 = driver.findElement(By.xpath("(//span[text()='Appointment'])[2]"));
		// WebElement wm1 =driver.findElement(By.xpath("//span[text()='Contact']"));
		wpm.ngClick(wm2);
		if (Customer_Dashboard.product_offering.contains("DCI")) {
			WebElement Install_Appointment_text = driver
					.findElement(By.xpath("(//span[text()='INSTALL SFP']/../../../datatable-body-cell)[1]"));

			wpm.scrollToElement(Install_Appointment_text);
			wpm.scrolldown();
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		} else if (!Customer_Dashboard.product_offering.contains("IoT")) {
			Site_survey_Appointment = driver
					.findElement(By.xpath("(//span[text()='SITE SURVEY']/../../../datatable-body-cell)[1]")).getText()
					.trim();
			WebElement Install_Appointment_text = driver
					.findElement(By.xpath("(//span[text()='INSTALL']/../../../datatable-body-cell)[1]"));
			Install_Appointment = Install_Appointment_text.getText().trim();
			Service_test_Appointment = driver
					.findElement(By.xpath("(//span[text()='SERVICE TEST']/../../../datatable-body-cell)[1]")).getText()
					.trim();
			Wiring_Appointment = driver
					.findElement(By.xpath("(//span[text()='WIRING']/../../../datatable-body-cell)[1]")).getText()
					.trim();
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			wpm.scrollToElement(Install_Appointment_text);
			wpm.scrolldown();
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}
		WebElement wm3 = driver.findElement(By.xpath("//span[text()='Tracking']"));
		wpm.ngClick(wm3);
		Service_ID = driver.findElement(By.xpath("(//div[@class='d-flex']/div/div/h6)[2]")).getText().trim();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrolldown();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void track_monitor_GPON() throws IOException {

		WebElement wm = driver.findElement(By.xpath("//span[text()='Order Items']"));
		wpm.ngClick(wm);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrolldown();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm1 = driver.findElement(By.xpath("//span[text()='Contact']"));
		wpm.ngClick(wm1);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrolldown();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm2 = driver.findElement(By.xpath("(//span[text()='Appointment'])[2]"));
		// WebElement wm1 =driver.findElement(By.xpath("//span[text()='Contact']"));
		wpm.ngClick(wm2);

		// Site_survey_Appointment = driver.findElement(By.xpath("(//span[text()='SITE
		// SURVEY']/../../../datatable-body-cell)[1]")).getText().trim();
		WebElement Install_Appointment_text = driver
				.findElement(By.xpath("(//span[text()='INSTALL']/../../../datatable-body-cell)[1]"));
		Install_Appointment = Install_Appointment_text.getText().trim();
		// Service_test_Appointment =
		// driver.findElement(By.xpath("(//span[text()='SERVICE
		// TEST']/../../../datatable-body-cell)[1]")).getText().trim();
		Wiring_Appointment = driver.findElement(By.xpath("(//span[text()='WIRING']/../../../datatable-body-cell)[1]"))
				.getText().trim();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.scrollToElement(Install_Appointment_text);
		wpm.scrolldown();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm3 = driver.findElement(By.xpath("//span[text()='Tracking']"));
		wpm.ngClick(wm3);
		Service_ID = driver.findElement(By.xpath("(//div[@class='d-flex']/div/div/h6)[2]")).getText().trim();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrolldown();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void track_monitor_complete() throws IOException {

		/*
		 * WebElement wm = driver.findElement(By.xpath("//span[text()='Order Items']"));
		 * wpm.ngClick(wm); Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 * wpm.scrolldown(); Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 * 
		 * WebElement wm1 =driver.findElement(By.xpath("//span[text()='Contact']"));
		 * wpm.ngClick(wm1); Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 * wpm.scrolldown(); Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 * 
		 * WebElement wm2
		 * =driver.findElement(By.xpath("(//span[text()='Appointment'])[2]"));
		 * //WebElement wm1 =driver.findElement(By.xpath("//span[text()='Contact']"));
		 * wpm.ngClick(wm2); Site_survey_Appointment = driver.findElement(By.
		 * xpath("(//span[text()='SITE SURVEY']/../../../datatable-body-cell)[1]")).
		 * getText().trim(); Install_Appointment = driver.findElement(By.xpath(
		 * "(//span[text()='INSTALL']/../../../datatable-body-cell)[1]")).getText().trim
		 * (); Service_test_Appointment = driver.findElement(By.
		 * xpath("(//span[text()='SERVICE TEST']/../../../datatable-body-cell)[1]")).
		 * getText().trim(); Wiring_Appointment = driver.findElement(By.xpath(
		 * "(//span[text()='WIRING']/../../../datatable-body-cell)[1]")).getText().trim(
		 * ); Reporter.addScreenCaptureFromPath(wpm.getScreenshot()); wpm.scrolldown();
		 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 */

	}

	public void verify_appointments() throws IOException, InterruptedException {

		DWFM.click();
		Appointment_submenu.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		Appointment_Ref.sendKeys(Site_survey_Appointment);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Appointment_Search.click();
		wpm.scrollToElement(Appointment_Details);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Appointment_Details);
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		DWFM.click();
		Appointment_submenu.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		Appointment_Ref.sendKeys(Install_Appointment);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Appointment_Search.click();
		wpm.scrollToElement(Appointment_Details);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Appointment_Details);
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		DWFM.click();
		Appointment_submenu.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		Appointment_Ref.sendKeys(Service_test_Appointment);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Appointment_Search.click();
		wpm.scrollToElement(Appointment_Details);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Appointment_Details);
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		DWFM.click();
		Appointment_submenu.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		Appointment_Ref.sendKeys(Wiring_Appointment);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Appointment_Search.click();
		wpm.scrollToElement(Appointment_Details);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Appointment_Details);
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}
	
	public void Quotaion_doc_upload() throws AWTException, IOException, InterruptedException, FindFailed {

		 

        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
        wpm.scrollToElement(Quote_upload);
        Quote_upload.click();
        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
        Thread.sleep(4000);
        // wpm.waitTillElementClickable(driver.findElement(By.xpath("(//a[@aria-haspopup='true'
        // and @role='button'])[2]/i")));
        WebElement wm = driver.findElement(By.xpath("(//a[@aria-haspopup='true' and @role='button'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(wm);
        actions.click().build().perform();
        // wpm.ngClick(wm);
        Thread.sleep(3000);
        // wpm.waitTillElementClickable(driver.findElement(By.xpath("//a[text()=' Sales
        // ']")));
        
        
         
          
          String CSVFile = "C:\\Users\\dineshreddy.jetti\\Downloads\\service_agreement_238495.pdf";
          WebElement wm1 = driver.findElement(By.xpath("(//a[contains(text(),'Sales')])[1]"));
            actions.moveToElement(wm1);
            actions.click().build().perform();
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//span[text()='Browse Files'])[2]")).click();
            Thread.sleep(3000);

 

                      StringSelection ss = new StringSelection(CSVFile);
                      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

 

                      //native key strokes for CTRL, V and ENTER keys
                      Robot robot = new Robot();

 

                      robot.keyPress(KeyEvent.VK_CONTROL);
                      robot.keyPress(KeyEvent.VK_V);
                      robot.keyRelease(KeyEvent.VK_V);
                      robot.keyRelease(KeyEvent.VK_CONTROL);
                      robot.keyPress(KeyEvent.VK_ENTER);
                      robot.keyRelease(KeyEvent.VK_ENTER);
        
        /*
         * 
         * 
         * File file = new File("/Users⁩/⁨mounidinu⁩/⁨Downloads⁩/QUO2020017825-1.pdf");
         * 
         * StringSelection stringSelection = new
         * StringSelection(file.getAbsolutePath());
         * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,
         * null); // Copy to clipboard //
         * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,
         * // null);
         * 
         * Robot robot = new Robot();
         * 
         * Thread.sleep(2000);
         * 
         * driver.switchTo().window(driver.getWindowHandle());
         * 
         * robot.delay(2000);
         * 
         * // Open Goto window robot.keyPress(KeyEvent.VK_META);
         * robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_G);
         * robot.keyRelease(KeyEvent.VK_META); robot.keyRelease(KeyEvent.VK_SHIFT);
         * robot.keyRelease(KeyEvent.VK_G); Thread.sleep(2000); // Paste the clipboard
         * value robot.keyPress(KeyEvent.VK_META); robot.keyPress(KeyEvent.VK_V);
         * robot.keyRelease(KeyEvent.VK_META); robot.keyRelease(KeyEvent.VK_V);
         * 
         * // Press Enter key to close the Goto window and Upload window
         * Thread.sleep(2000); robot.keyPress(KeyEvent.VK_ENTER);
         * robot.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(2000);
         * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
         * 
         * 
         */
        
        

 

        WebElement wm3 = driver.findElement(By.xpath("(//span[text()='Upload'])[2]"));
        actions.moveToElement(wm3);
        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
        actions.click().build().perform();
        wpm.waitTillElementDisappear(Loading_Spinner);
        // Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
        wpm.ngClick(Close);
        // Close.click();
        wpm.waitTillElementDisappear(Loading_Spinner);
        wpm.scrollToElement(driver.findElement(By.xpath("//button[text()='Accept']")));
        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
        WebElement wm4 = driver.findElement(By.xpath("//button[text()='Accept']"));
        wpm.ngClick(wm4);
        wpm.waitTillElementDisappear(Loading_Spinner);
        // Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
        wpm.ngClick(Close);
        wpm.waitTillElementDisappear(Loading_Spinner);
        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

 

        wpm.scrollToElement(Focus);
        Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

 

        // Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

 

        // Close.click();

 

    }

	
	public void Sales_admin_verification_acceptance() throws IOException, InterruptedException {

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Verify_acceptance.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrollToElement(driver.findElement(By.xpath("//h5[text()='Request Description']")));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.scrollToElement(driver.findElement(By.xpath("//button[text()='Proceed']")));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm = driver.findElement(By.xpath("//button[text()='Proceed']"));

		wpm.ngClick(wm);
		wpm.scrollToElement(driver.findElement(By.xpath("//button[text()='Yes, and bring me to confirm order']")));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		driver.findElement(By.xpath("//button[text()='Yes, and bring me to confirm order']")).click();
		wpm.ngClick(Close);

		/*
		 * driver.findElement(By.xpath("//button[text()='Convert to Order']")).click();
		 * wpm.waitTillElementDisappear(Loading_Spinner);
		 */

	}

	public void Quotation_Creation(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(Loading_Spinner);
		// Select Dropdown = new Select(Quote_Type);
		// Dropdown.selectByValue(arg1);
		Quote_Description.sendKeys(arg2);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// Select Dropdown1 = new Select(Quote_Order_Type);
		// Dropdown1.selectByVisibleText(arg3);
		// Select Dropdown2 = new Select(Quote_Currency);
		// Dropdown2.selectByValue(arg4);
		wpm.ngClick(Customer);

		Customer_Name.sendKeys(System.getProperty("CUSTOMER"));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Customer_Search);
		// Customer_Search.click();

		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Customer_Select);
		wpm.waitTillElementDisappear(Loading_Spinner);
		// Customer_Select.click();
		Postal_code.sendKeys(arg6);
		wpm.ngClick(Postal_code_search);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// Postal_code_search.click();
		Thread.sleep(5000);
		wpm.ngClick(Company_Contact);
		// Company_Contact.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		wpm.ngClick(Contact_Selection);
		// Contact_Selection.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		Contact_Selection_click.click();

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement wm = driver.findElement(By.xpath("//span[text()='Main Contact']/../../../../div[2]/div/a"));
		wpm.ngClick(wm);
		Thread.sleep(2000);
		WebElement wm1 = driver
				.findElement(By.xpath("//span[text()='Main Contact']/../../../../div[2]/div/a/../div[2]/div/a"));
		wpm.ngClick(wm1);

		// span[text()='Main Contact']/../../../../div[2]/div/a
		wpm.ngClick(Submit);

		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Close.click();
	}

	public void product_selection(String arg1, String arg2, String arg3) throws InterruptedException, IOException

	{
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		driver.findElement(By.xpath("//span[text()='" + arg3 + "']")).click();
		WebElement wm = driver.findElement(By.xpath("//span[text()='" + arg2 + "']"));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(wm);
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		driver.findElement(By.xpath("//span[text()='" + arg1 + "']/../../following::datatable-body-cell[3]")).click();
		wpm.waitTillElementDisappear(Loading_Spinner);
		product_offering = arg1;
	}

	public void Product_config_topology(String arg1, String arg2, String arg5, String arg6)
			throws IOException, InterruptedException {
		Network_Name.sendKeys(arg1);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);
			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config);
		Postal_code_Config.sendKeys(arg5, Keys.ENTER);

		Thread.sleep(2000);
		// Postal_code_Config_Search.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 20, 0).build();
		action_0.perform();

		if (QuotationPage.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 30, 0).build();
			action_1.perform();

		}

		// Availability.click();
		// wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// Availability_close.click();
		WebElement wm = driver
				.findElement(By.xpath("//crmx-form-radio-item/div/label[text()='" + arg6 + "']/../input"));
		wpm.ngClick(wm);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		/*
		 * OTC_Override.click(); OTC_Override.clear(); OTC_Override.sendKeys(arg6);
		 * MRC_Override.click(); MRC_Override.clear(); MRC_Override.sendKeys(arg7);
		 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Finalize);
		Finalize.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
	}

	public void Product_config(String arg1, String arg2, String arg5) throws IOException, InterruptedException {
		Network_Name.sendKeys(arg1);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config);
		Postal_code_Config.sendKeys(arg2, Keys.ENTER);

		Thread.sleep(2000);
		// Postal_code_Config_Search.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 20, 0).build();
		action_0.perform();

		if (QuotationPage.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 30, 0).build();
			action_1.perform();

		}

		// Availability.click();
		// wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// Availability_close.click();
		WebElement wm = driver
				.findElement(By.xpath("//crmx-form-radio-item/div/label[text()='" + arg5 + "']/../input"));
		wpm.ngClick(wm);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		/*
		 * OTC_Override.click(); OTC_Override.clear(); OTC_Override.sendKeys(arg6);
		 * MRC_Override.click(); MRC_Override.clear(); MRC_Override.sendKeys(arg7);
		 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Finalize);
		Finalize.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
	}

	public void Product_config_P2P_Staff(String arg1, String arg2, String arg3, String arg6, String arg7, String arg8)
			throws IOException, InterruptedException {
		Network_Name.sendKeys(arg1);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config);
		Postal_code_Config.sendKeys(arg2, Keys.ENTER);

		Thread.sleep(2000);
		// Postal_code_Config_Search.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_02);
		Postal_code_Config.sendKeys(arg3, Keys.ENTER);

		Thread.sleep(2000);
		// Postal_code_Config_Search.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 20, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 30, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		// Availability.click();
		// wpm.waitTillElementDisappear(Loading_Spinner);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// Availability_close.click();
		WebElement wm = driver
				.findElement(By.xpath("//crmx-form-radio-item/div/label[text()='" + arg6 + "']/../input"));
		wpm.ngClick(wm);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		OTC_Override.click();
		OTC_Override.clear();
		OTC_Override.sendKeys(arg7);
		MRC_Override.click();
		MRC_Override.clear();
		MRC_Override.sendKeys(arg8);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Finalize);
		Finalize.click();
		wpm.waitTillElementDisappear(Loading_Spinner);
	}

	public void Quote_template_generation() throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(Loading_Spinner);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement wm =driver.findElement(By.xpath("//crmx-button/button[@type='button' and text()='Yes']"));
		wpm.ngClick(wm);
		wpm.scrollup();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(select_template);
		// select_template.click();
		template_dropdown.click();
		Quotation_document.click();
		Quotation_Generation.click();

		wpm.waitTillElementDisappear(Loading_Spinner);

		// Close_popup_Quotaion_generation.click();

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void apply_click() throws InterruptedException {

		// wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		Re_config_apply.click();
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
	}

	public void ADD_NEW_LOCATION_STAFF(String arg1, String arg2, String arg3) throws IOException, InterruptedException {

		if (!arg1.contains("Diverse")) {

			WebElement wm = driver.findElement(By.xpath("//button[text()=' Add New Location ']"));
			wpm.ngClick(wm);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			driver.findElement(
					By.xpath("//span[text()='" + arg1 + "']/../../../../../../../div[3]/div/div/crmx-button/button"))
					.click();
			wpm.waitTillElementDisappear(Loading_Spinner);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal_multiline);
			Postal_code_Config_csportal_multiline.sendKeys(arg3);
			wpm.ngClick(Postal_code_Config_Search_multilin);
			// Postal_code_Config_Search.click();
			
			List<WebElement> Floor2 = driver
					.findElements(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[2]"));

			Floor2.get(Floor2.size() - 1).sendKeys("9");
		}

		else {

			WebElement Network_Group = driver.findElement(By.xpath("//span[text()='Add Product To Network Group']"));
			wpm.ngClick(Network_Group);
			wpm.waitTillElementDisappear(Loading_Spinner);
			WebElement Diverse = driver
					.findElement(By.xpath("//span[text()='"+arg1+"']/../../../datatable-body-cell[4]/div/div/crmx-icon-link/button"));
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(Diverse);
			wpm.ngClick(Diverse);
			wpm.waitTillElementDisappear(Loading_Spinner);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			

			
			List<WebElement> dropdown_diverse = driver.findElements(By.xpath("//span[text()='Location Name']/../../../../div[2]/div/a[@aria-haspopup='true']"));
			
			dropdown_diverse.get(dropdown_diverse.size()-1).click();
			
			WebElement Postal_code = driver.findElement(By.xpath("//span[text()='Location Name']/../../../../div[2]/div/a[@aria-haspopup='true']/../div/a"));
			Postal_code.click();
		}
		

		
		if (Customer_Dashboard.product_offering.contains("Burstable")) {

			WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[3]/.."));
			Actions move = new Actions(driver);

			Action action_0 = (Action) move.dragAndDropBy(slider, 160, 0).build();
			action_0.perform();

		} else {
			WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			Actions move = new Actions(driver);

			Action action_0 = (Action) move.dragAndDropBy(slider, 160, 0).build();
			action_0.perform();

		}

		if (arg1.contains("Burstable")) {

			List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='sliderRange'])/.."));

			System.out.println("Burstable..");
			Actions move1 = new Actions(driver);
			Action action_1 = (Action) move1.dragAndDropBy(elements.get(elements.size() - 1), 200, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		try {
			List<WebElement> Demarcatio_clicks = driver
					.findElements(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));

			Demarcatio_clicks.get(Demarcatio_clicks.size() - 1).click();

			List<WebElement> Demarcatio_select = driver.findElements(
					By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(Demarcatio_select.get(Demarcatio_select.size() - 1));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (arg1.contains("IPVPN") && (arg2.contains("Static"))) {

			WebElement IP_Type = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[4]"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a)[2]"));
			wpm.ngClick(IP_Type_Select);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}

		else if (arg1.contains("IPVPN") && (arg2.contains("BGP"))) {

			WebElement BGP = driver.findElement(By.xpath("(//label[text()='BGP']//../input)[2]"));
			wpm.ngClick(BGP);

			WebElement IP_Type = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[5]/i"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a)[2]"));
			wpm.ngClick(IP_Type_Select);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Finalize);
		Finalize.click();
		wpm.waitTillElementDisappear(Loading_Spinner);

	}

	
	public void ADD_NEW_LOCATION_lessthan_1G(String arg1, String arg2, String arg3) throws IOException, InterruptedException {

		if (!arg1.contains("Diverse")) {

			WebElement wm = driver.findElement(By.xpath("//button[text()=' Add New Location ']"));
			wpm.ngClick(wm);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			driver.findElement(
					By.xpath("//span[text()='" + arg1 + "']/../../../../../../../div[3]/div/div/crmx-button/button"))
					.click();
			wpm.waitTillElementDisappear(Loading_Spinner);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal_multiline);
			Postal_code_Config_csportal_multiline.sendKeys(arg3);
			wpm.ngClick(Postal_code_Config_Search_multilin);

			List<WebElement> Floor2 = driver
					.findElements(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[2]"));

			Floor2.get(Floor2.size() - 1).sendKeys("9");
		}

		else {

			WebElement Diverse = driver
					.findElement(By.xpath("//span[text()='" + arg1 + "']/../../../../../div[2]/crmx-button/button"));
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(Diverse);
			wpm.ngClick(Diverse);
			wpm.waitTillElementDisappear(Loading_Spinner);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
			List<WebElement> dropdown_diverse = driver.findElements(By.xpath("//span[text()='Location Name']/../../../../div[2]/div/a[@aria-haspopup='true']"));
			
			dropdown_diverse.get(dropdown_diverse.size()-1).click();
			
			WebElement Postal_code = driver.findElement(By.xpath("//span[text()='Location Name']/../../../../div[2]/div/a[@aria-haspopup='true']/../div/a"));
			Postal_code.click();
			//span[text()='Location Name']/../../../../div[2]/div/a[@aria-haspopup='true']/../div/a
		}
	
		// Postal_code_Config_Search.click();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {

			WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[3]/.."));
			Actions move = new Actions(driver);

			Action action_0 = (Action) move.dragAndDropBy(slider, 30, 0).build();
			action_0.perform();

		} else {
			WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			Actions move = new Actions(driver);

			Action action_0 = (Action) move.dragAndDropBy(slider, 30, 0).build();
			action_0.perform();

		}

		if (arg1.contains("Burstable")) {

			List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='sliderRange'])/.."));

			System.out.println("Burstable..");
			Actions move1 = new Actions(driver);
			Action action_1 = (Action) move1.dragAndDropBy(elements.get(elements.size() - 1), 30, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		try {
			List<WebElement> Demarcatio_clicks = driver
					.findElements(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));

			Demarcatio_clicks.get(Demarcatio_clicks.size() - 1).click();

			List<WebElement> Demarcatio_select = driver.findElements(
					By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(Demarcatio_select.get(Demarcatio_select.size() - 1));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (arg1.contains("IPVPN") && (arg2.contains("Static"))) {

			WebElement IP_Type = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[4]"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a)[2]"));
			wpm.ngClick(IP_Type_Select);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}

		else if (arg1.contains("IPVPN") && (arg2.contains("BGP"))) {

			WebElement BGP = driver.findElement(By.xpath("(//label[text()='BGP']//../input)[2]"));
			wpm.ngClick(BGP);

			WebElement IP_Type = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[4]/i"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a)[2]"));
			wpm.ngClick(IP_Type_Select);
			WebElement ASN_Number = driver
					.findElement(By.xpath("(//span[text()='AS Number (IPV4)']/../../../../div[2]/div[1]/input)[2]"));
			ASN_Number.sendKeys("1234");
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}
		

	}

	
	public void ADD_NEW_LOCATION(String arg1, String arg2, String arg3) throws IOException, InterruptedException {

		if (!arg1.contains("Diverse")) {

			WebElement wm = driver.findElement(By.xpath("//button[text()=' Add New Location ']"));
			wpm.ngClick(wm);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			driver.findElement(
					By.xpath("//span[text()='" + arg1 + "']/../../../../../../../div[3]/div/div/crmx-button/button"))
					.click();
			wpm.waitTillElementDisappear(Loading_Spinner);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal_multiline);
			Postal_code_Config_csportal_multiline.sendKeys(arg3);
			wpm.ngClick(Postal_code_Config_Search_multilin);

			List<WebElement> Floor2 = driver
					.findElements(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[2]"));

			Floor2.get(Floor2.size() - 1).sendKeys("9");
		}

		else {

			WebElement Diverse = driver
					.findElement(By.xpath("//span[text()='" + arg1 + "']/../../../../../div[2]/crmx-button/button"));
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(Diverse);
			wpm.ngClick(Diverse);
			wpm.waitTillElementDisappear(Loading_Spinner);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
			List<WebElement> dropdown_diverse = driver.findElements(By.xpath("//span[text()='Location Name']/../../../../div[2]/div/a[@aria-haspopup='true']"));
			
			dropdown_diverse.get(dropdown_diverse.size()-1).click();
			
			WebElement Postal_code = driver.findElement(By.xpath("//span[text()='Location Name']/../../../../div[2]/div/a[@aria-haspopup='true']/../div/a"));
			Postal_code.click();
			//span[text()='Location Name']/../../../../div[2]/div/a[@aria-haspopup='true']/../div/a
		}
	
		// Postal_code_Config_Search.click();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {

			WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[3]/.."));
			Actions move = new Actions(driver);

			Action action_0 = (Action) move.dragAndDropBy(slider, 160, 0).build();
			action_0.perform();

		} else {
			WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			Actions move = new Actions(driver);

			Action action_0 = (Action) move.dragAndDropBy(slider, 160, 0).build();
			action_0.perform();

		}

		if (arg1.contains("Burstable")) {

			List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='sliderRange'])/.."));

			System.out.println("Burstable..");
			Actions move1 = new Actions(driver);
			Action action_1 = (Action) move1.dragAndDropBy(elements.get(elements.size() - 1), 200, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		try {
			List<WebElement> Demarcatio_clicks = driver
					.findElements(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));

			Demarcatio_clicks.get(Demarcatio_clicks.size() - 1).click();

			List<WebElement> Demarcatio_select = driver.findElements(
					By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(Demarcatio_select.get(Demarcatio_select.size() - 1));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (arg1.contains("IPVPN") && (arg2.contains("Static"))) {

			WebElement IP_Type = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[4]"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a)[2]"));
			wpm.ngClick(IP_Type_Select);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}

		else if (arg1.contains("IPVPN") && (arg2.contains("BGP"))) {

			WebElement BGP = driver.findElement(By.xpath("(//label[text()='BGP']//../input)[2]"));
			wpm.ngClick(BGP);

			WebElement IP_Type = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[4]/i"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a)[2]"));
			wpm.ngClick(IP_Type_Select);
			WebElement ASN_Number = driver
					.findElement(By.xpath("(//span[text()='AS Number (IPV4)']/../../../../div[2]/div[1]/input)[2]"));
			ASN_Number.sendKeys("1234");
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}
		

	}

	public void order_completion() throws IOException, InterruptedException

	{

		WebElement wm3 = driver.findElement(By.xpath("//span[text()='Tracking']"));
		wpm.ngClick(wm3);

		List<WebElement> ReserveID = driver.findElements(
				By.xpath("//span[text()='Reserve']/../../div/div/crmx-icon-link/button/span[2]/span[text()='Claim']"));

		System.out.println("Size is" + ReserveID.size());
		for (int k = 0; k < ReserveID.size(); k++) {

			// Service_ID = ServiceID.get(i+2).getText();

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			WebElement ReserveId_claim = driver.findElement(By.xpath(
					"//span[text()='Reserve']/../../div/div/crmx-icon-link/button/span[2]/span[text()='Claim']"));
			wpm.ngClick(ReserveId_claim);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			WebElement Yes = driver.findElement(By.xpath("//button[text()='Yes']"));

			wpm.ngClick(Yes);

			wpm.waitTillElementDisappear(Loading_Spinner);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			wpm.ngClick(Availability_close);

			WebElement Complete_Order = driver.findElement(By.xpath("//span[text()='Submit Reservation']"));
			wpm.ngClick(Complete_Order);

			// wpm.waitTillElementDisappear(Loading_Spinner);

			WebElement Complete_Order_submit = driver.findElement(By.xpath("//button[text()='Submit']"));
			wpm.ngClick(Complete_Order_submit);
			wpm.waitTillElementDisappear(Loading_Spinner);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			// wpm.ngClick(Availability_close);
			// wpm.waitTillElementDisappear(Loading_Spinner);
			wpm.ngClick(Availability_close);
			wpm.waitTillElementDisappear(Loading_Spinner);
			WebElement Complete_Order_Refresh = driver.findElement(By.xpath("//button[text()=' Refresh ']"));
			wpm.ngClick(Complete_Order_Refresh);
			wpm.waitTillElementDisappear(Loading_Spinner);

		}

		List<WebElement> ServiceID = driver.findElements(By.xpath("//div[@class='d-flex']/div/div/h6"));
		List<WebElement> Service_ID = driver.findElements(By.xpath("//div[@class='input-group']/div[text()='In Progress']/../../../../h6"));
		
		int i = 0;
		for (int k = 0; k < ServiceID.size() / 2; k++) {
			try {
				// Service_ID = ServiceID.get(i+2).getText();

				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
				wpm.scrolldown();
				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
				WebElement Claim = driver.findElement(By.xpath("//span[text()='Claim']"));

				wpm.ngClick(Claim);
				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

				WebElement Yes = driver.findElement(By.xpath("//button[text()='Yes']"));

				wpm.ngClick(Yes);

				wpm.waitTillElementDisappear(Loading_Spinner);

				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

				wpm.ngClick(Availability_close);

				WebElement Complete_Order = driver.findElement(By.xpath("//span[text()='Complete Order']"));
				wpm.ngClick(Complete_Order);
				wpm.waitTillElementDisappear(Loading_Spinner);
				WebElement txn_code = driver
						.findElement(By.xpath("//span[text()='Transaction Code']/../../../../div[2]/div/input"));
				// input[@class='form-control no-append no-prepend ng-untouched ng-pristine
				// ng-invalid ng-star-inserted']
				txn_code.sendKeys("123456");
				// wpm.waitTillElementDisappear(Loading_Spinner);
				
				try {
					
					List<WebElement> Resp = driver.findElements(By.xpath("//span[contains(text(),'RESP_SERVICE')]/../../../../div[2]/div/input"));
							
					for (int t = 2; t < Resp.size(); t++) {
						
						
						try {
							wpm.scrollToElement(Resp.get(t));
							if(k!=0) {
								Resp.get(t).sendKeys(Service_ID.get(Service_ID.size()-1).getText());
							}
							else {
							Resp.get(t).sendKeys(Service_ID.get(0).getText());
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				WebElement Complete_Order_submit = driver.findElement(By.xpath("//button[text()='Submit']"));
				wpm.ngClick(Complete_Order_submit);
				wpm.waitTillElementDisappear(Loading_Spinner);
				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

				// wpm.ngClick(Availability_close);
				wpm.waitTillElementDisappear(Loading_Spinner);
				wpm.ngClick(Availability_close);
				wpm.waitTillElementDisappear(Loading_Spinner);
				WebElement Complete_Order_Refresh = driver.findElement(By.xpath("//button[text()=' Refresh ']"));
				wpm.ngClick(Complete_Order_Refresh);
				wpm.waitTillElementDisappear(Loading_Spinner);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		  WebElement Order_status_complted = driver
				.findElement(By.xpath("//span[text()='Order Status']/../../../div/div"));
		  Order_Status =Order_status_complted.getText();
		Assert.assertTrue("Service order not completed", Order_status_complted.getText().contains("Completed"));
		wpm.scrollToElement(Order_status_complted);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrolldown();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// wpm.scrollup();
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		// Service_ID =
		// driver.findElement(By.xpath("(//div[@class='d-flex']/div/div/h6)[2]")).getText().trim();

	}

	public void Finalize_quote() throws IOException, InterruptedException {

//wpm.ngClick(Close_popup_Quotaion_generation);
		wpm.ngClick(Approver_Radio);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		Quote_approval_Req_comments.sendKeys("Request for approval");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrollToElement(Finalize);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.ngClick(Finalize);
		wpm.waitTillElementDisappear(Loading_Spinner);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void Product_config_CSPortal(String arg1, String arg2) throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		if (Customer_Dashboard.product_offering.contains("PTMP")) {
			WebElement wm = driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"));
			wpm.ngClick(wm);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg2);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 200, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 200, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		if (Customer_Dashboard.product_offering.contains("Internet")) {

			wpm.ngClick(IP_Version);
			wpm.ngClick(IPV6_Select);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		try {
			WebElement Demarcatio_click = driver
					.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(Demarcatio_click);

			WebElement Demarcatio_select = driver
					.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(Demarcatio_select);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			WebElement IP_Type = driver.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(IP_Type_Select);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());


		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_More_than_1G(String arg1, String arg2)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		if (Customer_Dashboard.product_offering.contains("PTMP")) {
			WebElement wm = driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"));
			wpm.ngClick(wm);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg2);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 170, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 170, 0).build();
			action_1.perform();

		}
		WebElement Demarcatio_click = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
		wpm.ngClick(Demarcatio_click);

		WebElement Demarcatio_select = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(Demarcatio_select);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_Reconfig_CSPortal_Auto() throws IOException, InterruptedException {
		// wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		/*
		 * if (!arg1.equals("null")) { Network_Name.sendKeys(arg1); }
		 * 
		 * if (Customer_Dashboard.product_offering.contains("PTMP")) { WebElement wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 * 
		 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 * 
		 * JavascriptExecutor jse = (JavascriptExecutor) driver;
		 * jse.executeScript("arguments[0].scrollIntoView()",
		 * Postal_code_Config_csportal); Postal_code_Config_csportal.sendKeys(arg2);
		 * wpm.ngClick(Postal_code_Config_Search); // Postal_code_Config_Search.click();
		 * 
		 * WebElement Floor = driver.findElement(By.
		 * xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));
		 * 
		 * Floor.sendKeys("08");
		 */

		// wpm.waitTillElementDisappear(Loading_Spinner);

		if (Customer_Dashboard.product_offering.contains("IPVPN")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);
		} else if (Customer_Dashboard.product_offering.contains("PTMP")) {
			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);
		}

		// div[@class='input-group custom-control custom-checkbox']

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 200, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 200, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (Customer_Dashboard.product_offering.contains("IPVPN")
				|| Customer_Dashboard.product_offering.contains("Internet")) {
			WebElement IP_Type = driver.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(IP_Type_Select);
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_Reconfig_CSPortal_Auto_multiline(String arg2) throws IOException, InterruptedException {
		// wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		/*
		 * if (!arg1.equals("null")) { Network_Name.sendKeys(arg1); }
		 * 
		 * if (Customer_Dashboard.product_offering.contains("PTMP")) { WebElement wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 * 
		 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 * 
		 * JavascriptExecutor jse = (JavascriptExecutor) driver;
		 * jse.executeScript("arguments[0].scrollIntoView()",
		 * Postal_code_Config_csportal); Postal_code_Config_csportal.sendKeys(arg2);
		 * wpm.ngClick(Postal_code_Config_Search); // Postal_code_Config_Search.click();
		 * 
		 * WebElement Floor = driver.findElement(By.
		 * xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));
		 * 
		 * Floor.sendKeys("08");
		 */

		// wpm.waitTillElementDisappear(Loading_Spinner);

		if (Customer_Dashboard.product_offering.contains("IPVPN")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		else if (Customer_Dashboard.product_offering.contains("PTMP")) {
			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 250, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 250, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='sliderRange'])/.."));

		Action action_2 = (Action) move.dragAndDropBy(elements.get(elements.size() - 2), 250, 0).build();
		action_2.perform();

		if (arg2.contains("Burstable")) {

			System.out.println("Burstable..");

			Action action_3 = (Action) move.dragAndDropBy(elements.get(elements.size() - 1), 250, 0).build();
			action_3.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_Cloud_connect(String arg1, String arg2)
			throws IOException, InterruptedException {
Thread.sleep(4000);
		wpm.scrollToElement(Cloud_connect_Add);
		Cloud_connect_Add.click();
		Actions move = new Actions(driver);
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='sliderRange'])/.."));

		Action action_1 = (Action) move.dragAndDropBy(elements.get(elements.size() - 1), 20, 0).build();
		action_1.perform();

		wpm.ngClick(Cloud_connect_Provider);

		WebElement provider_value = driver.findElement(By.xpath(
				"//span[text()='Cloud Provider']/../../../../div[2]/div/div/a[contains(text(),'" + arg1 + "')]"));

		wpm.ngClick(provider_value);

		wpm.ngClick(Data_Center);

		WebElement Data_Center_value = driver.findElement(
				By.xpath("//span[text()='Data Center']/../../../../div[2]/div/div/a[contains(text(),'" + arg2 + "')]"));

		wpm.ngClick(Data_Center_value);
		
	
	try {
		wpm.ngClick(Cloud_Connect_IP_Version);
		wpm.ngClick(IPV4_Select);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_topo(String arg1, String arg2, String arg3)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg3);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver
				.findElement(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[1]"));

		Floor.sendKeys("08");
		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 20, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 30, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement Demarcatio_click;
		try {
			Demarcatio_click = driver
					.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(Demarcatio_click);

			WebElement Demarcatio_select = driver.findElement(
					By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(Demarcatio_select);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement IP_Type = driver.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/a"));
		wpm.ngClick(IP_Type);

		WebElement IP_Type_Select = driver
				.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(IP_Type_Select);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_topo_more_than_1G(String arg1, String arg2, String arg3)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg3);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver
				.findElement(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[1]"));

		Floor.sendKeys("08");
		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 200, 0).build();
		action_0.perform();
		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 200, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_topo_morethan_1G(String arg1, String arg2, String arg3)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg3);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 180, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 180, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (Customer_Dashboard.product_offering.contains("Internet")) {

			wpm.ngClick(IP_Version);
			wpm.ngClick(IPV6_Select);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		try {
			WebElement Demarcatio_click = driver
					.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(Demarcatio_click);

			WebElement Demarcatio_select = driver
					.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(Demarcatio_select);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			WebElement IP_Type = driver.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(IP_Type_Select);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_topo_morethan_1G_staff(String arg1, String arg2, String arg3, String arg4)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		try {
			if (arg2.contains("Hub and Spoke")) {
				WebElement wm = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
				wpm.ngClick(wm);

				WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
				wpm.ngClick(wm1);

				// div[@class='input-group custom-control custom-checkbox']
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg3);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 300, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 300, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (Customer_Dashboard.product_offering.contains("Internet")) {

			wpm.ngClick(IP_Version);
			wpm.ngClick(IPV6_Select);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement Demarcatio_click = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
		wpm.ngClick(Demarcatio_click);

		WebElement Demarcatio_select = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(Demarcatio_select);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		
		if (!Customer_Dashboard.product_offering.contains("MetroE")) {

			WebElement IP_Type = driver.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(IP_Type_Select);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// Availability_close.click();
		WebElement wm = driver
				.findElement(By.xpath("//crmx-form-radio-item/div/label[text()='" + arg4 + "']/../input"));
		wpm.ngClick(wm);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void Product_config_CSPortal_topo_morethan_1G_IPV4(String arg1, String arg2, String arg3)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg3);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 180, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 180, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (Customer_Dashboard.product_offering.contains("Internet")) {

			wpm.ngClick(IP_Version);
			wpm.ngClick(IPV4_Select);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement Demarcatio_click = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
		wpm.ngClick(Demarcatio_click);

		WebElement Demarcatio_select = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(Demarcatio_select);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement IP_Type = driver.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/a"));
		wpm.ngClick(IP_Type);

		WebElement IP_Type_Select = driver
				.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(IP_Type_Select);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_topo_morethan_1G(String arg1, String arg2, String arg3, String arg4)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg4);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 180, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 180, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	
			try {
				wpm.ngClick(IP_Version);
				wpm.ngClick(IPV6_Select);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			try {
				WebElement Demarcatio_click = driver
						.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
				wpm.ngClick(Demarcatio_click);

				WebElement Demarcatio_select = driver
						.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
				wpm.ngClick(Demarcatio_select);

				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement BGP = driver.findElement(By.xpath("//label[text()='" + arg3 + "']//../input"));
			wpm.ngClick(BGP);

			WebElement IP_Type = driver.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[2]"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(IP_Type_Select);
			
			WebElement ASN_Number;
			try {
				ASN_Number = driver
						.findElement(By.xpath("//span[text()='AS Number (IPV6)']/../../../../div[2]/div[1]/input"));
				ASN_Number.sendKeys("1234");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				WebElement ASN_Number2 = driver
						.findElement(By.xpath("//span[text()='AS Number (IPV4)']/../../../../div[2]/div[1]/input"));
				ASN_Number2.sendKeys("1234");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}
	public void Product_config_CSPortal_topo_morethan_1G(String arg1, String arg2, String arg3, String arg4, String arg5)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg4);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 180, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 180, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	
			try {
				wpm.ngClick(IP_Version);
				wpm.ngClick(IPV4_Select);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			try {
				WebElement Demarcatio_click = driver
						.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
				wpm.ngClick(Demarcatio_click);

				WebElement Demarcatio_select = driver
						.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
				wpm.ngClick(Demarcatio_select);

				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement BGP = driver.findElement(By.xpath("//label[text()='" + arg3 + "']//../input"));
			wpm.ngClick(BGP);

			WebElement IP_Type = driver.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[2]"));
			wpm.ngClick(IP_Type);

			WebElement IP_Type_Select = driver
					.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(IP_Type_Select);
			
			WebElement ASN_Number;
			try {
				ASN_Number = driver
						.findElement(By.xpath("//span[text()='AS Number (IPV6)']/../../../../div[2]/div[1]/input"));
				ASN_Number.sendKeys("1234");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				WebElement ASN_Number2 = driver
						.findElement(By.xpath("//span[text()='AS Number (IPV4)']/../../../../div[2]/div[1]/input"));
				ASN_Number2.sendKeys("1234");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_topo_morethan_1G_IPV4(String arg1, String arg2, String arg3, String arg4)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg4);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();

		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 180, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 180, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.ngClick(IP_Version);
		wpm.ngClick(IPV4_Select);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement Demarcatio_click = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
		wpm.ngClick(Demarcatio_click);

		WebElement Demarcatio_select = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(Demarcatio_select);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement BGP = driver.findElement(By.xpath("//label[text()='" + arg3 + "']//../input"));
		wpm.ngClick(BGP);

		WebElement IP_Type = driver.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[2]"));
		wpm.ngClick(IP_Type);

		WebElement IP_Type_Select = driver
				.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(IP_Type_Select);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_DCI(String arg1, String arg2, String arg3, String arg4)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm_1 = driver.findElement(By.xpath(
				"(//div[@class='position-relative text-nowrap text-truncate crmx-select-value-wrapper placeholder'])[1]"));

		wpm.ngClick(wm_1);

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'" + arg3 + "')]")));
		actions.click().build().perform();

		WebElement wm_2 = driver.findElement(By.xpath(
				"(//div[@class='position-relative text-nowrap text-truncate crmx-select-value-wrapper placeholder'])[1]"));

		wpm.ngClick(wm_2);

		actions.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'" + arg4 + "')])[3]")));
		actions.click().build().perform();

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 300, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 30, 0).build();
			action_1.perform();

		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_IOT(String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6) throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		/*
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * wm =
		 * driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"
		 * )); wpm.ngClick(wm); }
		 */

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm_1 = driver.findElement(By.xpath(
				"(//div[@class='position-relative text-nowrap text-truncate crmx-select-value-wrapper placeholder'])[1]"));

		wpm.ngClick(wm_1);

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'" + arg3 + "')]")));
		actions.click().build().perform();

		WebElement wm_3 = driver
				.findElement(By.xpath("//span[text()='" + arg4 + "']/../../../../../div[2]/crmx-button/button"));

		wpm.ngClick(wm_3);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		WebElement wm_4 = driver.findElement(By.xpath(
				"(//div[@class='position-relative text-nowrap text-truncate crmx-select-value-wrapper placeholder'])[1]"));

		wpm.ngClick(wm_4);

		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'" + arg6 + "')]")));
		actions.click().build().perform();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement wm_2 = driver.findElement(By.xpath(
				"(//div[@class='position-relative text-nowrap text-truncate crmx-select-value-wrapper placeholder'])[1]"));

		wpm.ngClick(wm_2);

		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'" + arg5 + "')]")));
		actions.click().build().perform();

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver);
		 * 
		 * Action action_0 = (Action) move.dragAndDropBy(slider, 20, 0).build();
		 * action_0.perform();
		 * 
		 * if (Customer_Dashboard.product_offering.contains("Burstable")) { WebElement
		 * slider_2 =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
		 * System.out.println("Burstable..");
		 * 
		 * Action action_1 = (Action) move.dragAndDropBy(slider_2, 100, 0).build();
		 * action_1.perform();
		 * 
		 * }
		 */
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal_topo_VAS(String arg1, String arg2, String arg3, String arg4)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement wm = driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"));
			wpm.ngClick(wm);
		}

		if (arg2.contains("Hub and Spoke")) {
			WebElement wm = driver.findElement(By.xpath("//label[text()='Hub and Spoke']/../input"));
			wpm.ngClick(wm);

			WebElement wm1 = driver.findElement(By.xpath("//label[text()='Hub ']/../input"));
			wpm.ngClick(wm1);

			// div[@class='input-group custom-control custom-checkbox']
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg3);
		wpm.ngClick(Postal_code_Config_Search);
		// Postal_code_Config_Search.click();
		WebElement Floor = driver.findElement(By.xpath("//span[text()='Unit Number']/../../../../div[2]/div/input"));

		Floor.sendKeys("08");
		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 180, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 180, 0).build();
			action_1.perform();

		}
		try {
			WebElement Demarcatio_click = driver
					.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(Demarcatio_click);

			WebElement Demarcatio_select = driver.findElement(
					By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(Demarcatio_select);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement BGP = driver.findElement(By.xpath("//label[text()='BGP']//../input"));
		wpm.ngClick(BGP);

		WebElement IP_Type = driver
				.findElement(By.xpath("(//span[text()='IP Type']/../../../../div[2]/div[1]/a)[2]/i"));
		wpm.ngClick(IP_Type);

		WebElement IP_Type_Select = driver
				.findElement(By.xpath("//span[text()='IP Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(IP_Type_Select);
		
		WebElement ASN_Number = driver
				.findElement(By.xpath("//span[text()='AS Number (IPV4)']/../../../../div[2]/div[1]/input"));
		ASN_Number.sendKeys("1234");
		
		
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		if (arg4.contains("Upgrade")) {

			WebElement upgrade = driver.findElement(By.xpath("//label[text()='Upgrade']/../input"));
			wpm.ngClick(upgrade);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			WebElement Critical_data = driver.findElement(By.xpath("//label[text()='Critical Data']/../input"));
			wpm.ngClick(Critical_data);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			WebElement save = driver.findElement(By.xpath("//button[text()='OK']/../button"));
			wpm.ngClick(save);

		}

		else {
			WebElement upgrade = driver.findElement(By.xpath("//label[text()='Flexi Cos']/../input"));
			wpm.ngClick(upgrade);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			WebElement split1 = driver.findElement(By.xpath(
					"(//a[@href='javascript:void(0)' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend'])[2]"));
			wpm.ngClick(split1);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			WebElement perce1 = driver.findElement(By.xpath("//a[contains(text(),'100')]"));
			wpm.ngClick(perce1);
			wpm.ngClick(split1);

			/*
			 * WebElement split2 = driver.findElement(By.
			 * xpath("(//a[@href='javascript:void(0)' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend'])[4]"
			 * )); wpm.ngClick(split2);
			 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			 * 
			 * WebElement perce2 =
			 * driver.findElement(By.xpath("//a[contains(text(),'30')]"));
			 * wpm.ngClick(perce2); wpm.ngClick(split2);
			 * 
			 * 
			 * WebElement split3 = driver.findElement(By.
			 * xpath("(//a[@href='javascript:void(0)' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend'])[6]"
			 * )); wpm.ngClick(split3);
			 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			 * 
			 * WebElement perce3 =
			 * driver.findElement(By.xpath("//a[contains(text(),'20')]"));
			 * wpm.ngClick(perce3); wpm.ngClick(split3);
			 */
			WebElement save = driver.findElement(By.xpath("//button[text()='OK']/../button"));
			wpm.ngClick(save);

		}
		/*
		 * else {
		 * 
		 * if(!arg3.contains("NA")) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("3Gbps")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("600")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } } }
		 * 
		 * if(!Customer_Dashboard.product_offering.contains("ATA")&&!arg4.contains("NA")
		 * ) { WebElement slider =
		 * driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/..")); Actions
		 * move = new Actions(driver); if(arg3.equals("600")) { Action action_0 =
		 * (Action) move.dragAndDropBy(slider, 10, 0).build(); action_0.perform(); }
		 * else if(arg3.equals("3Gbps")) { Action action_0 = (Action)
		 * move.dragAndDropBy(slider, 150, 0).build(); action_0.perform(); } else
		 * if(arg3.equals("700")) { Action action0 = (Action) move.dragAndDropBy(slider,
		 * 20, 0).build(); action0.perform(); } else if(arg4.equals("900")) {
		 * System.out.println("Burstable.."); Action action0 = (Action)
		 * move.dragAndDropBy(slider, 30, 0).click().build(); action0.perform(); } }
		 */

	}

	public void Product_config_CSPortal(String arg1, String arg2, String arg3)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement wm = driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"));
			wpm.ngClick(wm);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg2);
		wpm.ngClick(Postal_code_Config_Search);

		WebElement Floor = driver
				.findElement(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[1]"));

		Floor.sendKeys("08");

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_02);
		Postal_code_Config_02.sendKeys(arg3, Keys.ENTER);

		Thread.sleep(2000);
		WebElement Floor2 = driver
				.findElement(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[2]"));

		Floor2.sendKeys("9");
		// Floor.sendKeys("09");
		// Postal_code_Config_Search.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 20, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 30, 0).build();
			action_1.perform();

		}

		try {
			WebElement Demarcatio_click = driver
					.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
			wpm.ngClick(Demarcatio_click);

			WebElement Demarcatio_select = driver.findElement(
					By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
			wpm.ngClick(Demarcatio_select);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void Product_config_CSPortal_morethan_1G(String arg1, String arg2, String arg3)
			throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		if (!arg1.equals("null")) {
			Network_Name.sendKeys(arg1);
		}

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement wm = driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/input"));
			wpm.ngClick(wm);
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_csportal);
		Postal_code_Config_csportal.sendKeys(arg2);
		wpm.ngClick(Postal_code_Config_Search);

		WebElement Floor = driver
				.findElement(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[1]"));

		Floor.sendKeys("08");

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", Postal_code_Config_02);
		Postal_code_Config_02.sendKeys(arg3, Keys.ENTER);

		Thread.sleep(2000);
		WebElement Floor2 = driver
				.findElement(By.xpath("(//span[text()='Unit Number']/../../../../div[2]/div/input)[2]"));

		Floor2.sendKeys("9");
		// Floor.sendKeys("09");
		// Postal_code_Config_Search.click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		WebElement slider = driver.findElement(By.xpath("(//div[@class='sliderRange'])[1]/.."));
		Actions move = new Actions(driver);

		Action action_0 = (Action) move.dragAndDropBy(slider, 180, 0).build();
		action_0.perform();

		if (Customer_Dashboard.product_offering.contains("Burstable")) {
			WebElement slider_2 = driver.findElement(By.xpath("(//div[@class='sliderRange'])[2]/.."));
			System.out.println("Burstable..");

			Action action_1 = (Action) move.dragAndDropBy(slider_2, 180, 0).build();
			action_1.perform();

		}

		WebElement Demarcatio_click = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/a"));
		wpm.ngClick(Demarcatio_click);

		WebElement Demarcatio_select = driver
				.findElement(By.xpath("//span[text()='Demarcation Device Type']/../../../../div[2]/div[1]/div[1]/a"));
		wpm.ngClick(Demarcatio_select);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void click_quote_CSportal(String arg4) throws IOException, InterruptedException

	{
		// wpm.Switch_to_another();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		// wpm.scrollToElement(driver.findElement(By.xpath("//h5[text()=' Client
		// Interface ']")));

		wpm.scrollToElement(Contract_tenure_ipvpn.get(Contract_tenure_ipvpn.size() - 1));
		// wpm.ngClick(Contract_tenure_ipvpn.get(Contract_tenure_ipvpn.size()-1));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// wpm.scrollToElement(Contract_tenure_ipvpn.get(Contract_tenure_ipvpn.size()-1));
		Actions actions = new Actions(driver);
		actions.moveToElement(Contract_tenure_ipvpn.get(Contract_tenure_ipvpn.size() - 1));
		actions.click().build().perform();

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		try {
			Thread.sleep(2000);

			WebElement wm = driver.findElement(By.xpath("(//a[contains(text(),'" + arg4 + "')])[1]"));
			actions.moveToElement(wm);
			actions.click().build().perform();
			// wpm.ngClick(wm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wpm.scrollToElement(Quote);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot(), "After click on Quote button in Prod config page");
		wpm.ngClick(Quote);
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

	}

	public void reject_quote() throws IOException, InterruptedException {
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		wpm.ngClick(driver.findElement(By.xpath("//button[text()='Reject ']")));
		// driver.findElement(By.xpath("//button[text()='Reject ']")).click();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		driver.findElement(By.xpath("//div[@class='input-group']/textarea")).sendKeys("Rejected ");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		driver.findElement(By.xpath("//button[text()='Send']")).click();

	}

	@SuppressWarnings("deprecation")
	public void verify_quote_myquotes(String arg1) throws IOException, InterruptedException {

		try {
			// wpm.waitTillElementAppeared(feasibility_alert);
			wpm.waitTillVisible(feasibility_alert);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			Quote_value = feasibility_alert.getText().split(":")[1];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		driver.findElement(By.xpath("//input[@placeholder='Quotation no.']")).sendKeys(Quote_value);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		driver.findElement(By.xpath("//i[@class='icon-search4']")).click();
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		Assert.assertTrue(driver.findElement(By.xpath("//crmx-status-badge/div/div/div")).getText().contains(arg1));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void Availability_check() throws InterruptedException, IOException {
		// Thread.sleep(4000);
		// Availability.click();
		// wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// wpm.waitTillElementAppeared(feasibility_alert);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void feasibility_verification_order_management() throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('https://lxflohapapp.dc1uat.boss.sptel.int:44043')");
		// String Symphony_URL =
		// properties.getProperty("Symphony_order_management_URL");
		// driver.get(Symphony_URL);
		wpm.Switch_to_another();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		username.sendKeys(properties.getProperty("Nokia_order_managment_username"));
		password.sendKeys(properties.getProperty("Nokia_order_managment_password"));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		order_management_login.click();
		driver.switchTo().frame("headerFrame");
		Monitoring.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		try {
			if (search_form.isDisplayed()) {
				search_form.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("mainFrame");
		wpm.ngClick(Datepicker);
		// ((JavascriptExecutor) driver).executeScript("arguments[0].value ='';",
		// Datepicker);
		Datepicker.clear();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// ((JavascriptExecutor) driver).executeScript("arguments[0].value ='1.1';",
		// Datepicker);
		// js.executeScript(“document.getElementsById(‘some_id’).value=’Avinash
		// Mishra’;”);

		wpm.ngClick(Search);

		for (WebElement iterable_element : Basic_requests) {
			if (iterable_element.getAttribute("title").contains("SPT-CUST-1593999094993")) {
				feasibiliy_order_ID = iterable_element.getAttribute("title").trim();
				break;

			}

		}

		for (WebElement iterable_element : Basic_requests) {
			if (iterable_element.getAttribute("title").contains("SPT-CUST-1593999094993")
					&& (Customer_Dashboard.product_offering.contains("PTP"))) {
				feasibiliy_order_ID = iterable_element.getAttribute("title").trim();
				if (feasibiliy_order_ID_1 != null) {

					feasibiliy_order_ID_2 = feasibiliy_order_ID;
					break;
				} else {
					feasibiliy_order_ID_1 = feasibiliy_order_ID;

				}

			}

		}

		if ((Customer_Dashboard.product_offering.contains("PTP"))) {

			for (int i = 1; i <= 2; i++) {

				Order_id.sendKeys(feasibiliy_order_ID + "_" + i);
				wpm.ngClick(Search);
				// Search.click();
				wpm.scrollToElement(Basic_request);
				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
				wpm.ngClick(Basic_request);

				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
				wpm.scrollToElement(driver.findElement(By.xpath("//table[@id='details-table']/tbody/tr[8]")));
				wpm.scrolldown();
				try {
					if (Basic_request_failure_task.isDisplayed()) {
						Basic_request_failure_task.click();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			}

		} else {
			Order_id.sendKeys(feasibiliy_order_ID);
			wpm.ngClick(Search);
			// Search.click();
			wpm.scrollToElement(Basic_request);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.ngClick(Basic_request);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(driver.findElement(By.xpath("//table[@id='details-table']/tbody/tr[8]")));
			wpm.scrolldown();
			try {
				if (Basic_request_failure_task.isDisplayed()) {
					Basic_request_failure_task.click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		}

	}

	public void reservation_verification_order_management() throws IOException {

		wpm.Switch_to_another();
		driver.navigate().refresh();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("headerFrame");
		Monitoring.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		try {
			search_form.click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("mainFrame");
		wpm.ngClick(Datepicker);
		// ((JavascriptExecutor) driver).executeScript("arguments[0].value ='';",
		// Datepicker);
		Datepicker.clear();
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// ((JavascriptExecutor) driver).executeScript("arguments[0].value ='1.1';",
		// Datepicker);
		// js.executeScript(“document.getElementsById(‘some_id’).value=’Avinash
		// Mishra’;”);
		// Order_id.sendKeys(Quote_value+"-1-1.1");
		wpm.ngClick(Search);
		// Search.click();

		for (WebElement iterable_element : Basic_requests) {
			if (iterable_element.getAttribute("title").contains(Quote_value)) {
				Reservation_order_ID = iterable_element.getAttribute("title").trim();
				break;
			}

		}
		System.out.println(Quote_value);
		Order_id.sendKeys(Reservation_order_ID);
		wpm.ngClick(Search);
		// Search.click();
		wpm.scrollToElement(Basic_request);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(Basic_request);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.scrollToElement(driver.findElement(By.xpath("//table[@id='details-table']/tbody/tr[8]")));
		wpm.scrolldown();
		try {
			Basic_request_failure_task.click();
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Terms_Conditions_by_placing_signature() throws IOException, InterruptedException {
		wpm.Switch_to_another();
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// wpm.waitForLoad();
		// wpm.waitTillElementAppeared(Accept_CSportal);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		/*
		 * if ((Customer_Dashboard.product_offering.contains("IPVPN"))) {
		 * wpm.scrollToElement(checkbox_terms_CSportal_IPVPN);
		 * wpm.ngClick(checkbox_terms_CSportal_IPVPN); }
		 * 
		 * else { wpm.scrollToElement(checkbox_terms_CSportal);
		 * wpm.ngClick(checkbox_terms_CSportal); }
		 */

		wpm.scrollToElement(checkbox_terms_CSportal.get(checkbox_terms_CSportal.size() - 1));
		wpm.ngClick(checkbox_terms_CSportal.get(checkbox_terms_CSportal.size() - 1));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// wpm.ngClick(Terms_conditions);
		// Thread.sleep(7000);

		// wpm.waitTillElementClickable(Terms_conditions_popup);
		// wpm.ngClick(Terms_conditions_popup);
		// wpm.waitTillElementAppeared(Accept_CSportal);
		wpm.scrollToElement(Digi_Signature_CSportal);
		// wpm.waitTillVisible(Digi_Signature_CSportal);
		// wpm.waitTillElementClickable(Digi_Signature_CSportal);
		wpm.digital_signature(Digi_Signature_CSportal);

		wpm.scrollToElement(Accept_CSportal);
		wpm.ngClick(Accept_CSportal);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		try {
			wpm.waitTillElementAppeared(feasibility_alert);
			wpm.waitTillVisible(feasibility_alert);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

			Quote_value = feasibility_alert.getText().split(":")[1];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
