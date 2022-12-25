package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login_Page;
import org.example.pages.Home_Page;
import org.example.pages.Shoes_Page;
import org.example.pages.PageBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Steps.Registr_Step.email;
import static Steps.Registr_Step.password;

public class FilterWithColor_Step extends Hooks {

    Login_Page loginPage;
    Home_Page homePage;
    Shoes_Page shoesPage;
    @Given("user login to the application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }


    @When("user select subcategory and filter with specific color")
    public void userSelectSubcategoryAndFilterWithSpecificColor() {
        loginPage=new Login_Page(driver);
        homePage=new Home_Page(driver);
        shoesPage=new Shoes_Page(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        shoesPage.filterShoes();
    }

    @Then("filtered results should appear correctly")
    public void filteredResultsShouldAppearCorrectly() {
        List<WebElement> elements=driver.findElements(shoesPage.getAddToCardButton());
        Assert.assertNotEquals(elements.size(),0);
        tearDown();
    }
}
