package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AddToCartModalWindow extends BasePage implements IConstants {

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']//span[contains(text(),'Оформить заказ')]")
    public WebElement placeAnOrderButton;

    /**
     * Instantiates a new Add to cart modal window.
     *
     * @param driver the driver
     */
    public AddToCartModalWindow(WebDriver driver) {
        super(driver);
    }

    /**
     * Click place an order button on modal window cart page.
     *
     * @return the cart page
     */
    public CartPage clickPlaceAnOrderButtonOnModalWindow() {
        log.info("Click on 'Place an order' button");
        placeAnOrderButton.click();
        return new CartPage(driver);
    }
}