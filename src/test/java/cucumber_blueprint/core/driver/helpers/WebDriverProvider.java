package cucumber_blueprint.core.driver.helpers;


import com.google.inject.Provider;
import cucumber_blueprint.enums.Props;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;

import static cucumber_blueprint.core.driver.helpers.DriverOptions.chromeOptions;
import static cucumber_blueprint.core.driver.helpers.DriverOptions.firefoxOptions;
import static cucumber_blueprint.utils.ConfigUtils.getProp;

public class WebDriverProvider implements Provider<WebDriver> {

    WebDriver delegate;

    @Override
    public WebDriver get() {
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
        return delegate;
    }

    @After
    public void tearDown() {
        if (delegate != null) {
            delegate.manage().deleteAllCookies();
            delegate.quit();
        }
    }
}
