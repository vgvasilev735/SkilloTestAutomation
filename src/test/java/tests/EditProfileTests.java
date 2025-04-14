package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditProfilePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class EditProfileTests extends BaseTest {

    @Test
    public void testChangeProfilePicture() {
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("marmot1", "Marmot123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.profileLink));

        // Отиваме директно на профилната страница
        driver.get("http://training.skillo-bg.com:4300/users/9435");

        EditProfilePage profile = new EditProfilePage(driver);

        // Изчакваме да се зареди профила
        wait.until(ExpectedConditions.visibilityOf(profile.profileUsername));

        // Hover върху снимката, за да се появи камерата
        Actions actions = new Actions(driver);
        actions.moveToElement(profile.profileImage).perform();

        // Изчакваме камерата да се покаже и кликваме
        wait.until(ExpectedConditions.visibilityOf(profile.editProfilePictureDiv));
        profile.editProfilePictureDiv.click();

        // Изпращаме новата снимка (пътят може да се смени според това къде ти е файла)
        String imagePath = System.getProperty("user.dir") + "/src/test/resources/myProfilePic.png";
        profile.uploadInput.sendKeys(imagePath);

        // Изчакваме да се покаже новата снимка
        wait.until(ExpectedConditions.visibilityOf(profile.profileImage));

        Assert.assertTrue(profile.profileImage.isDisplayed(), "Profile image should be visible after upload.");
    }
}
