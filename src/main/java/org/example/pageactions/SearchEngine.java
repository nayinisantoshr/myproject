package org.example.pageactions;

import org.openqa.selenium.WebElement;

public interface SearchEngine {

    public void performSearch(String searchString);
    public WebElement getFirstResultText();

}
