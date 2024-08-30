package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;

@Log4j2
public class MyAccountSteps implements IConstants {

    public MyAccountPage myAccountPage;

    public MyAccountSteps(WebDriver driver){
        myAccountPage = new MyAccountPage(driver);
    }

    @Step("Open wishlist")
    public MyAccountSteps openWishList() {
        log.info("Open {} page and click 'Wishlist' button", MY_ACCOUNT_PAGE_URL);
        myAccountPage.openPage(MY_ACCOUNT_PAGE_URL)
                     .goToWishList();
        return this;
    }
}