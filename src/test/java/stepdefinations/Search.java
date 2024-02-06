package stepdefinations;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BaseActions;
import org.example.DriverFactory;
import org.example.pageactions.BingoSearchPage;
import org.example.pageactions.GoogleSearchPage;
import org.example.pageactions.SearchEngine;
import org.example.pageactions.YahooSearchPage;
import org.junit.Assert;


import static org.junit.Assert.assertEquals;

public class Search {

    private SearchEngine searchPage;
    private String actualResult;

    @Given("I am on the {string} search engine")
    public void iAmOnTheSearchEngine(String searchEngine) {
        BaseActions.navigateURL(assignSearchEngine(searchEngine));
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        searchPage.performSearch(searchTerm);

    }

    @Then("the first result should be present")
    public void theFirstResultShouldBe() {
        Assert.assertTrue(searchPage.getFirstResultText().isDisplayed());
    }



    private String assignSearchEngine(String searchEngine){
        switch (searchEngine.toLowerCase()) {
            case "google":
                searchPage = new GoogleSearchPage(DriverFactory.getCurrentDriver());
                return "https://www.google.com";

            case "bing":
                searchPage = new BingoSearchPage(DriverFactory.getCurrentDriver());
                return "https://www.bing.com";
            case "yahoo":
                searchPage = new YahooSearchPage(DriverFactory.getCurrentDriver());
                return "https://www.yahoo.com";
            default:
                throw new IllegalArgumentException("Invalid search engine: " + searchEngine);
        }
    }
}
