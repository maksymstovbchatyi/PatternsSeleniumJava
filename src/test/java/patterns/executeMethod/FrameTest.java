package patterns.executeMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.BaseTest;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage(){
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest(){
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> {
            a.setFirstName("fn1");
            a.setMessage("I am going to fill text area");
        });
        this.mainPage.onFrameC(c ->
                c.setAddress("address for FrameC"));
        this.mainPage.onFrameB(
                b ->{
                    b.setMessage("this is for Frame B");
                   b.setAddress("AddresB maks");
                  b.setFirstName("Maks");
                  b.setLastName("St");
                });
    }

}