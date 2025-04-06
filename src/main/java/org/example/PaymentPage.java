package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expirydate= By.name("expiry_month");
    private By expiryyear= By.name("expiry_year");
    private By payButton = By.xpath("//button[@data-qa='pay-button']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterPaymentDetails(String name, String cardNum, String cvcCode, String expiryDate, String expiryYear) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber)).sendKeys(cardNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvc)).sendKeys(cvcCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirydate)).sendKeys(expiryDate);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryyear)).sendKeys(expiryYear);
    }

    public void clickPayButton() {
        wait.until(ExpectedConditions.elementToBeClickable(payButton)).click();
    }
}
