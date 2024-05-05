package site.nomoreparties.stellarburgers.pom.constants.locators;

import org.openqa.selenium.By;

public class RegisterPageLocators {
    public static final By NAME_FIELD = By.xpath(".//fieldset[1]/div/div/input");
    public static final By EMAIL_FIELD = By.xpath(".//fieldset[2]/div/div/input");
    public static final By PASSWORD_FIELD = By.xpath(".//fieldset[3]/div/div/input");
    public static final By REGISTER_BUTTON = By.className("button_button__33qZ0");
    public static final By ENTER_BUTTON = By.className("Auth_link__1fOlj");
    public static final By ERROR_HINT = By.xpath(".//p[text()='Некорректный пароль']");
}
