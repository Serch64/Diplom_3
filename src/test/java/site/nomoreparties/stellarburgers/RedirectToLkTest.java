package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.*;

@DisplayName("Переход в личный кабинет")
public class RedirectToLkTest extends Steps{
    @Before
    public void setUp() {
        setUpDriver();
        accessToken = createUser();
    }

    @Test
    @DisplayName("Тест на переход в личный кабинет")
    @Description("Проверка что авторизованный пользователь может перейти в личный кабинет")
    public void redirectToLk() {
        clickOnEnterButtonOnMainPage();
        setDataOnLoginPage();
        clickOnEnterButtonOnLoginPage();
        clickOnLkButtonOnMainPage();
        waitForAccountPage();
        MatcherAssert.assertThat(accountPage.getActualEmailText(), is(EMAIL));
    }
    @After
    public void shutDownAndDeleteUser() {
        shutDownDriver();
        deleteUser();
    }
}
