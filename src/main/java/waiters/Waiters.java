package waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {

    /**
     * Wait until cart will be empty.
     *
     * @param driver the driver
     */
    public static void waitUntilCartWillBeEmpty(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='summary_products_quantity']"), "0 product"));
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