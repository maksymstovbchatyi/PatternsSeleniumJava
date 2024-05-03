package patterns.decorator;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.BaseTest;

import java.util.function.Consumer;

public class PaymentScreenHomeWorkTest extends BaseTest {

   private PaymentScreenPage paymentScreenPage;


   @BeforeTest
   public void setUp(){
       this.paymentScreenPage = new PaymentScreenPage(driver);
   }


  @Test(dataProvider = "getData")
  public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {
        this.paymentScreenPage.goTo();
        consumer.accept(this.paymentScreenPage);

  }



 @DataProvider
 public Object [] getData(){
       return new Object[]{
               PaymentDecorators.validCC.andThen(PaymentDecorators.buy).andThen(PaymentDecorators.successfulPurchase)
       };
 }


}
