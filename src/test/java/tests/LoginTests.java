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
        // open homepage
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        // create new objec
        HomePage home = new HomePage(driver);
        home.clickLogin();

        // login with user
        LoginPage login = new LoginPage(driver);
        login.login("marmot1", "Marmot123");

        // wait to see the profile link
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.profileLink));

        // check if the profile link is visible
        Assert.assertTrue(home.profileLink.isDisplayed(), "Профил линкът не се вижда!");
    }
}
