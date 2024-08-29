package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waiters.WaitUntilElementIsVisible.waitUntilElementIsVisible;

@Log4j2
public class WishListPage extends BasePage implements IConstants {

    @FindBy(xpath = "//a[contains(text(),'Мой лист пожеланий')]")
    public WebElement openWishListButton;
    @FindBy(xpath = "//p[@id='s_title']")
    public WebElement productNameFromWishList;
    @FindBy(xpath = "//input[@id='quantity_1_1']")
    public WebElement productCountInWishList;

    /**
     * Instantiates a new Wish list page.
     *
     * @param driver the driver
     */
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WishListPage openPage(String url) {
        log.info("Open {} page", url);
        driver.get(url);
        return this;
    }

    /**
     * Open wish list tails.
     */
    public void openWishListTails() {
        log.info("Expand products list");
        openWishListButton.click();
        waitUntilElementIsVisible(driver, productNameFromWishList);
    }

    /**
     * Get product name from wish list string.
     *
     * @return the string
     */
    public String getProductNameFromWishList() {
        log.info("Get product name from wishlist");
        return productNameFromWishList.getText();
    }

    /**
     * Get product count in wish list string.
     *
     * @return the string
     */
    public String getProductsCountInWishList() {
        log.info("Get products count from wishlist");
        return productCountInWishList.getAttribute("value");
    }
}