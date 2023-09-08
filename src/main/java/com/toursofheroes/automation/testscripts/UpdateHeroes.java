package com.toursofheroes.automation.testscripts;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class UpdateHeroes {
	WebDriver driver;
	
	@Test(description = "Verify able to launch Tours of Heroes site and move to Hero then validate its title", priority=1)
	public void UpdateHeroesSite() throws InterruptedException {
	this.driver = new ChromeDriver();
	this.driver.get("http://localhost:4200/");
	this.driver.manage().window().maximize();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/a[1]")).click();
	assertEquals(this.driver.getTitle(), "Tour of Heroes");
	}
	
	@Test(description = "Verify and Validate Update Hero Module Elements", priority=2)
	public void testUpdateHero() throws InterruptedException {
	
	//isDisplayed() method returns boolean value either True or False
	Boolean DashboardButtonDisplay = driver.findElement(By.xpath("/html/body/app-root/nav/a[1]")).isDisplayed();
	System.out.println("Dashboard button displayed is :"+ DashboardButtonDisplay);
	
	Boolean HeroesButtonDisplay = driver.findElement(By.xpath("/html/body/app-root/nav/a[2]")).isDisplayed();
	System.out.println("Heroes button displayed is :"+ HeroesButtonDisplay);
	Thread.sleep(4000);
		
	Boolean HeroNameDetails = driver.findElement(By.xpath("/html/body/app-root/app-hero-detail/div/h2")).isDisplayed();
	System.out.println("HeroName Details displayed is :"+ HeroNameDetails);
	
	Boolean HeroIdLabel = driver.findElement(By.xpath("/html/body/app-root/app-hero-detail/div/div[1]/span")).isDisplayed();
	System.out.println("HeroId Label displayed is :"+ HeroIdLabel);	

	Boolean HeroNameLabel = driver.findElement(By.xpath("/html/body/app-root/app-hero-detail/div/div[2]/label")).isDisplayed();
	System.out.println("HeroName Label displayed is :"+ HeroNameLabel);	

	Boolean HeroNameTextbox = driver.findElement(By.xpath("//*[@id=\"hero-name\"]")).isDisplayed();
	System.out.println("HeroName Textbox displayed is :"+ HeroNameTextbox);	
	
	Boolean GoBackButton = driver.findElement(By.xpath("/html/body/app-root/app-hero-detail/div/button[1]")).isDisplayed();
	System.out.println("Go Back Button displayed is :"+ GoBackButton);
	
	Boolean SaveButton = driver.findElement(By.xpath("/html/body/app-root/app-hero-detail/div/button[2]")).isDisplayed();
	System.out.println("Save Button displayed is :"+ SaveButton);
		
	Boolean MessagesLabel = driver.findElement(By.xpath("/html/body/app-root/app-messages/div/h2")).isDisplayed();
	System.out.println("Messages Label displayed is :"+ MessagesLabel);	
	
	Boolean ClearMessagesButton = driver.findElement(By.xpath("/html/body/app-root/app-messages/div/button")).isDisplayed();
	System.out.println("ClearMessages Button displayed is :"+ ClearMessagesButton);		
	
	Boolean ActionsHistory = driver.findElement(By.xpath("/html/body/app-root/app-messages/div/div[1]")).isDisplayed();
	System.out.println("Actions History displayed is :"+ ActionsHistory);
	
	}	
	
	@Test(description = "Verify and Validate Updating a Hero", priority=3)
	public void testUpdateHeroFeature() {
	try {	
	// Clear existing name and Type a new Hero name into Hero name Text box
	WebElement updateHeroName= driver.findElement(By.xpath("//*[@id=\"hero-name\"]"));
	updateHeroName.sendKeys(Keys.CONTROL + "a");
	updateHeroName.sendKeys(Keys.DELETE);
	updateHeroName.sendKeys("Steven");
		
	// Saving Hero by clicking on Save button
	WebElement saveHeroButton= driver.findElement(By.xpath("/html/body/app-root/app-hero-detail/div/button[2]"));
	saveHeroButton.click();
	System.out.println("Successfully updated Hero Name ...");

	// Going back to dashboard
	WebElement goBacktoDashboard= driver.findElement(By.xpath("/html/body/app-root/app-hero-detail/div/button[1]"));
	goBacktoDashboard.click();
	System.out.println("Back to Dashboard screen now ...");
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