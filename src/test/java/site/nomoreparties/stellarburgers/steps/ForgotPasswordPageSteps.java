package site.nomoreparties.stellarburgers.steps;

import io.qameta.allure.Step;
import site.nomoreparties.stellarburgers.pom.ForgotPasswordPage;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.driver;

public class ForgotPasswordPageSteps {

    @Step("Клик на \"Войти\" на странице сброса пароля")
    public void clickOnEnterButtonOnForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.waitForForgotPasswordPage();
        forgotPasswordPage.clickOnEnterButton();
    }
}
