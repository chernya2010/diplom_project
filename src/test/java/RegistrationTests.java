import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestPreconditions implements IConstants, ITestConstants{ ;

    @Test
    public void registerNewAccountWithValidDataTest() throws InterruptedException {
        loginPage.openPage(LOGIN_PAGE_URL);
        registrationSteps.registerNewAccount(NEW_ACCOUNT);
        Assert.assertEquals(MY_ACCOUNT_PAGE_URL, driver.getCurrentUrl());
        Assert.assertEquals(SUCCESSFUL_REGISTRATION_MESSAGE, registerPage.successfulRegistrationMessageText.getText());
    }
}