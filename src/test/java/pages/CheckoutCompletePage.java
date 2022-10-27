package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    static WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    private By labelCheckoutComplete = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public String getTextFromLabelCheckoutComplete() {
        return driver.findElement(labelCheckoutComplete).getText();
    }

}
