package com.opus.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

    private static String browser;
    private static boolean headless;

    @Value("${test.browser.default}")
    public void setDefaultBrowser(String browser) {
        WebDriverFactory.browser = browser;
    }

    @Value("${app.headless}")
    public void setHeadless(boolean headless) {
        WebDriverFactory.headless = headless;
    }

    public static WebDriver getDriver() {
        if (THREAD_LOCAL_DRIVER.get() != null) {
            return THREAD_LOCAL_DRIVER.get();
        } else {
            log.error("Webdriver is null and it should not be.");
            throw new RuntimeException("Webdriver is null and it should not be.");
        }
    }

    public static void cleanUpDriver() {
        WebDriverFactory.quitDriver();
        WebDriverFactory.removeDriver();
    }

    private static void quitDriver() {
        if (THREAD_LOCAL_DRIVER.get() != null) THREAD_LOCAL_DRIVER.get().quit();
    }

    private static void removeDriver() {
        if (THREAD_LOCAL_DRIVER.get() != null) THREAD_LOCAL_DRIVER.remove();
    }

    public static void createDriver() {
        String browserType = browser;
        log.info("Using browser type: {}", browserType);
        if (Browser.CHROME.is(browserType)) {
            THREAD_LOCAL_DRIVER.set(createLocalChromeDriver());
        } else {
            log.error("Unknown browser type entered.");
            throw new RuntimeException("Unknown browser type entered.");
        }
    }

    private static WebDriver createLocalChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) chromeOptions.addArguments("--headless");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        setBasicWebDriverProperties(webDriver);
        return webDriver;
    }

    private static void setBasicWebDriverProperties(WebDriver driver) {
        driver.manage().window().maximize();
    }
}
