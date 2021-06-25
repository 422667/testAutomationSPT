package com.sc.sym.pages;

import static com.sc.sym.utility.WrapperElements.properties;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
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


public class WorkforceManagemetPage extends Hooks{
	WrapperMethods wpm;
	WebDriver driver;
													
		@FindBy(xpath = "//div[text()='Order created']")
		public WebElement Confirm_order_page;
		
		
		
		@FindBy(xpath = "//button[text()=' Close ']")
		public WebElement Order_close_popup;
		
		@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[1]")
	    WebElement Survey_Date;
		
		@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[2]")
	    WebElement Wiring_Date;
		
		@FindBy(xpath = "(//div[@class='ngb-dp-day ng-star-inserted'])[1]")
	    WebElement Installation_Date;
		
		@FindBy(xpath = "(//div[@class='custom-control custom-radio'])[1]")
	    WebElement Site_Survey_Date_appointment;
		
		@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[2]/td[2]/crmx-form-input/div/div/div/input")
	    WebElement Site_surevey_contact;
		@FindBy(xpath = "//h4[text()='Site Survey Date']/../../div[2]/div[2]/div/crmx-form-input/div/div[2]/div/input")
	    WebElement Site_surevey_contact_staff;
		
		
		
		
		@FindBy(xpath = "//h4[text()='Site Survey Date']/../../div[2]/div[2]/div[2]/crmx-intl-tel-input/div/div/div/input")
	    WebElement Mobilenum_staff;
		
		@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[6]/td[2]/crmx-form-input/div/div/div/input")
	    WebElement Site_surevey_contact_PTP;
		
		@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[7]/td[2]/crmx-form-input/div/div/div/input")
	    WebElement Site_surevey_contact_site_2;
		
		@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[2]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	    WebElement Mobilenum;
		
		@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[6]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	    WebElement Mobilenum_PTP;
		
		@FindBy(xpath = "//td[text()=' Site Survey ']/../../tr[7]/td[3]/div/crmx-intl-tel-input/div/div/div/input")
	    WebElement Mobilenum_site2;
	
		@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[2]")
	    WebElement Wiring_contact;
		
		@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[3]")
	    WebElement installation_contact;
		
		@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[4]")
	    WebElement Wiring_contact_site_2;
		
		@FindBy(xpath = "(//div[contains(@class,'custom-checkbox')]/input)[5]")
	    WebElement installation_contact_site_2;
	

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
	    
	    @FindBy(xpath = "//input[@class='form-control no-append no-prepend ng-untouched ng-pristine ng-valid ng-star-inserted' and @type='text']")
	    WebElement Postal_code;
	    
	    @FindBy(xpath = "//button[@class='btn btn-primary h-100 input-append-btn']")
	    WebElement Postal_code_search;
	    
	    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
	    WebElement Billing_Recipient;
	    
	    @FindBy(xpath = "(//input[@type='checkbox'])[5]")
	    WebElement Terms_Condition;
	 	
	    @FindBy(xpath = "//button[text()='Confirm ']")
		
	    public  WebElement Order_confirmation;
	    

	  
	    @FindBy(xpath = "//button[text()='Confirm order']")
	    WebElement Order_confirmation_staff;

	 	private String Loading_Spinner = "//div[@class='loading-spinner ng-tns-c4-0 ng-star-inserted']";
	 	
	 	public String loading_Spinner_CSportal = "//div[@class='loading-wrapper ng-tns-c7-1 ng-star-inserted']";
	 	
	 	@FindBy(xpath = "//i[@class='icon-fire']/../span")
		WebElement DWFM;
		

		@FindBy(xpath = "//a[@href='/staff/dwfm/appointment']/span")
		WebElement Appointment_submenu;
		
		@FindBy(xpath = "//a[@href='/staff/dwfm/workOrder']/span")
		WebElement workorder_submenu;
		
		@FindBy(xpath = "//a[@href='/staff/dwfm/manualAssign']/span")
		WebElement workorder_Assignment;
		
		
		@FindBy(xpath = "//crmx-icon-link[@class='add-button']/button/span[2]/span")
		WebElement workorder_create;
		
		@FindBy(xpath = "//span[text()='Service Order No. / Case ID']/../../../../div[2]/div/input")
		WebElement Service_Order_Search;
		
		@FindBy(xpath = "//span[text()='Contact Name']/../../../../div[2]/div/input")
		WebElement Contact_Name;
		
		@FindBy(xpath = "//span[text()='Contact Number']/../../../../div[2]/div/input")
		WebElement Contact_Number;
		
		@FindBy(xpath = "//span[text()='Postal Code']/../../../../div[2]/div/input")
		WebElement Postal_Code;
		
		@FindBy(xpath = "(//i[@class='icon-calendar2'])[3]")
		WebElement appointment_calender;
		
		@FindBy(xpath = "//span[text()='Service Order No. / Case ID']/../../../../../../crmx-button/button")
		WebElement Service_Order_Search_icon;
		
		@FindBy(xpath = "//button[@class='btn btn-success timeslot']")
		WebElement time_slot;
		
		@FindBy(xpath = "(//i[@class='icon-checkmark3 ng-star-inserted'])[5]")
		WebElement time_slot_submit;
		
		@FindBy(xpath = "//button[text()=' Close ']")
		WebElement Close;
		
		@FindBy(xpath = "(//button[text()='Submit']/i[@class='icon-checkmark3 ng-star-inserted'])[1]/..")
		WebElement work_order_submit;
		
		//button[text()='Submit']/i[@ng-reflect-ng-class='icon-checkmark3']
		
		
		//label[text()='Create new billing account']
	
		public WorkforceManagemetPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
			wpm = new WrapperMethods(driver);
	
		}
		
		
	
		public void create_work_order() throws IOException, InterruptedException
		{
			DWFM.click();
			workorder_submenu.click();
			wpm.waitTillElementDisappear(Loading_Spinner);
			wpm.ngClick(workorder_create);
			wpm.waitTillElementDisappear(Loading_Spinner);
			
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			Service_Order_Search.sendKeys(QuotationPage.Service_ID);
			Service_Order_Search_icon.click();
			wpm.waitTillElementDisappear(Loading_Spinner);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		//	Contact_Name.sendKeys("notworking");
			//Contact_Number.sendKeys("94672529");
			//Postal_Code.sendKeys("460428");
			//wpm.ngClick(appointment_calender);
			//appointment_calender.click();
			//wpm.waitTillElementDisappear(Loading_Spinner);
			//wpm.ngClick(time_slot);
			//wpm.waitTillElementDisappear(Loading_Spinner);
			//time_slot.click();
			//time_slot_submit.click();
			WebElement wm = driver.findElement(By.xpath("(//a[@aria-haspopup='true' and @class='form-control text-decoration-none crmx-select-dropdown-toggler no-append no-prepend required' and @data-toggle='dropdown'])[2]"));
			wpm.ngClick(wm);
			
			Thread.sleep(2000);
			WebElement wm1 = driver.findElement(By.xpath("(//a[contains(text(),'Site Survey')])[1]"));
			wpm.ngClick(wm1);
			
			
			
			wpm.scrolldown();
			wpm.scrollToElement(work_order_submit);
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			
			wpm.ngClick(work_order_submit);
			
			Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			Close.click();
			
		
			
		}
		
		public void work_order_assignment() throws InterruptedException
		{
			DWFM.click();
			workorder_Assignment.click();
			wpm.waitTillElementDisappear(Loading_Spinner);
			
			
			Actions builder = new Actions(driver);
			 
	WebElement wm = driver.findElement(By.xpath("(//i[@class='icon-calendar2']/..)[2]"));
	wpm.ngClick(wm);
	
		
		  Select drpdwn = new
		  Select(driver.findElement(By.xpath("//select[@title='Select month']")));
		  drpdwn.selectByVisibleText("Aug");
		  
		  
		  WebElement wm1 = driver.findElement(By.
		  xpath("(//div[@class='custom-day btn-light ng-star-inserted' and contains(text(),'13')])[1]"
		  )); wpm.ngClick(wm1);
		  
		  wpm.waitTillElementDisappear(Loading_Spinner);
		 
	
	List<WebElement> elements =	driver.findElements(By.xpath("//div[@ng-reflect-klass='work-item-bar']/div/div/div"));
	
	WebElement wm3=null;
	for (WebElement iterable_element : elements) {
		
		if(iterable_element.getText().contains("3105"))
		{
			wm3=iterable_element;
			break;
		}
		
	}

			 
	List<WebElement> wms = driver.findElements(By.xpath("//div[@class='vis-item vis-background avail-resources']"));
			 
	
	
	  
	  Point location = wms.get(wms.size()-1).getLocation();
	  int x = location.getX();
	  int y = location.getY();
			 //Perform drag and drop
			 builder.dragAndDropBy(wm3,x,y).perform();
			
			
		try {
		
			wpm.waitTillElementDisappear(Loading_Spinner);
				WebElement wm4  =driver.findElement(By.xpath("//button[text()='Override']"));
				wm4.click();
				
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		}
		
		
}
