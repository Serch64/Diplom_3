package site.nomoreparties.stellarburgers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChoosingBrowser {

    public static WebDriver driver;
    private static final String BROWSER = "browser";
    private static final String CHROME = "chrome";
    private static final String YANDEX = "yandex";
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src/test/resources/chromedriver.exe";
    private static final String YANDEX_PATH = "src/test/resources/yandexdriver.exe";

    public static void createDriver() {
        String browserProperty = System.getProperty(BROWSER);
        if (browserProperty != null && browserProperty.equals(CHROME)) {
            System.setProperty(DRIVER_PROPERTY, CHROME_PATH);
            driver = new ChromeDriver();
        } else if (browserProperty != null && browserProperty.equals(YANDEX)) {
            System.setProperty(DRIVER_PROPERTY, YANDEX_PATH);
            driver = new ChromeDriver();
        }
    }
}
