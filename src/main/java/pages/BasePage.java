package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    WebDriver driver;
    private static final String PRODUCT_TILE = "//*[@class='product-container']//h5/a[contains(@title,'%s')]";
    private static final String SEARCH_DROP_DOWN_PRODUCT_NAME = "//strong[normalize-space()='%s']";

    @FindBy(xpath = "//*[@class='product-container']//h5/a[contains(@title,'Black blouse with flowers')]")
    public WebElement productTile;
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

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage openPage(String url){
        driver.get(url);
        return this;
    }

    public BasePage hoverOnProductTileAndClickAddToCartButton(String productName) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(String.format(PRODUCT_TILE, productName)));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(1000);//заменить
        addToCartButton.click();
        return this;
    }

    public BasePage hoverOnProductTileAndOpenProductDetailedPage(String productName) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(String.format(PRODUCT_TILE, productName)));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(1000);//заменить
        moreButton.click();
        return this;
    }

    public BasePage hoverOnWomanSection(){
        Actions action = new Actions(driver);
        action.moveToElement(womanSection).perform();
        return this;
    }

    public BasePage changeCurrencyToEuro(){
        openCurrencySelectDropDown.click();
        currencySelectEur.click();
        return this;
    }

    public String getProductCurrency(){
        String[] bits = productPriceAndCurrency.getText().split(" ");
        String lastOne = bits[bits.length-1];
        return lastOne;
    }

    public BasePage goToProductFromSearchDropDown(String productName){
        searchInput.sendKeys(productName);
        driver.findElement(By.xpath(String.format(SEARCH_DROP_DOWN_PRODUCT_NAME, productName))).click();
        return this;
    }
}