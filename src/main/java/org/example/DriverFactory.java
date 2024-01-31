package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    static WebDriver driver=null;
    public static void invokeDriver(String browserName){
        if (driver==null) {
            switch (browserName) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "Firefox":
                    break;
                case "Safari":
                    break;
                default:
                    break;
            }
        }
    }

    public static WebDriver getCurrentDriver(){
        return driver;
    }
}


