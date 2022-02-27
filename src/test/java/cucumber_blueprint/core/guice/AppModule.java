package cucumber_blueprint.core.guice;

import com.google.inject.AbstractModule;
import cucumber_blueprint.core.driver.LazyDriver;
import org.openqa.selenium.WebDriver;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        System.out.println("inside POM Module");
        bind(WebDriver.class).to(LazyDriver.class);
    }
}

