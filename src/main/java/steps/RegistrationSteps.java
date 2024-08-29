package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import objects.Account;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

public class RegistrationSteps implements IConstants {

    public RegisterPage registerPage;

    /**
     * Instantiates a new Registration steps.
     *
     * @param driver the driver
     */
    public RegistrationSteps(WebDriver driver) {
        registerPage = new RegisterPage(driver);
    }

    /**
     * Register new account.
     *
     * @param account the account
     */
    @Step("Register new account")
    public void registerNewAccount(Account account) {
        registerPage.openPage(LOGIN_PAGE_URL);
        registerPage.registerNewAccount(
                account.getEmail(),
                account.getFirstName(),
                account.getLastName(),
                account.getPassword(),
                account.getDayOfBirth(),
                account.getMonthOfBirth(),
                account.getYearOfBirth()
        );
    }
}