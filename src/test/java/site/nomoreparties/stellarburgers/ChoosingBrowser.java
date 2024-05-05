package site.nomoreparties.stellarburgers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChoosingBrowser {
    static WebDriver driver;
    public static final String CHROME = "chrome";
    public static final String YANDEX = "yandex";
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "C:/WebDriver/bin/Chrome/chromedriver.exe";
    private static final String YANDEX_PATH = "C:/WebDriver/bin/Yandex/yandexdriver.exe";
    private static final String INCORRECT_BROWSER_TEXT1 = "Неподдерживаемый браузер: ";
    private static final String INCORRECT_BROWSER_TEXT2 = ". В методе createDriver() в качестве аргумента нужно выбрать константу CHROME или YANDEX";
    public static void createDriver(String browser) {
        if (browser.equalsIgnoreCase(CHROME)) {
            System.setProperty(DRIVER_PROPERTY, CHROME_PATH);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase(YANDEX)) {
            System.setProperty(DRIVER_PROPERTY, YANDEX_PATH);
            driver = new ChromeDriver();
        } else {
            System.out.println(INCORRECT_BROWSER_TEXT1 + browser + INCORRECT_BROWSER_TEXT2);
        }
    }
}
