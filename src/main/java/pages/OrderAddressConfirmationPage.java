package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderAddressConfirmationPage extends BasePage implements IConstants {

    public OrderAddressConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@name='processAddress']")
    public WebElement proceedToCheckoutButton;

    public OrderAddressConfirmationPage proceedChechout(){
        proceedToCheckoutButton.click();
        return this;
    }
}
