package org.example.pageactions;

import org.example.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class GoogleSearchPage implements SearchEngine{
    WebDriver driver;


    @FindBy(name = "q")
    WebElement searchTextBox;

    @FindBy(xpath = "//input[@role='button' and @type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@id='search']")
    WebElement searchResult;
    @FindBy(xpath = "//div[@id='search']//following::h3")
    List<WebElement> resultList;

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void performSearch(String searchTerm) {
        BaseActions.sendKeys(searchTextBox,searchTerm);
        BaseActions.click(searchButton);
    }

    public WebElement getFirstResultText() {
        BaseActions.waitForElement(searchResult);
        return resultList.get(0);
    }
}
