package com.opus.steps.ui;

import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseUiSteps extends WebDriverFactory {
    @Then("the user see the {string} channel name")
    public void theUserSeeTheChannelName(String expectedChannelName) {
        String actualChannelName = getDriver().findElement(By.id("channel-name")).getText();
        assertEquals(expectedChannelName,actualChannelName);
    }
}
