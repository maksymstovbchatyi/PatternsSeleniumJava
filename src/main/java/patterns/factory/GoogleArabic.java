package patterns.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleArabic extends GoogleEnglish{

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    @FindBy(css = "span.hOoLGe")
    private WebElement keyboardBtn;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite(){
        this.driver.get("https://www.google.com.sa");
        this.language.click();
    }

    @Override
    public void search(String keyword){
        this.webDriverWait.until(d -> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.webDriverWait.until(d -> this.keyboard.isDisplayed());
        super.search(keyword);
    }




}
