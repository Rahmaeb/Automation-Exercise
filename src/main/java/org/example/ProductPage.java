package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // locators
    private By addToCartButton = By.xpath("//a[@data-product-id='1']");
    private By viewCartButton = By.linkText("View Cart");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Scroll to Element
    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

    }

    // Method to Scroll & Click "Add to Cart"
    public void addToCart() {
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        // Scroll to the element
        scrollToElement(addToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
        }

    // Method to Navigate to Cart
    public void goToCart() {
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));

        // **Scroll to the "View Cart" button if needed**
        scrollToElement(viewCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);

    }
}
