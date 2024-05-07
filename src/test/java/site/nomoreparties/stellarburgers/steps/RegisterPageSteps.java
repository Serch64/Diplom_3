package site.nomoreparties.stellarburgers.steps;

import io.qameta.allure.Step;
import site.nomoreparties.stellarburgers.pom.RegisterPage;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.driver;

public class RegisterPageSteps {
    private RegisterPage registerPage;
    @Step("Ввод данных на странице регистрации")
    public void setDataOnRegisterPage(String password) {
        registerPage = new RegisterPage(driver, password);
        registerPage.waitForRegisterPage();
        registerPage.setNameField();
        registerPage.setEmailField();
        registerPage.setPasswordField();
    }
    @Step("Клик на \"Зарегистрироваться\" на странице регистрации")
    public void clickOnRegisterButtonOnRegisterPage() {
        registerPage.clickOnRegisterButton();
    }
    @Step("Клик на поле \"Имя\" на странице регистрации")
    public void clickOnNameFieldOnRegisterPage() {
        registerPage.clickOnNameField();
    }
    @Step("Клик на \"Войти\" на странице регистрации")
    public void clickOnEnterButtonOnRegisterPage() {
        registerPage = new RegisterPage(driver);
        registerPage.waitForRegisterPage();
        registerPage.clickOnEnterButton();
    }
}
