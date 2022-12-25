package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class Register_Page {
    WebDriver driver;

    public Register_Page(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    public By registerTap= RelativeLocator.with(By.xpath("//a[@class='ico-register']"));



    final private By gender=RelativeLocator.with(By.xpath("(//input[@type='radio'])[1]"));

    final private By firstName=RelativeLocator.with(By.xpath("//input[@name='FirstName']"));

    final private By lastName=RelativeLocator.with(By.xpath("//input[@name='LastName']"));

    public By continueButton=RelativeLocator.with(By.xpath("//a[@class='button-1 register-continue-button']"));

    final private By dayOfBirth=RelativeLocator.with(By.xpath("//select[@name='DateOfBirthDay']"));

    final private By monthOfBirth=RelativeLocator.with(By.xpath("//select[@name='DateOfBirthMonth']"));


    final private By yearOfBirth=RelativeLocator.with(By.xpath("//select[@name='DateOfBirthYear']"));


    final private By email=RelativeLocator.with(By.xpath("//input[@type='email']"));


    final private By company=RelativeLocator.with(By.xpath("//input[@name='Company']"));


    final private By password=RelativeLocator.with(By.xpath("(//input[@type='password'])[1]"));


    final private By confirmPassword=RelativeLocator.with(By.xpath("(//input[@type='password'])[2]"));


    final private By registerButton=RelativeLocator.with(By.xpath("(//button[@type='submit'])[2]"));

    public void registerNewUser(
            String fname,
            String lname,
            String useerEmail,
            String companyName,
            String userPassword){
        // TODO: add new user
        // fill user data
        driver.findElement(gender).click();
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);

        Select select=new Select(driver.findElement(dayOfBirth));
        select.selectByIndex(1);
        select=new Select(driver.findElement(monthOfBirth));
        select.selectByIndex(1);
        select=new Select(driver.findElement(yearOfBirth));
        select.selectByIndex(1);

        driver.findElement(email).sendKeys(useerEmail);
        driver.findElement(company).sendKeys(companyName);

        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(confirmPassword).sendKeys(userPassword);

        driver.findElement(registerButton).click();
    }

}
