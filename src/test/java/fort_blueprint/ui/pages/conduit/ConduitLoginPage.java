package fort_blueprint.ui.pages.conduit;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConduitLoginPage {

    @Inject
    WebDriverWait wait;

    @Inject
    public ConduitLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Email']")
    private WebElement emailField;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordField;

    @FindBy(css = "form button")
    private WebElement signInButton;

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }
}
