package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TShirtsPage extends BasePage implements IConstants {

    @FindBy(xpath = "//span[@class='category-name']")
    public WebElement categoryName;

    public TShirtsPage(WebDriver driver) {
        super(driver);
    }
}