package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverFactory {

    private WebDriver driver;
    private WebDriverWait wait;
    private ElementHelpers elementHelpers;

    public WebDriverFactory(String pathToChromedriver, String urlToOpen) {
        startWebDriver(pathToChromedriver, urlToOpen);
    }

    private void startChromeDriver(String pathSeleniumDriverExe) {
        System.setProperty("webdriver.chrome.driver", pathSeleniumDriverExe);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-web-security");
        driver = new ChromeDriver(options);
    }

    private void startWebDriver(String pathSeleniumDriverExe, String webSiteUrl) {
        startChromeDriver(pathSeleniumDriverExe);
        initializeDriverWait();
        initializeElementHelpers();
        goToUrl(webSiteUrl);
    }

    private void goToUrl(String urlToOpen) {
        driver.get(urlToOpen);
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void initializeDriverWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private void initializeElementHelpers() {
        elementHelpers = new ElementHelpers(driver, wait);
    }

    public ElementHelpers getElementHelpers() {
        return elementHelpers;
    }
}
