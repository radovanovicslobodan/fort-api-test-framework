package cucumber_blueprint.ui.pages.saucedemo;

import com.google.inject.Inject;
import cucumber_blueprint.ui.pages.BasePage;
import cucumber_blueprint.utils.DriverUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class SaucedemoLoginPage extends BasePage {

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(id = "user-name")
    WebElement userNameTextInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(className = "error-message-container")
    WebElement errorMessageContainer;

    @Inject
    public SaucedemoLoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(final String userName, final String password) {
        userNameTextInput.clear();
        userNameTextInput.sendKeys(userName);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginButton.click();
    }

    public String getErrorMessage() {
        DriverUtils.waitUntilElementIsVisible(driver, errorMessageContainer);
        String text = errorMessageContainer.getText();
        if (Objects.nonNull(text)) {
            return text.trim();
        }
        return "";
    }

    public void waitUntilPageIsLoaded() {
        try {
            DriverUtils.waitUntilElementIsVisible(driver, loginButton);
        } catch (Exception ex) {
            throw new TimeoutException("Timeout exceeded while waiting for login page to load.");
        }
    }
}
