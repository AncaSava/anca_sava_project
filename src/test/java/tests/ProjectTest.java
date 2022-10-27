package tests;

import common.BasePage;
import common.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.*;
import testdata.User;

public class ProjectTest extends BasePage {
    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;
    public static CheckoutOverviewPage checkoutOverviewPage;
    public static CheckoutCompletePage checkoutCompletePage;
    public static HamburgerMenuPage hamburgerMenuPage;

    public User user;

    @Before
    public void init() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        hamburgerMenuPage = new HamburgerMenuPage(driver);
        user = new User(Constants.TEST_DATA);
    }


    @Test
    public void loginWithValidCredentials() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        Assertions.assertEquals(Constants.PRODUCTS, loginPage.getHeader());
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.authenticate(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);
        Assertions.assertEquals(Constants.INVALID_ERROR_MESSAGE, loginPage.getLoginError());
    }

    @Test
    public void viewProductDetail() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.clickProducts();
        Assertions.assertEquals(Constants.BACKPACK_NAME, productsPage.productDetailsName());
        Assertions.assertEquals(Constants.BACKPACK_DESCRIPTION, productsPage.productDetailsDescription());
        Assertions.assertEquals(Constants.BACKPACK_PRICE, productsPage.productDetailsPrice());
    }

    @Test
    public void addToCart() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.addToCart(productsPage.getAddToCartBackpackButton());
        productsPage.clickShoppingCartButton();
        Assertions.assertEquals(Constants.BACKPACK_NAME, cartPage.getTextFromProductInCart());

    }

    @Test
    public void removeFromCart() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.addToCart(productsPage.getAddToCartBackpackButton());
        productsPage.clickShoppingCartButton();
        cartPage.removeProductFromCart();
        Assertions.assertTrue(cartPage.elementIsRemoved());
    }

    @Test
    public void validateInvalidData() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.addToCart(productsPage.getAddToCartBackpackButton());
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.clickContinueButton();
        Assertions.assertEquals(Constants.INVALID_DATA_ERROR, checkoutPage.getTextFromErrorMesage());
    }

    @Test
    public void buyOneProduct() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.addToCart(productsPage.getAddToCartBackpackButton());
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName(RandomStringUtils.randomAlphabetic(10));
        checkoutPage.enterLastName(RandomStringUtils.randomAlphabetic(5));
        checkoutPage.enterPostalCode(RandomStringUtils.randomNumeric(6));
        checkoutPage.clickContinueButton();
        checkoutOverviewPage.clickFinishButton();
        Assertions.assertEquals(Constants.CHECKOUT_COMPLETE, checkoutCompletePage.getTextFromLabelCheckoutComplete());
    }

    @Test
    public void buyTwoProducts() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.addToCart(productsPage.getAddToCartBackpackButton());
        productsPage.addToCart(productsPage.getAddToCartBikeLightButton());
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName(RandomStringUtils.randomAlphabetic(10));
        checkoutPage.enterLastName(RandomStringUtils.randomAlphabetic(5));
        checkoutPage.enterPostalCode(RandomStringUtils.randomNumeric(6));
        checkoutPage.clickContinueButton();
        checkoutOverviewPage.clickFinishButton();
        Assertions.assertEquals(Constants.CHECKOUT_COMPLETE, checkoutCompletePage.getTextFromLabelCheckoutComplete());
    }

    @Test
    public void firstFilter() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.clickFilterButton();
        productsPage.clickOptionFilter(productsPage.getFirstOptionFilter());
        Assertions.assertEquals(Constants.BACKPACK_NAME, productsPage.getTextFromFirstFilteredItem());
    }

    @Test
    public void secondFilter() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.clickFilterButton();
        productsPage.clickOptionFilter(productsPage.getSecondOptionFilter());
        Assertions.assertEquals(Constants.T_SHIRT_NAME, productsPage.getTextFromFirstFilteredItem());
    }

    @Test
    public void thirdFilter() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.clickFilterButton();
        productsPage.clickOptionFilter(productsPage.getThirdOptionFilter());
        Assertions.assertEquals(Constants.ONESIE, productsPage.getTextFromFirstFilteredItem());
    }

    @Test
    public void fourthFilter() {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        productsPage.clickFilterButton();
        productsPage.clickOptionFilter(productsPage.getFourthOptionFilter());
        Assertions.assertEquals(Constants.FLEECE, productsPage.getTextFromFirstFilteredItem());
    }

    @Test
    public void logout() throws InterruptedException {
        loginPage.authenticate(user.getUsername(), user.getPassword());
        hamburgerMenuPage.clickOptionsInBurgerMenu(hamburgerMenuPage.getBurgerMenu());
        Thread.sleep(2000);
        hamburgerMenuPage.clickOptionsInBurgerMenu(hamburgerMenuPage.getLogoutOption());
        Assertions.assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
