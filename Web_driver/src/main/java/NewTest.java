import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {

    @Test
    public void Test ()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.alitalia.com/en_en/");
        //sleep(1000);
        WebElement searchBtn=driver.findElement(By.id("validate_date"));
        WebElement err=driver.findElement(By.id("labelErrorInfoStatoVolo"));
        //WebElement bookBtn=driver.findElement(By.id("cerca-volo__tab cerca-volo__tab--prenota is-active tabs-title"));
        searchBtn.click();
        searchBtn.click();
        Assert.assertEquals(err.getText(),"Data not entered correctly");

    }
}