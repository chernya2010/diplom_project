package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ShippingPage extends BasePage implements IConstants {

    /**
     * Instantiates a new Shipping page.
     *
     * @param driver the driver
     */
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@name='processCarrier']")
    public WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//*[@id='cgv']")
    public WebElement termsOfServiceCheckBox;

    /**
     * Proceed chechout shipping page.
     *
     * @return the shipping page
     */
    public ShippingPage proceedChechout() {
        log.info("Activate 'Terms of Service' checkbox");
        termsOfServiceCheckBox.click();
        log.info("Click 'Proceed to checkout' button");
        proceedToCheckoutButton.click();
        return this;
    }
}