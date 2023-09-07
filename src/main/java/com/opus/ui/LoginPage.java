package com.opus.ui;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    /**
     * Determines the visibility status of the login page.
     *
     * @return true in case the page is visible, false in case it's not.
     */
    @Override
    protected boolean isInitialized() {
        return isVisible(loginButton);
    }

    /**
     * Enters the given text to the specified input field.
     *
     * @param input the name of the input.
     * @param text  is the text which is being typed in.
     */
    protected void enterTextToInput(String input, String text) {
        switch (input) {
            case "username":
                sendKeysToElement(usernameInput, text);
                break;
            case "password":
                sendKeysToElement(passwordInput, text);
                break;
            default:
                throw new IllegalArgumentException(input + " does not exists!");
        }
    }

    /**
     * Performs a click on the given button.
     *
     * @param element the name of the button.
     */
    protected void clickOnButton(String element) {
        switch (element) {
            case "login":
                clickOnElement(loginButton);
                break;
            default:
                throw new IllegalArgumentException(element + " does not exists!");
        }
    }
}
