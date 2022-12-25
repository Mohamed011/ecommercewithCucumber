package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login_Page;
import org.example.pages.Home_Page;
import org.testng.Assert;

import static Steps.Registr_Step.email;
import static Steps.Registr_Step.password;

public class ChangeCurency_Step extends Hooks {

    Login_Page loginPage;
    Home_Page homePage;
    String firstOption;
    @Given("user login to nop commerce")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("change current currency to another")
    public void changeCurrentCurrencyToAnother() {
        loginPage=new Login_Page(driver);
        homePage=new Home_Page(driver);
        loginPage.login(email,password);
        firstOption=homePage.getFirstCurrency();
        homePage.changeCurrency();
    }

    @Then("currency should changed correctly")
    public void currencyShouldChangedCorrectly() {
        Assert.assertNotEquals(firstOption,homePage.getFirstCurrency());
        tearDown();
    }
}
