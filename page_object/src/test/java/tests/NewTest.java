package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class NewTest {
    public static WebDriver driver;
    public static SearchPage page;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        page = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.alitalia.com/en_en/");
    }

    @Test
    public void checkFieldsFill() throws InterruptedException {
        SearchPage A = new SearchPage(driver);
        A.test();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
