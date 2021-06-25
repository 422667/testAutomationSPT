package com.sc.sym.pages;

import static com.sc.sym.utility.WrapperElements.properties;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;
import com.sc.sym.glue.Hooks;
import com.sc.sym.utility.FetchTestData;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;

import junit.framework.Assert;

public class OrderconfirmationPage extends Hooks {
	WrapperMethods wpm;
	WebDriver driver;

	@FindBy(xpath = "//div[text()='Order created']")
	public WebElement Confirm_order_page;

	@FindBy(xpath = "(//button[text()=' Close '])[2]")
	public WebElement Order_close_popup;

	@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[1]")
	WebElement Survey_Date;

	@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[3]")
	WebElement Survey_Date_DCI_2;

	@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[3]")
	WebElement Survey_Date_PTP_2;

	@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[2]")
	WebElement Survey_Date_multiline;

	@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[3]")
	WebElement Wiring_Date;

	@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[1]")
	WebElement Wiring_Date_GPON;

	@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[1]")
	WebElement Installation_Date;
	
	@FindBy(xpath = "//div[@class='ngb-dp-day ng-star-inserted']")
	List<WebElement> Installation_Dates;
	
	@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[3]")
	WebElement Installation_Date_PTP;

	@FindBy(xpath = "(//div[@class='custom-control custom-radio'])[1]")
	WebElement Site_Survey_Date_appointment;

	@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[2]/td[2]/crmx-form-input/div/div/div/input")
	WebElement Site_surevey_contact;

	@FindBy(xpath = "//td[text()=' NLT Wiring ']/../../tr[2]/td[2]/crmx-form-input/div/div/div/input")
	WebElement Wire_contact_GPON;

	@FindBy(xpath = "(//h5[text()='Site Survey']/../../div[2]/div[2]/div/crmx-form-input/div/div[2]/div/input)[1]")
	WebElement Site_surevey_contact_staff;

	@FindBy(xpath = "(//h5[text()='Site Survey']/../../div[2]/div[2]/div/crmx-form-input/div/div[2]/div/input)[2]")
	WebElement Site_surevey_contact_staff_site_2;

	@FindBy(xpath = "(//h5[text()='Site Survey']/../../div[2]/div[2]/div[2]/crmx-intl-tel-input/div/div/div/input)[1]")
	WebElement Mobilenum_staff;

	@FindBy(xpath = "(//h5[text()='Site Survey']/../../div[2]/div[2]/div[2]/crmx-intl-tel-input/div/div/div/input)[2]")
	WebElement Mobilenum_staff_site_2;

	@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[6]/td[2]/crmx-form-input/div/div/div/input")
	WebElement Site_surevey_contact_PTP;

	@FindBy(xpath = "//td[text()=' NLT Wiring ']/../../tr[6]/td[2]/crmx-form-input/div/div/div/input")
	WebElement wiring_contact_PTP_GPON;

	@FindBy(xpath = "//td[text()=' NLT Wiring ']/../../tr[6]/td[2]/crmx-form-input/div/div/div/input")
	WebElement wiring_contact_multi_GPON;

	@FindBy(xpath = "//td[text()=' NLT Wiring ']/../../tr[7]/td[2]/crmx-form-input/div/div/div/input")
	WebElement wiring_contact_PTP_GPON_site_2;

	@FindBy(xpath = "(//td[text()=' NLT Wiring ']/../../tr[7]/td[2]/crmx-form-input/div/div/div/input)[1]")
	WebElement wiring_contact_multiline2_GPON_site_2;

	@FindBy(xpath = "(//td[text()=' Site Survey ']/../../tr[6]/td[2]/crmx-form-input/div/div/div/input)[2]")
	WebElement Site_surevey_contact_PTP_multiline_2;

	@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[7]/td[2]/crmx-form-input/div/div/div/input")
	WebElement Site_surevey_contact_site_2;

	@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[2]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	WebElement Mobilenum;
	
	@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[2]/td[4]/crmx-form-input/div/div/div/input")
	WebElement Email_confirm;
	
	
	@FindBy(xpath = "//td[text()=' NLT Wiring ']/../../tr[2]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	WebElement Mobilenum_GPON;

	@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[6]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	WebElement Mobilenum_PTP;

	@FindBy(xpath = "//td[text()=' NLT Wiring ']/../../tr[6]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	WebElement Wiring_Mobilenum_PTP_GPON;

	@FindBy(xpath = "//td[text()=' NLT Wiring ']/../../tr[6]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	WebElement Wiring_Mobilenum_multi_GPON;

	@FindBy(xpath = "(//td[text()=' NLT Wiring ']/../../tr[7]/td[3]/div/crmx-intl-tel-input/div/div/div/input)")
	WebElement Wiring_Mobilenum_multi_GPON_2;

	@FindBy(xpath = "(//td[text()=' NLT Wiring ']/../../tr[4]/td[3]/div/crmx-intl-tel-input/div/div/div/input)[4]")
	WebElement Wiring_Mobilenum_PTP_GPON_site_2;

	@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[7]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	WebElement Mobilenum_site2;

	@FindBy(xpath = "(//span[text()='Same as above']/../../../div/div[contains(@class,'custom-checkbox')]/input)[1]")
	WebElement Wiring_contact;

	@FindBy(xpath = "(//span[text()='Same as above']/../../../div/div[contains(@class,'custom-checkbox')]/input)[3]")
	WebElement staff_Wiring_contact_site_2;

	@FindBy(xpath = "(//span[text()='Same as above']/../../../div/div[contains(@class,'custom-checkbox')]/input)[2]")
	WebElement installation_contact;

	@FindBy(xpath = "(//span[text()='Same as above']/../../../div/div[contains(@class,'custom-checkbox')]/input)[4]")
	WebElement staff_installation_contact_site_2;

	@FindBy(xpath = "(//span[text()='Same as above']/../../../div/div[contains(@class,'custom-checkbox')]/input)[1]")
	WebElement installation_contact_GPON;

	@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[4]")
	WebElement Wiring_contact_site_2;

	@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[2]")
	WebElement Wiring_contact_site_2_GPON;

	@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[3]")
	WebElement Wiring_contact_site_2_multiline;

	@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[5]")
	WebElement Wiring_contact_site_2_multiline_PTMP;

	@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[4]")
	WebElement installation_contact_site_2_multiline;

	@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[6]")
	WebElement installation_contact_site_2_multiline_PTMP;

	@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[5]")
	WebElement installation_contact_site_2;

	@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[3]")
	WebElement installation_contact_site_GPON_PTP_Site_2;

	@FindBy(xpath = "(//span[text()='Same as above']/../../../div/div[contains(@class,'custom-checkbox')]/input)[2]")
	WebElement installation_contact_site_2_GPON;

	@FindBy(xpath = "//label[text()='Create new billing account']")
	WebElement Create_New_Billing_Account;

	@FindBy(xpath = "//input[@ng-reflect-model='Select contact']/../label[text()='New contact']")
	WebElement New_Contact;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement First_Name;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement Last_Name;

	@FindBy(xpath = "//input[@placeholder='e.g. CPA, Finance Department']")
	WebElement Attention_To;

	@FindBy(xpath = "//input[@placeholder='8123 4567']")
	WebElement mobile;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement email;

	@FindBy(xpath = "//crmx-form-input[@class='w-100 mr-1 ng-untouched ng-pristine ng-valid']/div/div[2]/div/input")
	WebElement Postal_code;

	@FindBy(xpath = "//button[@class='btn btn-primary h-100 input-append-btn']")
	WebElement Postal_code_search;

	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	WebElement Billing_Recipient;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement Billing_Recipient_GPON;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement Billing_Recipient_DCI;

	@FindBy(xpath = "(//input[@type='checkbox'])[4]")
	WebElement Terms_Condition;

	@FindBy(xpath = "(//input[@type='checkbox'])[4]")
	WebElement Terms_Condition_IPVPNN;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> Terms_Conditions;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> Terms_Condition_Multiline;

	@FindBy(xpath = "//button[text()='Confirm ']")

	public WebElement Order_confirmation;

	@FindBy(xpath = "//button[text()='Confirm order']")
	WebElement Order_confirmation_staff;

	private String Loading_Spinner = "//div[@class='loading-spinner ng-tns-c4-0 ng-star-inserted']";

	public String loading_Spinner_CSportal = "//div[@class='loading-wrapper ng-tns-c7-1 ng-star-inserted']";

	@FindBy(xpath = "//canvas[@style='touch-action: none;']")
	WebElement Digi_Signature_CSportal;

	@FindBy(xpath = "//button[text()='Accept ']")
	WebElement Accept_CSportal;

	@FindBy(xpath = "//i[@class='icon-close2']")
	WebElement close_pop_up;

	// label[text()='Create new billing account']

	public OrderconfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		wpm = new WrapperMethods(driver);

	}

	public void Order_Confirmation(String arg1) throws IOException, InterruptedException

	{

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);

		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wpm.scrollToElement(Create_New_Billing_Account);
		if (arg1.equalsIgnoreCase("Existing Billing Account")) {
			// driver.switchTo().frame("wbe-sdw-bot");
			Actions actions = new Actions(driver);
			actions.moveToElement(
					driver.findElement(By.xpath("//label[text()='Select existing billing account']/../input")));
			actions.click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath(
					"//a[@role='button' and @aria-haspopup ='true' and @data-toggle='dropdown' and @aria-expanded='false' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend']")));
			actions.click().build().perform();
			// wpm.ngClick(driver.findElement(By.xpath("(//a[@role='button' and
			// @aria-haspopup ='true'])[3]")));
			Thread.sleep(2000);
			actions.moveToElement(driver
					.findElement(By.xpath("(//div[@class='dropdown-menu crmx-select-dropdown-list show']/a)[1]")));
			actions.click().build().perform();

			wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		} else {

			Actions actions = new Actions(driver);
			actions.moveToElement(
					driver.findElement(By.xpath("//label[text()='Create new billing account']/../input")));
			actions.click().build().perform();
			Thread.sleep(2000);
			// Create_New_Billing_Account.click();
			// wpm.waitTillVisible(New_Contact);
			// wpm.waitTillElementClickable(New_Contact);
			// wpm.ngClick(New_Contact);
			// New_Contact.click();
			// wpm.waitTillElementDisappear_click(close_pop_up);
			wpm.scrollToElement(First_Name);
			First_Name.sendKeys("Kendrick");
			Last_Name.sendKeys("Test");
			wpm.waitTillElementDisappear_click(close_pop_up);
			Attention_To.sendKeys(rm.Attention_to);
			// mobile.sendKeys("81640980");
			email.sendKeys(rm.Email);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(Postal_code);
			Postal_code.sendKeys(rm.postal_code);
			wpm.ngClick(Postal_code_search);
			if (Customer_Dashboard.product_offering.contains("DCI")
					|| Customer_Dashboard.product_offering.contains("IoT")) {
				wpm.ngClick(Billing_Recipient_DCI);
			} else {
				wpm.ngClick(Billing_Recipient);
			}

			actions.moveToElement(driver.findElement(By.xpath(
					"(//a[@role='button' and @aria-haspopup ='true' and @data-toggle='dropdown' and @aria-expanded='false' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend'])[2]")));
			actions.click().build().perform();
			// wpm.ngClick(driver.findElement(By.xpath("(//a[@role='button' and
			// @aria-haspopup ='true'])[3]")));
			Thread.sleep(2000);
			actions.moveToElement(driver
					.findElement(By.xpath("(//div[@class='dropdown-menu crmx-select-dropdown-list show']/a)[1]")));
			actions.click().build().perform();

		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.scrollToElement(Terms_Conditions.get(Terms_Conditions.size() - 1));
		wpm.ngClick(Terms_Conditions.get(Terms_Conditions.size() - 1));

		wpm.scrollToElement(Digi_Signature_CSportal);
		wpm.digital_signature(Digi_Signature_CSportal);
		wpm.ngClick(Order_confirmation);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

	}

	public void GPON_Order_Confirmation(String arg1) throws IOException, InterruptedException

	{

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);

		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wpm.scrollToElement(Create_New_Billing_Account);
		if (arg1.equalsIgnoreCase("Existing Billing Account")) {
			// driver.switchTo().frame("wbe-sdw-bot");
			Actions actions = new Actions(driver);
			actions.moveToElement(
					driver.findElement(By.xpath("//label[text()='Select existing billing account']/../input")));
			actions.click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath(
					"//a[@role='button' and @aria-haspopup ='true' and @data-toggle='dropdown' and @aria-expanded='false' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend']")));
			actions.click().build().perform();
			// wpm.ngClick(driver.findElement(By.xpath("(//a[@role='button' and
			// @aria-haspopup ='true'])[3]")));
			Thread.sleep(2000);
			actions.moveToElement(driver
					.findElement(By.xpath("(//div[@class='dropdown-menu crmx-select-dropdown-list show']/a)[1]")));
			actions.click().build().perform();

			wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		} else {

			Actions actions = new Actions(driver);
			actions.moveToElement(
					driver.findElement(By.xpath("//label[text()='Create new billing account']/../input")));
			actions.click().build().perform();
			Thread.sleep(2000);
			// Create_New_Billing_Account.click();
			// wpm.waitTillVisible(New_Contact);
			// wpm.waitTillElementClickable(New_Contact);
			// wpm.ngClick(New_Contact);
			// New_Contact.click();
			// wpm.waitTillElementDisappear_click(close_pop_up);
			wpm.scrollToElement(First_Name);
			First_Name.sendKeys("Kendrick");
			Last_Name.sendKeys("Test");
			wpm.waitTillElementDisappear_click(close_pop_up);
			Attention_To.sendKeys(rm.Attention_to);
			// mobile.sendKeys("81640980");
			email.sendKeys(rm.Email);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(Postal_code);
			Postal_code.sendKeys(rm.postal_code);
			wpm.ngClick(Postal_code_search);
			if (Customer_Dashboard.product_offering.contains("DCI")
					|| Customer_Dashboard.product_offering.contains("IoT")) {
				wpm.ngClick(Billing_Recipient_DCI);
			} else {
				wpm.ngClick(Billing_Recipient_GPON);
			}

			actions.moveToElement(driver.findElement(By.xpath(
					"(//a[@role='button' and @aria-haspopup ='true' and @data-toggle='dropdown' and @aria-expanded='false' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend'])[2]")));
			actions.click().build().perform();
			// wpm.ngClick(driver.findElement(By.xpath("(//a[@role='button' and
			// @aria-haspopup ='true'])[3]")));
			Thread.sleep(2000);
			actions.moveToElement(driver
					.findElement(By.xpath("(//div[@class='dropdown-menu crmx-select-dropdown-list show']/a)[1]")));
			actions.click().build().perform();

		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		if (Customer_Dashboard.product_offering.contains("PTP")) {
			WebElement wm = driver.findElement(By.xpath(
					"(//div[@class='input-group']/div[@class='input-group custom-control custom-checkbox']/input[@type='checkbox'])[7]"));
			wpm.scrollToElement(wm);
			wpm.ngClick(wm);
		} else {
			wpm.scrollToElement(Terms_Conditions.get(Terms_Conditions.size() - 1));
			wpm.ngClick(Terms_Conditions.get(Terms_Conditions.size() - 1));

		}
		wpm.scrollToElement(Digi_Signature_CSportal);
		wpm.digital_signature(Digi_Signature_CSportal);
		wpm.ngClick(Order_confirmation);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

	}

	public void Order_Confirmation_multiline(String arg1, String arg2) throws IOException, InterruptedException

	{

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);

		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wpm.scrollToElement(Create_New_Billing_Account);
		if (arg1.equalsIgnoreCase("Existing Billing Account")) {
			// driver.switchTo().frame("wbe-sdw-bot");
			Actions actions = new Actions(driver);
			actions.moveToElement(
					driver.findElement(By.xpath("//label[text()='Select existing billing account']/../input")));
			actions.click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath(
					"//a[@role='button' and @aria-haspopup ='true' and @data-toggle='dropdown' and @aria-expanded='false' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend']")));
			actions.click().build().perform();
			// wpm.ngClick(driver.findElement(By.xpath("(//a[@role='button' and
			// @aria-haspopup ='true'])[3]")));
			Thread.sleep(2000);
			actions.moveToElement(driver
					.findElement(By.xpath("(//div[@class='dropdown-menu crmx-select-dropdown-list show']/a)[1]")));
			actions.click().build().perform();

			wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		} else {

			Actions actions = new Actions(driver);
			actions.moveToElement(
					driver.findElement(By.xpath("//label[text()='Create new billing account']/../input")));
			actions.click().build().perform();
			Thread.sleep(2000);
			// Create_New_Billing_Account.click();
			// wpm.waitTillVisible(New_Contact);
			// wpm.waitTillElementClickable(New_Contact);
			// wpm.ngClick(New_Contact);
			// New_Contact.click();
			// wpm.waitTillElementDisappear_click(close_pop_up);
			wpm.scrollToElement(First_Name);
			First_Name.sendKeys("Kendrick");
			Last_Name.sendKeys("Test");
			wpm.waitTillElementDisappear_click(close_pop_up);
			Attention_To.sendKeys(rm.Attention_to);
			// mobile.sendKeys("81640980");
			email.sendKeys(rm.Email);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(Postal_code);
			Postal_code.sendKeys(rm.postal_code);
			wpm.ngClick(Postal_code_search);
			wpm.ngClick(Billing_Recipient);

			actions.moveToElement(driver.findElement(By.xpath(
					"(//a[@role='button' and @aria-haspopup ='true' and @data-toggle='dropdown' and @aria-expanded='false' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend'])[2]")));
			actions.click().build().perform();
			// wpm.ngClick(driver.findElement(By.xpath("(//a[@role='button' and
			// @aria-haspopup ='true'])[3]")));
			Thread.sleep(2000);
			actions.moveToElement(driver
					.findElement(By.xpath("(//div[@class='dropdown-menu crmx-select-dropdown-list show']/a)[1]")));
			actions.click().build().perform();

		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.scrollToElement(Terms_Condition_Multiline.get(Terms_Condition_Multiline.size() - 1));
		wpm.ngClick(Terms_Condition_Multiline.get(Terms_Condition_Multiline.size() - 1));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.scrollToElement(Digi_Signature_CSportal);
		wpm.digital_signature(Digi_Signature_CSportal);
		wpm.ngClick(Order_confirmation);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

	}

	public void Order_Confirmation_Staff(String arg1) throws IOException, InterruptedException

	{

		wpm.waitTillElementDisappear(Loading_Spinner);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);

		wpm.waitTillElementAppeared(Order_confirmation_staff);
		wpm.waitForLoad();
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		// wpm.scrollToElement(Create_New_Billing_Account);
		if (arg1.equalsIgnoreCase("Existing Billing Account")) {
			// driver.switchTo().frame("wbe-sdw-bot");
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(By.xpath("//crmx-form-radio[@ng-reflect-options='Create
			// new billing account,Sel']/div/div/crmx-form-radio-item[2]")));
			// actions.click().build().perform();
			// Thread.sleep(2000);
			wpm.scrollToElement(
					driver.findElement(By.xpath("(//span[text()='Billing Account']/../../../../div[2]/div/a)[1]")));
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			actions.moveToElement(
					driver.findElement(By.xpath("(//span[text()='Billing Account']/../../../../div[2]/div/a)[1]")));
			actions.click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver
					.findElement(By.xpath("(//div[@class='dropdown-menu crmx-select-dropdown-list show']/a)[1]")));
			actions.click().build().perform();
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		} else {
			// Create_New_Billing_Account.click();
			wpm.waitTillVisible(New_Contact);
			wpm.waitTillElementClickable(New_Contact);
			wpm.ngClick(New_Contact);
			// New_Contact.click();
			// wpm.waitTillElementDisappear_click(close_pop_up);
			wpm.scrollToElement(First_Name);
			First_Name.sendKeys("Kendrick");
			Last_Name.sendKeys("Test");
			wpm.waitTillElementDisappear_click(close_pop_up);
			Attention_To.sendKeys(rm.Attention_to);
			mobile.sendKeys("81640980");
			email.sendKeys(rm.Email);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(Postal_code);
			Postal_code.sendKeys(rm.postal_code);
			wpm.ngClick(Postal_code_search);
			wpm.ngClick(Billing_Recipient);
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// wpm.scrollToElement(Terms_Condition);
		// wpm.ngClick(Terms_Condition);
		// wpm.digital_signature(Digi_Signature_CSportal);

	}

	public void Order_Confirmation_Staff_site_2(String arg1) throws IOException, InterruptedException

	{

		wpm.waitTillElementDisappear(Loading_Spinner);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);

		wpm.waitTillElementAppeared(Order_confirmation_staff);
		wpm.waitForLoad();
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		// wpm.scrollToElement(Create_New_Billing_Account);
		if (arg1.equalsIgnoreCase("Existing Billing Account")) {
			// driver.switchTo().frame("wbe-sdw-bot");
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(By.xpath("//crmx-form-radio[@ng-reflect-options='Create
			// new billing account,Sel']/div/div/crmx-form-radio-item[2]")));
			// actions.click().build().perform();
			// Thread.sleep(2000);
			wpm.scrollToElement(
					driver.findElement(By.xpath("(//span[text()='Billing Account']/../../../../div[2]/div/a)[2]")));
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			actions.moveToElement(
					driver.findElement(By.xpath("(//span[text()='Billing Account']/../../../../div[2]/div/a)[2]")));
			actions.click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver
					.findElement(By.xpath("(//div[@class='dropdown-menu crmx-select-dropdown-list show']/a)[1]")));
			actions.click().build().perform();
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		} else {
			// Create_New_Billing_Account.click();
			wpm.waitTillVisible(New_Contact);
			wpm.waitTillElementClickable(New_Contact);
			wpm.ngClick(New_Contact);
			// New_Contact.click();
			// wpm.waitTillElementDisappear_click(close_pop_up);
			wpm.scrollToElement(First_Name);
			First_Name.sendKeys("Kendrick");
			Last_Name.sendKeys("Test");
			wpm.waitTillElementDisappear_click(close_pop_up);
			Attention_To.sendKeys(rm.Attention_to);
			mobile.sendKeys("81640980");
			email.sendKeys(rm.Email);

			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			wpm.scrollToElement(Postal_code);
			Postal_code.sendKeys(rm.postal_code);
			wpm.ngClick(Postal_code_search);
			wpm.ngClick(Billing_Recipient);
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// wpm.scrollToElement(Terms_Condition);
		// wpm.ngClick(Terms_Condition);
		// wpm.digital_signature(Digi_Signature_CSportal);

	}

	public void Site_survey_date() throws IOException, InterruptedException

	{
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wpm.Switch_to_another();
		Survey_Date.click();
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		Site_Survey_Date_appointment.click();
		Site_surevey_contact.sendKeys("Kendrick");
		Mobilenum.sendKeys("81640980");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void Site_survey(String arg1) throws IOException, InterruptedException

	{
		wpm.Switch_to_another();

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		// driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wpm.waitTillVisible(driver.findElement(By.xpath(
				"//td[text()='" + arg1 + "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button")));
		WebElement wm = driver.findElement(By.xpath(
				"//td[text()='" + arg1 + "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);
		wpm.ngClick(Survey_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm1 = driver.findElement(By.xpath(
				"(//td[text()='" + arg1 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm1);
		Thread.sleep(2000);
		// ((JavascriptExecutor) driver).executeScript("arguments[0].value
		// ="Kendrick";", Site_surevey_contact);
		Site_surevey_contact.sendKeys("Kendrick");
		
		Mobilenum.sendKeys("81640980");
		Email_confirm.sendKeys("regspweek46@gmail.com");
		
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void Site1_survey_P2P(String arg1) throws IOException, InterruptedException

	{
		// wpm.Switch_to_another();

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		// driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		WebElement wm = driver.findElement(By.xpath("(//td[text()='" + arg1
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);
		wpm.ngClick(Survey_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm1 = driver.findElement(By.xpath(
				"(//td[text()='" + arg1 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm1);
		Site_surevey_contact_PTP.sendKeys("Kendrick");
		Mobilenum_PTP.sendKeys("81640980");
		Email_confirm.sendKeys("regspweek46@gmail.com");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void wire_survey_site1_auto(String arg2) throws IOException, InterruptedException

	{
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		WebElement wm = driver.findElement(By.xpath("(//td[text()='" + arg2
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);
		wpm.ngClick(Survey_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm1 = driver.findElement(By.xpath(
				"(//td[text()='" + arg2 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm1);
		wiring_contact_multi_GPON.sendKeys("Kendrick");
		Wiring_Mobilenum_multi_GPON.sendKeys("81640980");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void Site1_survey_P2P_multiline(String arg1) throws IOException, InterruptedException

	{
		// wpm.Switch_to_another();

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		// driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		WebElement wm = driver.findElement(By.xpath("(//td[text()='" + arg1
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);
		wpm.ngClick(Survey_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm1 = driver.findElement(By.xpath(
				"(//td[text()='" + arg1 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm1);

		WebElement site_survey_multiline_contact = driver.findElement(
				By.xpath("(//td[text()=' Site Survey ']/../../tr[2]/td[2]/crmx-form-input/div/div[2]/div/input)[1]"));
		site_survey_multiline_contact.sendKeys("Kendrick");

		WebElement site_survey_multiline_mobile = driver.findElement(By.xpath(
				"(//td[text()=' Site Survey ']/../../tr[2]/td[3]/div/crmx-intl-tel-input/div/div/div/input)[1]"));
		site_survey_multiline_mobile.sendKeys("81640980");
		Email_confirm.sendKeys("regspweek46@gmail.com");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void Site2_survey_P2P_multiline(String arg1) throws IOException, InterruptedException

	{
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		// driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		WebElement wm = driver.findElement(By.xpath("(//td[text()='" + arg1
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);
		
		//wpm.ngClick(Survey_Date_multiline);
		
		
		
		
		for (int i = 1; i <= 3; i++) {
		
				if(i==3) {
					wpm.ngClick(Survey_Date_multiline);
					break;
					
				}
				
				
				else {
					WebElement WM = driver.findElement(By.xpath("(//span[@class='ngb-dp-navigation-chevron'])[2]"));
					wpm.ngClick(WM);
				}
				
		
		}


		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		List<WebElement> sum = driver.findElements(By
				.xpath("//td[text()='" + arg1 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));

		WebElement site_survey_multiline_contact = driver.findElement(
				By.xpath("(//td[text()=' Site Survey ']/../../tr[2]/td[2]/crmx-form-input/div/div[2]/div/input)[2]"));
		site_survey_multiline_contact.sendKeys("Kendrick");

		WebElement site_survey_multiline_mobile = driver.findElement(By.xpath(
				"(//td[text()=' Site Survey ']/../../tr[2]/td[3]/div/crmx-intl-tel-input/div/div/div/input)[2]"));
		site_survey_multiline_mobile.sendKeys("81640980");

		
		WebElement site_survey_multiline_email = driver.findElement(By.xpath(
				"(//td[text()=' Site Survey ']/../../tr[2]/td[4]/crmx-form-input/div/div/div/input)[2]"));
		site_survey_multiline_email.sendKeys("regspweek46@gmail.com");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void Site2_survey_P2P(String arg1) throws IOException, InterruptedException

	{
		// wpm.Switch_to_another();

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		// driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		WebElement wm = driver.findElement(By.xpath("(//td[text()='" + arg1
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);
		wpm.ngClick(Survey_Date_DCI_2);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		List<WebElement> sum = driver.findElements(By
				.xpath("//td[text()='" + arg1 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		Site_surevey_contact_site_2.sendKeys("Kendrick");
		Mobilenum_site2.sendKeys("81640980");
		WebElement site_survey_multiline_email = driver.findElement(By.xpath(
				"(//td[text()=' Site Survey ']/../../tr[2]/td[4]/crmx-form-input/div/div/div/input)[2]"));
		site_survey_multiline_email.sendKeys("regspweek46@gmail.com");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void wire_survey(String arg2) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath(
				"//td[text()='" + arg2 + "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button"))
				.click();
		wpm.ngClick(Wiring_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		WebElement wm2 = driver.findElement(By.xpath(
				"(//td[text()='" + arg2 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm2);

		wpm.ngClick(Wiring_contact);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void wire_survey_auto(String arg2) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath(
				"//td[text()='" + arg2 + "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button"))
				.click();
		wpm.ngClick(Survey_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		WebElement wm2 = driver.findElement(By.xpath(
				"(//td[text()='" + arg2 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm2);
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm1 = driver.findElement(By.xpath(
				"(//td[text()='" + arg2 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm1);
		Thread.sleep(2000);
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
//((JavascriptExecutor) driver).executeScript("arguments[0].value ="Kendrick";", Site_surevey_contact);
		Wire_contact_GPON.sendKeys("Kendrick");

		Mobilenum_GPON.sendKeys("81640980");

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void wire_survey_site1(String arg2) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg2
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]")).click();
		for (int i = 1; i <= 3; i++) {
			try {
				wpm.ngClick(Survey_Date);
				break;
			} catch (Exception e) {

				WebElement WM = driver.findElement(By.xpath("(//span[@class='ngb-dp-navigation-chevron'])[2]"));
				wpm.ngClick(WM);
			}
		}

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		WebElement wm2 = driver.findElement(By.xpath(
				"(//td[text()='" + arg2 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm2);

		wpm.ngClick(Wiring_contact);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void wire_survey_site2(String arg2) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg2
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")).click();
		wpm.ngClick(Wiring_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		List<WebElement> sum = driver.findElements(By
				.xpath("//td[text()='" + arg2 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		wpm.ngClick(Wiring_contact_site_2);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void wire_survey_site2_GPON(String arg2) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg2
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")).click();
		wpm.ngClick(Wiring_Date_GPON);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		List<WebElement> sum = driver.findElements(By
				.xpath("//td[text()='" + arg2 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		// wpm.ngClick(Wiring_contact_site_2_GPON);s

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		// wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);
		// wpm.waitTillElementAppeared(Order_confirmation);
		// wpm.waitForLoad();
		// driver.switchTo().frame("wbe-sdw-bot");
		// Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wiring_contact_multiline2_GPON_site_2.sendKeys("Kendrick");
		Wiring_Mobilenum_multi_GPON_2.sendKeys("81640980");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void wire_survey_site2_multiline(String arg2) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg2
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")).click();
		wpm.ngClick(Wiring_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		List<WebElement> sum = driver.findElements(By
				.xpath("//td[text()='" + arg2 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		if (Customer_Dashboard.product_offering.contains("PTMP")
				|| (Customer_Dashboard.product_offering.contains("ATA"))) {
			wpm.ngClick(Wiring_contact_site_2_multiline_PTMP);
		} else {
			wpm.ngClick(Wiring_contact_site_2_multiline);
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath(
				"//td[text()='" + arg3 + "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button"))
				.click();

		wpm.ngClick(Installation_Date);
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm3 = driver.findElement(By.xpath(
				"(//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm3);
		wpm.ngClick(installation_contact);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void RFS_Cloud_connect() throws IOException

	{

		driver.findElement(By.xpath(
				"//td[text()='Request for Service Date']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button"))
				.click();

		for (int i = 1; i <= 3; i++) {
			try {
				wpm.ngClick(Survey_Date_multiline);
				break;
			} catch (Exception e) {

				WebElement WM = driver.findElement(By.xpath("(//span[@class='ngb-dp-navigation-chevron'])[2]"));
				wpm.ngClick(WM);
			}
		}

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_auto(String arg3) throws IOException, InterruptedException

	{
		driver.findElement(By.xpath(
				"//td[text()='" + arg3 + "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button"))
				.click();
		wpm.ngClick(Wiring_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		WebElement wm2 = driver.findElement(By.xpath(
				"(//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm2);

		wpm.ngClick(Wiring_contact);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_DCI(String arg3) throws IOException, InterruptedException

	{

		wpm.Switch_to_another();

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
//Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
//close_pop_up.click();
//Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
//driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wpm.waitTillVisible(driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]")));
		WebElement wm = driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);
		wpm.ngClick(Survey_Date);

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm1 = driver.findElement(By.xpath(
				"(//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm1);
		Thread.sleep(2000);

		WebElement site_survey_multiline_contact = driver.findElement(
				By.xpath("//td[text()='" + arg3 + "']/../../tr[6]/td[2]/crmx-form-input/div/div[2]/div/input"));
		site_survey_multiline_contact.sendKeys("Kendrick");

		WebElement site_survey_multiline_mobile = driver.findElement(
				By.xpath("//td[text()='" + arg3 + "']/../../tr[6]/td[3]/div/crmx-intl-tel-input/div/div/div/input"));
		site_survey_multiline_mobile.sendKeys("81640980");

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_RFS(String arg3) throws IOException, InterruptedException

	{

		wpm.Switch_to_another();

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
//Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
//close_pop_up.click();
//Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
//driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wpm.waitTillVisible(driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]")));
		WebElement wm = driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);
		wpm.ngClick(Survey_Date);

//wpm.waitTillElementDisappear(loading_Spinner_CSportal);
//WebElement wm1 = driver.findElement(By.xpath("(//td[text()='"+arg3+"']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
//wpm.ngClick(wm1);
		Thread.sleep(2000);

		wpm.waitTillVisible(driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")));
		WebElement wm2 = driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]"));
		wpm.waitTillElementClickable(wm2);
		wpm.ngClick(wm2);
		Thread.sleep(3000);
		wpm.ngClick(Survey_Date_DCI_2);

//wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_DCI_2(String arg3) throws IOException, InterruptedException

	{

		wpm.Switch_to_another();

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
//Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
//close_pop_up.click();
//Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
//driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		wpm.waitTillVisible(driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")));
		WebElement wm = driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);

		for (int i = 1; i <= 3; i++) {
			try {
				wpm.ngClick(Survey_Date_DCI_2);
				break;
			} catch (Exception e) {

				WebElement WM = driver.findElement(By.xpath("(//span[@class='ngb-dp-navigation-chevron'])[2]"));
				wpm.ngClick(WM);
			}
		}

		wpm.waitTillElementDisappear(loading_Spinner_CSportal);

		List<WebElement> wm1 = driver.findElements(By
				.xpath("//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(wm1.get(wm1.size() - 1));
		Thread.sleep(2000);

		WebElement site_survey_multiline_contact = driver.findElement(
				By.xpath("//td[text()=' Installation ']/../../tr[7]/td[2]/crmx-form-input/div/div[2]/div/input"));
		site_survey_multiline_contact.sendKeys("Kendrick");

		WebElement site_survey_multiline_mobile = driver.findElement(
				By.xpath("//td[text()='" + arg3 + "']/../../tr[7]/td[3]/div/crmx-intl-tel-input/div/div/div/input"));
		site_survey_multiline_mobile.sendKeys("81640980");

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_site1_GPON(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]")).click();

		wpm.ngClick(Installation_Date);
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm3 = driver.findElement(By.xpath(
				"(//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm3);

		wpm.ngClick(installation_contact_GPON);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_site1(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]")).click();

		wpm.ngClick(Installation_Date);
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		WebElement wm3 = driver.findElement(By.xpath(
				"(//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm3);

		wpm.ngClick(installation_contact);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_site2_GPON(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")).click();
		wpm.ngClick(Installation_Date);
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		List<WebElement> sum = driver.findElements(By
				.xpath("//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		wpm.ngClick(installation_contact_site_2_GPON);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_site2(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")).click();
		wpm.ngClick(Installation_Date);
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		List<WebElement> sum = driver.findElements(By
				.xpath("//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		wpm.ngClick(installation_contact_site_2);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_site2_multiline(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//td[text()='" + arg3
				+ "']/../td[2]/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")).click();

		wpm.ngClick(Installation_Dates.get(Installation_Dates.size()-1));
		wpm.waitTillElementDisappear(loading_Spinner_CSportal);
		List<WebElement> sum = driver.findElements(By
				.xpath("//td[text()='" + arg3 + "']/../td[3]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));

		if (Customer_Dashboard.product_offering.contains("PTMP")
				|| Customer_Dashboard.product_offering.contains("ATA")) {
			wpm.ngClick(installation_contact_site_2_multiline_PTMP);
		} else {
			wpm.ngClick(installation_contact_site_2_multiline);
		}
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	}

	public void Site_survey_staff(String arg1) throws IOException, InterruptedException

	{
		// wpm.Switch_to_another();

		wpm.waitTillElementDisappear(Loading_Spinner);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		// driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
		WebElement wm = driver.findElement(By.xpath("(//h5[text()='" + arg1
				+ "']/../../div[2]/div/div/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[1]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);

		for (int i = 1; i <= 3; i++) {
			try {
				wpm.ngClick(Survey_Date);
				break;
			} catch (Exception e) {

				WebElement WM = driver.findElement(By.xpath("(//span[@class='ngb-dp-navigation-chevron'])[2]"));
				wpm.ngClick(WM);
			}
		}

		wpm.waitTillElementDisappear(Loading_Spinner);
		WebElement wm1 = driver.findElement(By.xpath("(//h5[text()='" + arg1
				+ "']/../../div[2]/div/div[2]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm1);
		Site_surevey_contact_staff.sendKeys("Kendrick");
		Mobilenum_staff.sendKeys("81640980");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void Site_survey_staff_site_2(String arg1) throws IOException, InterruptedException

	{

		// wpm.Switch_to_another();

		wpm.waitTillElementDisappear(Loading_Spinner);
		// Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		// close_pop_up.click();
		// Thread.sleep(10000);
		wpm.waitTillElementAppeared(Order_confirmation);
		wpm.waitForLoad();
		// driver.switchTo().frame("wbe-sdw-bot");
		Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);

		WebElement wm = driver.findElement(By.xpath("(//h5[text()='" + arg1
				+ "']/../../div[2]/div/div/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]"));
		wpm.waitTillElementClickable(wm);
		wpm.ngClick(wm);
		Thread.sleep(3000);

		for (int i = 1; i <= 3; i++) {
			try {
				wpm.ngClick(Survey_Date);
				break;
			} catch (Exception e) {

				WebElement WM = driver.findElement(By.xpath("(//span[@class='ngb-dp-navigation-chevron'])[2]"));
				wpm.ngClick(WM);
			}
		}

		wpm.waitTillElementDisappear(Loading_Spinner);
		List<WebElement> sum = driver.findElements(By.xpath("//h5[text()='" + arg1
				+ "']/../../div[2]/div/div[2]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		// WebElement wm1 =
		// driver.findElement(By.xpath("(//h5[text()='"+arg1+"']/../../div[2]/div/div[2]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		// wpm.ngClick(wm1);
		Site_surevey_contact_staff_site_2.sendKeys("Kendrick");
		Mobilenum_staff_site_2.sendKeys("81640980");
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void wire_survey_staff(String arg2) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("//h5[text()='" + arg2
				+ "']/../../div[2]/div/div/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button")).click();
		wpm.ngClick(Survey_Date);

		wpm.waitTillElementDisappear(Loading_Spinner);

		WebElement wm2 = driver.findElement(By.xpath("(//h5[text()='" + arg2
				+ "']/../../div[2]/div/div[2]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm2);
		wpm.ngClick(Wiring_contact);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void wire_survey_staff_site_2(String arg2) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//h5[text()='" + arg2
				+ "']/../../div[2]/div/div/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")).click();
		wpm.ngClick(Survey_Date);
		wpm.waitTillElementDisappear(Loading_Spinner);
		List<WebElement> sum = driver.findElements(By.xpath("//h5[text()='" + arg2
				+ "']/../../div[2]/div/div[2]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		wpm.ngClick(staff_Wiring_contact_site_2);
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

	public void installation_staff(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("//h5[text()='" + arg3
				+ "']/../../div[2]/div/div/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button")).click();

		wpm.ngClick(Survey_Date);
		wpm.waitTillElementDisappear(Loading_Spinner);
		WebElement wm3 = driver.findElement(By.xpath("(//h5[text()='" + arg3
				+ "']/../../div[2]/div/div[2]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm3);
		wpm.ngClick(installation_contact);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.ngClick(Order_confirmation_staff);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.waitTillElementDisappear(Loading_Spinner);
	}

	public void installation_staff_site_1(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("//h5[text()='" + arg3
				+ "']/../../div[2]/div/div/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button")).click();

		wpm.ngClick(Survey_Date);
		wpm.waitTillElementDisappear(Loading_Spinner);
		WebElement wm3 = driver.findElement(By.xpath("(//h5[text()='" + arg3
				+ "']/../../div[2]/div/div[2]/crmx-form-radio/div/div/crmx-form-radio-item/div/input)[1]"));
		wpm.ngClick(wm3);
		wpm.ngClick(installation_contact);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

//wpm.ngClick(Order_confirmation_staff);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.waitTillElementDisappear(Loading_Spinner);
	}

	public void installation_staff_site_2(String arg3) throws IOException, InterruptedException

	{

		driver.findElement(By.xpath("(//h5[text()='" + arg3
				+ "']/../../div[2]/div/div/crmx-form-datepicker/div/div/crmx-datepicker/div/div/button)[2]")).click();

		wpm.ngClick(Survey_Date);
		wpm.waitTillElementDisappear(Loading_Spinner);
		List<WebElement> sum = driver.findElements(By.xpath("//h5[text()='" + arg3
				+ "']/../../div[2]/div/div[2]/crmx-form-radio/div/div/crmx-form-radio-item/div/input"));
		wpm.ngClick(sum.get(sum.size() - 1));
		wpm.ngClick(staff_installation_contact_site_2);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.ngClick(Order_confirmation_staff);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

		wpm.waitTillElementDisappear(Loading_Spinner);
	}

	public void verify_RFS() throws IOException {
		String RFS = driver.findElement(By.xpath("(//input[@placeholder='DD-MMM-YYYY'])[4]"))
				.getAttribute("ng-reflect-model");
		WebElement wm = driver.findElement(By.xpath(
				"//h4[text()='Installation Date']/../../div[2]/div/div/crmx-form-datepicker/div/div/crmx-datepicker/div/input[1]"));
		wpm.scrollToElement(wm);
		String installation_date = wm.getAttribute("ng-reflect-model");
		wpm.scrollToElement(installation_contact);
		Assert.assertTrue(RFS.equals(installation_date));
		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	}

}
