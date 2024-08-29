package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ProductDetailedPage extends BasePage implements IConstants {

    @FindBy(xpath = "//a[@id='wishlist_button']")
    public WebElement addToWishListButton;
    @FindBy(xpath = "//button[@name='Submit']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//a[@title='Close']")
    public WebElement closeInfoModalButton;
    @FindBy(xpath = "//*[@itemprop='name']")
    public WebElement productName;

    /**
     * Instantiates a new Product detailed page.
     *
     * @param driver the driver
     */
    public ProductDetailedPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Add to wish list product detailed page.
     *
     * @return the product detailed page
     */
    public ProductDetailedPage addToWishList() {
        log.info("Click 'Add to wishlist' button");
        addToWishListButton.click();
        log.info("Click 'Close modal window' button");
        closeInfoModalButton.click();
        return this;
    }

    /**
     * Add product to cart product detailed page.
     *
     * @return the product detailed page
     */
    public ProductDetailedPage addProductToCart() {
        log.info("Click 'Add to cart' button");
        addToCartButton.click();
        return this;
    }
}