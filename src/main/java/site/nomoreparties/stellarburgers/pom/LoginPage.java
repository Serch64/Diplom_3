package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static site.nomoreparties.stellarburgers.pom.constants.locators.LoginPageLocators.*;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.EMAIL;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.VALID_PASSWORD;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoginPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(ENTER_BUTTON));
    }
    public void clickOnRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }
    public void setEmailField() {
        driver.findElement(EMAIL_FIELD).sendKeys(EMAIL);
    }
    public void setPasswordField() {
        driver.findElement(PASSWORD_FIELD).sendKeys(VALID_PASSWORD);
    }
    public void clickOnEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }
    public void clickOnRecoverPasswordButton() {
        driver.findElement(RECOVER_PASSWORD_BUTTON).click();
    }
}
