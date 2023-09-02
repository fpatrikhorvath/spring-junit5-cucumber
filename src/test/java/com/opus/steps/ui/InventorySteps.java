package com.opus.steps.ui;

import com.opus.ui.InventoryPage;
import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Given("the user presses the {string} button on the inventory page")
    public void theUserPressesTheButtonOnTheInventoryPage(String button) {
        clickOnButton(button);
    }

    @Then("the user see the {string} button on the inventory page")
    public void theUserSeeTheButtonOnTheInventoryPage(String button) {
        boolean isDisplayed = isDisplayed(button);
        String message = "The remove from the cart button did not appear.";
        assertTrue(isDisplayed, message);
    }

    @Then("the user do not see the {string} button on the inventory page")
    public void theUserDoNotSeeTheButtonOnTheInventoryPage(String button) {
        boolean isDisplayed = isDisplayed(button);
        String message = "The add to the cart button did not appear.";
        assertFalse(isDisplayed, message);
    }

    @Then("the user see the {string} on the inventory page")
    public void theMenuAppearsOnTheInventoryPage(String element) {
        boolean isDisplayed = isDisplayed(element);
        String message = "The element is not visible.";
        assertTrue(isDisplayed, message);
    }
}
