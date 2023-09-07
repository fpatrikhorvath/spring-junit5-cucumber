package com.opus.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//*[@id='cart_contents_container']")
    WebElement cartList;

    /**
     * Returns the visibility state of the cart page.
     *
     * @return
     */
    @Override
    protected boolean isInitialized() {
        return isVisible(cartList);
    }
}
