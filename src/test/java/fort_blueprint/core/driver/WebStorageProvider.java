package fort_blueprint.core.driver;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class WebStorageProvider implements Provider<WebStorage> {

    @Inject
    WebDriver driver;

    @Override
    public WebStorage get() {
        return (WebStorage) new Augmenter().augment(driver);
    }
}
