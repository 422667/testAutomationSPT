package com.sc.sym.glue;

import static com.sc.sym.utility.WrapperElements.properties;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;
import com.sc.sym.pages.QuotationPage;
import com.sc.sym.utility.CsvDataReader;

import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WebDriverFactory;
import com.sc.sym.utility.WrapperMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.zeroturnaround.zip.ZipUtil;

public class Hooks{
	
	
	public static Scenario scenario;
	public static WebDriver driver;
	WrapperMethods wpm;
	String url = null;
	
	@Before
	public void launchDriver(Scenario scenario) throws Throwable {
		Hooks.scenario = scenario;
		//HTMLReporter.startReport();
		driver = WebDriverFactory.createDriver();
		
		//Arrays.stream(new File(System.getProperty("user.dir")+"/target/cucumber-reports/images/").listFiles()).forEach(File::delete);
		wpm = new WrapperMethods(driver);
		
	}

	@Before
	public void loadTestData() {
		Staff_Customer_Portal.loadCredentials(CsvDataReader.readFile());
		Staff_Customer_Portal.loaddetails(CsvDataReader.read1File());
	}

public void test_report_update(String arg1) throws IOException
{
	
	



	  WebElement wm1 = driver.findElement(By.xpath("//input[@value='Search']"));
			
	  if(System.getProperty("ENV").equalsIgnoreCase("local"))
	
			url = "http://10.251.140.9:8989/testscenario/all";
		
		
	 driver.get("http://localhost:8989/testscenario/all");
		 WebElement wm2 = driver.findElement(By.id("keyword"));
		wm1.sendKeys(LoginPage_Definition.TC_ID);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		wpm.ngClick(wm2);

		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		WebElement wm3 = driver.findElement(By.xpath("//a[text()=' EDIT ']"));
		wpm.ngClick(wm3);
		
		 WebElement wm4 = driver.findElement(By.id("RegressionDetails"));
		 wm4.sendKeys(QuotationPage_Definition.Order_no, Keys.ENTER);
		 wm4.sendKeys(arg1);
		 }
	
	
	@After
	public void killDriver() throws IOException {
		
		
	
			url = "http://10.251.140.9:8989/testscenario/orderitems/feedback";
		
		if(QuotationPage.Order_Status.contains("Completed"))
		{
	
		
		for (int i = 0; i <= QuotationPage_Definition.servs.length; i++) {

			if (i != 0) {
			
		      //  driver.get("http://localhost:8989/testscenario/orderitems/feedback");
		        WebElement wm = driver.findElement(By.id("keyword"));
		   				wm.sendKeys(QuotationPage_Definition.servs[i]);

		   				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		   		     WebElement wm1 = driver.findElement(By.xpath("//input[@value='Search']"));
		   			
		   				
		   				wpm.ngClick(wm1);

		   				Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		   		int k = driver.findElements(By.xpath("//table/tbody/tr")).size();
		   		
		   		if (k>=1) {
		   		  
		   		test_report_update(QuotationPage_Definition.servs[i]);
		   		 WebElement wm4 = driver.findElement(By.id("Latest_RegressionStatus"));
				
				 wm4.sendKeys("Failed");
		   			
		   		}
		   		else 
		   		{
		   			
		   		test_report_update(QuotationPage_Definition.servs[i]);
		   		WebElement wm4 = driver.findElement(By.id("Latest_RegressionStatus"));
				
				 wm4.sendKeys("Passed");
					
		   		}
		   			
		   	
			}			
		        
		
		}	
				
			
		
		if(scenario.isFailed()) {
			
		 Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
		 final byte[] screenshot = ((TakesScreenshot)
		 driver).getScreenshotAs(OutputType.BYTES); Hooks.scenario.embed(screenshot,
		"image/jpeg"); 
		 
	
		} 
		//driver.quit(); 
		 
	}
	
	}
}

