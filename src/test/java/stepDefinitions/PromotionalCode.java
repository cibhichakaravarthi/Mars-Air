package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.MarsAirMainPage;
import pages.SearchResultsPage;
import util.CommonActions;

public class PromotionalCode {

    private WebDriver driver = DriverFactory.getDriver();
    private MarsAirMainPage marsAirMainPage = new MarsAirMainPage(driver);
    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    private CommonActions commonActions = new CommonActions(driver);

    @Given("user informs a promotional code {string}")
    public void user_informs_a_promotional_code(String promoCode) {
        marsAirMainPage.setPromoCode(promoCode);
    }

    @Then("the search result should have a message {string}")
    public void the_search_result_should_have_a_message(String message) {
        String expectedMsg = message;
        String actualMsg = searchResultsPage.getPromoCodeMsg();
        System.out.println("Expected Message: " + expectedMsg);
        System.out.println("Actual Message: " + actualMsg);
    }
}
