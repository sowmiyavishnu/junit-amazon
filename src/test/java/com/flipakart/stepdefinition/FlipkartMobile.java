package com.flipakart.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartMobile {
	
     @BeforeClass
  public static void launch() {
    	 System.out.println("launch method from before class");
		
	}
	
	@AfterClass
   public static void browserQuit() {
		System.out.println("browser quit from after class");
	}

	@Before
	public void beforeMethod() {
	System.out.println("before method");
	}
	
	@After
	public void afterMethod() {
		System.out.println("after method");
	}
	@Test
	public void method1() {
		System.out.println("login method -1");

	}
	@Test
	public void method2() {
		System.out.println("mobile search method -2");
	}
	@Test
	public void method3() {
		System.out.println("mobile purchase method -3");
	}
	@Test
	public void method4() {
		System.out.println("screenShot method -4");
	}	
	}

