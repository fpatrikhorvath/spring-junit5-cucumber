
package com.opus.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * A factory class for creating and managing WebDriver instances for web automation.
 * This class supports the creation of Chrome WebDriver instances with optional headless mode.
 */
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
    /**
     * Retrieves the current WebDriver instance associated with the current thread.
     *
     * @return The WebDriver instance.
     * @throws RuntimeException if the WebDriver instance is null.
     */
    public static WebDriver getDriver() {
        if (THREAD_LOCAL_DRIVER.get() != null) {
            return THREAD_LOCAL_DRIVER.get();
        } else {
            log.error("Webdriver is null and it should not be.");
            throw new RuntimeException("Webdriver is null and it should not be.");
        }
    }
    /**
     * Cleans up and quits the WebDriver instance associated with the current thread.
     */
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

    /**
     * Initialize the driver, sets it thread local.
     */
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
    /**
     * Creates a new instance of the Chrome WebDriver with optional params, like headless mode.
     */
    private static WebDriver createLocalChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) chromeOptions.addArguments("--headless");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        setBasicWebDriverProperties(webDriver);
        return webDriver;
    }
    /**
     * Sets basic WebDriver properties, such as maximizing the window.
     *
     * @param driver The WebDriver instance to configure.
     */
    private static void setBasicWebDriverProperties(WebDriver driver) {
        driver.manage().window().maximize();
    }
}
