package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailedPage extends BasePage implements IConstants {

    @FindBy(xpath = "//a[@id='wishlist_button']")
    public WebElement addToWishListButton;
    @FindBy(xpath = "//button[@name='Submit']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//a[@title='Close']")
    public WebElement closeInfoModalButton;
    @FindBy(xpath = "//*[@itemprop='name']")
    public WebElement productName;

    public ProductDetailedPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailedPage addToWishList(){
        addToWishListButton.click();
        closeInfoModalButton.click();
        return this;
    }

    public ProductDetailedPage addProductToCart(){
        addToCartButton.click();
        return this;
    }
}