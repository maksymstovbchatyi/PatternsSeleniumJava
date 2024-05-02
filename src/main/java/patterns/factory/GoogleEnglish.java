package patterns.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleEnglish extends GoogleAbstractPage{

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(css = "#rso div")
    private List<WebElement> results;

    public GoogleEnglish(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }


    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        for(char ch : keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.webDriverWait.until(d -> this.searchBtn.isDisplayed());
        this.searchBtn.click();
    }

    @Override
    public int resultCount() {
        this.webDriverWait.until(d -> this.results.size() > 1);
        return this.results.size();
    }
}
