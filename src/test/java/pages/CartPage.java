package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    static WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By backpackInCart = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By productToBeRemoved = By.id("remove-sauce-labs-backpack");
    private By removedProduct = By.className("removed_cart_item");
    private By checkoutButton = By.id("checkout");

    public String getTextFromProductInCart() {
        return driver.findElement(backpackInCart).getText();
    }

    public void removeProductFromCart() {
        driver.findElement(productToBeRemoved).click();
    }

    public boolean elementIsRemoved() {
        return driver.findElement(removedProduct).isEnabled();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

}
