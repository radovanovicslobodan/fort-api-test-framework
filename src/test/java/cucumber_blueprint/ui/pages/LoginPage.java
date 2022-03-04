package cucumber_blueprint.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @Inject
    WebDriverWait wait;

    @Inject
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-testid='loginInputUsername']")
    public WebElement username;

    @FindBy(css = "div[data-testid='loginInputPassword']")
    public WebElement password;

    public boolean checkUserNameExist() {
        return wait.until(ExpectedConditions.visibilityOf(username)).isDisplayed();
    }

    public boolean checkPasswordExist() {
        return wait.until(ExpectedConditions.visibilityOf(password)).isDisplayed();
    }
}
