package com.opus.steps.ui;

import com.opus.ui.CartPage;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartSteps extends CartPage {
    @Then("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        String message = "The user is not on the cart page.";
        assertTrue(isInitialized(), message);
    }
}
