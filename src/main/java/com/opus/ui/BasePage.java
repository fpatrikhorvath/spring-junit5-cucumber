package com.opus.ui;

import com.opus.webdriver.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


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
        try {
            return element.isDisplayed();
        }
        catch (Exception e){
            log.info(e.getMessage());
            return false;
        }
    }
}
