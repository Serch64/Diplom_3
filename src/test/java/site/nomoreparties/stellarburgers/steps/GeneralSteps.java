package site.nomoreparties.stellarburgers.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.clients.UserClient;
import site.nomoreparties.stellarburgers.pojo.User;
import site.nomoreparties.stellarburgers.pojo.UserCreds;
import java.util.concurrent.TimeUnit;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.createDriver;
import static site.nomoreparties.stellarburgers.ChoosingBrowser.driver;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.*;

public class GeneralSteps {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    private UserClient userClient;
    public String accessToken;
    @Step("Подготовка драйвера")
    public void setUpDriver() {
        createDriver();
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Step("Закрытие браузера")
    public void shutDownDriver() {
        driver.quit();
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
}
