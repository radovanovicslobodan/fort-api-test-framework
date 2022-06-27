package fort_blueprint.ui.pages.conduit;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConduitHomePage {

    @Inject
    WebDriverWait wait;

    @Inject
    public ConduitHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    @FindBy(className = "user-pic")
    private WebElement userAvatar;

    public void goToLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public boolean checkUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOf(userAvatar)).isDisplayed();
    }
}
