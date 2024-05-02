package proxy;

import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;
import patterns.BaseTest;
import patterns.proxy.PaymentOptionFactory;
import patterns.proxy.PaymentScreen;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {

    private patterns.proxy.PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen(){
        System.setProperty("env", "QA");
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails){
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("vinoth", "selvaraj", "udemy@gmail.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrderComponent().placeOrder();

        System.out.println(
                "Order Number : " + orderNumber
        );

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }

    @DataProvider
    public Object[][] getData(){

        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "1231231231");
        cc.put("year", "2023");
        cc.put("cvv", "123");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "myaccount123");
        nb.put("pin", "999");

        return new Object[][]{
                {"CC", cc} ,
                {"NB", nb}
        };
    }

}