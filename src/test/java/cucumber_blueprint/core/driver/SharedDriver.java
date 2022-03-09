package cucumber_blueprint.core.driver;

import cucumber_blueprint.enums.Props;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static cucumber_blueprint.core.driver.helpers.DriverOptions.chromeOptions;
import static cucumber_blueprint.core.driver.helpers.DriverOptions.firefoxOptions;
import static cucumber_blueprint.utils.ConfigUtils.getProp;

@ScenarioScoped
public class SharedDriver implements WebDriver {

    private WebDriver delegate;

    private WebDriver getDelegate() {

        if (delegate == null) {

            switch (getProp(Props.DRIVER_TYPE.prop)) {
                case "headlessChrome":
                    WebDriverManager.chromedriver().setup();
                    delegate = new ChromeDriver(chromeOptions(true));
                    delegate.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    break;

                case "headlessFirefox":
                    WebDriverManager.firefoxdriver().setup();
                    delegate = new FirefoxDriver(firefoxOptions(true));
                    delegate.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    delegate = new ChromeDriver(chromeOptions(false));
                    delegate.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    delegate = new FirefoxDriver(firefoxOptions(false));
                    delegate.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + getProp(Props.DRIVER_TYPE.prop));
            }
        }
        return delegate;
    }

    @After
    public void tearDown() {
        if (delegate != null) {
            delegate.manage().deleteAllCookies();
            delegate.quit();
        }
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
