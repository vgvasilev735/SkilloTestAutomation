package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewPostPage {
    WebDriver driver;

    public NewPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='file']")
    public WebElement uploadInput;

    @FindBy(name = "caption")
    public WebElement captionField;

    @FindBy(id = "customSwitch2") // ⬅️ Ето го добавеният елемент за превключване между public/private
    public WebElement postStatusSwitch;

    @FindBy(id = "create-post")
    public WebElement createPostBtn;

    public void createPost(String imagePath, String caption) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.cssSelector("input[type='file']"))
        );

        uploadInput.sendKeys(imagePath);
        captionField.sendKeys(caption);

        // Always set the post to Public
        if (!postStatusSwitch.isSelected()) {
            postStatusSwitch.click();
        }

        createPostBtn.click();
    }
}