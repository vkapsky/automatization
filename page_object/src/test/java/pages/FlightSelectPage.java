package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSelectPage {
    public WebDriver driver;

    public FlightSelectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "bookInfoBoxItinerary__return")
    private WebElement arrivalCity;

    @FindBy(xpath = "//p[@class='bookInfoBoxItinerary__info']/span[@class='date']")
    private WebElement date;

    @FindBy(className = "bookInfoBoxItinerary__info")
    private WebElement numberOfAdults;

    @FindBy(xpath = "//div[@class='verticalAlignMiddle']/span[@class='text']/p")
    private WebElement flightClass;

    public WebElement getArrivalCity() {
        return arrivalCity;
    }

    public WebElement getDate() {
        return date;
    }

    public WebElement getNumberOfAdults() {
        return numberOfAdults;
    }

    public WebElement getFlightClass() {
        return flightClass;
    }
}
