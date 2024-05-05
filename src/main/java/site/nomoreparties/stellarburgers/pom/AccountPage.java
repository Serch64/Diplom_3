package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static site.nomoreparties.stellarburgers.pom.constants.locators.AccountPageLocators.*;


public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForAccountPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FIELD));
    }
    public String getActualEmailText() {
        return driver.findElement(LOGIN_FIELD).getAttribute("value");

    }
    public void clickOnMainPageButton(By mainPageButton) {
        driver.findElement(mainPageButton).click();
    }
    public void clickOnExitButton() {
        driver.findElement(EXIT_BUTTON).click();
    }
}
