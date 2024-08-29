package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class TShirtsPage extends BasePage implements IConstants {

    @FindBy(xpath = "//span[@class='category-name']")
    public WebElement categoryName;

    /**
     * Instantiates a new T-shirts page.
     *
     * @param driver the driver
     */
    public TShirtsPage(WebDriver driver) {
        super(driver);
    }
}