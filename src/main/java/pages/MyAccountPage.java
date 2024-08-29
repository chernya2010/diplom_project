package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class MyAccountPage extends BasePage implements IConstants {

    @FindBy(xpath = "//*[@class='lnk_wishlist']")
    public WebElement goToWishListButton;

    /**
     * Instantiates a new My account page.
     *
     * @param driver the driver
     */
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyAccountPage openPage(String url) {
        log.info("Open {} page", url);
        driver.get(url);
        return this;
    }

    /**
     * Go to wish list my account page.
     *
     * @return the account page
     */
    public MyAccountPage goToWishList() {
        log.info("Click 'Go to wishlist' button");
        goToWishListButton.click();
        return this;
    }
}