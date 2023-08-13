package com.stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefinitionLogin {
	
	WebDriver driver;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		System.out.println("Step1: user is on login page");
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
	}

	@When("the user enters valid username {string} and valid password {string}")
	public void the_user_enters_valid_username_and_valid_password(String string, String string2) {
		System.out.println("Step2: User enter username and password");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	 
	}

	@And("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
		System.out.println("Step3: User click on login btn");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
		//Alert alert = driver.switchTo().alert();
		// alert.accept();
		System.out.println("Step4: User can see the tile of new page");
		String exp=driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
		Assert.assertEquals(exp, "Swag Labs");
	}

}
