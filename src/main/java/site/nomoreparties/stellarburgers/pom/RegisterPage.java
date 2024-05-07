package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static site.nomoreparties.stellarburgers.pom.constants.locators.RegisterPageLocators.*;
import static site.nomoreparties.stellarburgers.pom.constants.testdata.UserTestData.*;

public class RegisterPage {
    private WebDriver driver;
    private String password;

    public RegisterPage(WebDriver driver, String password) {
        this.driver = driver;
        this.password = password;
    }
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForRegisterPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(NAME_FIELD));
    }
    public void clickOnNameField() {
        driver.findElement(NAME_FIELD).click();
    }
    public void setNameField() {
        driver.findElement(NAME_FIELD).sendKeys(NAME);
    }
    public void setEmailField() {
        driver.findElement(EMAIL_FIELD).sendKeys(EMAIL);
    }
    public void setPasswordField() {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    public void clickOnRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }
    public void clickOnEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }
    public String getActualPasswordErrorText() {
        return driver.findElement(ERROR_HINT).getText();
    }
}
