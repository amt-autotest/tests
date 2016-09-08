package Package;

/**
 * Created by Максим on 31.07.2016.
 */

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static Package.Constants.*;
import static org.junit.Assert.*;

public class TestJUnitLogIn {

    WebDriver driver = new ChromeDriver();
    WebDriverWait myWaitVar = new WebDriverWait(driver, 30);

    @Before
    public void setUp() {

        driver.manage().window().maximize();
        driver.get(BASE_URL);

    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Title("TC#01 - Log In Test")
	@Severity(SeverityLevel.CRITICAL)
    @Description("This test shows us that we can login in system successfully using default login and password")

    @org.junit.Test
    public void TestSignUp0() throws InterruptedException {

        WebElement login = driver.findElement(By.xpath(LOGIN_PATH));
        login.click();
        login.sendKeys(DEFAULT_LOGIN);

        WebElement password = driver.findElement(By.xpath(PASSWORD_PATH));
        password.click();
        password.sendKeys(CORRECT_PASSWORD);

        WebElement signUpButton = driver.findElement(By.xpath(SIGN_UP_BUTTON));
        signUpButton.click();
		
		/*

        WebElement menuCompanies = driver.findElement(By.xpath(MENU_PATH));
        menuCompanies.click();

        WebElement estafetaInMenu = driver.findElement(By.xpath(MENU_ELEMENT_PATH));
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MENU_ELEMENT_PATH)));
        estafetaInMenu.click();

        WebElement button = driver.findElement(By.xpath(MENU_BUTTON));
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MENU_BUTTON)));
        button.click();
		
		*/

        WebElement text = driver.findElement(By.xpath(TEXT_PATH));
        String t = text.getText();

        assertEquals(t, WELCOME_TEXT);

    }
	
	@Title("TC#02 - Log In Test")
	@Severity(SeverityLevel.NORMAL)
    @Description("/INCORRECT TEST/ This test shows us that we can login in system successfully using default login and password")
    @org.junit.Test
    public void TestSignUp1() throws InterruptedException {

        WebElement login = driver.findElement(By.xpath(LOGIN_PATH));
        login.click();
        login.sendKeys(DEFAULT_LOGIN);

        WebElement password = driver.findElement(By.xpath(PASSWORD_PATH));
        password.click();
        password.sendKeys(CORRECT_PASSWORD);

        WebElement signUp = driver.findElement(By.xpath(SIGN_UP_BUTTON));
        signUp.click();

        WebElement menu = driver.findElement(By.xpath(MENU_PATH));
        WebElement elementInMenu = driver.findElement(By.xpath(MENU_ELEMENT_PATH));

        Actions actions = new Actions(driver);
        menu.click();
        actions.moveToElement(elementInMenu).click().perform();

        WebElement button = driver.findElement(By.xpath(MENU_BUTTON));
        button.click();

        WebElement text = driver.findElement(By.xpath(TEXT_PATH));
        String t = text.getText();

        assertEquals(t, WELCOME_TEXT);

    }

    @Title("TC#03 - Log In Test")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("/INCORRECT TEST/ This test shows us that we can login in system successfully using default login and password")
    @org.junit.Test
    public void TestSignUp2() throws InterruptedException {

        WebElement login = driver.findElement(By.xpath(LOGIN_PATH));
        login.click();
        login.sendKeys(CORRECT_PASSWORD);

        WebElement password = driver.findElement(By.xpath(PASSWORD_PATH));
        password.click();
        password.sendKeys(CORRECT_PASSWORD);

        WebElement signUp = driver.findElement(By.xpath(SIGN_UP_BUTTON));
        signUp.click();

        WebElement menu = driver.findElement(By.xpath(MENU_PATH));
        WebElement elementInMenu = driver.findElement(By.xpath(MENU_PATH));

        Actions actions = new Actions(driver);
        menu.click();
        actions.moveToElement(elementInMenu).click().perform();

        WebElement button = driver.findElement(By.xpath(MENU_BUTTON));
        button.click();

        WebElement text = driver.findElement(By.xpath(TEXT_PATH));
        String t = text.getText();

        assertEquals(t, WELCOME_TEXT);

    }

}
