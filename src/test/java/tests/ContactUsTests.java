package tests;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class ContactUsTests extends BaseTest implements IConstants, ITestConstants {

    /**
     * Successful send contact us message test.
     */
    @Test(description = "Успешная отправка сообщения в разделе “Обратная связь”")
    public void successfulSendContactUsMessageTest() {
        contactUsPage.openPage(CONTACT_US_PAGE_URL)
                     .successfulSendContactUsMessage();
        Assert.assertEquals(driver.getCurrentUrl(), CONTACT_US_PAGE_URL);
        Assert.assertEquals(contactUsPage.successfulSendMessageText.getText(), SUCCESSFUL_SEND_CONTACT_US_MESSAGE);
    }
}