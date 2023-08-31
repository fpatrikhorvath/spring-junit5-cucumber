package com.opus.steps;

import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    @Before("@ui")
    public void beforeEach(){
        WebDriverFactory.createDriver();
    }
    @After("@ui")
    public void afterEach(){
        WebDriverFactory.cleanUpDriver();
    }
}
