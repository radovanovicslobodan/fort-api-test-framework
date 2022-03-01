package cucumber_blueprint.core.guice;

import com.google.inject.AbstractModule;
import cucumber_blueprint.core.driver.SharedDriver;
import org.openqa.selenium.WebDriver;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).to(SharedDriver.class);
    }
}

