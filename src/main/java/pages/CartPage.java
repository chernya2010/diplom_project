package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waiters.Waiters.waitUntilCartWillBeEmpty;
import static waiters.Waiters.waitUntilElementIsVisible;

@Log4j2
public class CartPage extends BasePage implements IConstants {

    private static final String PRODUCT_IN_CART_BY_PRODUCT_NAME = "//*[@class='cart_description']//a[contains(text(),'%s')]";
    private static final String DELETE_PRODUCT_BUTTON_BY_PRODUCT_NAME = "//*[contains(text(),'%s')]/ancestor::tr[contains(@class,'cart_item')]//*[@title='Delete']";
    @FindBy(xpath = "//*[@class='cart_description']//p[@class='product-name']/a")
    public WebElement productNameInCart;
    @FindBy(xpath = "//span[@id='summary_products_quantity']")
    public WebElement countOfProductsInCart;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;


    /**
     * Instantiates a new Cart page.
     *
     * @param driver the driver
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage openPage(String url) {
        log.info("Open {} page", url);
        driver.get(url);
        return this;
    }

    /**
     * Is product displayed in cart boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isProductDisplayedInCart(String productName) {
        log.info("Check product {} displayed in cart", productName);
        return driver.findElement(By.xpath(String.format(PRODUCT_IN_CART_BY_PRODUCT_NAME, productName))).isDisplayed();
    }

    /**
     * Get product name from cart string.
     *
     * @return the string
     */
    public String getProductNameFromCart() {
        log.info("Get product name from cart");
        return productNameInCart.getText();
    }

    /**
     * Get products count from cart string.
     *
     * @return the string
     */
    public String getProductsCountFromCart() {
        log.info("Get count of product from cart");
        return countOfProductsInCart.getText();
    }

    /**
     * Delete product from cart cart page.
     *
     * @param productName the product name
     * @return the cart page
     */
    public CartPage deleteProductFromCart(String productName) {
        log.info("Delete product {} from cart", productName);
        driver.findElement(By.xpath(String.format(DELETE_PRODUCT_BUTTON_BY_PRODUCT_NAME, productName))).click();
        waitUntilElementIsVisible(driver, productNameInCart);
        waitUntilCartWillBeEmpty(driver);
        return this;
    }

    /**
     * Checkout cart page.
     *
     * @return the cart page
     */
    public CartPage checkout() {
        log.info("Click 'Proceed To Checkout' button");
        proceedToCheckoutButton.click();
        return this;
    }
}