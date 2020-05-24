import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static utils.DriverManager.getDriver;
import static utils.DriverManager.quitDriver;

public class HomePageTest {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    WebDriver driver;

    @BeforeTest
    public void Setup() {
        driver = getDriver();
        driver.get("https://www.amazon.co.uk/");
    }

    @Test(description = "Select a five stared Laptop with the lowest price")
    public void testFiveStarFilter() {
        String size15_16 = "182753031";
        String interCorei5 = "8322530031";
        String SSD = "7472680031";
        String fourAndUp = "4";
        int firstProduct = 0;

        homePage.clickHamburgerMenu()
                .clickCategory("Electronics & Computers")
                .clickSubCategory("Laptops")
                .clickDisplaySize(size15_16)
                .clickCPUType(interCorei5)
                .clickStorageType(SSD)
                .clickStarRating(fourAndUp);

        homePage.sortBy("Price: Low to High");

        String productUrl = homePage.productHref(firstProduct);
        String productTitle = homePage.productTitle(firstProduct);
        homePage.clickProduct(firstProduct);

        assertEquals(driver.getCurrentUrl(), productUrl);
        assertEquals(productPage.productTitle(), productTitle);
    }

    @AfterTest
    public void tearDown() {
        quitDriver();
    }
}
