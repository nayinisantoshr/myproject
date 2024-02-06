package org.example.pageactions;

import org.example.BaseActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class BingoSearchPage implements SearchEngine{
    WebDriver driver;


    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchTextBox;

    @FindBy(xpath = "//input[@name='search' and @type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//ol[contains(@id,'results')]")
    WebElement searchResult;
    @FindBy(xpath = "//ol[contains(@id,'results')]//following::h2")
    List<WebElement> resultList;

    public BingoSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void performSearch(String searchTerm) {
        BaseActions.sendKeys(searchTextBox,searchTerm);
        BaseActions.sendKeys(searchTextBox,Keys.ENTER);
    }

    public WebElement getFirstResultText() {
        BaseActions.waitForElement(searchResult);
        return resultList.get(0);
    }
}
