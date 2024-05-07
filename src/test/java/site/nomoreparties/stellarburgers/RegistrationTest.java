package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pom.RegisterPage;
import site.nomoreparties.stellarburgers.steps.*;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.*;
import static site.nomoreparties.stellarburgers.pom.constants.locators.LoginPageLocators.ENTER_BUTTON;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.*;

@DisplayName("Регистрация пользователя")
public class RegistrationTest {

    private static final String EXPECTED_ERROR_TEXT = "Некорректный пароль";
    private GeneralSteps generalSteps = new GeneralSteps();
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private LoginPageSteps loginPageSteps = new LoginPageSteps();
    private RegisterPageSteps registerPageSteps = new RegisterPageSteps();
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        generalSteps.setUpDriver();
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка что пользователь может зарегистрироваться")
    public void registerAccountSuccessfully() {
        mainPageSteps.clickOnEnterButtonOnMainPage();
        loginPageSteps.clickOnRegisterButtonOnLoginPage();
        registerPageSteps.setDataOnRegisterPage(VALID_PASSWORD);
        registerPageSteps.clickOnRegisterButtonOnRegisterPage();
        loginPageSteps.waitForLoginPage();
        Assert.assertTrue(driver.findElement(ENTER_BUTTON).isEnabled());
    }
    @Test
    @DisplayName("Попытка регистрации пользователя с некорректным паролем")
    @Description("Проверка что пользователь не может зарегистрироваться и получение ошибки")
    public void registerAccountInvalidPassword() {
        mainPageSteps.clickOnEnterButtonOnMainPage();
        loginPageSteps.clickOnRegisterButtonOnLoginPage();
        registerPageSteps.setDataOnRegisterPage(INVALID_PASSWORD);
        registerPageSteps.clickOnNameFieldOnRegisterPage();
        Assert.assertEquals(EXPECTED_ERROR_TEXT, registerPage.getActualPasswordErrorText());
    }

    @After
    public void shutDownAndDeleteUser() {
        generalSteps.shutDownDriver();
        generalSteps.accessToken = generalSteps.deleteUserPreparation();
        generalSteps.deleteUser();
    }
}
