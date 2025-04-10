package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {
    @Test
    public void testLoginLinkIsVisible() {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        HomePage home = new HomePage(driver);
        assert home.loginLink.isDisplayed();
    }
}