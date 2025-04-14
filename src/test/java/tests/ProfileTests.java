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

        // Wait for the limk
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.profileLink));

        // Redirect to profile
        driver.get("http://training.skillo-bg.com:4300/users/9435");

        ProfilePage profile = new ProfilePage(driver);

        // Wait for the username
        wait.until(ExpectedConditions.visibilityOf(profile.profileUsername));

        // Validate the username
        String actualUsername = profile.profileUsername.getText();
        Assert.assertEquals(actualUsername, "marmot1", "Username on profile page is not correct.");
    }
}
