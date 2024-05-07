package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pom.AccountPage;
import site.nomoreparties.stellarburgers.steps.*;

import static org.hamcrest.CoreMatchers.is;
import static site.nomoreparties.stellarburgers.ChoosingBrowser.driver;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.*;

@DisplayName("Переход в личный кабинет")
public class RedirectToLkTest {
    private GeneralSteps generalSteps = new GeneralSteps();
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private LoginPageSteps loginPageSteps = new LoginPageSteps();
    private AccountPageSteps accountPageSteps = new AccountPageSteps();
    private AccountPage accountPage;


    @Before
    public void setUp() {
        generalSteps.setUpDriver();
        generalSteps.accessToken = generalSteps.createUser();
        accountPage = new AccountPage(driver);
    }

    @Test
    @DisplayName("Тест на переход в личный кабинет")
    @Description("Проверка что авторизованный пользователь может перейти в личный кабинет")
    public void redirectToLk() {
        mainPageSteps.clickOnEnterButtonOnMainPage();
        loginPageSteps.setDataOnLoginPage();
        loginPageSteps.clickOnEnterButtonOnLoginPage();
        mainPageSteps.waitForMainPage();
        mainPageSteps.clickOnLkButtonOnMainPage();
        accountPageSteps.waitForAccountPage();
        MatcherAssert.assertThat(accountPage.getActualEmailText(), is(EMAIL));
    }
    @After
    public void shutDownAndDeleteUser() {
        generalSteps.shutDownDriver();
        generalSteps.deleteUser();
    }
}
