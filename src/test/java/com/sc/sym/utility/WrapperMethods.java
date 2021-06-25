package com.sc.sym.utility;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.core.Snapshot;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.google.common.base.Function;
import com.sc.sym.enumlist.IDType;
import com.sc.sym.glue.Hooks;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.cucumber.messages.com.google.common.io.Files;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sc.sym.glue.Hooks.driver;
import static com.sc.sym.utility.WrapperElements.elementIDs;
import static com.sc.sym.utility.WrapperElements.properties;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class WrapperMethods {

	public WebDriver wrapperDriver;
	WebDriverWait waitDriver;
	FluentWait<WebDriver> wait;
	Actions action;
	Locatable hoverItem;

	public WrapperMethods(WebDriver driver) {
		wrapperDriver = driver;
		waitDriver = new WebDriverWait(wrapperDriver, 40);
		action = new Actions(wrapperDriver);
		wait = new FluentWait<>(wrapperDriver).pollingEvery(5,
				TimeUnit.SECONDS).withTimeout(4, TimeUnit.MINUTES);

	}

	public void ngClick(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor) wrapperDriver;
		ex.executeScript("arguments[0].click();", element);
	}
	
	public void ngClear(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor) wrapperDriver;
		ex.executeScript("arguments[0].clear();", element);
	}


	public void click(IDType TypeOfID, String Element) {
		// locateElement(TypeOfID, elementID(Element)).click();
		locateElement(TypeOfID, Element).click();
	}
	
	

	/*
	 * public void longPress(IDType TypeOfID, String Element) { TouchAction action =
	 * new TouchAction( (IOSDriver<WebElement>) wrapperDriver);
	 * action.longPress(locateElement(TypeOfID, Element)).perform();
	 * 
	 * // WebElement element = locateElement(TypeOfID, Element); // element.click();
	 * }
	 */

	public void clearTextBox(IDType TypeOfID, String Element) {
		locateElement(TypeOfID, Element).clear();
	}

	public void enter(IDType TypeOfID, String Element, String Text) {
		locateElement(TypeOfID, Element).sendKeys(Text);
	}

	/*
	 * public void doubleTap(IDType TypeOfID, String Element) { MobileElement
	 * doubleTap = (MobileElement) new WebDriverWait( wrapperDriver,
	 * 30).until(ExpectedConditions
	 * .elementToBeClickable(MobileBy.AccessibilityId(Element))); new
	 * IOSTouchAction((IOSDriver<WebElement>) wrapperDriver).doubleTap(
	 * doubleTap).perform(); }
	 */

	/*
	 * public void singleTap(IDType TypeOfID, String Element) { MobileElement
	 * singleTap = (MobileElement) new WebDriverWait( wrapperDriver,
	 * 30).until(ExpectedConditions
	 * .elementToBeClickable(MobileBy.AccessibilityId(Element))); new
	 * IOSTouchAction((IOSDriver<WebElement>) wrapperDriver)
	 * .tap(singleTap).perform(); }
	 */
	public void clickByCount(IDType TypeOfID, String Element, int noOfTimes) {
		int value = 1;

		while (value <= noOfTimes) {
			locateElement(TypeOfID, elementID(Element)).click();
			value++;

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	/*
	 * public String getScreenshot() { JavascriptExecutor executor =
	 * (JavascriptExecutor)driver;
	 * executor.executeScript("document.body.style.zoom = '0.8'"); TakesScreenshot
	 * ts=(TakesScreenshot) wrapperDriver;
	 * 
	 * File src =ts.getScreenshotAs(OutputType.FILE);
	 * 
	 * 
	 * //String
	 * path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()
	 * +".png"; String
	 * path="./target/cucumber-reports/images/"+System.currentTimeMillis()+".png";
	 * File destination=new File(path);
	 * 
	 * try { FileUtils.copyFile(src, destination); } catch (IOException e) {
	 * 
	 * System.out.println("Capture Failed "+e.getMessage()); }
	 * executor.executeScript("document.body.style.zoom = '1'");
	 * 
	 * return path;
	 * 
	 * //return "data:image/png;base64, " + dest ; }
	 */
	
	
	public void clearcache() throws InterruptedException
	{
		//driver.get("chrome://settings/clearBrowserData");
		  driver.manage().deleteAllCookies();
		    driver.get("chrome://settings/clearBrowserData");
		    //Thread.sleep(7000);
		    driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
	}

	public String getScreenshot() throws IOException
	{

		String path=""+System.currentTimeMillis()+"";
		Snapshot<?> snapshot = Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS, 500, true).withName(path);
		snapshot.save("./output/images/");
		path = "./../../output/images/"+path+".png";
		return path;
		
	
		
	}
	public void clickByIndex(IDType TypeOfID, String Element, int Index) {
		locateElements(TypeOfID, elementID(Element)).get(Index).click();
	}

	public void waitTillVisible(WebElement element) {
		waitDriver.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitTillElementDisappear(String element) throws InterruptedException {
		/*
		 * if (isElementDisplayed(By.xpath(element))) {
		 * waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(By
		 * .xpath(element))); }
		 */
		int count =0;
		try {
			while(wrapperDriver.findElements(By.xpath(element)).size()!=0 && count<30)
			{
				Thread.sleep(1000);
				count++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void waitForElementToDisappear(String element) throws InterruptedException{
		//try for 5 seconds
		
		int count =0;
		try {
			while(wrapperDriver.findElements(By.xpath(element)).size()!=0 && count<30)
			{
				Thread.sleep(2000);
				count++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void waitTillElementDisappear(WebElement element) {
		if (isElementDisplayed(element)) {
			waitDriver.until(ExpectedConditions.invisibilityOf(element));
		}
	}
	public void waitTillElementDisappear_click(WebElement element) {
		if (isElementDisplayed(element)) {
			ngClick(element);
			waitDriver.until(ExpectedConditions.invisibilityOf(element));
		}
	}



	public WebElement waitTillElementClickable(WebElement element) {
		return waitDriver.until(ExpectedConditions
				.elementToBeClickable(element));
	}

	public void waitTillElementAppeared(WebElement Element) {
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg0) {
				//WebElement element = arg0.findElement(By.id("dynamicColor"));
				String color = Element.getCssValue("color");
				System.out.println("The button text has color :" + color);
				if (color.equals("rgb(255, 255,255)")) {
					return true;
				}
				return false;
			}
		};
	}

	public boolean isElementPresent(IDType TypeOfID, String Element) {
		int element_instances = locateElements(TypeOfID, elementID(Element))
				.size();
		return element_instances > 0 ? true : false;
	}

	public List<String> get_Listofstring_From_Listofwebelements(
			List<WebElement> listElements) {
		List<String> stringList = new ArrayList<String>();
		for (WebElement eachElement : listElements) {
			stringList.add(eachElement.getText().trim());
		}
		return stringList;
	}
	
	public boolean is_listofwebelements_empty(
			List<WebElement> listElements) {
		for (WebElement eachElement : listElements) {
			if((eachElement.getText().trim().equalsIgnoreCase(" ")) || (eachElement.getText().trim().equalsIgnoreCase("-"))){
				return false;
			}
		}
		return true;
	}

	public static Predicate<WebElement> isYesNo(){
		HashSet<String> validValues = new HashSet<>(Arrays.asList("YES", "NO", "-"));
		return element -> validValues.contains(element.getText().trim());
	}

	public static Predicate<WebElement> isCIP(){
		Predicate<Integer> testCIPRange = integer -> integer > 0 && integer <= 6;
		return element -> {
			String text = element.getText().trim();
			return text.equalsIgnoreCase("-") || testCIPRange.test(Integer.parseInt(text));
		};
	}

	public static Predicate<WebElement> isMoneyValue(){
		Predicate<String> predicate = Pattern.compile("^\\d{1,3}(,\\d{3})*(\\.\\d{2})$").asPredicate();
		return element -> predicate.test(element.getText().trim());
	}

	public static Predicate<WebElement> isNumericValue() {
		Predicate<String> predicate = Pattern.compile("^-?\\d{1,3}(,\\d{3})*(\\.*\\d*)$").asPredicate();
		return element -> predicate.test(element.getText().trim());
	}

	public static Predicate<WebElement> isNA() {
		Predicate<String> predicate = Pattern.compile("^N.A.$").asPredicate();
		return element -> predicate.test(element.getText().trim());
	}

	public List<Integer> get_Listofinteger_From_Listofwebelements(
			List<WebElement> listElements) {
		List<Integer> integerList = new ArrayList<Integer>();
		for (WebElement eachElement : listElements) {
			integerList.add(Integer.parseInt(eachElement.getText()
					.replace(",", "").trim()));
		}
		return integerList;
	}

	public List<String> get_Listofstring_From_Listofobjects(
			List<Object> ObjectList) {
		List<String> stringList = new ArrayList<String>();
		for (Object eachElement : ObjectList) {
			stringList.add(eachElement.toString());
		}
		return stringList;
	}

	public List<Integer> get_Listofinteger_From_Listofobjects(
			List<Object> ObjectList) {
		List<Integer> integerList = new ArrayList<Integer>();
		for (Object eachElement : ObjectList) {
			integerList.add((int) eachElement);
		}
		return integerList;
	}

	
	
	public Integer compare_two_listofstring(List<String> StringList1,
			List<String> StringList2) {
		if (StringList1.size() != StringList2.size()) {
			return 1;
		} else {
			Integer flag = 0;
			for (int listindex = 0; listindex < StringList1.size(); listindex++) {
				if (StringList2.get(listindex).contains(
						(StringList1.get(listindex)))) {
					flag = 0;
				} else {
					flag = listindex + 1;
					break;
				}
			}
			return flag;
		}
	}

	

	public boolean is_listofwebelements_sorted_ascending(
		List<WebElement> Client_Listing_Table_Values) {
		List<String> tablevalues_beforesort = new ArrayList<String>();
		List<String> tablevalues_aftersort = new ArrayList<String>();
			for (WebElement Table_Value : Client_Listing_Table_Values) {
				Matcher matcher = Pattern.compile(".+?(?=[,])").matcher(Table_Value.getText());
				if (matcher.find()) {
					tablevalues_beforesort.add(matcher.group(0));
				} else {
					tablevalues_beforesort.add(Table_Value.getText());
				}
			}
		
		tablevalues_aftersort.addAll(tablevalues_beforesort);
		Collections.sort(tablevalues_aftersort, String.CASE_INSENSITIVE_ORDER);


			for (int index = 0; index < tablevalues_aftersort.size(); index++) {
				if (!(tablevalues_beforesort.get(index)
						.equalsIgnoreCase(tablevalues_aftersort.get(index)))) {
					return false;
				}
			}
		return true;
	}

	public boolean is_listofwebelements_sorted_descending(
		List<WebElement> Client_Listing_Table_Values) {
			List<String> tablevalues_beforesort = new ArrayList<String>();
			List<String> tablevalues_aftersort = new ArrayList<String>();
			for (WebElement Table_Value : Client_Listing_Table_Values) {
				Matcher matcher = Pattern.compile(".+?(?=[,])").matcher(Table_Value.getText());
				if (matcher.find()) {
					tablevalues_beforesort.add(matcher.group(0));
				} else {
					tablevalues_beforesort.add(Table_Value.getText());
				}
			}
			tablevalues_aftersort.addAll(tablevalues_beforesort);
			Collections.sort(tablevalues_aftersort, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

			for (int index = 0; index < tablevalues_aftersort.size(); index++) {
				if (!(tablevalues_beforesort.get(index)
						.equalsIgnoreCase(tablevalues_aftersort.get(index)))) {
					return false;
				}
			}
			return true;
	}

	public boolean is_listofwebelements_sorted_ascending_bigdecimal(
			List<WebElement> Client_Listing_Table_Values) {
		List<BigDecimal> tablevalues_beforesort = new ArrayList<BigDecimal>();
		List<BigDecimal> tablevalues_aftersort = new ArrayList<BigDecimal>();
		for (WebElement Table_Value : Client_Listing_Table_Values) {
			tablevalues_beforesort.add(convertStringAmtToBigDecimal(Table_Value
					.getText()));
		}
		tablevalues_aftersort.addAll(tablevalues_beforesort);
		tablevalues_aftersort.sort(new Comparator<BigDecimal>() {
			@Override
			public int compare(BigDecimal o1, BigDecimal o2) {
				return o1.compareTo(o2);
			}
		});

		return tablevalues_beforesort.equals(tablevalues_aftersort);
	}

	public boolean is_listofwebelements_sorted_descending_bigdecimal(
			List<WebElement> Client_Listing_Table_Values) {
		List<BigDecimal> tablevalues_beforesort = new ArrayList<BigDecimal>();
		List<BigDecimal> tablevalues_aftersort = new ArrayList<BigDecimal>();
		for (WebElement Table_Value : Client_Listing_Table_Values) {
			tablevalues_beforesort.add(convertStringAmtToBigDecimal(Table_Value
					.getText()));
		}
		tablevalues_aftersort.addAll(tablevalues_beforesort);
		tablevalues_aftersort.sort(new Comparator<BigDecimal>() {
			@Override
			public int compare(BigDecimal o1, BigDecimal o2) {
				return o1.compareTo(o2);
			}
		}.reversed());

		return tablevalues_beforesort.equals(tablevalues_aftersort);
	}

	public Integer compare_two_listofinteger(List<Integer> IntegerList1,
			List<Integer> IntegerList2) {
		if (IntegerList1.size() != IntegerList2.size())
			return 1;
		else {
			Integer flag = 0;
			for (int listindex = 0; listindex < IntegerList1.size(); listindex++) {
				if (IntegerList1.get(listindex).equals(
						IntegerList2.get(listindex))) {
					flag = 0;
				} else {
					flag = listindex++;
					break;
				}
			}
			return flag;
		}
	}

	public boolean compare_two_string(String String1, String String2) {
		if (String1.equalsIgnoreCase(String2)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean compare_two_integer(int integer1, int integer2) {
		if (integer1 == integer2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDisplayed(IDType TypeOfID, String Element) {
		return locateElement(TypeOfID, elementID(Element)).isDisplayed();
	}

	public boolean isElementDisplayed(WebElement pageElement) {
       try{
    	   return pageElement.isDisplayed();
	   }catch(Exception e){
		   return false;
	   }
	}
	
	public boolean isNumeric(String value) {
	    try{
	    	return value != null && value.matches("[-+]?\\d*\\.?\\d+") || value.contains("-");  		
		} catch(Exception e){
			 return false;
		   } 
	} 

	public int getElementsCount(IDType TypeOfID, String Element) {
		return locateElements(TypeOfID, elementID(Element)).size();
	}

	public String getText(WebElement pageElement) {
		return pageElement.getText();
	}

	public void close_ng_dialog_window() {
		JavascriptExecutor executor = (JavascriptExecutor) wrapperDriver;
		executor.executeScript("arguments[0].click();", wrapperDriver
				.findElement(By
						.xpath("//*[contains(@class,'ngdialog-close-icon')]")));
	}

	public String getTextByIndex(IDType TypeOfID, String Element, int Index) {
		return locateElements(TypeOfID, elementID(Element)).get(Index)
				.getText();
	}

	public WebElement locateElement(IDType TypeOfID, String Element) {

		WebElement reqEl;
		switch (TypeOfID) {

		case ID:
			reqEl = wrapperDriver.findElement(By.id(Element));
			return reqEl;

		case Xpath:
			reqEl = wrapperDriver.findElement(By.xpath(Element));
			return reqEl;

		case Class:
			reqEl = wrapperDriver.findElement(By.className(Element));
			return reqEl;

		case Css:
			reqEl = wrapperDriver.findElement(By.cssSelector(Element));
			return reqEl;

		default:
			reqEl = wrapperDriver.findElement(By.name(Element));
			return reqEl;
		}
	}

	public List<WebElement> locateElements(IDType TypeOfID, String Element) {

		switch (TypeOfID) {

		case ID:
			return wrapperDriver.findElements(By.id(Element));

		case Xpath:
			return wrapperDriver.findElements(By.xpath(Element));

		case Class:
			return wrapperDriver.findElements(By.className(Element));

		case Css:
			return wrapperDriver.findElements(By.cssSelector(Element));

		default:
			return wrapperDriver.findElements(By.name(Element));
		}
	}

	public void moveMouseToElement(IDType TypeOfID, String Element) {
		hoverItem = (Locatable) locateElement(TypeOfID, elementID(Element));
		Mouse mouse = ((HasInputDevices) wrapperDriver).getMouse();
		mouse.mouseMove(hoverItem.getCoordinates());
	}

	public void moveMouseToElement(WebElement element) {
		hoverItem = (Locatable) element;
		Mouse mouse = ((HasInputDevices) wrapperDriver).getMouse();
		mouse.mouseMove(hoverItem.getCoordinates());
	}

	public String getAttribute(IDType TypeOfID, String Element,
			String AttributeName) {
		return locateElement(TypeOfID, elementID(Element)).getAttribute(
				AttributeName);
	}

	public String getAttributeByIndex(IDType TypeOfID, String Element,
			String AttributeName, int Index) {
		return locateElements(TypeOfID, elementID(Element)).get(Index)
				.getAttribute(AttributeName);
	}

	public String elementID(String ElementVariable) {
		if (ElementVariable.contains("//")) {

			return ElementVariable;

		} else if (ElementVariable.contains("#")) {

			return ElementVariable.replace("#", "");
		} else {
			return elementIDs.getProperty(ElementVariable);
		}
	}

	public void scrollToElement(WebElement Element) {
		((JavascriptExecutor) wrapperDriver).executeScript(
				"arguments[0].scrollIntoView(true);", Element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrolldown() {
	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollup() {

		JavascriptExecutor js = (JavascriptExecutor) wrapperDriver;
		js.executeScript("javascript:window.scrollBy(0,-250)");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void digital_signature(WebElement element)
{

		/*
		 * Actions builder = new Actions(driver); Action drawAction =
		 * builder.moveToElement(element,135,15) //start points x axis and y axis.
		 * .click() .moveByOffset(200, 60) // 2nd points (x1,y1) .click()
		 * .moveByOffset(100, 70)// 3rd points (x2,y2) .doubleClick() .build();
		 * drawAction.perform();
		 */
		/*
		 * Actions actionBuilder=new Actions(driver); Action drawOnCanvas=actionBuilder
		 * .contextClick(element) .moveToElement(element,8,8) .clickAndHold(element)
		 * .moveByOffset(120, 120) .moveByOffset(60,70) .moveByOffset(-140,-140)
		 * .release(element) .build(); drawOnCanvas.perform();
		 */
        
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        builder.clickAndHold(element).perform();
        builder.moveByOffset(150, 50).perform();
        builder.moveToElement(element).perform();
        builder.clickAndHold(element).perform();
        builder.moveByOffset(100, 50).perform();
        builder.moveToElement(element).perform();
}

public void waitForLoad() {
    ExpectedCondition<Boolean> pageLoadCondition = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(pageLoadCondition);
}


	public void scrollDownInElement(String cssSelector, String distance) {
		JavascriptExecutor js = (JavascriptExecutor) wrapperDriver;
		js.executeScript("document.querySelector('"+cssSelector+"').scrollTop="+distance);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isElementVisibleOnScreen(WebElement element) {
		Dimension weD = element.getSize();
		Point weP = element.getLocation();
		Dimension d = wrapperDriver.manage().window().getSize();

		int x = d.getWidth();
		int y = d.getHeight();
		int x2 = weD.getWidth() + weP.getX();
		int y2 = weD.getHeight() + weP.getY();

		return x2 <= x && y2 <= y;
	}
	
	
	
	 public void Switch_to_another()
	 {
		  String current_window = driver.getWindowHandle();
		   for(String winHandle : driver.getWindowHandles()){
			   if(!winHandle.equals(current_window))
		          {
		          driver.switchTo().window(winHandle);

		          }
	       }
	 }
	public void highletElement(WebElement element) {

		if (properties.getProperty("browser").equals("chrome")) {
			JavascriptExecutor js = (JavascriptExecutor) wrapperDriver;
			for (int iCnt = 0; iCnt < 1; iCnt++) {
				js.executeScript(
						"arguments[0].style.border='4px groove FireBrick'",
						element);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				js.executeScript("arguments[0].style.border=''", element);
			}
		}
	}

	public void locateCloseButton(IDType TypeOfID, String Element) {
		WebElement element = locateElement(TypeOfID, Element);
		Dimension elementSize = element.getSize();

		int x = elementSize.getHeight();
		int y = elementSize.getWidth();
		action.moveToElement(element).moveByOffset(10, y).click().perform();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			wrapperDriver.findElement(locator);
			return true;
		} catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
			return false;
		}
	}

	public WebElement locateElementByText(List<WebElement> list, String name) {
		for (WebElement webElement : list) {
			if (webElement.getText().equals(name)) {
				return webElement;
			}
		}
		return null;
	}

	public void threadSleepMethod(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public BigDecimal convertStringAmtToBigDecimal(String string) {
		Double number = (new BigDecimal(string.replaceAll(",", "").trim()))
				.doubleValue();
		DecimalFormat format = new DecimalFormat("#.##");
		format.setMinimumFractionDigits(2);

		return new BigDecimal(format.format(number));

	}



}
