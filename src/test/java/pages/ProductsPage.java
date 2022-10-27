package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    static WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCartBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addToCartBikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By shoppingCartButton = By.id("shopping_cart_container");
    private By filterButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span");
    private By firstOptionFilter = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]");
    private By secondOptionFilter = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]");
    private By thirdOptionFilter = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]");
    private By fourthOptionFilter = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]");
    private By products = By.className("inventory_item_name");

    public By getFourthOptionFilter() {
        return fourthOptionFilter;
    }

    public By getThirdOptionFilter() {
        return thirdOptionFilter;
    }

    public By getSecondOptionFilter() {
        return secondOptionFilter;
    }

    public By getFirstOptionFilter() {
        return firstOptionFilter;
    }

    public void addToCart(By productToCart) {
        driver.findElement(productToCart).click();
    }

    public By getAddToCartBikeLightButton() {
        return addToCartBikeLightButton;
    }

    public void clickShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
    }

    public By getAddToCartBackpackButton() {
        return addToCartBackpackButton;
    }

    public void clickFilterButton() {
        driver.findElement(filterButton).click();
    }

    public void clickOptionFilter(By option) {
        driver.findElement(option).click();
    }

    public String getTextFromFirstFilteredItem() {
        return driver.findElement(products).getText();
    }

    public void clickProducts() {
        driver.findElement(products).click();
    }

    public String productDetailsName() {
        return driver.findElement(By.className("inventory_details_name")).getText();
    }

    public String productDetailsDescription() {
        return driver.findElement(By.className("inventory_details_desc")).getText();
    }

    public String productDetailsPrice() {
        return driver.findElement(By.className("inventory_details_price")).getText();
    }
}
