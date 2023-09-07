package com.opus.ui;

import com.opus.webdriver.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * Schema page for all the Pages, they're inheriting these methods.
 * The main rule is: All the element interactions should be implemented here.
 */
@Component
@Slf4j
public abstract class BasePage extends WebDriverFactory {
    /**
     * Returns the page state, it's an abstract method, all the pages should contain this.
     *
     * @return true in case the page is visible by the driver, false in case it's not.
     */
    protected abstract boolean isInitialized();

    /**
     * Enter the given text to the given element.
     *
     * @param element the element, for example an input field.
     * @param text    the value, which is being typed in.
     */
    protected void sendKeysToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Performing a click on the given element.
     *
     * @param element the element, for example a button.
     */
    protected void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * Return the visibility state of the given element.
     *
     * @param element the element we would like to find.
     * @return true in case it's visible, false in case it's not.
     */
    protected boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }

    /**
     * Wait for the given item for a given time.
     * @param element is the web element that must appear within the specified time.
     * @param timeout the drive must stop after the specified number of seconds.
     */
    protected void waitForElement(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
