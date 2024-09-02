package tests;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

@Log4j2
public class RegistrationTests extends TestPreconditions implements IConstants, ITestConstants{ ;

    /**
     * Register new account with valid data test.
     */
    @Test(description = "Успешная регистрация нового пользователя")
    public void registerNewAccountWithValidDataTest() throws InterruptedException {
        loginPage.openPage(LOGIN_PAGE_URL);
        registrationSteps.registerNewAccount(NEW_ACCOUNT);
        AllureUtils.takeScreenshot(driver);
        Assert.assertEquals(driver.getCurrentUrl(), MY_ACCOUNT_PAGE_URL);
        Assert.assertEquals(registerPage.successfulRegistrationMessageText.getText(), SUCCESSFUL_REGISTRATION_MESSAGE);
    }
}