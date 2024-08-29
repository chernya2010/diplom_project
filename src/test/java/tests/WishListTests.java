package tests;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class WishListTests extends TestPreconditions implements IConstants, ITestConstants {

    /**
     * Add product to wish list from main page test.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test(description = "Добавить товар в список избранного с детальной страницы товара")
    public void addProductToWishListFromMainPageTest() throws InterruptedException {
        loginPage.openPage(LOGIN_PAGE_URL);
        registrationSteps.registerNewAccount(NEW_ACCOUNT);
        basePage.openPage(BASE_PAGE_URL);
        basePage.hoverOnProductTileAndOpenProductDetailedPage("Faded Short Sleeve T-shirts");
        productDetailedPage.addToWishList();
        myAccountPage.openPage(MY_ACCOUNT_PAGE_URL)
                     .goToWishList();
        wishListPage.openWishListTails();
        Assert.assertEquals(driver.getCurrentUrl(), WISH_LIST_PAGE_URL);
        Assert.assertEquals(wishListPage.getProductNameFromWishList(), EXPECTED_WISH_LIST_PRODUCT_NAME);
        Assert.assertEquals(wishListPage.getProductsCountInWishList(), EXPECTED_PRODUCT_COUNT_IN_WISH_LIST);
    }
}