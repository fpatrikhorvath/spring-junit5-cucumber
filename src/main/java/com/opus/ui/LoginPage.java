package com.opus.ui;

import com.opus.webdriver.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Override
    protected boolean isInitialized() {
        return isVisible(loginButton);
    }
    public void enterTextToInput(String input, String text){
        switch (input){
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
    public void clickOnButton(String element){
        switch (element){
            case "login":
                clickOnElement(loginButton);
                break;
            default:
                throw new IllegalArgumentException(loginButton + " does not exists!");
        }
    }
}
