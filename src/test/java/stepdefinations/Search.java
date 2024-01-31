package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BaseActions;
import org.example.DriverFactory;
import org.example.pageactions.SearchPage;

import static org.junit.Assert.assertEquals;

public class Search {
    SearchPage searchPage = new SearchPage(DriverFactory.getCurrentDriver());
    private String actualResult;

    @Given("I am on the {string} search engine")
    public void iAmOnTheSearchEngine(String searchEngine) {
        BaseActions.navigateURL(getSearchEngineUrl(searchEngine));
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        searchPage.performSearch(searchTerm);
        actualResult = searchPage.getFirstResultText();
    }

    @Then("the first result should be {string}")
    public void theFirstResultShouldBe(String expectedResult) {
        assertEquals(expectedResult, actualResult);
        DriverFactory.getCurrentDriver().quit();
    }

    private String getSearchEngineUrl(String searchEngine) {
        switch (searchEngine.toLowerCase()) {
            case "google":
                return "https://www.google.com";
            case "bing":
                return "https://www.bing.com";
            case "yahoo":
                return "https://www.yahoo.com";
            default:
                throw new IllegalArgumentException("Invalid search engine: " + searchEngine);
        }
    }
}
