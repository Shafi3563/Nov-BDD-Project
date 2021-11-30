package com.util.nov;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NovTestBase {
	
	// 1. Constructor for communicating with config file
	// 	  Apache POI gave - Fileinputstream class to read file
	//    properties - class 
	
	// 2. Will make driver as Global- public and 
	//    will make properties class object as global as well
	
	// 3. Browser init - method
	
	// 4. Will create method for launching browser
	public static WebDriver driver; // WebDriver made global
	public static Properties prop; // Properties class object made global
	
	public NovTestBase() { // Constructor for communicating with config file 
	try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "src\\test\\java\\com\\config\\nov\\ConfigNov.properties"); // / to be converted to \\ to tread files from directories.
		prop.load(fis); // Apache POI gave - Fileinputstream class to read file of ConfigNov.properties file
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); // The printStackTrace() method of Java Throwble class is used to print the Throwable along with other details like classname and line number where the exception occurred.
	} catch (IOException e) { // IOException is a type of checked exception which occurs during input/output operation. BufferedReader is used to read data from a file, input stream, database, etc. ... If all the lines are read then next some lines of the file are copied from secondary memory into the buffer.
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void initbrowser() {
		String browsername = prop.getProperty("browser1");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\dirver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(NovUtility.implicitlyWait_wait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(NovUtility.pageLoadTimeout_wait, TimeUnit.SECONDS);
				
		}
		else if(browsername.equals("FF")) { // intentionally doing negative testing
			
		}
		
	}
	
	public static void OpenApplicationss(String URL) {
		driver.get(prop.getProperty("url"));
		
	}
	
	// 90%
}

//Java try and catch
//
//The try statement allows you to define a block of 
//code to be tested for errors while it is being 
//executed. The catch statement allows you to define 
//a block of code to be executed, if an error occurs 
//in the try block.
