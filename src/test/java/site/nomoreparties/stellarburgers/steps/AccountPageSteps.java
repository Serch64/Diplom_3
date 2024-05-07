package site.nomoreparties.stellarburgers.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import site.nomoreparties.stellarburgers.pom.AccountPage;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.driver;

public class AccountPageSteps {
    private AccountPage accountPage;

    @Step("Ожидание страницы профиля")
    public void waitForAccountPage() {
        accountPage = new AccountPage(driver);
        accountPage.waitForAccountPage();
    }
    @Step("Клик на \"Конструктор/лого\" на странице профиля")
    public void clickOnMainPageButtonOnAccountPage(By mainPageButton) {
        accountPage.clickOnMainPageButton(mainPageButton);
    }
    @Step("Клик на \"Выход\" на странице профиля")
    public void clickOnExitButtonOnAccountPage() {
        accountPage.clickOnExitButton();
    }
}
