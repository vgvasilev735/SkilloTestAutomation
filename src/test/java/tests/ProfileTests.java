package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class ProfileTests extends BaseTest {
    @Test
    public void testViewProfile() {
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("marmot1", "Marmot123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.profileLink));

        home.profileLink.click();

        ProfilePage profile = new ProfilePage(driver);
        // Изчакай елемента, който съдържа потребителското име
        wait.until(ExpectedConditions.visibilityOf(profile.profileUsername));

        Assert.assertTrue(profile.profileUsername.isDisplayed(), "Username is not visible on profile page.");
    }
}
