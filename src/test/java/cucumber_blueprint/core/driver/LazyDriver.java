package cucumber_blueprint.core.driver;

import io.cucumber.guice.ScenarioScoped;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

@ScenarioScoped
public class LazyDriver implements WebDriver {

    private WebDriver delegate;

    private WebDriver getDelegate() {
        if (delegate == null) {
            System.out.println("Creating lazy initialization...");
            WebDriverManager.chromedriver().setup();
            delegate = new ChromeDriver();
            delegate.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            System.out.println("DELEGATE " + delegate);
        }
        return delegate;
    }

    @Override
    public void get(String url) {
        getDelegate().get(url);
    }

    @Override
    public String getCurrentUrl() {
        return getDelegate().getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return getDelegate().getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getDelegate().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getDelegate().findElement(by);
    }

    @Override
    public String getPageSource() {
        return getDelegate().getPageSource();
    }

    @Override
    public void close() {
        getDelegate().close();
    }

    @Override
    public void quit() {
        getDelegate().quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return getDelegate().getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return getDelegate().getWindowHandle();
    }

    @Override
    public WebDriver.TargetLocator switchTo() {
        return getDelegate().switchTo();
    }

    @Override
    public WebDriver.Navigation navigate() {
        return getDelegate().navigate();
    }

    @Override
    public WebDriver.Options manage() {
        return getDelegate().manage();
    }
}
