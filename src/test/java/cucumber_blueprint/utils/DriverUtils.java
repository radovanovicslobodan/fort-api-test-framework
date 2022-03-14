package cucumber_blueprint.utils;

import com.google.inject.Inject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

    @Inject
    static
    WebDriverWait wait;

    public static void waitUntilElementIsClickable(WebDriver driver, WebElement webElement) throws TimeoutException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception ex) {
            throw new TimeoutException("Timeout exceeded while waiting for element to be clickable.");
        }
    }

    public static void waitUntilElementIsVisible(WebDriver driver, WebElement webElement) throws TimeoutException {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception ex) {
            throw new TimeoutException("Timeout exceeded while waiting for element to appear.");
        }
    }
}
