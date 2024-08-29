package waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUntilElementIsVisible {

    private WaitUntilElementIsVisible() {
    }

    /**
     * Wait until element is visible.
     *
     * @param driver the driver
     * @param xpath  the xpath
     */
    public static void waitUntilElementIsVisible(WebDriver driver, WebElement xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(xpath));
    }
}