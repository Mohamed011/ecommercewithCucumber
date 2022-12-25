package Steps;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login_Page;
import org.example.pages.Home_Page;

import static Steps.Registr_Step.email;
import static Steps.Registr_Step.password;

public class CheckSearch_Step extends Hooks {

    Login_Page loginPage;
    Home_Page homePage;

    @Given("user login to nop commerce web application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("search for product")
    public void searchForProduct() {
        loginPage=new Login_Page(driver);
        homePage=new Home_Page(driver);
        loginPage.login(email,password);
        homePage.searchProducts();

    }

    @Then("results should appear correctly")
    public void resultsShouldAppearCorrectly(){
        homePage.checkSearchResult();
        // extend report status
        test.log(LogStatus.PASS, "Searching Work Correctly");
        tearDown();
//        PageBase.startHtmlReport(System.getProperty("user.dir")+"/target/HtmlReports","report.html");
    }
}
