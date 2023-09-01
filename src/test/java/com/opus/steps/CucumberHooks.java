package com.opus.steps;

import com.opus.steps.ui.LoginSteps;
import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CucumberHooks {
    @Before("@ui")
    public void beforeEach() {
        WebDriverFactory.createDriver();
    }

    @After("@ui")
    public void afterEach(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] SCREENSHOT = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(SCREENSHOT, "image/png", "Screenshot.png");
        }
        WebDriverFactory.cleanUpDriver();
    }
}
