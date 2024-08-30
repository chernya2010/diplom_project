package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.BasePageSteps;
import steps.LoginSteps;
import steps.MyAccountSteps;
import steps.RegistrationSteps;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;

    BasePage basePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    CartPage cartPage;
    AddToCartModalWindow addToCartModalWindow;
    ProductDetailedPage productDetailedPage;
    WishListPage wishListPage;
    MyAccountPage myAccountPage;
    LoginSteps loginSteps;
    BasePageSteps basePageSteps;
    MyAccountSteps myAccountSteps;
    RegistrationSteps registrationSteps;
    WomanModalWindow womanModalWindow;
    TShirtsPage tShirtsPage;
    ContactUsPage contactUsPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;

    /**
     * Init pages.
     */
    public void initPages(){
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        cartPage = new CartPage(driver);
        productDetailedPage = new ProductDetailedPage(driver);
        wishListPage = new WishListPage(driver);
        myAccountPage = new MyAccountPage(driver);
        addToCartModalWindow = new AddToCartModalWindow(driver);
        womanModalWindow = new WomanModalWindow(driver);
        tShirtsPage = new TShirtsPage(driver);
        contactUsPage = new ContactUsPage(driver);
        addressPage = new AddressPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    /**
     * Init steps.
     */
    public void initSteps(){
        loginSteps = new LoginSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        basePageSteps = new BasePageSteps(driver);
        myAccountSteps = new MyAccountSteps(driver);
    }

    /**
     * Init test.
     *
     * @param iTestContext the test context
     */
    @BeforeMethod
    public void initTest(ITestContext iTestContext) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disk-cache-size=0");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("intl.accept_languages", "ru-RU");
//        FirefoxOptions options = new FirefoxOptions();
//        options.setProfile(profile);
//        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        initPages();
        initSteps();
        iTestContext.setAttribute("driver", driver);
    }

    /**
     * End test.
     */
    @AfterMethod(enabled = true)
    public void endTest(){
        driver.close();
    }
}