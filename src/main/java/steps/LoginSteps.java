package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps implements IConstants {

    public LoginPage loginPage;

    /**
     * Instantiates a new Login steps.
     *
     * @param driver the driver
     */
    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    /**
     * Login login steps.
     *
     * @param email    the email
     * @param password the password
     * @return the login steps
     */
    @Step("Login")
    public LoginSteps login(String email, String password) {
        loginPage
                .openPage(LOGIN_PAGE_URL)
                .login(email, password);
        return this;
    }
}