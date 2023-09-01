package com.opus.ui;

import com.opus.webdriver.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public abstract class BasePage extends WebDriverFactory {
    protected abstract boolean isInitialized();
    protected void sendKeysToElement(WebElement element, String text){
        element.sendKeys(text);
    }
    protected void clickOnElement(WebElement element){
        element.click();
    }
    protected boolean isVisible(WebElement element){
        return element.isDisplayed();
    }
}
