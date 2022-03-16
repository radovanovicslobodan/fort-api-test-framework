package cucumber_blueprint.ui.pages.saucedemo;

import com.google.inject.Inject;
import cucumber_blueprint.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class SaucedemoInventoryPage extends BasePage {

    @FindBy(className = "inventory_item")
    List<WebElement> inventoryWebElements;

    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;

    @FindBy(className = "product_sort_container")
    WebElement sortDropdownWebElement;

    // Locators for Products
    private static final String PRODUCT_NAME_CLASSNAME_LOCATOR = "inventory_item_name";
    private static final String PRODUCT_DESCRIPTION_CLASSNAME_LOCATOR = "inventory_item_desc";
    private static final String PRODUCT_PRICE_CLASSNAME_LOCATOR = "inventory_item_price";

    @Inject
    WebDriverWait wait;

    @Inject
    public SaucedemoInventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(inventoryContainer));
        } catch (Exception ex) {
            throw new RuntimeException("Timeout exceeded while waiting for inventory page to load.");
        }
    }

    public void sortProductsByCriteria(String criteria){
        wait.until(ExpectedConditions.elementToBeClickable(sortDropdownWebElement)).click();

        Select sortDropdown = new Select(sortDropdownWebElement);
        try {
            sortDropdown.selectByVisibleText(criteria);
        } catch (NoSuchElementException noSuchElementException) {
            throw new WebDriverException(String.format("Sort criteria %s was not available.", criteria), noSuchElementException);
        }
    }

    public List<Product> getProducts() {
        LinkedList<Product> products = new LinkedList<>();
        for (WebElement productWebElement: inventoryWebElements) {
            try {
                String name = productWebElement.findElement(By.className(PRODUCT_NAME_CLASSNAME_LOCATOR)).getText();
                String description = productWebElement.findElement(By.className(PRODUCT_DESCRIPTION_CLASSNAME_LOCATOR)).getText();
                String priceStr = productWebElement.findElement(By.className(PRODUCT_PRICE_CLASSNAME_LOCATOR)).getText().replace("$", "");
                Double price = Double.parseDouble(priceStr);

                products.add(new Product(name, description, price));
            } catch (Exception e) {
                Assert.fail ("Could not parse WebElement and build a Product. " + e.getMessage());
            }
        }
        return products;
    }
}
