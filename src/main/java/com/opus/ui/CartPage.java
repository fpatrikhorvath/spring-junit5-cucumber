package com.opus.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(id="continue-shopping")
    WebElement continueShoppingButton;
    @FindBy(xpath="//div[@class='cart_quantity']")
    WebElement cartQuantityCounter;
    @Override
    protected boolean isInitialized() {
        return isVisible(continueShoppingButton);
    }

    protected int getCartQuantityCounter(){
        return Integer.parseInt(cartQuantityCounter.getText());
    }
}
