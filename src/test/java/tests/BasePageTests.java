package tests;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

@Log4j2
public class BasePageTests extends BaseTest implements IConstants, ITestConstants {

    /**
     * Change currency test.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test(description = "Изменить валюту")
    public void changeCurrencyTest() throws InterruptedException {
        basePage.openPage(BASE_PAGE_URL)
                .changeCurrency("Евро");
        Thread.sleep(1000);//не менять
        basePage.hoverOnProductTileAndOpenProductDetailedPage(PRODUCT_NAME);
        AllureUtils.takeScreenshot(driver);
        Assert.assertEquals(basePage.getProductCurrency(),"€");
    }

    /**
     * Open t shirts page from woman section test.
     */
    @Test(description = "Переход к странице Tops -> T-Shirts из модального окна WOMEN")
    public void openTShirtsPageFromWomanSectionTest() {
        basePage.openPage(BASE_PAGE_URL)
                .hoverOnWomanSection();
        womanModalWindow.openTShirtsPage();
        AllureUtils.takeScreenshot(driver);
        Assert.assertEquals(driver.getCurrentUrl(), TSHIRTS_PAGE_URL);
        Assert.assertEquals(tShirtsPage.categoryName.getText(), EXPECTED_TSHIRTS_CATEGORY_NAME);
    }

    /**
     * Go to product from search drop down test.
     */
    @Test(description = "Переход на детальную страницу товара из выпадающего списка поля “Поиск”")
    public void goToProductFromSearchDropDownTest() {
        basePage.openPage(BASE_PAGE_URL)
                .goToProductFromSearchDropDown(PRODUCT_NAME);
        AllureUtils.takeScreenshot(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/ru/tshirts/1-faded-short-sleeve-tshirts.html");
        Assert.assertEquals(productDetailedPage.productName.getText(), PRODUCT_NAME);
    }
}