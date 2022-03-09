package cucumber_blueprint.core.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import cucumber_blueprint.core.driver.FluentWaitProvider;
import cucumber_blueprint.core.driver.JavaScriptExecutorProvider;
import cucumber_blueprint.core.driver.SharedDriver;
import cucumber_blueprint.core.driver.WebDriverWaitProvider;
import cucumber_blueprint.core.driver.helpers.WebDriverProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
//        bind(WebDriver.class).to(SharedDriver.class);
        bind(WebDriver.class).toProvider(WebDriverProvider.class).in(Singleton.class);
        bind(WebDriverWait.class).toProvider(WebDriverWaitProvider.class);
        bind(FluentWait.class).toProvider(FluentWaitProvider.class);
        bind(JavascriptExecutor.class).toProvider(JavaScriptExecutorProvider.class);
    }
}

