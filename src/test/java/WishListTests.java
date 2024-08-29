import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTests extends TestPreconditions implements IConstants, ITestConstants {

    @Test
    public void addProductToWishListFromMainPageTest() throws InterruptedException {
        loginPage.openPage(LOGIN_PAGE_URL);
        registrationSteps.registerNewAccount(NEW_ACCOUNT);
        basePage.openPage(BASE_PAGE_URL);
        basePage.hoverOnProductTileAndOpenProductDetailedPage("Faded Short Sleeve T-shirts");
        productDetailedPage.addToWishList();
        myAccountPage.openPage(MY_ACCOUNT_PAGE_URL)
                     .goToWishList();
        wishListPage.openWishListTails();
        Assert.assertEquals(WISH_LIST_PAGE_URL, driver.getCurrentUrl());
        Assert.assertEquals(wishListPage.getProductNameFromWishList(), EXPECTED_WISH_LIST_PRODUCT_NAME);
        Assert.assertEquals(wishListPage.getProductCountInWishList(), EXPECTED_PRODUCT_COUNT_IN_WISH_LIST);
    }
}