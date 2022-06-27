package fort_blueprint.ui.pages;

import com.google.inject.Inject;
import fort_blueprint.core.customby.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class BasePage {

    protected final WebDriver driver;

    @Inject
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    public abstract void waitUntilPageIsLoaded();
}
