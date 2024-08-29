import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest implements IConstants, ITestConstants{

    @Test
    public void loginWithCorrectDataTest(){
        loginSteps.login(EMAIL, PASSWORD);
        Assert.assertEquals(MY_ACCOUNT_PAGE_URL, driver.getCurrentUrl());
        Assert.assertEquals(SUCCESSFUL_LOGIN_MESSAGE, loginPage.successfulLoginMessageText.getText());
    }
}