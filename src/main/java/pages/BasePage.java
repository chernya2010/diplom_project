package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class BasePage {
    WebDriver driver;
    private static final String PRODUCT_TILE = "//*[@class='product-container']//h5/a[contains(@title,'%s')]";
    private static final String SEARCH_DROP_DOWN_PRODUCT_NAME = "//strong[normalize-space()='%s']";

    @FindBy(xpath = "//*[@id='homefeatured']/li[1]//a[contains(@class,'button ajax_add_to_cart_button btn btn-default')]")
    public WebElement addToCartButton;
    @FindBy(xpath = "//*[@id='homefeatured']/li[1]//a[contains(@class,'button lnk_view btn btn-default')]")
    public WebElement moreButton;
    @FindBy(xpath = "//*[@id='setCurrency']")
    public WebElement openCurrencySelectDropDown;
    @FindBy(xpath = "//*[contains(text(),'Евро')]")
    public WebElement currencySelectEur;
    @FindBy(xpath = "//*[@id='homefeatured']/li[1]/div/div[2]/div[1]/span")
    public WebElement productPriceAndCurrency;
    @FindBy(xpath = "//a[@title='Women']")
    public WebElement womanSection;
    @FindBy(xpath = "//input[@id='search_query_top']")
    public WebElement searchInput;

    /**
     * Instantiates a new Base page.
     *
     * @param driver the driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Open page base page.
     *
     * @param url the url
     * @return the base page
     */
    public BasePage openPage(String url) {
        log.info("Open {} page", url);
        driver.get(url);
        return this;
    }

    /**
     * Hover on product tile and click add to cart button base page.
     *
     * @param productName the product name
     * @return the base page
     * @throws InterruptedException the interrupted exception
     */
    public BasePage hoverOnProductTileAndClickAddToCartButton(String productName) throws InterruptedException {
        log.info("Hover mouse scroll on product tile");
        WebElement element = driver.findElement(By.xpath(String.format(PRODUCT_TILE, productName)));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(1000);//заменить
        log.info("Click 'Add To Cart' button");
        addToCartButton.click();
        return this;
    }

    /**
     * Hover on product tile and open product detailed page base page.
     *
     * @param productName the product name
     * @return the base page
     * @throws InterruptedException the interrupted exception
     */
    public BasePage hoverOnProductTileAndOpenProductDetailedPage(String productName) throws InterruptedException {
        log.info("Hover mouse scroll on product tile");
        WebElement element = driver.findElement(By.xpath(String.format(PRODUCT_TILE, productName)));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(1000);//заменить
        log.info("Click 'More' button");
        moreButton.click();
        return this;
    }

    /**
     * Hover on woman section base page.
     *
     * @return the base page
     */
    public BasePage hoverOnWomanSection() {
        log.info("Hover mouse scroll on 'Woman' section");
        Actions action = new Actions(driver);
        action.moveToElement(womanSection).perform();
        return this;
    }

    /**
     * Change currency to euro base page.
     *
     * @return the base page
     */
    public BasePage changeCurrencyToEuro() {
        log.info("Open currency select dropdown");
        openCurrencySelectDropDown.click();
        log.info("Select EUR currency from dropdown list");
        currencySelectEur.click();
        return this;
    }

    /**
     * Get product currency string.
     *
     * @return the string
     */
    public String getProductCurrency() {
        log.info("Get currency symbol from product tile");
        String[] bits = productPriceAndCurrency.getText().split(" ");
        return bits[bits.length-1];
    }

    /**
     * Go to product from search drop down base page.
     *
     * @param productName the product name
     * @return the base page
     */
    public BasePage goToProductFromSearchDropDown(String productName) {
        log.info("Fill search field by product name");
        searchInput.sendKeys(productName);
        log.info("Click on product name in search field dropdown");
        driver.findElement(By.xpath(String.format(SEARCH_DROP_DOWN_PRODUCT_NAME, productName))).click();
        return this;
    }
}