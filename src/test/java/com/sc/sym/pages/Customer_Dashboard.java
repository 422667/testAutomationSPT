package com.sc.sym.pages;

import static com.sc.sym.utility.WrapperElements.properties;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import com.cucumber.listener.Reporter;

import com.sc.sym.glue.Hooks;
import com.sc.sym.utility.FetchTestData;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;


public class Customer_Dashboard extends Hooks{
	WrapperMethods wpm;
	WebDriver driver;
	public static String product_offering=null;

	 	@FindBy(id = "userNameInput")
	    WebElement Username;
	 	
		@FindBy(xpath = "(//a[text()=' Explore By product '])[1]")
	    WebElement Explore_By_product;
		
		@FindBy(xpath = "(//i[@class='ng-tns-c3-0 icon-cart5'])[1]")
	    WebElement cart_icon;
		
		@FindBy(xpath = "//button[text()='Proceed to Quote']")
	    WebElement Proceed_to_Quote;
		
		@FindBy(xpath = "//span[text()='Dashboard']")
	   public WebElement CS_Dash_board;
		
		public String loading_Spinner_CSportal = "//div[@class='loading-wrapper ng-tns-c7-1 ng-star-inserted']";
		
		public Customer_Dashboard(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
			wpm = new WrapperMethods(driver);
		}
		 public void Explore_By_product() throws IOException, InterruptedException 
		 {
			wpm.waitTillElementDisappear(loading_Spinner_CSportal);
	
			try {
				driver.findElement(By.xpath("(//i[contains(@class,'icon-cart5')])[1]")).click();
				java.util.List<WebElement>  Removals = driver.findElements(By.xpath("//button[text()='Remove']"));
				System.out.println(Removals.size());
				for(int i=0;i<Removals.size();i++) {
					//driver.findElement(By.xpath("//span[@class='menu-text-wrapper']/i[@ng-reflect-ng-class='icon-cart5']")).click();
					wpm.ngClick(Removals.get(i));
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Actions action = new Actions(driver);
			 WebElement element = driver.findElement(By.xpath("//span[text()='Explore']"));
			 action.moveToElement(element).perform();	
			 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			 wpm.ngClick(Explore_By_product);
			 //Explore_By_product.click();
			 wpm.waitTillElementDisappear(loading_Spinner_CSportal);
			 
			 try {
				WebElement Close_walk_thru = driver.findElement(By.xpath("//div[@title='Stop Walk-thru']"));
				 wpm.ngClick(Close_walk_thru);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 }
		
		 public void Add_to_cart(String arg1,String arg2) throws IOException, InterruptedException
		 {
			 			 
			WebElement wm1 = driver.findElement(By.xpath("//p[text()='"+arg2+"']/../div/img"));
			Thread.sleep(3000);
				wpm.ngClick(wm1);
			 wpm.waitTillElementDisappear(loading_Spinner_CSportal);
			 WebElement wm = driver.findElement(By.xpath("//span[text()='"+arg1+"']"));
			 wpm.scrollToElement(wm);
			 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			 Thread.sleep(3000);
			 
			WebElement wm2 =  driver.findElement(By.xpath("//span[text()='"+arg1+"']/../../../../../../../div[3]/div/div/crmx-button[2]/button"));
			wpm.ngClick(wm2); 
			product_offering = arg1;
			
		 }
		
		 
		 public void click_proceed_Quote() throws IOException, InterruptedException
		 {
			 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
			 wpm.ngClick(cart_icon);
			 wpm.ngClick(Proceed_to_Quote);
			 wpm.waitTillElementDisappear(loading_Spinner_CSportal);
			
		 }
		
	 
	 
}
