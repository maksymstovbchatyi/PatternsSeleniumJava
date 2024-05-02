package patterns.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {
    private static final Function<WebDriver, GoogleAbstractPage> ENG = GoogleEnglish::new;
    private static final Function<WebDriver, GoogleAbstractPage> FR = GoogleFrench::new;
    private static final Function<WebDriver, GoogleAbstractPage> SA = GoogleArabic::new;
    private static final Map<String, Function<WebDriver, GoogleAbstractPage>> MAP = new HashMap<>();

    //private final static Function<WebDriver, GoogleAbstractPage> ENG = (driver)-> new GoogleEnglish(driver);

    static {
        MAP.put("ENG", ENG);
        MAP.put("FR", FR);
        MAP.put("SA", SA);
       // MAP.put("ES", ES);

    }

    public static GoogleAbstractPage get(String language, WebDriver driver) {
        return MAP.get(language).apply(driver);
    }

}
