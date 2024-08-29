import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTest implements IConstants, ITestConstants {

    @Test
    public void successfulSendContactUsMessageTest(){
        contactUsPage.openPage(CONTACT_US_PAGE_URL)
                     .successfulSendContactUsMessage();
        Assert.assertEquals(driver.getCurrentUrl(), CONTACT_US_PAGE_URL);
        Assert.assertEquals(contactUsPage.successfulSendMessageText.getText(), SUCCESSFUL_SEND_CONTACT_US_MESSAGE);
    }
}