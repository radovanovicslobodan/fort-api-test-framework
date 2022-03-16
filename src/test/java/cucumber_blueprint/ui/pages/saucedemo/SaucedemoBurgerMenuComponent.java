package cucumber_blueprint.ui.pages.saucedemo;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaucedemoBurgerMenuComponent {

    WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    @Inject
    WebDriverWait wait;

    @Inject
    public SaucedemoBurgerMenuComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}
