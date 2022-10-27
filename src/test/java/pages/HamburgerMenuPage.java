package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HamburgerMenuPage {
    static WebDriver driver;

    public HamburgerMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private By burgerMenu = By.id("react-burger-menu-btn");
    private By logoutOption = By.id("logout_sidebar_link");

    public void clickOptionsInBurgerMenu(By option) {
        driver.findElement(option).click();
    }

    public By getLogoutOption() {
        return logoutOption;
    }

    public By getBurgerMenu() {
        return burgerMenu;
    }
}
