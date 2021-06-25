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
import com.sc.sym.utility.SKU_Data;
import com.sc.sym.utility.Staff_Customer_Data;
import com.sc.sym.utility.Staff_Customer_Portal;
import com.sc.sym.utility.WrapperMethods;


   
public class InventoryPage {
	 WebDriver driver;
	    WrapperMethods wpm;

	    @FindBy(xpath = "//span[text()='Inventory']")
	    private WebElement Inventory;
	    
	    @FindBy(xpath = "//span[text()='SKU']")
	    private WebElement SKU;
	    
	    @FindBy(xpath = "//span[text()='Resource Type']")
	    private WebElement Resource_Type_Creation;
	    
	    
	    //@FindBy(xpath = "//div[@class='loading-spinner ng-tns-c4-0 ng-star-inserted']")
	    private String Loading_Spinner = "//div[@class='loading-spinner ng-tns-c4-0 ng-star-inserted']";
	 
	    @FindBy(xpath = "(//span[text()='Create'])[12]")
	    private WebElement SKU_Create;
	    
	    @FindBy(xpath = "(//span[text()='Create'])[12]")
	    private WebElement Resource_Creation;
	    
	    @FindBy(xpath = "//a[@href='/staff/customer/add']/span")
	    private WebElement create;

	    @FindBy(xpath ="//input[contains(@id,'input_skuNum_0')]")
	    private WebElement SKU_No;
	    
	    @FindBy(xpath = "//input[contains(@id,'input_skuName_1')]")
	    private WebElement SKU_Name;
	    
	    @FindBy(xpath = "//select[contains(@id,'select_typeSpec_2')]")
	    private WebElement Resource_Type;
	    
	    
	    @FindBy(xpath = "//select[contains(@id,'select_owner_3')]")
	    private WebElement Owner;
	   
	    @FindBy(xpath = "//textarea[contains(@id,'textarea_skuDesc_4')]")
	    private WebElement Sku_Desription;
	    
	    @FindBy(xpath = "//input[contains(@id,'number_jitLeadTime_5')]")
	    private WebElement Jit_Lead_Time;
	    
	    @FindBy(xpath = "//select[@placeholder='Select Status']")
	    private WebElement Active;
	    
	    @FindBy(xpath = "//input[contains(@id,'number_thresholdLevel_0')]")
	    private WebElement Threshold;
	    
	    @FindBy(xpath = "//button[contains(text(),'Add')]")
	    private WebElement Add_threahold;
	    
	    @FindBy(xpath = "//span[text()='Select Action Type']")
	    private WebElement Select_Action;
	    
	    @FindBy(xpath = "(//input[@type='checkbox']/../label)[2]")
	    private WebElement Select_Action_type;
	    
	    @FindBy(xpath = "//button[contains(text(),'Add Specification')]")
	    private WebElement Add_Specification;
	  
	    @FindBy(xpath = "//input[contains(@id,'input_typeCode_0')]")
	    private WebElement Type_Code;
	    
	    @FindBy(xpath = "//input[contains(@id,'input_typeName_1')]")
	    private WebElement Type_Name;
	    
	    @FindBy(xpath = "//select[contains(@id,'select_sequential_2')]")
	    private WebElement Select_Sequential;
	    
	    @FindBy(xpath = "//select[contains(@id,'select_status_3')]")
	    private WebElement Select_Active;
	    
	    @FindBy(xpath = "//select[contains(@id,'select_specId_4')]")
	    private WebElement Select_Specification;
	    
	    @FindBy(xpath = "//select[contains(@id,'select_classId_5')]")
	    private WebElement Select_Classification;
	    
	    @FindBy(xpath = "//textarea[contains(@id,'textarea_typeDesc_6')]")
	    private WebElement Type_Description;
	    
	    @FindBy(xpath = "//button[text()=' Save Changes ']")
	    private WebElement save_changes;
	  
	    @FindBy(xpath = "//button[text()=' close ']")
	    private WebElement save_button_popup;
	    

	    public InventoryPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
	        wpm = new WrapperMethods(driver);
	    }
	    
	    public void Stock_Creation(String Resourcetype) throws IOException, InterruptedException
	    
	    { 
	    	SKU_Data rm = Staff_Customer_Portal.getData1(Resourcetype);
	    	//wpm.waitTillElementDisappear(Loading_Spinner);
	    	wpm.waitTillVisible(Inventory);
	    	
	    	Inventory.click();
	    	Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	    	SKU.click();
	    	//wpm.waitTillVisible(SKU_Create);
	    	wpm.waitTillElementDisappear(Loading_Spinner);
	    	//wpm.waitTillElementDisappear(Loading_Spinner);
	    	//wpm.waitTillElementClickable(SKU_Create);
	    	SKU_Create.click();
	    	wpm.waitTillElementDisappear(Loading_Spinner);
	    	//wpm.waitTillElementDisappear(Loading_Spinner);
	    	//wpm.waitTillElementClickable(SKU_No);
	    	SKU_No.sendKeys(rm.SKU_NO);
	    	SKU_Name.sendKeys(rm.SKU_Name);
	    	Select Resource_type = new Select(Resource_Type);
	    	Resource_type.selectByVisibleText(Resourcetype);
	    	
	    	Select Owner_type = new Select(Owner);
	    	Owner_type.selectByVisibleText(rm.Owner_Type);
	    	
	    	Sku_Desription.sendKeys(rm.SKU_Description);
	    	
	    	Jit_Lead_Time.sendKeys(rm.JIT_Lead);
	    	
	    	try {
				Active.click();
				driver.findElement(By.xpath("//option[text()='No']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Threshold.sendKeys(rm.Threshould_Level);
	        Select_Action.click();
	    	Select_Action_type.click();
	    	Add_threahold.click();
	    	driver.findElement(By.xpath("(//button[@type='button' and @class='btn btn-primary'])[3]")).click();
	    }
	    
	    
	    
	    public void Click_Resource_Type() throws IOException, InterruptedException
	    
	    {
	    	
	    	wpm.waitTillVisible(Inventory);
	      	Inventory.click();
	      	Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	    	  Resource_Type_Creation.click();
	    	  wpm.waitTillElementDisappear(Loading_Spinner);
	    		Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	    	 // Thread.sleep(7000);
	    	
	    }
	    
  public void Resource_Type_Creation(String Resource_code,String Resource_Name,String specification, String classification,String Description) throws IOException, InterruptedException
	    
	    { 
	
	  Resource_Creation.click();
	  wpm.waitTillElementDisappear(Loading_Spinner);
	  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	 // Thread.sleep(5000);
	  Type_Code.sendKeys(Resource_code);
	  Type_Name.sendKeys(Resource_Name);
	  Select sequential = new Select(Select_Sequential);
	  sequential.selectByVisibleText("Yes");
	  Select SelectActive = new Select(Select_Active);
	  SelectActive.selectByVisibleText("Yes");
	  
	  Select SelectSpecification = new Select(Select_Specification);
	  SelectSpecification.selectByVisibleText(specification);
	  
	  Select SelectClassification = new Select(Select_Classification);
	  SelectClassification.selectByVisibleText(classification);
	  Type_Description.sendKeys(Description);
	  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());

	
	    }
	    
  public void save_resource_type() throws IOException, InterruptedException
  {
	  save_changes.click();
	  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
	  wpm.waitTillElementDisappear(Loading_Spinner);
	  save_button_popup.click();
	  Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
  }
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
