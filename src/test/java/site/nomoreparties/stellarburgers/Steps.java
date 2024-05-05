package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.By;
import site.nomoreparties.stellarburgers.clients.UserClient;
import site.nomoreparties.stellarburgers.pojo.User;
import site.nomoreparties.stellarburgers.pojo.UserCreds;
import site.nomoreparties.stellarburgers.pom.*;
import java.util.concurrent.TimeUnit;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.*;
import static site.nomoreparties.stellarburgers.ChoosingBrowser.driver;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.*;

public class Steps {
    protected UserClient userClient;
    protected String accessToken;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected AccountPage accountPage;
    protected ForgotPasswordPage forgotPasswordPage;
    @Step("Подготовка драйвера")
    public void setUpDriver() {
        createDriver(CHROME);
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Step("Клик на \"Войти в аккаунт\" на главной странице")
    public void clickOnEnterButtonOnMainPage() {
        mainPage = new MainPage(driver);
        mainPage.clickOnEnterButton();
    }
    @Step("Клик на \"Зарегистрироваться\" на странице логина")
    public void clickOnRegisterButtonOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoginPage();
        loginPage.clickOnRegisterButton();
    }
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
        loginPage.waitForLoginPage();
    }
    @Step("Клик на поле \"Имя\" на странице регистрации")
    public void clickOnNameFieldOnRegisterPage() {
        registerPage.clickOnNameField();
    }
    @Step("Ввод данных на странице логина")
    public void setDataOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoginPage();
        loginPage.setEmailField();
        loginPage.setPasswordField();
    }
    @Step("Клик на \"Войти\" на странице логина")
    public void clickOnEnterButtonOnLoginPage() {
        loginPage.clickOnEnterButton();
        mainPage.waitForMainPage();
    }
    @Step("Клик на \"Личный кабинет\" на главной странице")
    public void clickOnLkButtonOnMainPage() {
        mainPage = new MainPage(driver);
        mainPage.clickOnLkButton();
    }
    @Step("Клик на \"Войти\" на странице регистрации")
    public void clickOnEnterButtonOnRegisterPage() {
        registerPage = new RegisterPage(driver);
        registerPage.waitForRegisterPage();
        registerPage.clickOnEnterButton();
        loginPage.waitForLoginPage();
    }
    @Step("Клик на \"Восстановить пароль\" на странице логина")
    public void clickOnRecoverPasswordButtonOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoginPage();
        loginPage.clickOnRecoverPasswordButton();
    }
    @Step("Клик на \"Войти\" на странице сброса пароля")
    public void clickOnEnterButtonOnForgotPasswordPage() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.waitForForgotPasswordPage();
        forgotPasswordPage.clickOnEnterButton();
        loginPage.waitForLoginPage();
    }
    @Step("Ожидание страницы профиля")
    public void waitForAccountPage() {
        accountPage = new AccountPage(driver);
        accountPage.waitForAccountPage();
    }
    @Step("Клик на \"Конструктор/лого\" на странице профиля")
    public void clickOnMainPageButtonOnAccountPage(By mainPageButton) {
        accountPage.clickOnMainPageButton(mainPageButton);
        mainPage.waitForMainPage();
    }
    @Step("Клик на \"Выход\" на странице профиля")
    public void clickOnExitButtonOnAccountPage() {
        accountPage.clickOnExitButton();
        loginPage.waitForLoginPage();
    }
    @Step("Клик на элемент \"булка/соус/начинка\" в конструкторе")
    public void clickOnOtherElementInConstructor(By otherElement) {
        mainPage = new MainPage(driver);
        mainPage.clickOnConstructorElement(otherElement);
    }
    @Step("Клик на тестируемый элемент \"булка/соус/начинка\" в конструкторе")
    public void clickOnOTestedElementInConstructor(By testedElement) {
        mainPage.clickOnConstructorElement(testedElement);
    }
    @Step("Создание пользователя")
    public String createUser() {
        userClient = new UserClient();
        User user = new User(EMAIL, VALID_PASSWORD, NAME);
        ValidatableResponse response = userClient.createUserClient(user);
        return response.extract().jsonPath().getString("accessToken");
    }
    @Step("Подготовка к удалению пользователя")
    public String deleteUserPreparation() {
        userClient = new UserClient();
        User user = new User(EMAIL, VALID_PASSWORD, NAME);
        ValidatableResponse response = userClient.loginUserClient(UserCreds.from(user));
        return response.extract().jsonPath().getString("accessToken");
    }
    @Step("Удаление пользователя")
    public void deleteUser() {
        if (accessToken != null) {
            userClient.deleteUserClient(accessToken);
        }
    }
    @Step("Закрытие браузера")
    public void shutDownDriver() {
        driver.quit();
    }
}
