package com.sc.sym.pages;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sc.sym.utility.FetchTestData;
import com.sc.sym.utility.WrapperElements;
import com.sc.sym.utility.WrapperMethods;
 
public class EntryPointPage {
    WrapperMethods wpm;
    WebDriver driver;

//--------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//*[contains(text(),'Menu')]")
    WebElement Picasso_Menu_Tab;
    
    @FindBy(xpath = "//*[contains(text(),'Personalised Investment Ideas')]")
    WebElement Picasso_Pii_Submenu_Link;
    
    @FindBy(xpath = "//*[contains(text(),'Investment ideas just for you')]")
    WebElement Picasso_Pii_Banner;    
    
    @FindBy(xpath = "//*[@id='pii_home_page_close_button']")
    WebElement Pii_Home_Page_Close_Button;
    
    @FindBy(xpath = "//*[@id='pii_home_page_close_msg_yes']")
    WebElement Pii_Home_Page_Close_Message_Yes;
    
    @FindBy(xpath = "//*[@id='pii_home_page_close_msg_no']")
    WebElement Pii_Home_Page_Close_Message_No; 
    
    @FindBy(xpath = "//*[@id='pii_home_page_take_a_tour_button']")
    WebElement Pii_Home_Page_Take_A_Tour_Button;
    
    @FindBy(xpath = "//*[contains(text(),'OR skip the tour and get started immediately!')]")
    WebElement Pii_Home_Page_Skip_Tour_Link;    
    
    @FindBy(xpath = "//*[@id='pii_home_page_skip_button_in_tour_page']")
    WebElement Pii_Home_Page_Skip_Button_In_Tour_Page;  
    
    @FindBy(xpath = "//*[@id='no_cip_page']")
    WebElement No_CIP_Page;
    
    @FindBy(xpath = "//*[contains(text(),'VIEW MORE DETAILS ON PERSONALISED INVESTMENT IDEAS')]")
    WebElement No_Cip_View_More_Details_CTA_Button; 
    
    @FindBy(xpath = "//*[@id='campaign_page']")
    WebElement Campaign_Page;    
    
    @FindBy(xpath = "//*[@id='campaign_page_back_button']")
    WebElement Campaign_Page_Back_Button;   
 
    // START Sprint 5
    @FindBy(xpath = "//*[@id='page_pii_home_page']")
    WebElement Pii_Home_Page;
    
    @FindBy(xpath = "//*[@id='pii_home_page_close_msg']")
    WebElement Pii_Home_Page_Close_Msg;
    
    @FindBy(xpath = "//*[@id='pii_home_page_start_tour_button']")
    WebElement Pii_Home_Page_Start_Tour_Button;
    
    @FindBy(xpath = "//*[@id='ellipses_icon']")
    WebElement Ellipses_Icon;
    
    @FindBy(xpath = "//*[@id='ellipses_icon_tour_button']")
    WebElement Ellipses_Icon_Tour_Button;
    
    @FindBy(xpath = "//*[@id='picasso_pii_banner']")
    WebElement Picasso_PII_Banner;
    
    @FindBy(xpath = "//*[@id='pii_tour_scroll_right_button']")
    WebElement PII_Tour_Scroll_Right_Button;
    
    @FindBy(xpath = "//*[@id='pii_tour_scroll_left_button']")
    WebElement PII_Tour_Scroll_Left_Button;
    
    //END Sprint 5
    
    
    public EntryPointPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
        wpm = new WrapperMethods(driver);
    }
    
    public void click_on_menu_tab(){
    	Picasso_Menu_Tab.click(); // When I click on Menu tab
    }  
   
    public void click_on_pii_submenu_link_in_the_menu(){
    	Picasso_Pii_Submenu_Link.click(); // And I click on PII submenu in the menu tab
    }  
    
    public void click_on_close_button_of_pii_home_page(){
    	Pii_Home_Page_Close_Button.click(); // And I click on close button of PII Home Page
    }  
    
    public void click_on_yes_in_quit_confirmation_popup(){
    	Pii_Home_Page_Close_Message_Yes.click(); // And I select yes in quit confirmation popup
    }     
   
    public void click_on_no_in_quit_confirmation_popup(){
    	Pii_Home_Page_Close_Message_No.click(); // And I select no in quit confirmation popup
    } 
    // START Sprint 5
    public void click_on_view_more_details_button_in_no_cip_page(){
    	No_Cip_View_More_Details_CTA_Button.click(); // And I click on view more details CTA in No CIP Page
    }
    
    public void click_on_campaign_page_back_button(){
    	Campaign_Page_Back_Button.click(); // And i click on Campaign Page Back button
    }
    
    public void click_on_take_a_tour_button(){
    	Pii_Home_Page_Take_A_Tour_Button.click(); // And I select take a tour button
    }
    
    public void click_on_start_tour_button(){
    	Pii_Home_Page_Start_Tour_Button.click(); // And I select start tour button
    }
    
    public void click_on_skip_the_tour_link(){
    	Pii_Home_Page_Skip_Tour_Link.click(); // And I select skip the tour and start immediately link
    }
    
    public void click_on_skip_button_in_the_tour_page(){
    	Pii_Home_Page_Skip_Button_In_Tour_Page.click(); // And I select skip button
    }
    
    public void click_on_ellipses_icon(){
    	Ellipses_Icon.click(); // And I select the ellipses menu
    }
    
    public void click_on_ellipses_icon_tour_button(){
    	Ellipses_Icon_Tour_Button.click(); // And I select the ellipses menu
    }
    
   public boolean is_PII_link_submenu_displayed() {
	   return wpm.isElementDisplayed(Picasso_Pii_Submenu_Link);
   } 
   
   public boolean is_PII_Home_Page_accessible() {
	   return wpm.isElementDisplayed(Pii_Home_Page);
   }

   public boolean is_exit_warning_msg_PII_Home_Page_displayed() {
	return wpm.isElementDisplayed(Pii_Home_Page_Close_Msg);
   }

   public boolean is_PicassoHomePage_displayed() {
	return wpm.isElementDisplayed(Picasso_Menu_Tab);
   }

   public boolean is_pii_banner_displayed() {
	   return wpm.isElementDisplayed(Picasso_PII_Banner);
   }

   public boolean is_NOCIP_msg_displayed() {
	   return wpm.isElementDisplayed(No_CIP_Page);
   }

   public boolean is_campaign_page_displayed() {
	   return wpm.isElementDisplayed(Campaign_Page);
   }
 
   public void navigate_tour_screens() {
	   Integer pageCnt = 4;
	   for(int i=0; i<pageCnt; i++){
		   PII_Tour_Scroll_Right_Button.click();
	   }
   }
   
   
   //END Sprint 5
}