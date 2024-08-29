package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage implements IConstants {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    public WebElement noPaymentModulesMessage;
}