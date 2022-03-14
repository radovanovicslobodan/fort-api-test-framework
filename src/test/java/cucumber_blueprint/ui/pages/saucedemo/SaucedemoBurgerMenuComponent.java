package cucumber_blueprint.ui.pages.saucedemo;

import com.google.inject.Inject;
import cucumber_blueprint.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoBurgerMenuComponent {

    WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    @Inject
    public SaucedemoBurgerMenuComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        DriverUtils.waitUntilElementIsClickable(driver, burgerMenuBtn);
        burgerMenuBtn.click();
        DriverUtils.waitUntilElementIsClickable(driver, logoutLink);
        logoutLink.click();
    }
}
