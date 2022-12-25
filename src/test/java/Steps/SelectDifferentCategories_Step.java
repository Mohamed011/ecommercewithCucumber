package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login_Page;
import org.example.pages.Home_Page;
import org.example.pages.Shoes_Page;
import org.example.pages.PageBase;
import org.testng.Assert;

import static Steps.Registr_Step.email;
import static Steps.Registr_Step.password;

public class SelectDifferentCategories_Step extends Hooks {

    Login_Page loginPage;
    Home_Page homePage;
    Shoes_Page shoesPage;
    @Given("user login to the app")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user select hover Computers categories and select Notebooks sub category")
    public void userSelectHoverComputersCategoriesAndSelectNotebooksSubCategory() {
        loginPage=new Login_Page(driver);
        homePage=new Home_Page(driver);
        shoesPage=new Shoes_Page(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
    }

    @Then("Notebooks page should start correctly")
    public void notebooksPageShouldStartCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Notebooks");
    }

    @And("user select hover Apparel categories and select Shoes sub category")
    public void userSelectHoverApparelCategoriesAndSelectShoesSubCategory() {
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
    }

    @Then("Shoes page should appear correctly")
    public void shoesPageShouldAppearCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Shoes");
        tearDown();
    }
}
