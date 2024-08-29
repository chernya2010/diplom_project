import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.LoginSteps;
import steps.RegistrationSteps;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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
    RegistrationSteps registrationSteps;
    WomanModalWindow womanModalWindow;
    TShirtsPage tShirtsPage;
    ContactUsPage contactUsPage;
    AddressPage addressPage;
    OrderAddressConfirmationPage orderAddressConfirmationPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;

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
        orderAddressConfirmationPage = new OrderAddressConfirmationPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    public void initSteps(){
        loginSteps = new LoginSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
    }

    @BeforeMethod
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disk-cache-size=0");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        initPages();
        initSteps();
    }

    @AfterMethod(enabled = false)
    public void endTest(){
        driver.close();
    }
}