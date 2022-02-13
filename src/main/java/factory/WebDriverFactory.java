package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriverFactory(String pathSeleniumDriverExe, String webSiteUrl) {
        startWebDriver(pathSeleniumDriverExe, webSiteUrl);
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

}
