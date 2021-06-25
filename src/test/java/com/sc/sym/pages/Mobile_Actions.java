package com.sc.sym.pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;


   
public class Mobile_Actions {
	 WebDriver driver;
	    WrapperMethods wpm;

	    @FindBy(xpath = "//span[text()='Customer']")
	    private WebElement Customer;

	    @FindBy(xpath = "//a[@href='/staff/customer/add']/span")
	    private WebElement create;

	    @FindBy(id = "btnLogin")
	    private WebElement loginBtn;

	    @FindBy(xpath="//input[@placeholder='UEN']")
	    private WebElement UEN;

	    @FindBy(xpath="//input[@placeholder='YYYY']")
	    private WebElement Established_Year;

	    @FindBy(xpath="//input[@class='form-control no-append no-prepend ng-untouched ng-pristine ng-valid ng-star-inserted'][1]")
	    private WebElement Postal_code;
	    
	    @FindBy(xpath="//input[@class='form-control no-append no-prepend ng-untouched ng-pristine ng-valid ng-star-inserted'][2]")
	    private WebElement Address_unit;
	      
	    @FindBy(xpath="//span[contains(text(),'Select Market Segment')]")
	    private WebElement Market_Segment;
	    
	    @FindBy(xpath="//ul[@class='lazyContainer']/li[1]")
	    private WebElement All_Segment;
	    
	    @FindBy(xpath="//span[text()='Add Contact']")
	    private WebElement Add_contact;
	    
	    @FindBy(xpath="//input[@placeholder='First Name']")
	    private WebElement First_name;
	    
	    @FindBy(xpath="//input[@placeholder='Last Name']")
	    private WebElement Last_name;
	    
	    @FindBy(xpath="//input[@placeholder='Attention To']")
	    private WebElement Attention_To;
	    
	    @FindBy(xpath="//span[text()='Select Contact Roles']")
	    private WebElement Select_contact_roles;
	    		
	    @FindBy(xpath="(//span[text()='Select All'])[2]")
	    private WebElement Select_All_contact_roles;
	    
	    @FindBy(xpath="//input[@placeholder='Email Address']")
	    private WebElement Email_Address;
	    
	    @FindBy(xpath="//input[@placeholder='Phone No']")
	    private WebElement Phone_No;
	    
	    @FindBy(xpath="//button[text()=' Save ']")
	    private WebElement Save;
	    
	    @FindBy(xpath="//crmx-button[@ng-reflect-template='Save']/button[@class='btn btn-primary' and @type='button']")
	    private WebElement Main_Form_Save;
	    
	    
	    public Mobile_Actions(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
	        wpm = new WrapperMethods(driver);
	    }
	    
	    
	    
	    
	    
	    
	/*
	 * public void customer_Creation() throws IOException, InterruptedException
	 * 
	 * { Staff_Customer_Data rm = Staff_Customer_Portal.getData(LoginPage.UserName);
	 * wpm.waitTillVisible(Customer); Customer.click();
	 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot()); create.click();
	 * wpm.waitTillVisible(UEN); UEN.sendKeys(rm.UEN,Keys.TAB);
	 * driver.findElement(By.xpath(
	 * "/html/body/app-root/div/crmx-horizontal-layout/div[2]/div[2]/section/app-customer/cust-add-page/crmx-card/div/div[2]/div/div/crmx-card[1]/div/div[2]/div/div/organization-add/formly-form/formly-field[2]/formly-group/formly-field[1]/app-formly-lookup/app-lookup/div/div/select"
	 * )).click();
	 * driver.findElement(By.xpath("//option[text()='Public Limited Company']")).
	 * click(); //Select drpdwn = new Select(driver.findElement(By.
	 * xpath("//select[@class='form-control ng-pristine ng-valid ng-star-inserted ng-touched']"
	 * ))); //drpdwn.selectByVisibleText(rm.Organization_type.replaceAll("_"," "));
	 * Established_Year.sendKeys(rm.Established_year,Keys.TAB);
	 * //Postal_code.sendKeys(rm.postal_code,Keys.TAB);
	 * wpm.waitTillVisible(Market_Segment); Market_Segment.click();
	 * //All_Segment.click();
	 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot()); Add_contact.click();
	 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	 * First_name.sendKeys(rm.First_Name,Keys.TAB);
	 * Last_name.sendKeys(rm.Last_Name,Keys.TAB);
	 * Attention_To.sendKeys(rm.Attention_to,Keys.TAB);
	 * driver.findElement(By.xpath("//span[text()='Select Contact Roles']")).click()
	 * ; driver.findElement(By.xpath("//label[text()='"+rm.contact_Role.replaceAll(
	 * "_"," ")+"']")).click(); First_name.click();
	 * Email_Address.sendKeys(rm.Email,Keys.TAB);
	 * Phone_No.sendKeys(rm.Contact_Number,Keys.TAB);
	 * Reporter.addScreenCaptureFromPath(wpm.getScreenshot()); Save.click();
	 * wpm.scrolldown(); Thread.sleep(3000); Main_Form_Save.click(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	    
	    
	    
	    
	    
	    
	    
	    
}
