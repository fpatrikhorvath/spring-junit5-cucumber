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
            default:
                throw new IllegalArgumentException(element + " does not exists!");
        }
    }
}
