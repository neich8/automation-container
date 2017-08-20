import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by nick on 8/15/17.
 */
public class GoogleTest {
    WebDriver d;
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Setting chrome options");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        System.out.println("Setting chrome.driver location to " +  System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        System.out.println("Building chrome");
        d =  new ChromeDriver(chromeOptions);
        System.out.println("Going to google.com");
        d.get("https://google.com");
    }

    @Test
    public void passingTest() {
        System.out.println("Starting test");
        WebElement el = d.findElement(By.cssSelector("#hplogo"));
        Assert.assertTrue(el.isDisplayed());
    }

    @Test(enabled = false)
    public void failingTest() {
        WebElement el = d.findElement(By.cssSelector("#hplogo"));
        Assert.assertFalse(el.isDisplayed());
    }


    @AfterMethod
    public void quitDriver() {
        d.quit();
    }

}
