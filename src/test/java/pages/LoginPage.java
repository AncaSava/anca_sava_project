package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By headerLabel = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public void enterUserName(String name) {
        driver.findElement(userNameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void authenticate(String name, String password) {
        enterUserName(name);
        enterPassword(password);
        clickLogin();
    }

    public String getHeader() {
        return driver.findElement(headerLabel).getText();
    }

    public String getLoginError() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean loginButtonIsDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
