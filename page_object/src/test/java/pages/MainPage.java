package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@class='cerca-volo__tab cerca-volo__tab--prenota tabs-title']")
    private WebElement bookSwitchBtn;

    @FindBy(id = "validate_date")
    private WebElement bookBtn;

    @FindBy(id = "labelErrorInfoStatoVolo")
    private WebElement bookError;

    @FindBy(xpath = "//li[@class='cerca-volo__tab cerca-volo__tab--check-in tabs-title']")
    private WebElement checkInSwitchBtn;

    @FindBy(id = "cercaPnrSubmit")
    private WebElement checkInBtn;

    @FindBy(id = "labelCheckinError")
    private WebElement checkInError;

    @FindBy(xpath = "//li[@class='cerca-volo__tab cerca-volo__tab--miei-voli tabs-title']")
    private WebElement myFlightsSwitchBtn;

    @FindBy(id = "cercamyFlightSubmit")
    private WebElement myFlightsBtn;

    @FindBy(xpath = "//div[@class='custom-row']/form[@class='flight_search_code']/div[@class='labelErrorInfoStatoVolo feedback-wrap feedback-error']")
    private WebElement myFlightsError;


    @FindBy(xpath = "//li[@class='cerca-volo__tab cerca-volo__tab--info-voli tabs-title']/a[@id='flights-info']")
    private WebElement flightInfoSwitchBtn;

    @FindBy(id = "flight-status-search")
    private WebElement flightInfoBtn;

    @FindBy(xpath = "//form[@class='flight_status']/div[@class='labelErrorInfoStatoVolo feedback-wrap feedback-error']")
    private WebElement flightInfoError;

    @FindBy(id = "luogo-arrivo--prenota-desk")
    private WebElement dest;

    @FindBy(id = "data-andata--prenota-desk")
    private WebElement departureDate;

    @FindBy(id = "data-ritorno--prenota-desk")
    private WebElement returnDate;

    @FindBy(id = "submitHidden--prenota")
    private WebElement bookSubmitBtn;

    @FindBy(id = "addBabies")
    private WebElement addBabiesBtn;

    @FindBy(id = "name")
    private WebElement checkInName;

    @FindBy(id = "surname")
    private WebElement checkInSurname;

    public WebElement getBookSwitchBtn() {
        return bookSwitchBtn;
    }

    public WebElement getBookError() {
        return bookError;
    }

    public WebElement getBookBtn() {
        return bookBtn;
    }

    public WebElement getCheckInSwitchBtn() {
        return checkInSwitchBtn;
    }

    public WebElement getCheckInError() {
        return checkInError;
    }

    public WebElement getCheckInBtn() {
        return checkInBtn;
    }

    public WebElement getMyFlightsSwitchBtn() {
        return myFlightsSwitchBtn;
    }

    public WebElement getMyFlightsBtn() {
        return myFlightsBtn;
    }

    public WebElement getMyFlightsError() {
        return myFlightsError;
    }

    public WebElement getFlightInfoSwitchBtn() {
        return flightInfoSwitchBtn;
    }

    public WebElement getFlightInfoBtn() {
        return flightInfoBtn;
    }

    public WebElement getFlightInfoError() {
        return flightInfoError;
    }

    public WebElement getDest() {
        return dest;
    }

    public WebElement getDepartureDate() {
        return departureDate;
    }

    public WebElement getReturnDate() {
        return returnDate;
    }

    public WebElement getBookSubmitBtn() {
        return bookSubmitBtn;
    }

    public WebElement getCheckInName() {
        return checkInName;
    }

    public WebElement getCheckInSurname() {
        return checkInSurname;
    }
}
