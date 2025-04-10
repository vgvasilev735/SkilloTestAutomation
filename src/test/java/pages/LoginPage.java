package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "defaultLoginFormUsername")
    public WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    public WebElement passwordField;

    @FindBy(id = "sign-in-button")
    public WebElement signInBtn;

    @FindBy(css = ".toast-message")
    public WebElement toastMsg;

    public void login(String username, String password) {
        // 🟢 Чакаме username полето да стане видимо
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInBtn.click();
    }
}
