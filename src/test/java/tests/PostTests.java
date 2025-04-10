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

        // Изчакай профил линка като потвърждение за успешен login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.newPostLink));

        home.newPostLink.click();

        NewPostPage post = new NewPostPage(driver);
        post.createPost(System.getProperty("user.dir") + "/src/test/resources/testimg.png", "Автоматизиран тест!");


        wait.until(ExpectedConditions.visibilityOf(home.profileLink));
        home.profileLink.click();

// Изчакай постът да се появи в профила
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-post")));

        ProfilePage profile = new ProfilePage(driver);
        Assert.assertTrue(profile.post.isDisplayed(), "Post is not visible in profile.");

    }
}
