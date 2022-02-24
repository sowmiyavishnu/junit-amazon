package com.flipakart.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkartmobiletask {
	static WebDriver driver;
	static long startTime;
	  @BeforeClass
	  public static void launch() {
	    	 System.out.println("launch method from before class");
	    	// WebDriverManager.chromedriver().setup();
	 		System.setProperty("webdriver.chrome.driver","C:\\Users\\Gowthaman\\eclipse-workspace\\SeleniumProject\\driver\\chromedriver.exe");
	 	  driver = new ChromeDriver();
	 		driver.get("https://www.flipkart.com/");
	 		driver.manage().window().maximize();
	 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 		 
		}
		
		@AfterClass
	   public static void browserQuit() {
	    System.out.println("browser quit from after class");
		driver.quit();
			
		}

		@Before
		public void beforeMethod() {
		System.out.println("before method");
		long startTime = System.currentTimeMillis();
		}
		
		@After
		public void afterMethod() {
			System.out.println("after method");
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken is : endTime - startTime");
		}
		@Test
		public void method1() {
			System.out.println("login method -1");
			WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
	 	    close.click();
			

		}
		@Test
		public void method2() throws InterruptedException, AWTException {
			System.out.println("mobile search method -2");
		//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 		WebElement search = driver.findElement(By.xpath("//*[contains(@placeholder,'Search for products, brands')]"));
	     	search.sendKeys("realme");
	     	Thread.sleep(2000);
	     	driver.findElement(By.xpath("//*[@type='submit']")).click();
//	     	Robot r = new Robot();
//	     	r.keyPress(KeyEvent.VK_ENTER);
//	     	r.keyRelease(KeyEvent.VK_ENTER);
	     	Thread.sleep(3000);
		   WebElement mobileName = driver.findElement(By.xpath("(//*[contains(text(),'realme ')])[1]"));
			mobileName.click();
		}
		@Test
		public void method3() {
			System.out.println("mobile purchase method -3");
			String parent = driver.getWindowHandle();
			Set<String> child = driver.getWindowHandles();
            for(String x : child)
            {
            	if(!x.equals(child))
            	{
            		driver.switchTo().window(x);
            	}
            		
            }
		}
		@Test
		public void method4() throws IOException {
			System.out.println("screenShot method -4");
			TakesScreenshot t =(TakesScreenshot)driver;
		    File source = t.getScreenshotAs(OutputType.FILE);
		    File target = new File("C:\\Users\\Gowthaman\\eclipse-workspace\\junit-flip\\target\\fl.png");
		    FileUtils.copyFile(source, target);
		}	
		
    	@Test
		public void method5() throws Exception {
			File f = new File("C:\\Users\\Gowthaman\\Desktop\\Flipkart.xlsx");
			FileInputStream f1 = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(f1);
			Sheet s = w.getSheet("flip");
			Row r = s.getRow(1);
	        Cell c = r.getCell(1);
	        System.out.println(c);
		}
		}
		
		
		
		
		
		
		
		
		
     



