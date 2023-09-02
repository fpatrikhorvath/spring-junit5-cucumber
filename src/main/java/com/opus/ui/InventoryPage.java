package com.opus.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{
    @FindBy(id = "inventory_container")
    private WebElement mainElement;
    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackFromCartButton;
    @FindBy(xpath = "//img[@alt='Open Menu']/..")
    private WebElement openMenuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;
    @FindBy(id = "//div[@class='bm-item-list']")
    private WebElement menu;
    @Override
    protected boolean isInitialized() {
        return isVisible(mainElement);
    }
    protected void clickOnButton(String element) {
        switch (element) {
            case "cart":
                clickOnElement(cartButton);
                break;
            case "add backpack to cart":
                clickOnElement(addBackpackToCartButton);
                break;
            case "open the menu":
                clickOnElement(openMenuButton);
                break;
            case "logout":
                clickOnElement(logoutButton);
                break;
            default:
                throw new IllegalArgumentException(element + " does not exists!");
        }
    }
    protected boolean isDisplayed(String element){
        switch (element){
            case "remove backpack from cart":
                return isVisible(removeBackpackFromCartButton);
            case "add backpack to cart":
                return isVisible(addBackpackToCartButton);
            case "menu":
                return isVisible(menu);
            case "login button":
                return isVisible(logoutButton);
            default:
                throw new IllegalArgumentException(element + " does not exists!");
        }
    }
}
