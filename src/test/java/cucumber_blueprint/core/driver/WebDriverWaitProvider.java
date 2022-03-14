package cucumber_blueprint.core.driver;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverWaitProvider implements Provider<WebDriverWait> {

    @Inject
    WebDriver driver;

    @Override
    public WebDriverWait get() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
