package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.*;
import static site.nomoreparties.stellarburgers.pom.constants.locators.MainPageLocators.MAKE_ORDER_BUTTON;

@DisplayName("Вход в аккаунт")
public class LoginTest extends Steps{
    @Before
    public void setUp() {
        setUpDriver();
        accessToken = createUser();
    }
    @Test
    @DisplayName("Тест на вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("Проверка что пользователь залогиниться по кнопке «Войти в аккаунт» на главной странице")
    public void loginOnMainPage() {
        clickOnEnterButtonOnMainPage();
        setDataOnLoginPage();
        clickOnEnterButtonOnLoginPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @Test
    @DisplayName("Тест на вход через кнопку «Личный кабинет»")
    @Description("Проверка что пользователь залогиниться через кнопку «Личный кабинет»")
    public void loginOnLoginPage() {
        clickOnLkButtonOnMainPage();
        setDataOnLoginPage();
        clickOnEnterButtonOnLoginPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @Test
    @DisplayName("Тест на вход через кнопку «Войти» в форме регистрации")
    @Description("Проверка что пользователь залогиниться через кнопку «Войти» в форме регистрации")
    public void loginOnRegisterPage() {
        clickOnLkButtonOnMainPage();
        clickOnRegisterButtonOnLoginPage();
        clickOnEnterButtonOnRegisterPage();
        setDataOnLoginPage();
        clickOnEnterButtonOnLoginPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @Test
    @DisplayName("Тест на вход через кнопку «Войти» в форме восстановления пароля")
    @Description("Проверка что пользователь залогиниться через кнопку «Войти» в форме восстановления пароля")
    public void loginOnForgotPasswordPage() {
        clickOnLkButtonOnMainPage();
        clickOnRecoverPasswordButtonOnLoginPage();
        clickOnEnterButtonOnForgotPasswordPage();
        setDataOnLoginPage();
        clickOnEnterButtonOnLoginPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @After
    public void shutDownAndDeleteUser() {
        shutDownDriver();
        deleteUser();
    }
}
