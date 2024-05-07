package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.steps.*;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.*;
import static site.nomoreparties.stellarburgers.pom.constants.locators.MainPageLocators.MAKE_ORDER_BUTTON;

@DisplayName("Вход в аккаунт")
public class LoginTest {
    private GeneralSteps generalSteps = new GeneralSteps();
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private LoginPageSteps loginPageSteps = new LoginPageSteps();
    private ForgotPasswordPageSteps forgotPasswordPageSteps = new ForgotPasswordPageSteps();
    private RegisterPageSteps registerPageSteps = new RegisterPageSteps();
    @Before
    public void setUp() {
        generalSteps.setUpDriver();
        generalSteps.accessToken = generalSteps.createUser();
    }
    @Test
    @DisplayName("Тест на вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("Проверка что пользователь залогиниться по кнопке «Войти в аккаунт» на главной странице")
    public void loginOnMainPage() {
        mainPageSteps.clickOnEnterButtonOnMainPage();
        loginPageSteps.setDataOnLoginPage();
        loginPageSteps.clickOnEnterButtonOnLoginPage();
        mainPageSteps.waitForMainPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @Test
    @DisplayName("Тест на вход через кнопку «Личный кабинет»")
    @Description("Проверка что пользователь залогиниться через кнопку «Личный кабинет»")
    public void loginOnLoginPage() {
        mainPageSteps.clickOnLkButtonOnMainPage();
        loginPageSteps.setDataOnLoginPage();
        loginPageSteps.clickOnEnterButtonOnLoginPage();
        mainPageSteps.waitForMainPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @Test
    @DisplayName("Тест на вход через кнопку «Войти» в форме регистрации")
    @Description("Проверка что пользователь залогиниться через кнопку «Войти» в форме регистрации")
    public void loginOnRegisterPage() {
        mainPageSteps.clickOnLkButtonOnMainPage();
        loginPageSteps.clickOnRegisterButtonOnLoginPage();
        registerPageSteps.clickOnEnterButtonOnRegisterPage();
        loginPageSteps.waitForLoginPage();
        loginPageSteps.setDataOnLoginPage();
        loginPageSteps.clickOnEnterButtonOnLoginPage();
        mainPageSteps.waitForMainPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @Test
    @DisplayName("Тест на вход через кнопку «Войти» в форме восстановления пароля")
    @Description("Проверка что пользователь залогиниться через кнопку «Войти» в форме восстановления пароля")
    public void loginOnForgotPasswordPage() {
        mainPageSteps.clickOnLkButtonOnMainPage();
        loginPageSteps.clickOnRecoverPasswordButtonOnLoginPage();
        forgotPasswordPageSteps.clickOnEnterButtonOnForgotPasswordPage();
        loginPageSteps.waitForLoginPage();
        loginPageSteps.setDataOnLoginPage();
        loginPageSteps.clickOnEnterButtonOnLoginPage();
        mainPageSteps.waitForMainPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @After
    public void shutDownAndDeleteUser() {
        generalSteps.shutDownDriver();
        generalSteps.deleteUser();
    }
}
