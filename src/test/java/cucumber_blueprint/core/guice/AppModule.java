package cucumber_blueprint.core.guice;

import com.google.inject.AbstractModule;
import cucumber_blueprint.core.driver.FluentWaitProvider;
import cucumber_blueprint.core.driver.SharedDriver;
import cucumber_blueprint.core.driver.WebDriverWaitProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).to(SharedDriver.class);
        bind(WebDriverWait.class).toProvider(WebDriverWaitProvider.class);
        bind(FluentWait.class).toProvider(FluentWaitProvider.class);
    }
}

