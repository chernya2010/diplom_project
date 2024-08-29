package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage implements IConstants {

    /**
     * Instantiates a new Login page.
     *
     * @param driver the driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    public WebElement signInButton;
    @FindBy(xpath = "//p[@class='info-account']")
    public WebElement successfulLoginMessageText;

    @Override
    public LoginPage openPage(String url) {
        log.info("Open {} page", url);
        driver.get(url);
        return this;
    }

    /**
     * Login login page.
     *
     * @param email    the email
     * @param password the password
     * @return the login page
     */
    public LoginPage login(String email, String password) {
        log.info("Login with email: {}", email);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        log.info("Click 'Sign in' button");
        signInButton.click();
        return this;
    }
}