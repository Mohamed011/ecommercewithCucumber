package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;

import java.io.IOException;

import static Steps.Registr_Step.email;
import static Steps.Registr_Step.password;

public class CreateSuccess_fulOrder extends Hooks {

    Login_Page loginPage;
    Home_Page homePage;
    CheckOut_Page checkOutPage;
    @Given("user login Successfully to Nop Commerce App")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user click go to card button and complete checkout")
    public void userClickGoToCardButtonAndCompleteCheckout() throws InterruptedException {
        loginPage=new Login_Page(driver);
        homePage=new Home_Page(driver);
        checkOutPage=new CheckOut_Page(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.getShoppingCard());
        homePage.clickGoToCardButton();
        checkOutPage.checkTermsOfService();
        checkOutPage.ClickCheckoutButton();
        // fill billing address form
        checkOutPage.fillBillingAddress();
        Thread.sleep(2000);
        // choose shipping method
        checkOutPage.chooseShippingMethod();
        Thread.sleep(2000);
        // choose payment method
        checkOutPage.choosePaymentMethod();
        Thread.sleep(2000);
        // fill payment information
        checkOutPage.fillPaymentInformation();
        Thread.sleep(2000);
        // complete payment
        checkOutPage.confirmPayment();
    }

    @Then("order should created successfully")
    public void orderShouldCreatedSuccessfully() throws IOException {
        homePage.logout();
        tearDown();
        PageBase.startHtmlReport(System.getProperty("user.dir")+"/target/HtmlReports","report.html");
    }
}
