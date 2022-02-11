package util;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelpers {

    private WebDriver driver;
    private WebDriverWait wait;

    protected ElementHelpers(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getElement(String xpathSelector) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelector)));
        return driver.findElement(By.xpath(xpathSelector));
    }

    public void clickElement(String xpathSelector){
        getElement(xpathSelector).click();
    }

    public String getElementValue(String xpathSelector){
        return getElement(xpathSelector).getText();
    }

    public void enterValue(String xpathSelector, String inputValue){
        getElement(xpathSelector).clear();
        getElement(xpathSelector).sendKeys(inputValue);
    }

    public void clearValue(String xpathSelector){
        getElement(xpathSelector).clear();
    }

    public void assertElementValue(String expectedValue, String actualValueXpathSelector){
        Assertions.assertEquals(expectedValue, getElementValue(actualValueXpathSelector));
    }

}
