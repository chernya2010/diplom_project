package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    WebDriver driver;

    public Button(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * Click button.
     *
     * @param webElement the web element
     * @return the button
     */
    public Button click(WebElement webElement){
        webElement.click();
        return this;
    }
}