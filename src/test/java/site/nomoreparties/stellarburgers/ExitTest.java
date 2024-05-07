package site.nomoreparties.stellarburgers;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.steps.AccountPageSteps;
import site.nomoreparties.stellarburgers.steps.GeneralSteps;
import site.nomoreparties.stellarburgers.steps.LoginPageSteps;
import site.nomoreparties.stellarburgers.steps.MainPageSteps;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.*;
import static site.nomoreparties.stellarburgers.pom.constants.locators.LoginPageLocators.ENTER_BUTTON;

@DisplayName("Выход из аккаунта")
public class ExitTest {
    private GeneralSteps generalSteps = new GeneralSteps();
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private LoginPageSteps loginPageSteps = new LoginPageSteps();
    private AccountPageSteps accountPageSteps = new AccountPageSteps();
    @Before
    public void setUp() {
        generalSteps.setUpDriver();
        generalSteps.accessToken = generalSteps.createUser();
    }

    @Test
    @DisplayName("Тест на выход по кнопке «Выйти» в личном кабинете")
    @Description("Проверка что пользователь может выйти по кнопке «Выйти» в личном кабинете")
    public void exitAccount() {
        mainPageSteps.clickOnEnterButtonOnMainPage();
        loginPageSteps.setDataOnLoginPage();
        loginPageSteps.clickOnEnterButtonOnLoginPage();
        mainPageSteps.waitForMainPage();
        mainPageSteps.clickOnLkButtonOnMainPage();
        accountPageSteps.waitForAccountPage();
        accountPageSteps.clickOnExitButtonOnAccountPage();
        loginPageSteps.waitForLoginPage();
        Assert.assertTrue(driver.findElement(ENTER_BUTTON).isEnabled());
    }
    @After
    public void shutDownAndDeleteUser() {
        generalSteps.shutDownDriver();
        generalSteps.deleteUser();
    }
}
