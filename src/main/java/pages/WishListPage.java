package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage implements IConstants {

    @FindBy(xpath = "//a[contains(text(),'Мой лист пожеланий')]")
    public WebElement openWishListButton;
    @FindBy(xpath = "//p[@id='s_title']")
    public WebElement productNameFromWishList;
    @FindBy(xpath = "//input[@id='quantity_1_1']")
    public WebElement productCountInWishList;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public WishListPage openPage(String url){
        driver.get(url);
        return this;
    }

    public WishListPage openWishListTails(){
        openWishListButton.click();
        return this;
    }

    public String getProductNameFromWishList(){
        return productNameFromWishList.getText();
    }

    public String getProductCountInWishList(){
        return productCountInWishList.getAttribute("value");
    }
}
