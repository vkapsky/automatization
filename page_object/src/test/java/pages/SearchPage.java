package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class SearchPage {
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "validate_date")
    private WebElement searchBtn;

    @FindBy(id = "labelErrorInfoStatoVolo")
    private WebElement err;

    public void test() throws InterruptedException {
        sleep(5000);
        searchBtn.click();
        searchBtn.click();

        Assert.assertEquals(err.getText(), "Data not entered correctly");
    }
}
