package site.nomoreparties.stellarburgers.pom.constants.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By REGISTER_BUTTON = By.xpath(".//a[@href='/register']");
    public static final By EMAIL_FIELD = By.xpath(".//fieldset[1]/div/div/input");
    public static final By PASSWORD_FIELD = By.xpath(".//fieldset[2]/div/div/input");
    public static final By ENTER_BUTTON = By.xpath(".//button[text()='Войти']");
    public static final By RECOVER_PASSWORD_BUTTON = By.xpath(".//a[@href='/forgot-password']");

}
