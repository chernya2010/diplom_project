package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import static constants.IConstants.BASE_PAGE_URL;

@Log4j2
public class BasePageSteps {

    public BasePage basePage;

    /**
     * Instantiates a new Base page steps.
     *
     * @param driver the driver
     */
    public BasePageSteps(WebDriver driver) {
        basePage = new BasePage(driver);
    }

    /**
     * Open product detailed page base page steps.
     *
     * @param productName the product name
     * @return the base page steps
     * @throws InterruptedException the interrupted exception
     */
    @Step("Open product detailed page")
    public BasePageSteps openProductDetailedPage(String productName) throws InterruptedException {
        log.info("Open {} page", BASE_PAGE_URL);
        basePage.openPage(BASE_PAGE_URL);
        log.info("Click 'More' button on {} product tile", productName);
        basePage.hoverOnProductTileAndOpenProductDetailedPage(productName);
        return this;
    }
}