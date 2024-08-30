package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.Account;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

@Log4j2
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
    public RegistrationSteps registerNewAccount(Account account) {
        log.info("Open {} page", LOGIN_PAGE_URL);
        registerPage.openPage(LOGIN_PAGE_URL);
        log.info("Register new account");
        registerPage.registerNewAccount(
                account.getEmail(),
                account.getFirstName(),
                account.getLastName(),
                account.getPassword(),
                account.getDayOfBirth(),
                account.getMonthOfBirth(),
                account.getYearOfBirth()
        );
        return this;
    }
}