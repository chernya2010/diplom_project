package pages;

import constants.IConstants;
import generators.NumberGenerator;
import generators.StringGenerator;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class ContactUsPage extends BasePage implements IConstants {
    protected NumberGenerator numberGenerator = new NumberGenerator();
    protected StringGenerator stringGenerator = new StringGenerator();
    private static final String SUBJECT_HEADING_DROPDOWN = "//select[@id='id_contact']";

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@id='id_order']")
    public WebElement orderReferenceInput;
    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement messageInput;
    @FindBy(xpath = "//button[@id='submitMessage']")
    public WebElement sendMessageButton;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement successfulSendMessageText;

    /**
     * Instantiates a new Contact us page.
     *
     * @param driver the driver
     */
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactUsPage openPage(String url) {
        log.info("Open {} page", url);
        driver.get(url);
        return this;
    }

    /**
     * Successful send contact us message contact us page.
     *
     * @return the contact us page
     */
    public ContactUsPage successfulSendContactUsMessage() {
        log.info("Fill contact us form");
        Select dropdown = new Select(driver.findElement(By.xpath(SUBJECT_HEADING_DROPDOWN)));
        dropdown.selectByValue("1");
        emailInput.sendKeys("email" + numberGenerator.generateRandomInt(50000) + "@mail.com");
        orderReferenceInput.sendKeys("Some text" + stringGenerator.randomText());
        messageInput.sendKeys("Some text" + stringGenerator.randomText());
        log.info("Click 'Send' button");
        sendMessageButton.click();
        return this;
    }
}