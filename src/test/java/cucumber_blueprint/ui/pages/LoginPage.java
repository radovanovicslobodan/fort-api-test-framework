package cucumber_blueprint.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "div[data-testid='loginInputUsername']")
    public WebElement username;

    @FindBy(css = "div[data-testid='loginInputPassword']")
    public WebElement password;

    @Inject
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public boolean checkUserNameExist() {
        return username.isDisplayed();
    }

    public boolean checkPasswordExist() {
        return password.isDisplayed();
    }
}
