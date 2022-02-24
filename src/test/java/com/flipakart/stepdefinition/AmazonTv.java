package com.flipakart.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTv {
     static WebDriver driver; 
@BeforeClass
public static void launch() {
	 System.out.println("launch method from before class");
     System.setProperty("webdriver.chrome.driver","C:\\Users\\Gowthaman\\eclipse-workspace\\SeleniumProject\\driver\\chromedriver.exe");
     driver = new ChromeDriver();
     driver.get("https://www.amazon.in/");
     driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
}

@AfterClass
public static void browserQui() {
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
	WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
	search.sendKeys("tv");
	WebElement enter = driver.findElement(By.xpath("//input[@type='submit']"));
	enter.click();
}
@Test
public void method2() throws InterruptedException {
	WebElement lg = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]"));
    lg.click();
    Thread.sleep(3000);
}
@Test
public void method3() throws IOException {
	TakesScreenshot t = (TakesScreenshot)driver;
      File source = t.getScreenshotAs(OutputType.FILE);
	  File target = new File("C:\\Users\\Gowthaman\\eclipse-workspace\\junit-flip\\target\\amz.png");
	  FileUtils.copyFile(source, target);
}
}




