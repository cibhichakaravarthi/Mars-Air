package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.MarsAirMainPage;
import pages.SearchResultsPage;
import util.CommonActions;

public class LinkToHome {

    private WebDriver driver = DriverFactory.getDriver();
    private MarsAirMainPage marsAirMainPage = new MarsAirMainPage(driver);
    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    private CommonActions commonActions = new CommonActions(driver);

    @When("user clicks on the MarsAir logo on the top left from home")
    public void user_clicks_on_the_MarsAir_logo_on_the_top_left_from_home() {
        marsAirMainPage.clickMarsAirLogo();
    }

    @When("user clicks on the MarsAir logo on the top left from search results page")
    public void user_clicks_on_the_MarsAir_logo_on_the_top_left_from_search_results_page() {
        searchResultsPage.clickMarsAirLogo();
    }

    @Then("user should be taken to home page")
    public void user_should_be_taken_to_home_page() {
        String actualFormTitle = marsAirMainPage.getPageTitle();
        System.out.println("Navigated page title: " + actualFormTitle);
    }
}
