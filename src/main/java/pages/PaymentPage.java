package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class PaymentPage extends BasePage implements IConstants {

    /**
     * Instantiates a new Payment page.
     *
     * @param driver the driver
     */
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    public WebElement noPaymentModulesMessage;
}