package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static site.nomoreparties.stellarburgers.pom.constants.locators.ForgotPasswordPageLocators.LOGIN_BUTTON;

public class ForgotPasswordPage {
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForForgotPasswordPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
    }
    public void clickOnEnterButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
