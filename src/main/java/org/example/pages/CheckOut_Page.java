package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;


public class CheckOut_Page {

    WebDriver driver;
    public CheckOut_Page(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    final private By termsOfService= RelativeLocator.with(By.id("termsofservice"));


    final private By checkout=RelativeLocator.with(By.id("checkout"));

    // Billing address WebElements
    final private By country=RelativeLocator.with(By.xpath("//select[@data-trigger='country-select']"));

    final private By state=RelativeLocator.with(By.xpath("//select[@data-trigger='state-select']"));

    final private By city=RelativeLocator.with(By.id("BillingNewAddress_City"));

    final private By address1=RelativeLocator.with(By.id("BillingNewAddress_Address1"));

    final private By address2=RelativeLocator.with(By.id("BillingNewAddress_Address2"));

    final private By zipCode=RelativeLocator.with(By.id("BillingNewAddress_ZipPostalCode"));

    final private By phoneNumber=RelativeLocator.with(By.id("BillingNewAddress_PhoneNumber"));

    final private By faxNumber=RelativeLocator.with(By.id("BillingNewAddress_FaxNumber"));

    final private By continueButton=RelativeLocator.with(By.xpath("//button[text()='Continue']"));

    //Shipping Method WebElements


    final private By shippingMethod=RelativeLocator.with(By.id("shippingoption_2"));

    //payment method

    final private By paymentMethod=RelativeLocator.with(By.id("paymentmethod_1"));
    // payment information

    final private By creditCard=RelativeLocator.with(By.id("CreditCardType"));

    final private By cardHolderName=RelativeLocator.with(By.id("CardholderName"));

    final private By cardNumber=RelativeLocator.with(By.id("CardNumber"));

    final private By expireMonth=RelativeLocator.with(By.id("ExpireMonth"));

    final private By expireYear=RelativeLocator.with(By.id("ExpireYear"));

    final private By cardCode=RelativeLocator.with(By.id("CardCode"));

    //complete payment
        final private By confirmButton=RelativeLocator.with(By.xpath("//button[text()='Confirm']"));

    public void ClickCheckoutButton(){driver.findElement(checkout).click();}

    public void checkTermsOfService(){driver.findElement(termsOfService).click();}

    public void fillBillingAddress() throws InterruptedException {
        Select select=new Select(driver.findElement(country));
        select.selectByIndex(1);
        Thread.sleep(2000);
        select=new Select(driver.findElement(state));
        select.selectByIndex(1);
        driver.findElement(city).sendKeys(PageBase.generateString(5));
        driver.findElement(address1).sendKeys(PageBase.generateString(5));
        driver.findElement(address2).sendKeys(PageBase.generateString(5));
        driver.findElement(zipCode).sendKeys(PageBase.generateString(5));
        driver.findElement(phoneNumber).sendKeys(PageBase.generateString(5));
        driver.findElement(faxNumber).sendKeys(PageBase.generateString(5));
        driver.findElement(continueButton).click();
    }
    public void chooseShippingMethod()
    {
        driver.findElement(shippingMethod).click();
        driver.findElement(By.xpath("(//button[text()='Continue'])[3]")).click();
    }


    public void choosePaymentMethod()
    {
        driver.findElement(paymentMethod).click();
        driver.findElement(By.xpath("(//button[text()='Continue'])[4]")).click();
    }
    public void fillPaymentInformation()
    {
        Select select=new Select(driver.findElement(creditCard));
        select.selectByIndex(1);
        driver.findElement(cardHolderName).sendKeys(PageBase.generateString(5)+" "+PageBase.generateString(5));
        driver.findElement(cardNumber).sendKeys("4485593446805921");
        select=new Select(driver.findElement(expireMonth));
        select.selectByIndex(8);
        select=new Select(driver.findElement(expireYear));
        select.selectByIndex(5);
        driver.findElement(cardCode).sendKeys("0123");
        driver.findElement(By.xpath("(//button[text()='Continue'])[5]")).click();
    }
    public void confirmPayment(){
        driver.findElement(confirmButton).click();
    }
}
