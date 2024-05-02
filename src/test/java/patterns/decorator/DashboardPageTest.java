package patterns.decorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.BaseTest;

import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeTest
    public void setDashboardPage(){
        this.dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "getData")
    public void roleTest(Consumer<DashboardPage> role){
        this.dashboardPage.goTo();
        role.accept(this.dashboardPage);
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                Decorators.guestPage,
                Decorators.suPage,
                Decorators.adminPage
        };
    }



}