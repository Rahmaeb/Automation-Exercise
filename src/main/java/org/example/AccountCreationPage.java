package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // locators (acc. info.)
    private By genderRadio = By.xpath("//input[@value='Mrs']");
    private By passwordField = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    // locators for (address info.)
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By addressField = By.id("address1");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    //scroll to an element
    private void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    // fill acc. info.
    public void selectGender() {
        scrollToElement(genderRadio);
        wait.until(ExpectedConditions.elementToBeClickable(genderRadio)).click();
    }

    public void enterPassword(String password) {
        scrollToElement(passwordField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        scrollToElement(daysDropdown);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(daysDropdown))).selectByVisibleText(day);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(monthsDropdown))).selectByVisibleText(month);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(yearsDropdown))).selectByVisibleText(year);
    }

    // **Fill Address Information**
    public void enterFirstName(String firstName) {
        scrollToElement(firstNameField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        scrollToElement(lastNameField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        scrollToElement(addressField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(address);
    }

    public void selectCountry(String country) {
        scrollToElement(countryDropdown);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown))).selectByVisibleText(country);
    }

    public void enterState(String state) {
        scrollToElement(stateField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateField)).sendKeys(state);
    }

    public void enterCity(String city) {
        scrollToElement(cityField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
    }

    public void enterZipCode(String zipCode) {
        scrollToElement(zipCodeField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField)).sendKeys(zipCode);
    }

    public void enterMobileNumber(String mobileNumber) {
        scrollToElement(mobileNumberField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberField)).sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        scrollToElement(createAccountButton);
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }
}
