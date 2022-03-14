package cucumber_blueprint.core.driver;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutorProvider implements Provider<JavascriptExecutor> {

    @Inject
    WebDriver driver;

    @Override
    public JavascriptExecutor get() {
        return (JavascriptExecutor) driver;
    }
}
