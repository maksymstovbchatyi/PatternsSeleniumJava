package patterns.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Supplier<PaymentOption> CC = CreditCard::new;
    private static final Supplier<PaymentOption> NB = NetBanking::new;

    private static final Map<String, Supplier<PaymentOption>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
    }

    public static PaymentOption get(String option){
        return MAP.get(option).get();
    }

}