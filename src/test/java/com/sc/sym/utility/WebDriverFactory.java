package com.sc.sym.utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.sc.sym.utility.WrapperElements.properties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver createDriver() throws MalformedURLException, InterruptedException {
        final String browserName = System.getProperty("BROWSER") !=null ? System.getProperty("BROWSER") : "Chrome";
        final String Env = System.getProperty("ENV") !=null ? System.getProperty("ENV") : "jenkins";
        final String machineType = System.getProperty("MACHINE") !=null ? System.getProperty("MACHINE") : "Mac";
        final String reportConfigPath = System.getProperty("reportConfigPath") !=null ? System.getProperty("reportConfigPath") : "reportConfigPath";
        System.out.println("Browser: " + browserName);
        System.out.println("Machine: " + machineType);
        switch (browserName.toLowerCase()) {
            case "chrome":
			/*
			 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			 * capabilities.setCapability("chrome.switches",
			 * Arrays.asList("--ignore-certificate-errors")); ChromeOptions options = new
			 * ChromeOptions(); options.addArguments("lang=en_GB");
			 * options.addArguments("--start-maximized");
			 * options.setAcceptInsecureCerts(true);
			 * capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 * capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 * capabilities.setPlatform(Platform.LINUX); WebDriver driver = new
			 * RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); return
			 * driver;
			 */
			 
			 
			 
            return getChromeDriver(Env,machineType, false, false);
            case "Chrome-Emulation":
                return getChromeDriver(Env,machineType, true, true);
            case "firefox":
			
			/*
			 * DesiredCapabilities capabilities1 = DesiredCapabilities.firefox();
			 * capabilities1.setCapability("firefox.switches",
			 * Arrays.asList("--ignore-certificate-errors")); FirefoxOptions options1 = new
			 * FirefoxOptions(); //options1.addArguments("lang=en_GB");
			 * options1.addArguments("--start-maximized");
			 * options1.setAcceptInsecureCerts(true);
			 * capabilities1.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options1);
			 * capabilities1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 * capabilities1.setPlatform(Platform.LINUX); WebDriver driver1 = new
			 * RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities1);
			 * driver1.manage().window().maximize(); return driver1;
			 */
			 
          		//return driver1;
            	return getfirefoxDriver(machineType, false, false);
            case "Safari":
                //return getSafariDriver();

            case "Ipad-RealDevice":
               // return getIPadDriver();

            case "Simulator-WebApp":
               // return getSimulatorWebAppDriver();

            case "Simulator-NativeApp":
                //return getSimulatorNativeAppDriver();

            case "Emulator-NativeApp":
                return getEmulatorNativeAppDriver();

            case "Android_WEB":
                //return getEmulatorWebAppDriver();

            case "Perfecto":
                //return getPerfectoDriver();


            case "Chrome-Headless":
            default:
                return getChromeDriver(Env,machineType, false, false);
        }
    }

	/*
	 * private static WebDriver getPerfectoDriver() throws MalformedURLException {
	 * final DesiredCapabilities capabilities = new DesiredCapabilities("mobileOS",
	 * "", Platform.ANY); final String host = "demo.perfectomobile.com";
	 * capabilities.setCapability("user", "poc6@mobilecloud.com");
	 * capabilities.setCapability("password", "SCA123!");
	 * capabilities.setCapability("deviceName",
	 * "CC7EC0150CD1B61386699071257C584C3186B353");
	 * capabilities.setCapability("automationName", "Appium");
	 * capabilities.setCapability("bundleId", "com.sc.mobile.rcworkbench.13");
	 * capabilities.setCapability("scriptName", "SC Harness");
	 * 
	 * // Call this method if you want the script to share the devices with the
	 * Perfecto Lab plugin. //
	 * PerfectoLabUtils.setExecutionIdCapability(capabilities, host);
	 * 
	 * IOSDriver<WebElement> driver = new IOSDriver<>( new URL("https://" + host +
	 * "/nexperience/perfectomobile/wd/hub"), capabilities); String view = null;
	 * Set<String> contexts = driver.getContextHandles(); for (String context :
	 * contexts) { if (context.contains("NATIVE")) view = context;
	 * System.out.println("context: " + context); } driver.context(view); return
	 * driver; }
	 * 
	 * private static WebDriver getEmulatorWebAppDriver() throws
	 * MalformedURLException { DesiredCapabilities capabilities1 = new
	 * DesiredCapabilities();
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
	 * capabilities1.setCapability(MobileCapabilityType.DEVICE_NAME,
	 * "Android SDK built for x86");
	 * capabilities1.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
	 * capabilities1.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
	 * capabilities1.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome"); try
	 * { AndroidDriver<MobileElement> driver = new AndroidDriver<>(new
	 * URL(getHubUrl()), capabilities1); // driver = ((AppiumDriver<WebElement>)
	 * driver); String view = null; Set<String> contexts =
	 * driver.getContextHandles(); for (String context : contexts) { if
	 * (context.contains("CHROMIUM")) view = context; System.out.println("context: "
	 * + context); } driver.context(view); return driver; } catch
	 * (MalformedURLException e) { e.printStackTrace(); throw e; } }
	 * 
	 * private static WebDriver getEmulatorNativeAppDriver() throws
	 * MalformedURLException { DesiredCapabilities capabilities1 = new
	 * DesiredCapabilities();
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
	 * capabilities1.setCapability(MobileCapabilityType.DEVICE_NAME,
	 * "Nexus 6 - Marshallow - Android 6");
	 * //capabilities.setCapability(MobileCapabilityType.UDID,
	 * "67D08447-D764-4AB7-B019-7788E342D827"); //
	 * capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, //
	 * AutomationName.IOS_XCUI_TEST);
	 * capabilities1.setCapability(MobileCapabilityType.NO_RESET, true);
	 * capabilities1.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
	 * capabilities1.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
	 * capabilities1.setCapability(MobileCapabilityType.APP,
	 * "/Users/SCB/Documents/IOS_App/test.apk"); //
	 * capabilities.setCapability("bundleId", "com.scb.mobile.rwbpii"); try {
	 * AndroidDriver<MobileElement> driver = new AndroidDriver<>(new
	 * URL(getHubUrl()), capabilities1); // driver = ((AppiumDriver<WebElement>)
	 * driver); String view = null; Set<String> contexts =
	 * driver.getContextHandles(); for (String context : contexts) { if
	 * (context.contains("NATIVE")) view = context; System.out.println("context: " +
	 * context); } driver.context(view); return driver; } catch
	 * (MalformedURLException e) { e.printStackTrace(); throw e; } }
	 * 
	 * private static WebDriver getSimulatorNativeAppDriver() throws
	 * MalformedURLException { DesiredCapabilities capabilities1 = new
	 * DesiredCapabilities();
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
	 * capabilities1.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
	 * //capabilities.setCapability(MobileCapabilityType.UDID,
	 * "67D08447-D764-4AB7-B019-7788E342D827");
	 * capabilities1.setCapability(MobileCapabilityType.AUTOMATION_NAME,
	 * AutomationName.IOS_XCUI_TEST);
	 * capabilities1.setCapability(MobileCapabilityType.NO_RESET, true);
	 * capabilities1.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
	 * capabilities1.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
	 * capabilities1.setCapability(MobileCapabilityType.APP,
	 * "/Users/SCB/Documents/IOS_App/test.app"); //
	 * capabilities.setCapability("bundleId", "com.scb.mobile.rwbpii"); try {
	 * IOSDriver<MobileElement> driver = new IOSDriver<>(new URL(getHubUrl()),
	 * capabilities1); // driver = ((AppiumDriver<WebElement>) driver); String view
	 * = null; Set<String> contexts = driver.getContextHandles(); for (String
	 * context : contexts) { if (context.contains("WEBVIEW")) view = context;
	 * System.out.println("context: " + context); } driver.context(view); return
	 * driver; } catch (MalformedURLException e) { e.printStackTrace(); throw e; } }
	 * 
	 * private static WebDriver getSimulatorWebAppDriver() throws
	 * MalformedURLException { DesiredCapabilities capabilities1 = new
	 * DesiredCapabilities();
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
	 * capabilities1.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
	 * //capabilities.setCapability(MobileCapabilityType.UDID,
	 * "67D08447-D764-4AB7-B019-7788E342D827");
	 * capabilities1.setCapability(MobileCapabilityType.AUTOMATION_NAME,
	 * AutomationName.IOS_XCUI_TEST);
	 * capabilities1.setCapability(MobileCapabilityType.NO_RESET, true);
	 * capabilities1.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
	 * capabilities1.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true); //
	 * capabilities.setCapability(MobileCapabilityType.APP,
	 * "/Users/SCB/Documents/IOS_App/test.app"); //
	 * capabilities.setCapability("bundleId", "com.scb.mobile.rwbpii");
	 * capabilities1.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari"); try
	 * { IOSDriver<MobileElement> driver = new IOSDriver<>(new URL(getHubUrl()),
	 * capabilities1); // driver = ((AppiumDriver<WebElement>) driver); String view
	 * = null; Set<String> contexts = driver.getContextHandles(); for (String
	 * context : contexts) { if (context.contains("WEBVIEW")) view = context;
	 * System.out.println("context: " + context); } driver.context(view); return
	 * driver;
	 * 
	 * } catch (MalformedURLException e) { e.printStackTrace(); throw e; } }
	 * 
	 * private static WebDriver getSafariDriver() throws InterruptedException {
	 * DesiredCapabilities safariCapabilities = DesiredCapabilities.safari();
	 * safariCapabilities.acceptInsecureCerts();
	 * 
	 * SafariDriver driver = new SafariDriver(safariCapabilities);
	 * Thread.sleep(2000); driver.manage().timeouts().implicitlyWait(5,
	 * TimeUnit.SECONDS); driver.manage().window().maximize(); return driver; }
	 * 
	 * @SuppressWarnings("unchecked") private static WebDriver getIPadDriver()
	 * throws MalformedURLException { DesiredCapabilities capabilities1 =
	 * DesiredCapabilities.ipad();
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	 * capabilities1.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2.1");
	 * capabilities1.setCapability(MobileCapabilityType.DEVICE_NAME,
	 * "Pankaj's iPad"); capabilities1.setCapability(MobileCapabilityType.UDID,
	 * "e4d4cd18035414fbac1b79d1cf6028ff35860a15");
	 * capabilities1.setCapability(MobileCapabilityType.AUTOMATION_NAME,
	 * AutomationName.IOS_XCUI_TEST);
	 * capabilities1.setCapability(MobileCapabilityType.NO_RESET, true);
	 * capabilities1.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
	 * capabilities1.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true); //
	 * capabilities.setCapability(MobileCapabilityType.APP, // "RWB_PII");
	 * capabilities1.setCapability("bundleId", "com.scb.mobile.rwbpii");
	 * capabilities1.setCapability(MobileCapabilityType.BROWSER_NAME, ""); try {
	 * WebDriver driver = new IOSDriver<MobileElement>(new URL(getHubUrl()),
	 * capabilities1); String view = null; Set<String> contexts =
	 * ((AppiumDriver<WebElement>) driver).getContextHandles(); for (String context
	 * : contexts) { if (context.contains("NATIVE")) view = context;
	 * System.out.println("context: " + context); } ((AppiumDriver<WebElement>)
	 * driver).context(view); return driver;
	 * 
	 * } catch (MalformedURLException e) { e.printStackTrace(); throw e; } }
	 * 
	 * private
	 */ static String getHubUrl() {
        String driverHost = System.getProperty("driverHost") != null ? System
                .getProperty("driverHost") : "127.0.0.1";
        String driverPort = System.getProperty("driverPort") != null ? System
                .getProperty("driverPort") : "4723";
        return "http://" + driverHost + ":" + driverPort + "/wd/hub";
    }

	private static WebDriver getChromeDriver(String Env, String machineType, boolean headless, boolean mobileEmulation) throws MalformedURLException {
        
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setPlatform(Platform.LINUX);
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities)
		
		
		
		 // if (machineType.equals("windows")) {
		// System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe"); } else if
		// (machineType.equals("Mac")) {
		//  System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe"); }
		 if(Env.equalsIgnoreCase("local")) {
         
         WebDriverManager.chromedriver().setup();
		 }
          ChromeOptions options = new ChromeOptions();
		 if (mobileEmulation) { Map<String, Object> deviceMetrics = new HashMap<>();
		 deviceMetrics.put("width", 1024);
		 deviceMetrics.put("height", 768);
		 Map<String, Object> metrics = new HashMap<>(); metrics.put("deviceMetrics",
		 deviceMetrics); options.setExperimentalOption("mobileEmulation", metrics); }
		//options.setHeadless(false); 
		 options.setHeadless(headless);
		 options.setAcceptInsecureCerts(true);
		// options.addArguments("--window-size=1920,1080");
		 options.addArguments("--start-maximized");
		 //options.addArguments("incognito");	
		 if(Env.equalsIgnoreCase("jenkins")) {
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 }
		 WebDriver driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
         return driver;
    }

   

    private static RemoteWebDriver getfirefoxDriver(String machineType, boolean headless, boolean mobileEmulation) throws MalformedURLException {
         //ChromeOptions options = new ChromeOptions();
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setPlatform(Platform.LINUX);
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities)
		/*
		 * if (machineType.equals("windows")) {
		 * System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); } else if
		 * (machineType.equals("mac")) {
		 * System.setProperty("webdriver.chrome.driver","chromedriver"); }
		 */
         
         WebDriverManager.firefoxdriver().setup();
         
		
		  FirefoxProfile profile = new FirefoxProfile();
		    profile.setPreference("browser.cache.disk.enable", false);
		    profile.setPreference("browser.cache.memory.enable", false);
		    profile.setPreference("browser.cache.offline.enable", false);
		    profile.setPreference("network.http.use-cache", false);
		    FirefoxOptions options = new FirefoxOptions().setProfile(profile);
		 RemoteWebDriver driver = new FirefoxDriver(options);
		 if (mobileEmulation) { Map<String, Object> deviceMetrics = new HashMap<>();
		 deviceMetrics.put("width", 1024);
		 deviceMetrics.put("height", 768);
		 Map<String, Object> metrics = new HashMap<>(); metrics.put("deviceMetrics",
		 deviceMetrics);}
		// options.setHeadless(headless); 
		 options.setAcceptInsecureCerts(true);
		// options.addArguments("--window-size=1920,1080");
		 options.addArguments("--start-maximized");
		 //options.addArguments("incognito");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
         return driver;
    }
    
    
    
    
    private static WebDriver getEmulatorNativeAppDriver() throws
	 MalformedURLException { DesiredCapabilities capabilities = new
	 DesiredCapabilities();
	 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
	  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
	  "Nexus 6 - Marshallow - Android 6");
	  capabilities.setCapability(MobileCapabilityType.UDID,
	  "emulator-5554"); //
	  //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, //
	  //AutomationName.IOS_XCUI_TEST);
	  capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	  capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
	  capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
	  capabilities.setCapability("appActivity","com.pccw.dwfmmobileclient.MainActivity");
	  capabilities.setCapability("appPackage", "com.pccw.dwfmmobileclient"); try {
	  AndroidDriver<MobileElement> driver = new AndroidDriver<>(new
	  URL(getHubUrl()), capabilities); 
	  // driver = ((AppiumDriver<WebElement>)
	  String view = null; Set<String> contexts =
	  driver.getContextHandles(); for (String context : contexts) { if
	  (context.contains("NATIVE")) view = context; System.out.println("context: " +
	  context); } driver.context(view); return driver; } catch
	  (MalformedURLException e) { e.printStackTrace(); throw e; } }
}
