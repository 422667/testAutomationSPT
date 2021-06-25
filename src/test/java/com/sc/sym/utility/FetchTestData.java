package com.sc.sym.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.cucumber.listener.Reporter;
import com.sc.sym.glue.Hooks;



public class FetchTestData extends Hooks{
	
	 static WrapperMethods wpm;
	public FetchTestData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		wpm = new WrapperMethods(driver);
		
		
	}
	

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	
	static{
		File testDataFile = new File("./src/test/resources/test-data/WCP - SPTel - FAQ Engine Template_20200121.xlsx");
		System.out.println("tested ");
        FileInputStream fileInputStream=null;
		try {
			fileInputStream = new FileInputStream(testDataFile);
			ExcelWBook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	        try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
/*Read the data from all the row in the given excel sheet name */
	public static List<Map<String,Object>> get_all_test_data(String SheetName) {
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int lastrow = ExcelWSheet.getLastRowNum();
        int lastcolumn = ExcelWSheet.getRow(1).getLastCellNum();
        //To be updated based on column numbers
        Row row = null;       
        Cell cell = null;
        
        List<Map<String, Object>> collection_row_data = new ArrayList<Map<String, Object>>();
        for (int rowIndex = 1; rowIndex <= lastrow; rowIndex++) {
            row = ExcelWSheet.getRow(rowIndex);
            if(row == null){
            	break;
            }
            Map<String,Object> single_row_data = new LinkedHashMap<String,Object>();
            for (int columnIndex = 0; columnIndex < lastcolumn; columnIndex++) {
                cell = row.getCell(columnIndex);
                Cell headerCell = ExcelWSheet.getRow(0).getCell(columnIndex);
                if(cell!=null){
                	if(cell.getCellType() == Cell.CELL_TYPE_STRING){
                		single_row_data.put(headerCell.getStringCellValue(), cell.getStringCellValue());
                	} else if(cell.getCellType() == Cell.CELL_TYPE_BLANK){
                		single_row_data.put(headerCell.getStringCellValue(), "");
                	} else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                		single_row_data.put(headerCell.getStringCellValue(), cell.getNumericCellValue());
                	}
                }
            }
            collection_row_data.add(single_row_data);
        }
        return collection_row_data;
	}
	
	/*Read the data from all the row in the given excel sheet name */
	public static Map<String,String> get_all_test_data_chatbot(String SheetName) {
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int lastrow = ExcelWSheet.getLastRowNum();
        int lastcolumn = ExcelWSheet.getRow(1).getLastCellNum();
        //To be updated based on column numbers
        Row row = null;       
        Cell cell = null;
        
        Map<String,String> single_row_data = new LinkedHashMap<String,String>();
        for (int rowIndex = 1; rowIndex <= lastrow; rowIndex++) {
            row = ExcelWSheet.getRow(rowIndex);
            if(row == null){
            	break;
            }
          
            for (int columnIndex = 0; columnIndex < lastcolumn; columnIndex++) {
                cell = row.getCell(columnIndex);
                Cell headerCell = ExcelWSheet.getRow(rowIndex).getCell(0);
                Cell headerCell1 = ExcelWSheet.getRow(rowIndex).getCell(1);
                if(cell!=null){
                	if(cell.getCellType() == Cell.CELL_TYPE_STRING){
                		//System.out.println(headerCell.getStringCellValue());
                		//System.out.println(headerCell1.getStringCellValue());
                		single_row_data.put(headerCell.getStringCellValue(), headerCell1.getStringCellValue());
                	} else if(cell.getCellType() == Cell.CELL_TYPE_BLANK){
                		single_row_data.put(headerCell.getStringCellValue(), "");
                	} 
                }
            }
           // collection_row_data.add(single_row_data);
        }
        return single_row_data;
	}
	
	public static  void fetch_testdata_from_chatbot() throws IOException{	
		Map<String, String> collection_row_data = get_all_test_data_chatbot("Sheet1");
	
		String filtered_data = null;
			Iterator it = collection_row_data.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        driver.findElement(By.id("message-input__text-field")).sendKeys(pair.getKey().toString());
		        driver.findElement(By.id("message-input__send-message-btn")).click();
		        	//int n = driver.findElements(By.xpath("//p[contains(text(),'"+pair.getKey().toString().split("'")[0]+"')]/../../following::div[@class='flex flex--row']")).size();
		        
		        
						
							if(pair.getValue().toString().contains(driver.findElement(By.xpath("//p[contains(text(),'"+pair.getKey().toString().split("'")[0]+"')]/../../following::div[@class='flex flex--row']")).getText().toString()))
							{
							System.out.println(pair.getValue().toString());
							System.out.println(driver.findElement(By.xpath("//p[contains(text(),'"+pair.getKey().toString().split("'")[0]+"')]/../../following::div[@class='flex flex--row']")).getText().toString());
							System.out.println("Values matched");
							Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
							}
							else
								
							{
								System.out.println(pair.getValue().toString());
								System.out.println(driver.findElement(By.xpath("//p[contains(text(),'"+pair.getKey().toString().split("'")[0]+"')]/../../following::div[@class='flex flex--row']")).getText().toString());
								System.out.println("Values not matched");
								Reporter.addScreenCaptureFromPath(wpm.getScreenshot());
							}
						
				
					
			
		    }
		
		}
		//return filtered_data;
	//}
	
	public static String fetch_testdata_from_funddetails(String productID, String cipRating, String requiredColumn){		
		List<Map<String, Object>> collection_row_data = get_all_test_data("Idea_Details_Fund");
		String filtered_data = null;
		for(Map<String,Object> row_data : collection_row_data){
			if((row_data.get("Product ID").toString().equalsIgnoreCase(productID)) &&
				(row_data.get("CIP Rating").toString().equalsIgnoreCase(cipRating))){
				filtered_data = ((String) row_data.get(requiredColumn));
				}		
		}
		return filtered_data;
	}

}
