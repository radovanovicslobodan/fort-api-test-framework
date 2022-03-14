package cucumber_blueprint.ui.pages.saucedemo;

import com.google.inject.Inject;
import cucumber_blueprint.ui.pages.BasePage;
import cucumber_blueprint.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaucedemoInventoryPage extends BasePage {

    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;

    @Inject
    public SaucedemoInventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        try {
            DriverUtils.waitUntilElementIsVisible(driver, inventoryContainer);
        } catch (Exception ex) {
            throw new RuntimeException("Timeout exceeded while waiting for inventory page to load.");
        }
    }
}
