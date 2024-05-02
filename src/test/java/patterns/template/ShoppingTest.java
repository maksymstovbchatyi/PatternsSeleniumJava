package patterns.template;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.BaseTest;
import patterns.templateMethod.AmazonShopping;
import patterns.templateMethod.EBayShopping;
import patterns.templateMethod.ShoppingTemplate;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate){
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                new EBayShopping(driver, "samsung 4k"),
                new AmazonShopping(driver, "samsung 4k")
        };
    }

}