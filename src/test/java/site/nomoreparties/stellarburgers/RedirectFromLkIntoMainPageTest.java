package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import site.nomoreparties.stellarburgers.steps.*;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.*;
import static site.nomoreparties.stellarburgers.pom.constants.locators.AccountPageLocators.CONSTRUCTOR_BUTTON;
import static site.nomoreparties.stellarburgers.pom.constants.locators.AccountPageLocators.LOGO_IMG;
import static site.nomoreparties.stellarburgers.pom.constants.locators.MainPageLocators.MAKE_ORDER_BUTTON;

@DisplayName("Переход из личного кабинета в конструктор")
@RunWith(Parameterized.class)
public class RedirectFromLkIntoMainPageTest {
    private GeneralSteps generalSteps = new GeneralSteps();
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private AccountPageSteps accountPageSteps = new AccountPageSteps();
    private LoginPageSteps loginPageSteps = new LoginPageSteps();
    private final By mainPageButton;
    private final String buttonName;


    public RedirectFromLkIntoMainPageTest(By mainPageButton, String buttonName) {
        this.mainPageButton = mainPageButton;
        this.buttonName = buttonName;
    }

    @Parameterized.Parameters(name = "Тест {index}. Переход по клику на {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {CONSTRUCTOR_BUTTON, "конструктор"},
                {LOGO_IMG, "лого"}
        };
    }

    @Before
    public void setUp() {
        generalSteps.setUpDriver();
        generalSteps.accessToken = generalSteps.createUser();
    }
    @Test
    @DisplayName("Параметризованный тест на переход из личного кабинета на главную страницу с конструктором")
    @Description("Проверка что авторизованный пользователь может перейти из личного кабинета на главную страницу с конструктором")
    public void redirectFromLkIntoMainPage() {
        mainPageSteps.clickOnEnterButtonOnMainPage();
        loginPageSteps.setDataOnLoginPage();
        loginPageSteps.clickOnEnterButtonOnLoginPage();
        mainPageSteps.waitForMainPage();
        mainPageSteps.clickOnLkButtonOnMainPage();
        accountPageSteps.waitForAccountPage();
        accountPageSteps.clickOnMainPageButtonOnAccountPage(mainPageButton);
        mainPageSteps.waitForMainPage();
        Assert.assertTrue(driver.findElement(MAKE_ORDER_BUTTON).isEnabled());
    }
    @After
    public void shutDownAndDeleteUser() {
        generalSteps.shutDownDriver();
        generalSteps.deleteUser();
    }
}
