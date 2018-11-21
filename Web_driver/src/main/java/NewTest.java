import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {

    @Test
    public void Test () throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.alitalia.com/en_en/");
        WebElement searchBtn=driver.findElement(By.className("button"));
        WebElement err=driver.findElement(By.id("labelErrorInfoStatoVolo"));
        searchBtn.click();
        searchBtn.click();
        Assert.assertEquals(err,"Data not entered correctly");

    }

}