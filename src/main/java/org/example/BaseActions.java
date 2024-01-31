package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseActions {
    static WebDriverWait wait;
    public static void waitForElement(WebElement element){
        wait = new WebDriverWait(DriverFactory.getCurrentDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void sendKeys(WebElement element,String value){
        waitForElement(element);
        element.sendKeys(value);
    }
    public static void click(WebElement element){
        waitForElement(element);
        element.click();
    }
    public static String getText(WebElement element){
        waitForElement(element);
        return element.getText();
    }

    public static void navigateURL(String url){
        DriverFactory.getCurrentDriver().get(url);
        DriverFactory.getCurrentDriver().manage().window().maximize();
    }
}
