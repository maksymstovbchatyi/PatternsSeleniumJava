package patterns.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.BaseTest;

public class GoogleSearchTest extends BaseTest {
    private GoogleAbstractPage googleAbstractPage;


    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword){
        this.googleAbstractPage = GoogleFactory.get(language, this.driver);
        this.googleAbstractPage.launchSite();
        this.googleAbstractPage.search(keyword);
        int resultCount = this.googleAbstractPage.resultCount();
        System.out.println("Result Count : " + resultCount);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "design patterns"},
                {"SA", "docker"},
                {"ES", "selenium"}
        };
    }
}
