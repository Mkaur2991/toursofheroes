package com.toursofheroes.automation.testscripts;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AddHeroes {
	WebDriver driver;
	
	@Test(description = "Verify able to launch Tours of Heroes site and move to Heros module then validate its title", priority=1)
	public void AddHeroesSite() {
	this.driver = new ChromeDriver();
	this.driver.get("http://localhost:4200/");	
	this.driver.manage().window().maximize();
	driver.findElement(By.xpath("/html/body/app-root/nav/a[2]")).click();
	assertEquals(this.driver.getTitle(), "Tour of Heroes");
	}
	
	@Test(description = "Verify and Validate Add Heroes Module Elements", priority=2)
	public void testAddHeroesElements() throws InterruptedException {
	try {
	//isDisplayed() method returns boolean value either True or False
	Boolean DashboardButtonDisplay = driver.findElement(By.xpath("/html/body/app-root/nav/a[1]")).isDisplayed();
	System.out.println("Dashboard button displayed is :"+ DashboardButtonDisplay);
	
	Boolean HeroesButtonDisplay = driver.findElement(By.xpath("/html/body/app-root/nav/a[2]")).isDisplayed();
	System.out.println("Heroes button displayed is :"+ HeroesButtonDisplay);
	
	Boolean MyHeroesLabel = driver.findElement(By.xpath("/html/body/app-root/app-heroes/h2")).isDisplayed();
	System.out.println("My Heroes Label displayed is :"+ MyHeroesLabel);
	
	Boolean HeroNameLabel = driver.findElement(By.xpath("/html/body/app-root/app-heroes/div/label")).isDisplayed();
	System.out.println("HeroName Label displayed is :"+ HeroNameLabel);
	
	Boolean HeroNameTextBox = driver.findElement(By.xpath("//*[@id=\"new-hero\"]")).isDisplayed();
	System.out.println("HeroName Textbox displayed is :"+ HeroNameTextBox);	

	Boolean AddHeroButton = driver.findElement(By.xpath("/html/body/app-root/app-heroes/div/button")).isDisplayed();
	System.out.println("Add Hero Button displayed is :"+ AddHeroButton);
	
	Thread.sleep(3000);
	
	Boolean ListOfHeroes1 = driver.findElement(By.xpath("/html/body/app-root/app-heroes/ul/li[1]/a")).isDisplayed();
	System.out.println("List Of Heroes1 displayed is :"+ ListOfHeroes1);
	
	Boolean ListOfHeroes2 = driver.findElement(By.xpath("/html/body/app-root/app-heroes/ul/li[2]/a")).isDisplayed();
	System.out.println("List Of Heroes2 displayed is :"+ ListOfHeroes2);
	
	Boolean DeleteHeroButton1 = driver.findElement(By.xpath("/html/body/app-root/app-heroes/ul/li[1]/button")).isDisplayed();
	System.out.println("Delete Hero1 Button displayed is :"+ DeleteHeroButton1);	

	Boolean DeleteHeroButton2 = driver.findElement(By.xpath("/html/body/app-root/app-heroes/ul/li[2]/button")).isDisplayed();
	System.out.println("Delete Hero2 Button displayed is :"+ DeleteHeroButton2);	
	
	Boolean MessagesLabel = driver.findElement(By.xpath("/html/body/app-root/app-messages/div/h2")).isDisplayed();
	System.out.println("Messages Label displayed is :"+ MessagesLabel);	
	
	Boolean ClearMessagesButton = driver.findElement(By.xpath("/html/body/app-root/app-messages/div/button")).isDisplayed();
	System.out.println("ClearMessages Button displayed is :"+ ClearMessagesButton);		
	
	Boolean ActionsHistory = driver.findElement(By.xpath("/html/body/app-root/app-messages/div/div[1]")).isDisplayed();
	System.out.println("Actions History displayed is :"+ ActionsHistory);
	}	
	catch (Exception e) {
		System.out.println(e.getStackTrace());
	}	
	}	
	

	@Test(description = "Verify and Validate Adding of Hero", priority=3)
	public void testAddHeroFeature() throws InterruptedException {
	try {	
	// Type Hero name into Hero name Text box
	WebElement addHeroText= driver.findElement(By.xpath("//*[@id=\"new-hero\"]"));
	addHeroText.sendKeys("Albert");
		
	// Adding Hero by clicking on Add Hero button
	WebElement addHeroButton= driver.findElement(By.xpath("/html/body/app-root/app-heroes/div/button"));
	addHeroButton.click();
	System.out.println("Successfully added a New Hero to the List ...");

	// Deleting a Hero by clicking on Delete Cross button
	WebElement deleteHeroFromList= driver.findElement(By.xpath("/html/body/app-root/app-heroes/ul/li[1]/button"));
	deleteHeroFromList.click();
	Thread.sleep(3000);
	System.out.println("Deleted a Top Hero from List");
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