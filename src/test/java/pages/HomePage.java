package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/users/login']")
    public WebElement loginLink;

    @FindBy(id = "nav-link-profile")
    public WebElement profileLink;

    @FindBy(id = "nav-link-new-post")
    public WebElement newPostLink;

    @FindBy(id = "nav-link-home")
    public WebElement homeLink;

    @FindBy(id = "nav-link-logout")
    public WebElement logoutLink;

    public void clickLogin() {
        loginLink.click();
    }
}