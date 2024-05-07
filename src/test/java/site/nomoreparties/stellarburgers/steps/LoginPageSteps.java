package site.nomoreparties.stellarburgers.steps;

import io.qameta.allure.Step;
import site.nomoreparties.stellarburgers.pom.LoginPage;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.driver;

public class LoginPageSteps {
    private LoginPage loginPage;

    @Step("Клик на \"Зарегистрироваться\" на странице логина")
    public void clickOnRegisterButtonOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoginPage();
        loginPage.clickOnRegisterButton();
    }
    @Step("Клик на \"Войти\" на странице логина")
    public void clickOnEnterButtonOnLoginPage() {
        loginPage.clickOnEnterButton();
    }
    @Step("Клик на \"Восстановить пароль\" на странице логина")
    public void clickOnRecoverPasswordButtonOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoginPage();
        loginPage.clickOnRecoverPasswordButton();
    }
    @Step("Ввод данных на странице логина")
    public void setDataOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoginPage();
        loginPage.setEmailField();
        loginPage.setPasswordField();
    }
    @Step("Ожидание страницы логина")
    public void waitForLoginPage() {
        loginPage.waitForLoginPage();
    }
}
