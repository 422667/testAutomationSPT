package com.sc.sym.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sc.sym.utility.WrapperMethods;

import static com.sc.sym.utility.WrapperElements.properties;

import java.util.Iterator;
import java.util.Set;

public class GlobePage {
    WebDriver driver;
    WrapperMethods wpm;

    @FindBy(id = "txtUserID")
    private WebElement rmIdInput;

    @FindBy(id = "txtPassword")
    private WebElement passwordInput;

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    @FindBy(xpath="//*[contains(text(), 'PII Project Function')]")
    private WebElement piiProjectFunction;

    @FindBy(xpath="//*[contains(text(), 'PII Start')]")
    private WebElement piiStart;

    public GlobePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
        wpm = new WrapperMethods(driver);
    }

    public void login(String rmId, String password) throws Exception {
        String globeUrl = properties.getProperty("GLOBE_URL");
        this.driver.get(globeUrl);

        rmIdInput.sendKeys(rmId);
        passwordInput.sendKeys(password);
        loginBtn.click();

        this.driver.switchTo().alert().accept();
        this.driver.switchTo().frame("WebSplitter1_tmpl1_ParentFrame_tmpl0_I1");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UltraWebListbar1_Group_0_text")));
        piiProjectFunction.click();

        wait.until(ExpectedConditions.elementToBeClickable(piiStart));
        piiStart.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set windows = this.driver.getWindowHandles();
        Iterator it = windows.iterator();
        String newWindow = this.driver.getWindowHandle();

        while(it.hasNext()) {
            newWindow = it.next().toString();
        }

        this.driver.switchTo().window(newWindow);
    }
}
