package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomanModalWindow extends BasePage implements IConstants {

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']")
    public WebElement tShirtsPageLink;

    public WomanModalWindow(WebDriver driver) {
        super(driver);
    }

    public WomanModalWindow openTShirtsPage(){
        tShirtsPageLink.click();
        return this;
    }
}
