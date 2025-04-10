package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        // Отвори началната страница
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        // Създай обект на началната страница
        HomePage home = new HomePage(driver);
        home.clickLogin();

        // Създай обект на login страницата и логни
        LoginPage login = new LoginPage(driver);
        login.login("marmot1", "Marmot123");

        // Изчакай появата на линка към профила
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.profileLink));

        // Провери, че линкът към профила се вижда
        Assert.assertTrue(home.profileLink.isDisplayed(), "Профил линкът не се вижда!");
    }
}
