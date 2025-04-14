package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class PostTests extends BaseTest {

    @Test
    public void testCreatePost() {
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("marmot1", "Marmot123");

        // Waiting for successful login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(home.newPostLink));

        home.newPostLink.click();

        NewPostPage post = new NewPostPage(driver);
        post.createPost(System.getProperty("user.dir") + "/src/test/resources/testimg.png", "atomated groundhog");


        wait.until(ExpectedConditions.visibilityOf(home.profileLink));
        home.profileLink.click();

// Wait for post to be posted
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-post")));

        ProfilePage profile = new ProfilePage(driver);
        Assert.assertTrue(profile.post.isDisplayed(), "Post is not visible in profile.");

    }
}