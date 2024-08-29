package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage implements IConstants {

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

    public LoginPage openPage(String url){
        driver.get(url);
        return this;
    }

    public LoginPage login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
        return this;
    }
}