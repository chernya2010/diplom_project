import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends TestPreconditions implements IConstants, ITestConstants {

    @Test
    public void addProductToCartFromModalWindowTest() throws InterruptedException {
        basePage.openPage(BASE_PAGE_URL)
                .hoverOnProductTileAndClickAddToCartButton("Faded Short Sleeve T-shirts");
        addToCartModalWindow.clickPlaceAnOrderButtonOnModalWindow();
        Assert.assertEquals(CART_PAGE_URL, driver.getCurrentUrl());
        Assert.assertEquals(EXPECTED_PRODUCT_NAME, cartPage.getProductNameFromCart());
    }

    @Test
    public void deleteProductFromCartTest() throws InterruptedException {
        basePage.openPage(BASE_PAGE_URL)
                .hoverOnProductTileAndOpenProductDetailedPage("Faded Short Sleeve T-shirts");
        productDetailedPage.addProductToCart();
        addToCartModalWindow.clickPlaceAnOrderButtonOnModalWindow();
        cartPage.deleteProductFromCart("Faded Short Sleeve T-shirts");
        Assert.assertTrue(cartPage.isProductDisplayedInCart("Faded Short Sleeve T-shirts"));
        Assert.assertEquals(EXPECTED_PRODUCT_COUNT_IN_CART_AFTER_DELETE, cartPage.getProductsCountFromCart());
    }

    @Test
    public void seccessfulCheckoutWithoutPaymentTest() throws InterruptedException {
        loginPage.openPage(LOGIN_PAGE_URL);
        registrationSteps.registerNewAccount(NEW_ACCOUNT);
        basePage.openPage(BASE_PAGE_URL)
                .hoverOnProductTileAndOpenProductDetailedPage("Faded Short Sleeve T-shirts");
        productDetailedPage.addProductToCart();
        addToCartModalWindow.clickPlaceAnOrderButtonOnModalWindow();
        cartPage.checkout();
        addressPage.addNewAddress();
        addressPage.proceedCheckout();
        shippingPage.proceedChechout();
        Assert.assertEquals(paymentPage.noPaymentModulesMessage.getText(), NO_PAYMENT_MODULES_CHECKOUT_MESSAGE);
    }
}