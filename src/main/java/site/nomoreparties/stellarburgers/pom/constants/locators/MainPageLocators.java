package site.nomoreparties.stellarburgers.pom.constants.locators;

import org.openqa.selenium.By;

public class MainPageLocators {
    public static final By LK_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    public static final By ENTER_BUTTON= By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By BUN_ELEMENT= By.xpath(".//span[text()='Булки']/parent::div");
    public static final By SAUCE_ELEMENT= By.xpath(".//span[text()='Соусы']/parent::div");
    public static final By FILLING_ELEMENT= By.xpath(".//span[text()='Начинки']/parent::div");
    public static final By MAKE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
}
