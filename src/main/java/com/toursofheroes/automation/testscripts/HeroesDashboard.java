package com.toursofheroes.automation.testscripts;


import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HeroesDashboard {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(description = "Verify able to launch Tours of Heroes site and validate its title", priority=1)
	public void testHeroesSite() {
	this.driver = new ChromeDriver();
	this.driver.get("http://localhost:4200/");	 
	this.driver.manage().window().maximize();
	assertEquals(this.driver.getTitle(), "Tour of Heroes");
	}
	
	@Test(description = "Verify and Validate Tours of Heroes Dashboard Elements", priority=2)
	public void testHeroesDashboard() throws InterruptedException {
	try {
	//isDisplayed() method returns boolean value either True or False
	Boolean DashboardButtonDisplay = driver.findElement(By.xpath("/html/body/app-root/nav/a[1]")).isDisplayed();
	System.out.println("Dashboard button displayed is :"+ DashboardButtonDisplay);
	
	Boolean HeroesButtonDisplay = driver.findElement(By.xpath("/html/body/app-root/nav/a[2]")).isDisplayed();
	System.out.println("Heroes button displayed is :"+ HeroesButtonDisplay);
	
	Boolean TopHeroeslabel = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/h2")).isDisplayed();
	System.out.println("Top Heroes section displayed is :"+ TopHeroeslabel);
	Thread.sleep(3000);

	Boolean TopHero1 = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/a[1]")).isDisplayed();
	System.out.println("Top Hero1 displayed is :"+ TopHero1);
	
	Boolean TopHero2 = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/a[2]")).isDisplayed();
	System.out.println("Top Hero2 displayed is :"+ TopHero2);
	
	Boolean TopHero3 = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/a[3]")).isDisplayed();
	System.out.println("Top Hero3 displayed is :"+ TopHero3);
	
	Boolean TopHero4 = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/a[4]")).isDisplayed();
	System.out.println("Top Hero4 displayed is :"+ TopHero4);	

	Boolean HeroSearchLabel = driver.findElement(By.xpath("//*[@id=\"search-component\"]/label")).isDisplayed();
	System.out.println("HeroSearch Label displayed is :"+ HeroSearchLabel);	
	
	Boolean HeroSearchTextbox = driver.findElement(By.id("search-box")).isDisplayed();
	System.out.println("HeroSearch Textbox displayed is :"+ HeroSearchTextbox);	
	
	Boolean MessagesLabel = driver.findElement(By.xpath("/html/body/app-root/app-messages/div/h2")).isDisplayed();
	System.out.println("Messages Label displayed is :"+ MessagesLabel);	
	
	Boolean ClearMessagesButton = driver.findElement(By.xpath("/html/body/app-root/app-messages/div/button")).isDisplayed();
	System.out.println("ClearMessages Button displayed is :"+ ClearMessagesButton);		
	}	
	catch (Exception e) {
		System.out.println(e.getStackTrace());
	}
	}	
	
	@Test(description = "Verify and Validate Searching a Hero at Dashboard", priority=3)
	public void testSearchHeroFeature() throws InterruptedException {
		
	// Type Hero name into Text box
	WebElement typeHeroName= driver.findElement(By.id("search-box"));
	typeHeroName.sendKeys("Rubber");
	Thread.sleep(3000);	
	selectOptionWithText("RubberMan");
	}
	public void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.id("search-box"));
			wait.until(ExpectedConditions.visibilityOf(autoOptions));
			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
		
	 
	@AfterTest(alwaysRun = true)
	public void tearDown() {
	this.driver.quit();
	}
}