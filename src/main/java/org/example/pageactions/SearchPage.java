package org.example.pageactions;

import org.example.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;


public class SearchPage {
    WebDriver driver;


    @FindBy(name = "q")
    WebElement searchTextBox;

    @FindBy(id = "ybar-sbq")
    WebElement yahooSearchTextBox;

    @FindBy(id = "ybar-search")
    WebElement yahooSearchButton;
    @FindBy(xpath = "//input[@role='button' and @type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@id='search']")
    WebElement searchResult;
    @FindBy(xpath = "//div[@id='search']//following::h3")
    List<WebElement> resultList;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void performSearch(String searchTerm, String searchEngine) {
        if (searchEngine.equals("chrome")) {
            BaseActions.sendKeys(searchTextBox, searchTerm);
            BaseActions.click(searchButton);
        }
        if (searchEngine.equals("bing")) {
            System.out.println("bing");
            BaseActions.sendKeys(searchTextBox, searchTerm);
            BaseActions.click(searchButton);
        }
        if (searchEngine.equals("Yahoo")) {
            System.out.println("Yahoo");
            BaseActions.sendKeys(yahooSearchTextBox, searchTerm);
            BaseActions.click(yahooSearchButton);
        }
    }

    public String getFirstResultText() {
        BaseActions.waitForElement(searchResult);
        return BaseActions.getText(resultList.get(0));
    }
}
