package waiters;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForPageLoaded {

    public void waitForPageLoaded(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until((ExpectedCondition<Boolean>) page ->
                ((JavascriptExecutor) page).executeScript("return document.readyState").equals(
                        "complete"));
    }
}