package cucumber_blueprint.core.driver;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FluentWaitProvider implements Provider<FluentWait> {

    @Inject
    WebDriver driver;

    @Override
    public FluentWait<WebElement> get() {
        return new FluentWait(driver);
    }
}
