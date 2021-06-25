package com.sc.sym.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WrapperElements {
	
	public static Properties properties;
	public static Properties elementIDs;
	
	static {
		properties = new Properties();
		elementIDs = new Properties();
		
		try {
			FileInputStream objfile = new FileInputStream("src/test/resources/configs/Objects.properties");		
			properties.load(objfile);
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
		try {
			FileInputStream idsFile = new FileInputStream("src/test/resources/configs/ElementIds.properties");		
			elementIDs.load(idsFile);
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
		
}
