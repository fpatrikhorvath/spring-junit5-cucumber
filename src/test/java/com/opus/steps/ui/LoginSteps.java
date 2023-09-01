package com.opus.steps.ui;

import com.opus.ui.LoginPage;
import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginSteps extends LoginPage {
    @Autowired
    public LoginSteps(){
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }
    @When("the user opens the {string}")
    public void theUserOpensThe(String url) {
        getDriver().get(url);
    }

    @And("the user types in the {string} as {string} on the login page")
    public void theUserTypesInTheAsOnTheLoginPage(String value, String field) {
        enterTextToInput(field, value);
    }

    @When("the user presses the {string} button on the login page")
    public void theUserPressesTheButtonOnTheLoginPage(String button) {
        clickOnButton(button);
    }

    @Then("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        String message = "The user is not on the login page.";
        assertTrue(isInitialized(), message);
    }
}
