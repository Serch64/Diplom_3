package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.*;
import static site.nomoreparties.stellarburgers.pom.constants.locators.LoginPageLocators.ENTER_BUTTON;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.*;

@DisplayName("Регистрация пользователя")
public class RegistrationTest extends Steps{

    private static final String EXPECTED_ERROR_TEXT = "Некорректный пароль";

    @Before
    public void setUp() {
        setUpDriver();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка что пользователь может зарегистрироваться")
    public void registerAccountSuccessfully() {
        clickOnEnterButtonOnMainPage();
        clickOnRegisterButtonOnLoginPage();
        setDataOnRegisterPage(VALID_PASSWORD);
        clickOnRegisterButtonOnRegisterPage();
        Assert.assertTrue(driver.findElement(ENTER_BUTTON).isEnabled());
    }
    @Test
    @DisplayName("Попытка регистрации пользователя с некорректным паролем")
    @Description("Проверка что пользователь не может зарегистрироваться и получение ошибки")
    public void registerAccountInvalidPassword() {
        clickOnEnterButtonOnMainPage();
        clickOnRegisterButtonOnLoginPage();
        setDataOnRegisterPage(INVALID_PASSWORD);
        clickOnNameFieldOnRegisterPage();
        Assert.assertEquals(EXPECTED_ERROR_TEXT, registerPage.getActualPasswordErrorText());
    }

    @After
    public void shutDownAndDeleteUser() {
        shutDownDriver();
        accessToken = deleteUserPreparation();
        deleteUser();
    }
}
