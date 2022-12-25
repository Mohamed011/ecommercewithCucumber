package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login_Page;
import org.example.pages.Home_Page;
import org.example.pages.PageBase;
import org.testng.Assert;

import static Steps.Registr_Step.email;
import static Steps.Registr_Step.password;

public class HoverAndSelect_Step extends Hooks {
    Login_Page loginPage;
    Home_Page homePage;
    @Given("user login to Application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("Hover over any category and select subcategory")
    public void hoverOverAnyCategoryAndSelectSubcategory() {
        loginPage=new Login_Page(driver);
        homePage=new Home_Page(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
    }

    @Then("the sub category page should appear correctly")
    public void theSubCategoryPageShouldAppearCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Notebooks");
        tearDown();
    }
}
