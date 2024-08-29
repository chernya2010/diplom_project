package pages;

import constants.IConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static waiters.WaitUntilCartWillBeEmpty.waitUntilCartWillBeEmpty;
import static waiters.WaitUntilElementIsVisible.waitUntilElementIsVisible;

public class CartPage extends BasePage implements IConstants {

    private static final String PRODUCT_IN_CART_BY_PRODUCT_NAME = "//*[@class='cart_description']//a[contains(text(),'%s')]";
    private static final String DELETE_PRODUCT_BUTTON_BY_PRODUCT_NAME = "//*[contains(text(),'%s')]/ancestor::tr[contains(@class,'cart_item')]//*[@title='Delete']";
    @FindBy(xpath = "//*[@class='cart_description']//p[@class='product-name']/a")
    public WebElement productNameInCart;
    @FindBy(xpath = "//span[@id='summary_products_quantity']")
    public WebElement countOfProductsInCart;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openPage(String url){
        driver.get(url);
        return this;
    }

    public boolean isProductDisplayedInCart(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_IN_CART_BY_PRODUCT_NAME, productName))).isDisplayed();
    }

    public String getProductNameFromCart(){
        return productNameInCart.getText();
    }

    public String getProductsCountFromCart(){
        return countOfProductsInCart.getText();
    }

    public CartPage deleteProductFromCart(String productName) throws InterruptedException {
        driver.findElement(By.xpath(String.format(DELETE_PRODUCT_BUTTON_BY_PRODUCT_NAME, productName))).click();
        waitUntilElementIsVisible(driver, productNameInCart);
        waitUntilCartWillBeEmpty(driver);
        return this;
    }

    public CartPage checkout(){
        proceedToCheckoutButton.click();
        return this;
    }
}