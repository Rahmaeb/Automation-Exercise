package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.example.loginPage;
import org.example.AccountCreationPage;

import java.time.Duration;

public class RegisterationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private loginPage loginPage;
    private AccountCreationPage accountCreationPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
        loginPage = new loginPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
    }

    @Test (priority = 1)
    public void testRegistration() {

            driver.get("https://www.automationexercise.com/login");

            // Login steps
            loginPage.enterName("Rahma65");
            String uniqueEmail = "Rahma" + System.currentTimeMillis() + "@gmail.com";
            loginPage.enterEmail(uniqueEmail);
            loginPage.clickSignup();

            // Account Creation steps
            accountCreationPage.selectGender();
            accountCreationPage.enterPassword("123456");
            accountCreationPage.selectDateOfBirth("1", "March", "2001");

            // Fill Address Information
            accountCreationPage.enterFirstName("Rahma");
            accountCreationPage.enterLastName("Ebraheem");
            accountCreationPage.enterAddress("California");
            accountCreationPage.selectCountry("United States");
            accountCreationPage.enterState("California");
            accountCreationPage.enterCity("California");
            accountCreationPage.enterZipCode("0000");
            accountCreationPage.enterMobileNumber("01033434342");

            // Scroll to the "Create Account" button
            WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='create-account']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountButton);
            createAccountButton.click();
       // Thread.sleep(5000); // Wait 5 seconds to see the confirmation message (REMOVE after debugging)


        By accountCreated= By.xpath("//h2/b[contains(text(),'Account Created!')]");
             String text = "Account Created!";
            Assert.assertEquals(driver.findElement((accountCreated)).getText(),text.toUpperCase());
        }


    @AfterMethod
    public void tearDown() {

            driver.quit();

    }
}
