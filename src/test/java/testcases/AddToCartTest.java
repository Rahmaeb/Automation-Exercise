package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.example.ProductPage;

public class AddToCartTest {
    private WebDriver driver;
    private ProductPage productPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
    }

    @Test (priority = 2)
    public void testAddToCart() {
        driver.get("https://www.automationexercise.com/products");  // Navigate to the correct page

        productPage.addToCart();
        productPage.goToCart();

        // Assertion to Verify Successful Navigation to Shopping Cart
       // Assert.assertTrue(driver.getPageSource().contains("Shopping Cart"), "Shopping Cart page not displayed.");
        //Assert.assertEquals(driver.findElement((accountCreated)).getText(),text.toUpperCase());

    }

    @AfterMethod
    public void tearDown() {
            driver.quit();

    }
}
