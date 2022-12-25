package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class Home_Page {

    WebDriver driver;
    public Home_Page(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    final private By searchBox= RelativeLocator.with(By.xpath("//input[@name='q']"));


    final private By searchButton=RelativeLocator.with(By.xpath("//button[@class='button-1 search-box-button']"));


    final private By searchResult=RelativeLocator.with(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]"));


    final private By computersProducts=RelativeLocator.with(By.xpath("//a[@href='/computers']"));


    final private By notebooksProducts=RelativeLocator.with(By.xpath("//a[@href='/notebooks']"));



    final private By apparelProducts=RelativeLocator.with(By.xpath("//a[@href='/apparel']"));


     final private By shoesProducts=RelativeLocator.with(By.xpath("//a[@href='/shoes']"));


    final private By currecny=RelativeLocator.with(By.id("customerCurrency"));



    final private By productPageHeader=RelativeLocator.with(By.xpath("(//h1)[1]"));


    final private By shoppingCard=RelativeLocator.with(By.xpath("//span[@class='cart-qty']"));


    final private By wishList=RelativeLocator.with(By.xpath("//span[@class='wishlist-qty']"));



    final private By goToCardButton=RelativeLocator.with(By.xpath("//button[text()='Go to cart']"));

    final private By logout=RelativeLocator.with(By.xpath("//a[text()='Log out']"));

    public void clickGoToCardButton(){driver.findElement(goToCardButton).click();}

    public WebElement getShoppingCard(){return driver.findElement(shoppingCard);}

    public String getWhiteListAmount(){return driver.findElement(wishList).getText();}

    public String getShoppingCardAmount(){return driver.findElement(shoppingCard).getText();}

    public void selectComputerProduct(){
        driver.findElement(notebooksProducts).click();
    }

    public WebElement ComputerProductsTap(){
        return driver.findElement(computersProducts);
    }

    public WebElement apparelProductsTap(){
        return driver.findElement(apparelProducts);
    }

    public void selectApparelProduct(){
        driver.findElement(shoesProducts).click();
    }

    public String getProductPageHeader(){
        return driver.findElement(productPageHeader).getText();
    }

    public void changeCurrency(){

        Select select=new Select(driver.findElement(currecny));

        select.selectByIndex(1);

    }

    public String getFirstCurrency(){

        Select select=new Select(driver.findElement(currecny));

        return select.getFirstSelectedOption().getText();

    }

    public void searchProducts(){

        driver.findElement(searchBox).sendKeys("MacBook");
        driver.findElement(searchButton).click();

    }

    public void logout(){driver.findElement(logout).click();}

    public boolean checkSearchResult(){
       return driver.findElement(searchResult).getText().equals("Add to cart");
    }

}

