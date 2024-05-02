package patterns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = getChromeDriver();
    }


    public ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @AfterTest
    public void exit() {
        this.driver.quit();
    }

}
