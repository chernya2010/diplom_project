import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BsePageTests extends BaseTest implements IConstants, ITestConstants {

    @Test
    public void changeCurrencyTest() throws InterruptedException {
        basePage.openPage(BASE_PAGE_URL)
                .changeCurrencyToEuro();
        Thread.sleep(1000);//не менять
        Assert.assertEquals(basePage.getProductCurrency(),"€");
    }

    @Test
    public void openTShirtsPageFromWomanSectionTest(){
        basePage.openPage(BASE_PAGE_URL)
                .hoverOnWomanSection();
        womanModalWindow.openTShirtsPage();
        Assert.assertEquals(driver.getCurrentUrl(), TSHIRTS_PAGE_URL);
        Assert.assertEquals(EXPECTED_TSHIRTS_CATEGORY_NAME, tShirtsPage.categoryName.getText());
    }

    @Test
    public void goToProductFromSearchDropDownTest(){
        basePage.openPage(BASE_PAGE_URL)
                .goToProductFromSearchDropDown("Faded Short Sleeve T-shirts");
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/ru/tshirts/1-faded-short-sleeve-tshirts.html");
        Assert.assertEquals(productDetailedPage.productName.getText(), "Faded Short Sleeve T-shirts");
    }
}