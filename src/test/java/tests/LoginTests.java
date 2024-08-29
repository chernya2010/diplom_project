package tests;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class LoginTests extends BaseTest implements IConstants, ITestConstants{

    /**
     * Login with correct data test.
     */
    @Test(description = "Успешная авторизация зарегистрированного пользователя")
    public void loginWithCorrectDataTest(){
        loginSteps.login(EMAIL, PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), MY_ACCOUNT_PAGE_URL);
        Assert.assertEquals(loginPage.successfulLoginMessageText.getText(), SUCCESSFUL_LOGIN_MESSAGE);
    }
}