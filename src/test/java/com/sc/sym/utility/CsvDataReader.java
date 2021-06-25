package com.sc.sym.utility;

import static com.sc.sym.utility.WrapperElements.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CsvDataReader {
	
    static String fileNameDefined = "./src/test/resources/test-data/" + properties.getProperty("STAFF_CUSTOMER");
    static File file = new File(fileNameDefined);

    static String fileNameDefined1 = "./src/test/resources/test-data/" + properties.getProperty("SKU");
    static File file1 = new File(fileNameDefined1);
    
    public static Map<String, Staff_Customer_Data> readFile() {
        Map<String, Staff_Customer_Data> result = new HashMap<>();

        try{
            Scanner inputStream = new Scanner(file);

            if (inputStream.hasNext()) inputStream.next();

            while(inputStream.hasNext()){
                String[] line = inputStream.next().split(",");
                for (String string : line) {
					System.out.println(string);
				}
                Staff_Customer_Data data = new Staff_Customer_Data();
                data.Country_Registred = line[0];
                data.UEN = line[1];
                data.Username = line[2];
                data.Organization_type = line[3];
                data.Established_year = line[4];
                data.postal_code = line[5];
                data.First_Name = line[6];
                data.Last_Name = line[7];
                data.Attention_to = line[8];
                data.contact_Role = line[9];
                data.Contact_Number = line[10];
                data.Email = line[11];
                data.Password = line[12];
                result.put(line[2], data);
            }
            inputStream.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return result;
    }
    
    
    public static Map<String, SKU_Data> read1File() {
        Map<String, SKU_Data> result = new HashMap<>();

        try{
            Scanner inputStream = new Scanner(file1);

            if (inputStream.hasNext()) inputStream.next();

            while(inputStream.hasNext()){
                String[] line = inputStream.next().split(",");
                for (String string : line) {
					System.out.println(string);
				}
                SKU_Data data = new SKU_Data();
                data.Username = line[0];
                data.SKU_NO = line[1];
                data.SKU_Name = line[2];
                data.Resource_Type = line[3];
                data.Owner_Type = line[4];
                data.SKU_Description = line[5];
                data.JIT_Lead = line[6];
                data.Active_Type = line[7];
                data.Threshould_Level = line[8];
                data.Password = line[9];
                result.put(line[3], data);
            }
            inputStream.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return result;
    }
}