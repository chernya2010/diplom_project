package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps implements IConstants {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login")
    public LoginSteps login(String email, String password) {
        loginPage
                .openPage(LOGIN_PAGE_URL)
                .login(email, password);
        return this;
    }
}