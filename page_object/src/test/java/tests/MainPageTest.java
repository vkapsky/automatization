package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.server.handler.SendKeys;
import pages.FlightSelectPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MainPageTest {
    public static WebDriver driver;
    public static MainPage page;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        page = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.alitalia.com/en_en/");
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    @Test
    public void checkBookFieldsFillMain() {
        MainPage page = new MainPage(driver);
        waitForLoad(driver);
        String errorText = "Data not entered correctly";
        //page.getBookBtn().click();
        page.getBookSwitchBtn().click();
        page.getBookBtn().click();
        Assert.assertEquals(page.getBookError().getText(), errorText);
    }

    @Test
    public void checkCheckInFieldsFillMain() {
        MainPage page = new MainPage(driver);
        waitForLoad(driver);
        String errorText = "The Booking Code field is mandatory. The name field is mandatory. The last name field is mandatory.";
        page.getCheckInSwitchBtn().click();
        page.getCheckInBtn().click();
        Assert.assertEquals(page.getCheckInError().getText(), errorText);
    }

    @Test
    public void checkMyFlightsFieldsFillMain() {
        MainPage page = new MainPage(driver);
        waitForLoad(driver);
        String errorText = "The Booking Code field is mandatory. The name field is mandatory. The last name field is mandatory.";
        page.getMyFlightsSwitchBtn().click();
        page.getMyFlightsBtn().click();
        Assert.assertEquals(page.getMyFlightsError().getText(), errorText);
    }

    @Test
    public void checkFlightInfoFieldsFillMain() {
        MainPage page = new MainPage(driver);
        waitForLoad(driver);
        String errorText = "The flight number field is mandatory. The departure date field is mandatory.";
        page.getFlightInfoSwitchBtn().click();
        page.getFlightInfoBtn().click();
        Assert.assertEquals(page.getFlightInfoError().getText(), errorText);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
