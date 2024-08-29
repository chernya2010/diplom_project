package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class WomanModalWindow extends BasePage implements IConstants {

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']")
    public WebElement tShirtsPageLink;

    /**
     * Instantiates a new Woman modal window.
     *
     * @param driver the driver
     */
    public WomanModalWindow(WebDriver driver) {
        super(driver);
    }

    /**
     * Open t shirts page woman modal window.
     *
     * @return the woman modal window
     */
    public WomanModalWindow openTShirtsPage() {
        log.info("Open T-Shirt page from 'Woman' section");
        tShirtsPageLink.click();
        return this;
    }
}