package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Login_Page {
	
	WebDriver driver;
	
	public Login_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public By loginTap= RelativeLocator.with(By.xpath("//a[@class='ico-login']"));
	
 	final private By email=RelativeLocator.with(By.xpath("//input[@type='email']"));
	

	final private By password=RelativeLocator.with(By.xpath("//input[@type='password']"));


	final private By rememberMe=RelativeLocator.with(By.xpath("//input[@type='checkbox']"));



	final private By loginButton=RelativeLocator.with(By.xpath("(//button[@type='submit'])[2]"));


	final private By forgetPassword=RelativeLocator.with(By.xpath("//a[text()='Forgot password?']"));


	final private By recoverButton=RelativeLocator.with(By.xpath("//button[@name='send-email']"));



	final private By recoverConfirmationMessage=RelativeLocator.with(By.xpath("//p[@class='content']"));

	//TODO: Login to Application
	public void login(String email,String password)
	{
		// choose login tap from home page
		driver.findElement(loginTap).click();
		// add email and password
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(rememberMe).click();
		// click login button
		driver.findElement(loginButton).click();
	}
	// to set new password
	public void setPassword(String email){
		driver.findElement(forgetPassword).click();
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(recoverButton).click();
	}

	public String getRecoverPasswordMessage() {
		return driver.findElement(recoverConfirmationMessage).getText();
	}
}
