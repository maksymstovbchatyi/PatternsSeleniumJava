package patterns.srp.personal.pages;

import org.openqa.selenium.support.PageFactory;
import patterns.srp.personal.components.SearchSuggestion;
import patterns.srp.personal.components.SearchWidget;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

    public GooglePage(final WebDriver driver){
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public void goTo(){
        this.driver.get("https://www.google.com");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}