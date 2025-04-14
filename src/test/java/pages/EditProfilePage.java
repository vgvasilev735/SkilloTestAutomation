package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {
    WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "app-profile-section .profile-user-settings h2")
    public WebElement profileUsername;

    @FindBy(css = ".profile-image img")
    public WebElement profileImage;

    @FindBy(css = ".edit-profile-pic")
    public WebElement editProfilePictureDiv;

    @FindBy(css = "#upload-img")
    public WebElement uploadInput;
}
