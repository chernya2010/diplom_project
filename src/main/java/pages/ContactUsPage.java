package pages;

import constants.IConstants;
import generators.NumberGenerator;
import generators.StringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage openPage(String url){
        driver.get(url);
        return this;
    }

    public ContactUsPage successfulSendContactUsMessage(){
        Select dropdown = new Select(driver.findElement(By.xpath(SUBJECT_HEADING_DROPDOWN)));
        dropdown.selectByValue("1");
        emailInput.sendKeys("email" + numberGenerator.generateRandomInt(50000) + "@mail.com");
        orderReferenceInput.sendKeys("Some text" + stringGenerator.randomText());
        messageInput.sendKeys("Some text" + stringGenerator.randomText());
        sendMessageButton.click();
        return this;
    }
}