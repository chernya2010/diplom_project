package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartModalWindow extends BasePage implements IConstants {

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']//span[contains(text(),'Оформить заказ')]")
    public WebElement placeAnOrderButton;

    public AddToCartModalWindow(WebDriver driver) {
        super(driver);
    }

    public CartPage clickPlaceAnOrderButtonOnModalWindow() throws InterruptedException {
        placeAnOrderButton.click();
        return new CartPage(driver);
    }
}
