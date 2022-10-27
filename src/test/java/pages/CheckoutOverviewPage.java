package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    static WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By finishButton = By.xpath("//*[@id=\"finish\"]");

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}
