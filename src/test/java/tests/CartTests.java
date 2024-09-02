package tests;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

@Log4j2
public class CartTests extends TestPreconditions implements IConstants, ITestConstants {

    /**
     * Add product to cart from modal window test.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test(description = "Добавить товар в корзину с главной страницы")
    public void addProductToCartFromModalWindowTest() throws InterruptedException {
        basePage.openPage(BASE_PAGE_URL)
                .hoverOnProductTileAndClickAddToCartButton("Faded Short Sleeve T-shirts");
        addToCartModalWindow.clickPlaceAnOrderButtonOnModalWindow();
        AllureUtils.takeScreenshot(driver);
        Assert.assertEquals(CART_PAGE_URL, driver.getCurrentUrl());
        Assert.assertEquals(EXPECTED_PRODUCT_NAME, cartPage.getProductNameFromCart());
    }

    /**
     * Delete product from cart test.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test(description = "Удалить товар из корзины")
    public void deleteProductFromCartTest() throws InterruptedException {
        basePageSteps.openProductDetailedPage("Faded Short Sleeve T-shirts");
        productDetailedPage.addProductToCart();
        addToCartModalWindow.clickPlaceAnOrderButtonOnModalWindow();
        cartPage.deleteProductFromCart("Faded Short Sleeve T-shirts");
        AllureUtils.takeScreenshot(driver);
        Assert.assertTrue(cartPage.isProductDisplayedInCart("Faded Short Sleeve T-shirts"));
        Assert.assertEquals(cartPage.getProductsCountFromCart(), EXPECTED_PRODUCT_COUNT_IN_CART_AFTER_DELETE);
    }

    /**
     * Successful checkout without payment test.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test(description = "Успешное оформление заказа, до страницы выбора способа оплаты")
    public void successfulCheckoutWithoutPaymentTest() throws InterruptedException {
        loginPage.openPage(LOGIN_PAGE_URL);
        registrationSteps.registerNewAccount(NEW_ACCOUNT);
        basePageSteps.openProductDetailedPage("Faded Short Sleeve T-shirts");
        productDetailedPage.addProductToCart();
        addToCartModalWindow.clickPlaceAnOrderButtonOnModalWindow();
        cartPage.checkout();
        addressPage.addNewAddress()
                   .proceedCheckout();
        shippingPage.proceedChechout();
        AllureUtils.takeScreenshot(driver);
        Assert.assertEquals(paymentPage.noPaymentModulesMessage.getText(), NO_PAYMENT_MODULES_CHECKOUT_MESSAGE);
    }
}