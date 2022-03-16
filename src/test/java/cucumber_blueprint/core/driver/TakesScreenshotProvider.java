package cucumber_blueprint.core.driver;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakesScreenshotProvider implements Provider<TakesScreenshot> {

    @Inject
    WebDriver driver;

    @Override
    public TakesScreenshot get() {
        return (TakesScreenshot) driver;
    }
}
