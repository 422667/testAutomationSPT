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

import junit.framework.Assert;


   
public class ProductPage {
	    WebDriver driver;
	    WrapperMethods wpm;

	    @FindBy(xpath = "//span[text()='Product']")
	    private WebElement Product;

	    @FindBy(xpath = "//span[text()='Product Catalogue']")
	    private WebElement Product_Catalogue;

	  
	    @FindBy(xpath = "//h5[text()='SG Connectivity']/../../div[2]/i")
	    private WebElement Product_Family;
	    
	  
	    
	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
	        wpm = new WrapperMethods(driver);
	    }
	    
	    
	    public void click_product_catalogue() throws IOException
	    
	    {
	    	Product.click();
	 	    wpm.waitTillVisible(Product_Catalogue);
	 	    try {
				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	    Product_Catalogue.click();
	 	    try {
				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @SuppressWarnings("deprecation")
		public void Product_family_validaion(String product_family) throws IOException, InterruptedException
	   
	    { 
	   
	    Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='"+product_family+"']/../../div[2]/i")).isDisplayed());
	    wpm.isElementDisplayed(Product_Family);
	    Product_Family.click();
	    Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	    }
	    
	    

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
