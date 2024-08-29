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
public class AddressPage extends BasePage implements IConstants {

    protected NumberGenerator numberGenerator = new NumberGenerator();
    protected StringGenerator stringGenerator = new StringGenerator();
    private static final String STATE_DROPDOWN = "//select[@id='id_state']";

    /**
     * Instantiates a new Address page.
     *
     * @param driver the driver
     */
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstnameInput;
    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastnameInput;
    @FindBy(xpath = "//input[@id='company']")
    public WebElement companyInput;
    @FindBy(xpath = "//input[@id='address1']")
    public WebElement address1Input;
    @FindBy(xpath = "//input[@id='address2']")
    public WebElement address2Input;
    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement zipcodeInput;
    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement homePhoneInput;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElement mobilePhoneInput;
    @FindBy(xpath = "//textarea[@id='other']")
    public WebElement additionalInformationInput;
    @FindBy(xpath = "//input[@id='alias']")
    public WebElement assignAddressInput;
    @FindBy(xpath = "//button[@id='submitAddress']")
    public WebElement saveAddressButton;
    @FindBy(xpath = "//button[@name='processAddress']")
    public WebElement proceedToCheckoutButton;

    /**
     * Add new address page.
     *
     * @return the address page
     */
    public AddressPage addNewAddress() {
        log.info("Fill address form");
        firstnameInput.sendKeys("Some text" + stringGenerator.randomText());
        lastnameInput.sendKeys("Some text" + stringGenerator.randomText());
        companyInput.sendKeys("Some text" + stringGenerator.randomText());
        address1Input.sendKeys("Some text" + stringGenerator.randomText());
        address2Input.sendKeys("Some text" + stringGenerator.randomText());
        zipcodeInput.sendKeys("00000");
        cityInput.sendKeys("Some text" + stringGenerator.randomText());
        homePhoneInput.sendKeys("22" + numberGenerator.generateRandomInt(50000));
        mobilePhoneInput.sendKeys("22" + numberGenerator.generateRandomInt(50000));
        Select dropdown = new Select(driver.findElement(By.xpath(STATE_DROPDOWN)));
        dropdown.selectByValue("1");
        additionalInformationInput.sendKeys("Some text" + stringGenerator.randomText());
        assignAddressInput.sendKeys("Some text" + stringGenerator.randomText());
        log.info("Click on 'Save' button");
        saveAddressButton.click();
        return this;
    }

    /**
     * Proceed checkout address page.
     *
     * @return the address page
     */
    public AddressPage proceedCheckout() {
        log.info("Click on 'Proceed To Checkout' button");
        proceedToCheckoutButton.click();
        return this;
    }
}