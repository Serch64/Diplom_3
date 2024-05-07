package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static site.nomoreparties.stellarburgers.pom.constants.locators.MainPageLocators.*;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForMainPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(LK_BUTTON));
    }
    public void clickOnLkButton() {
        driver.findElement(LK_BUTTON).click();
    }
    public void clickOnEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }
    public void clickOnConstructorElement(By element) {
        driver.findElement(element).click();
    }
    public String getActualElementClass(By element) {
        return driver.findElement(element).getAttribute("class");

    }
}
