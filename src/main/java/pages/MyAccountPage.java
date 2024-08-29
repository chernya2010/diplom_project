package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage implements IConstants {

    @FindBy(xpath = "//*[@class='lnk_wishlist']")
    public WebElement goToWishListButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage openPage(String url){
        driver.get(url);
        return this;
    }

    public MyAccountPage goToWishList(){
        goToWishListButton.click();
        return this;
    }
}
