package com.sptel.sym.baserunner;

import java.io.File;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.zeroturnaround.zip.ZipUtil;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/symphony-features"},
        tags = {
                "~@ignore","~@Ref","@Customer_Auto_E2E_Flow_PTMP"
               },
        glue = {"classpath:com.sc.sym.glue", "src/test/resources/snippet"},
        monochrome = true,
        strict = true,
        plugin = {"pretty", "html:target/cucumber-html-reports",
        		  "com.cucumber.listener.ExtentCucumberFormatter:",
        		  "json:target/cucumber-reports/Cucumber.json"})

public class BaseRunnerTest02 {
	@AfterClass
	 public static void writeExtentReport() {
		 Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		     Reporter.setSystemInfo("User Name", "Symphony");
		     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		     Reporter.setSystemInfo("Selenium", "3.7.0");
		     Reporter.setSystemInfo("Maven", "3.5.2");
		     Reporter.setSystemInfo("Java Version", "1.8.0_231");
		/*
		 * Document doc = Jsoup.parse("./reports/Cucumber_report.html"); Elements links
		 * = doc.select("href=\"./reports/images/"); String baseUri =
		 * links.get(0).baseUri(); for(Element link : links) { link.replaceWith(new
		 * TextNode("href=\"./../reports/images")); System.out.println(link); }
		 * ZipUtil.pack(new File("./reports"), new File("./reports.zip"));
		 */
		    
		 }
	 }

	

