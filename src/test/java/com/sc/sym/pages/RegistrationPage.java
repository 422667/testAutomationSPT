package com.sc.sym.pages;

import static com.sc.sym.utility.WrapperElements.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;

public class RegistrationPage {
	WrapperMethods wpm;
	WebDriver driver;
	
	
	
		@FindBy(id = "")
		WebElement Registration_link;
	
	 	@FindBy(id = "")
	    WebElement Username;
	 	
	 	@FindBy(id = "")
	    WebElement Password;
	 	
	 	@FindBy(id = "")
	    WebElement email;
	 	
	 	@FindBy(id = "")
	    WebElement mobile;
	 	
	 	@FindBy(id = "")
	    WebElement UEN;
	 	
	 	@FindBy(id = "")
	    WebElement Company_Name;

	 	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		wpm = new WrapperMethods(driver);
	}
	
	 public void Registration(String username) throws Exception {
		 Staff_Customer_Data rm = Staff_Customer_Portal.getData(username);
	        Username.sendKeys(username);
	        Password.sendKeys(rm.Password);
	        email.sendKeys(rm.Email);
	        mobile.sendKeys(rm.Contact_Number);
            UEN.sendKeys(rm.UEN);
           // Company_Name.sendKeys(rm.Company_Name);
	        
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
