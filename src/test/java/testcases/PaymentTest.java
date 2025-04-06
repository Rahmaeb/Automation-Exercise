package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.example.PaymentPage;
import java.time.Duration;


    public class PaymentTest {
        private WebDriver driver;
        private PaymentPage paymentPage;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            paymentPage = new PaymentPage(driver);
        }

        @Test (priority = 3)
        public void testPayment() {
            driver.get("https://www.automationexercise.com/payment");
            paymentPage.enterPaymentDetails("Rahma", "2387429874", "245", "07", "2001");
            paymentPage.clickPayButton();


            By orderPlaced= By.xpath("//h2/b[contains(text(),'Order Placed!')]");
            String msg = "Order Placed!";
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlaced));
            Assert.assertEquals(driver.findElement((orderPlaced)).getText(),msg.toUpperCase());
        }

        /*@AfterMethod
        public void tearDown() {
            driver.quit();
        }*/
    }

