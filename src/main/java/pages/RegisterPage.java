package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waiters.WaitUntilElementIsVisible.waitUntilElementIsVisible;

@Log4j2
public class RegisterPage extends BasePage implements IConstants {

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement createAccountEmailInput;
    @FindBy(xpath = "//button[@id='SubmitCreate']")
    public WebElement createAnAccountButton;
    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement selectTitle;
    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement passwordInput;
    @FindBy(xpath = "//select[@id='days']")
    public WebElement selectDay;
    @FindBy(xpath = "//select[@id='months']")
    public WebElement selectMonth;
    @FindBy(xpath = "//*[@id='cuselFrame-years']")
    public WebElement selectYear;
    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement registerButton;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement successfulRegistrationMessageText;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage(String url) {
        log.info("Open {} page", url);
        driver.get(url);
        return new LoginPage(driver);
    }

    public void registerNewAccount(String email, String firstname, String lastname, String password, String day, String month, String year) {
        log.info("Fill registration form");
        createAccountEmailInput.sendKeys(email);
        createAnAccountButton.click();
        waitUntilElementIsVisible(driver, registerButton);
        selectTitle.click();
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        passwordInput.sendKeys(password);
        selectDay.sendKeys(day);
        selectMonth.sendKeys(month);
        selectYear.click();
        WebElement year1989 = driver.findElement(By.xpath("//span[@val='" + year + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", year1989);
        year1989.click();
        log.info("Click 'Register' button");
        registerButton.click();
    }
}