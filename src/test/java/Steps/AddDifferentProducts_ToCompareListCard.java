package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.testng.Assert;

import static Steps.Registr_Step.email;
import static Steps.Registr_Step.password;

public class AddDifferentProducts_ToCompareListCard extends Hooks {
    Login_Page loginPage;
    Home_Page homePage;
    Shoes_Page shoesPage;
    Notebook_Page notebookPage;
    @Given("user login Successfully")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user add one product from Notebooks in computer category to Compare List")
    public void userAddOneProductFromNotebooksInComputerCategoryToShoppingCard() throws InterruptedException {
        loginPage=new Login_Page(driver);
        homePage=new Home_Page(driver);
        notebookPage=new Notebook_Page(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
        driver.findElements(notebookPage.getAddToCompareList()).get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(notebookPage.getConfirmationMessage(),"The product has been added to your product comparison");
    }

    @And("user add one product from Shoes in Apparel category to Compare List")
    public void userAddOneProductFromShoesInApparelCategoryToShoppingCard() throws InterruptedException {
        shoesPage=new Shoes_Page(driver);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        driver.findElements(shoesPage.getAddToCompareList()).get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(shoesPage.getConfirmationMessage(),"The product has been added to your product comparison");
    }

    @Then("the selected two products should added and appear correctly")
    public void theSelectedTwoProductsShouldAddedAndAppearCorrectlyInShoppingCard() {
        Assert.assertEquals(homePage.getShoppingCardAmount(),"(3)");
        Assert.assertEquals(homePage.getWhiteListAmount(),"(3)");
        tearDown();
    }
}
