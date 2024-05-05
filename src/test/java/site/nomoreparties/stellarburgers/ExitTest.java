package site.nomoreparties.stellarburgers;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.*;
import static site.nomoreparties.stellarburgers.pom.constants.locators.LoginPageLocators.ENTER_BUTTON;

@DisplayName("Выход из аккаунта")
public class ExitTest extends Steps {
    @Before
    public void setUp() {
        setUpDriver();
        accessToken = createUser();
    }

    @Test
    @DisplayName("Тест на выход по кнопке «Выйти» в личном кабинете")
    @Description("Проверка что пользователь может выйти по кнопке «Выйти» в личном кабинете")
    public void exitAccount() {
        clickOnEnterButtonOnMainPage();
        setDataOnLoginPage();
        clickOnEnterButtonOnLoginPage();
        clickOnLkButtonOnMainPage();
        waitForAccountPage();
        clickOnExitButtonOnAccountPage();
        Assert.assertTrue(driver.findElement(ENTER_BUTTON).isEnabled());
    }
    @After
    public void shutDownAndDeleteUser() {
        shutDownDriver();
        deleteUser();
    }
}
