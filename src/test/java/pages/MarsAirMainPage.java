package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import util.CommonActions;
import util.Constants;

public class MarsAirMainPage {

    private WebDriver driver;
    private CommonActions commonActions;

    private By departureField = By.cssSelector("[for='departing']");
    private By departureSelect = By.cssSelector("#departing");
    private By returnField = By.cssSelector("[for='returning']");
    private By returnSelect = By.cssSelector("#returning");
    private By promoCode = By.cssSelector("#promotional_code");
    private By searchBtn = By.cssSelector("[type='submit']");
    private By marsAirLogo = By.xpath("//a[contains(text(),' MarsAir')]");
    private By pageFormTitle = By.xpath("//h2[contains(text(),'Welcome to MarsAir!')]");

    private String departureFieldName = "Departure";
    private String returnFieldName = "Return";


    public MarsAirMainPage(WebDriver driver) {
        this.driver = driver;
        commonActions = new CommonActions(driver); // Initialize CommonActions
    }

    public MarsAirMainPage accessMainPage() {
        driver.get(Constants.MAIN_URL);
        return this;
    }

    // Select departure date
    public void setDepartureDate(String value) {
        Select departureDate = new Select(commonActions.findElement(departureSelect));
        departureDate.selectByVisibleText(value);
    }

    // Select return date
    public void setReturnDate(String value) {
        Select returnDate = new Select(commonActions.findElement(returnSelect));
        returnDate.selectByVisibleText(value);
    }

    // Set the promo code
    public void setPromoCode(String code) {
        commonActions.setElementValue(promoCode, code);
    }

    // Click the search button
    public void clickSearchBtn() {
        commonActions.click(searchBtn);
    }

    // Click MarsAir Logo using JavaScript (in case regular click doesn’t work)
    public void clickMarsAirLogo() {
        commonActions.clickWithJavaScript(marsAirLogo);
    }

    // Check if the departure field is present and correct
    public boolean hasDepartureField() {
        return commonActions.isFieldName(departureField, departureFieldName) 
                && commonActions.hasElement(departureSelect);
    }

    // Check if the return field is present and correct
    public boolean hasReturnField() {
        return commonActions.isFieldName(returnField, returnFieldName) 
                && commonActions.hasElement(returnSelect);
    }

    // Get the form title text (Welcome message)
    public String getFormTitle() {
        return commonActions.getElementText(pageFormTitle);
    }

    // Get the title of the page
    public String getPageTitle() {
        return driver.getTitle();
    }
}
