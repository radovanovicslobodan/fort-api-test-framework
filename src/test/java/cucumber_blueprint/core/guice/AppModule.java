package cucumber_blueprint.core.guice;

import com.google.inject.AbstractModule;

import cucumber_blueprint.core.driver.FluentWaitProvider;
import cucumber_blueprint.core.driver.JavaScriptExecutorProvider;
import cucumber_blueprint.core.driver.WebDriverProvider;
import cucumber_blueprint.core.driver.WebDriverWaitProvider;
import cucumber_blueprint.core.driver.helpers.DriverHelpers;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).toProvider(WebDriverProvider.class).in(ScenarioScoped.class);
        bind(WebDriverWait.class).toProvider(WebDriverWaitProvider.class);
        bind(FluentWait.class).toProvider(FluentWaitProvider.class);
        bind(JavascriptExecutor.class).toProvider(JavaScriptExecutorProvider.class);
        bind(DriverHelpers.class).in(ScenarioScoped.class);
    }
}

