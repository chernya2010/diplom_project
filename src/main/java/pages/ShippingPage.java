package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends BasePage implements IConstants {

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@name='processCarrier']")
    public WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//*[@id='cgv']")
    public WebElement termsOfServiceCheckBox;

    public ShippingPage proceedChechout(){
        termsOfServiceCheckBox.click();
        proceedToCheckoutButton.click();
        return this;
    }
}
