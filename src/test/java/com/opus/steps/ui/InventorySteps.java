package com.opus.steps.ui;

import com.opus.ui.InventoryPage;
import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventorySteps extends InventoryPage {
    @Autowired
    public InventorySteps(){
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }
    @Then("the user is on the inventory page")
    public void theUserOpensThe() {
        String message = "The user is not on the inventory page.";
        assertTrue(isInitialized(), message);
    }
}
