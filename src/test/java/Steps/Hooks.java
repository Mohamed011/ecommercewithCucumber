package Steps;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Hooks {

	// define main properties
	protected WebDriver driver;
	//FileInputStream readProperty;
	//public static Properties prop;

	// extend report
	// define extend report
	protected static ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/ExtentReportResults.html");
	protected static ExtentTest test = report.startTest("nopcommerce demo Project");
	private ChromeOptions options;
	protected JavascriptExecutor js;

	public void initialization(String browser){
//		readProperty = new FileInputStream(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\generalProperties.properties");
//		prop = new Properties();
//		prop.load(readProperty);
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		options.addArguments("--ignore-certificate-errors");
		// to run headless test
//		options.addArguments("--headless");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		if (browser.equalsIgnoreCase("Firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + prop.getProperty("firefoxdriver"));
			// use webdrivermanager
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + prop.getProperty("chromedriver"));
			// use web driver manager
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else {
			throw new IllegalArgumentException("Invalid browser value!!");
			// Change thread count 1 for sequential , 2 for parallel 3 ..browser..
		}

		js = (JavascriptExecutor) driver;
		// Set Driver wait
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	// Start nopcommerce demo Web Application

	public void startApplication(){
		// Maximize current window
		driver.manage().window().maximize();
		// navigate to website
		driver.get("https://demo.nopcommerce.com/");
		// take screenshot to Main page
		PageBase.captureScreenshot(driver, "MainPage");
		// assert if application start correctly
		PageBase.assertToObjectExistWithGetText(driver, "Log in");
		// extend report status
//		test.log(LogStatus.PASS, "Starting Application Successfully");
	}

	// tear down function
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
