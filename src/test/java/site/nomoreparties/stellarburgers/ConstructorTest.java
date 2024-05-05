package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;
import static site.nomoreparties.stellarburgers.pom.constants.locators.MainPageLocators.*;

@DisplayName("Раздел «Конструктор»")
@RunWith(Parameterized.class)
public class ConstructorTest extends Steps{
    private static final String EXPECTED_CLASS_SUBSTRING = "tab_tab_type_current__2BEPc";
    private final By testedElement;
    private final By otherElement;
    private final String testedElementName;

    public ConstructorTest(By testedElement, By otherElement, String testedElementName) {
        this.testedElement = testedElement;
        this.otherElement = otherElement;
        this.testedElementName = testedElementName;
    }

    @Parameterized.Parameters(name = "Тест {index}. Тестируемый элемент {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {BUN_ELEMENT, SAUCE_ELEMENT, "булка"},
                {SAUCE_ELEMENT, FILLING_ELEMENT, "соус"},
                {FILLING_ELEMENT, SAUCE_ELEMENT, "начинка"}
        };
    }

    @Before
    public void setUp() {
        setUpDriver();
    }

    @Test
    @DisplayName("Параметризованный тест раздела «Конструктор»")
    @Description("Проверка  что работают переходы к разделам: «Булки», Соусы», «Начинки»")
    public void constructorTest() {
        clickOnOtherElementInConstructor(otherElement);
        clickOnOTestedElementInConstructor(testedElement);
        MatcherAssert.assertThat(mainPage.getActualElementClass(testedElement), containsString(EXPECTED_CLASS_SUBSTRING));
    }
    @After
    public void shutDown() {
        shutDownDriver();
    }
}
