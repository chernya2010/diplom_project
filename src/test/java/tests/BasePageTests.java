package tests;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class BasePageTests extends BaseTest implements IConstants, ITestConstants {

    /**
     * Change currency test.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test(description = "Изменить валюту с UAH на EUR")
    public void changeCurrencyTest() throws InterruptedException {
        basePage.openPage(BASE_PAGE_URL)
                .changeCurrencyToEuro();
        Thread.sleep(1000);//не менять
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
        Assert.assertEquals(driver.getCurrentUrl(), TSHIRTS_PAGE_URL);
        Assert.assertEquals(tShirtsPage.categoryName.getText(), EXPECTED_TSHIRTS_CATEGORY_NAME);
    }

    /**
     * Go to product from search drop down test.
     */
    @Test(description = "Переход на детальную страницу товара из выпадающего списка поля “Поиск”")
    public void goToProductFromSearchDropDownTest() {
        basePage.openPage(BASE_PAGE_URL)
                .goToProductFromSearchDropDown("Faded Short Sleeve T-shirts");
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/ru/tshirts/1-faded-short-sleeve-tshirts.html");
        Assert.assertEquals(productDetailedPage.productName.getText(), "Faded Short Sleeve T-shirts");
    }
}