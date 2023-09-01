package com.opus.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{
    @FindBy(id = "inventory_container")
    private WebElement mainElement;
    @Override
    protected boolean isInitialized() {
        return isVisible(mainElement);
    }
}
