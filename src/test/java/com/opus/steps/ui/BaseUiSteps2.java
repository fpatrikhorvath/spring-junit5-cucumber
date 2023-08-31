package com.opus.steps.ui;

import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseUiSteps2 extends WebDriverFactory {
    @When("the user opens the {string}")
    public void theUserOpensThe(String url) {
        getDriver().get(url);
    }

}
