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
import pages.FlightSelectPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class FlightSelectPageTest {
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
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    @Test
    public void isCityRight() {
        MainPage mPage = new MainPage(driver);
        FlightSelectPage fsPage = new FlightSelectPage(driver);
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        waitForLoad(driver);
        //mPage.getBookSwitchBtn().click();
        mPage.getBookBtn().click();
        String inputText = "Milan MIL";
        mPage.getDest().sendKeys(inputText);
        mPage.getDepartureDate().sendKeys("26/12/2018");
        mPage.getReturnDate().sendKeys("02/01/2019");
        mPage.getBookBtn().click();
        mPage.getBookSubmitBtn().click();
        Assert.assertEquals(fsPage.getArrivalCity().getText(), inputText);
        driver.get("https://www.alitalia.com/en_en/");

    }

    @Test
    public void isDataRight() {
        MainPage mPage = new MainPage(driver);
        FlightSelectPage fsPage = new FlightSelectPage(driver);
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        waitForLoad(driver);
        //mPage.getBookSwitchBtn().click();
        mPage.getBookBtn().click();
        String inputText = "Milan MIL";
        mPage.getDest().sendKeys(inputText);
        mPage.getDepartureDate().clear();
        mPage.getDepartureDate().sendKeys("26/12/2018");
        mPage.getReturnDate().clear();
        mPage.getReturnDate().sendKeys("03/01/2019");
        mPage.getBookBtn().click();
        mPage.getBookSubmitBtn().click();
        Assert.assertEquals(fsPage.getDate().getText(), "26 Dec - 03 Jan");
        driver.get("https://www.alitalia.com/en_en/");

    }
    @Test
    public void numberOfAdults() {
        MainPage mPage = new MainPage(driver);
        FlightSelectPage fsPage = new FlightSelectPage(driver);
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        waitForLoad(driver);
        //mPage.getBookSwitchBtn().click();
        mPage.getBookBtn().click();
        String inputText = "Milan MIL";
        mPage.getDest().sendKeys(inputText);
        mPage.getDepartureDate().clear();
        mPage.getDepartureDate().sendKeys("26/12/2018");
        mPage.getReturnDate().clear();
        mPage.getReturnDate().sendKeys("03/01/2019");
        mPage.getBookBtn().click();
        mPage.getBookSubmitBtn().click();
        Assert.assertEquals(fsPage.getNumberOfAdults().getText(), "26 Dec - 03 Jan | 1 Adult\n" +
                "Change search");
        driver.get("https://www.alitalia.com/en_en/");
    }

    @Test
    public void EconomicClass() {
        MainPage mPage = new MainPage(driver);
        FlightSelectPage fsPage = new FlightSelectPage(driver);
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        waitForLoad(driver);
        //mPage.getBookSwitchBtn().click();
        mPage.getBookBtn().click();
        String inputText = "Milan MIL";
        mPage.getDest().sendKeys(inputText);
        mPage.getDepartureDate().clear();
        mPage.getDepartureDate().sendKeys("26/12/2018");
        mPage.getReturnDate().clear();
        mPage.getReturnDate().sendKeys("03/01/2019");
        mPage.getBookBtn().click();
        mPage.getBookSubmitBtn().click();
        Assert.assertEquals(fsPage.getFlightClass().getText(), "ECONOMY");
        driver.get("https://www.alitalia.com/en_en/");
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
