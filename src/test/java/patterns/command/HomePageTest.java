package patterns.command;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.BaseTest;

public class HomePageTest extends BaseTest {

     private HomePage homePage;

    @BeforeTest
    public void setHomePage(){
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest(){
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ElementValidator::validate)
                .forEach(Assert::assertTrue);
    }
}
