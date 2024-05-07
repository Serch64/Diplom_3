package site.nomoreparties.stellarburgers.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import site.nomoreparties.stellarburgers.pom.MainPage;

import static site.nomoreparties.stellarburgers.ChoosingBrowser.driver;

public class MainPageSteps {
    private MainPage mainPage;
    @Step("Клик на \"Войти в аккаунт\" на главной странице")
    public void clickOnEnterButtonOnMainPage() {
        mainPage = new MainPage(driver);
        mainPage.clickOnEnterButton();
    }
    @Step("Клик на \"Личный кабинет\" на главной странице")
    public void clickOnLkButtonOnMainPage() {
        mainPage = new MainPage(driver);
        mainPage.clickOnLkButton();
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
    @Step("Ожидание главной страницы")
    public void waitForMainPage() {
        mainPage.waitForMainPage();
    }
}
