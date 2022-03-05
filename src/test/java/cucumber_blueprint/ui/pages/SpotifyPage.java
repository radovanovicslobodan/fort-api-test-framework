package cucumber_blueprint.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyPage {

    @Inject
    WebDriverWait wait;

    @Inject
    FluentWait fluentWait;

    @Inject
    public SpotifyPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".logo.WJsKJXEbycxxq8OcGHM1.active")
    public WebElement logo;

    public WebElement checkLogo() {
        return wait.until(ExpectedConditions.visibilityOf(logo));
    }

    public WebElement checkLogoFluent() {
        return (WebElement) fluentWait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(logo));
    }
}
