package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    static WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By continueButton = By.id("continue");
    private By errorMesage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");


    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String getTextFromErrorMesage() {
        return driver.findElement(errorMesage).getText();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeInput).sendKeys(postalCode);
    }

}
