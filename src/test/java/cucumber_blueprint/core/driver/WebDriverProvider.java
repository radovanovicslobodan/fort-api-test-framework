package cucumber_blueprint.core.driver;

import com.google.inject.Provider;
import cucumber_blueprint.constants.Props;
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

@ScenarioScoped
public class WebDriverProvider implements Provider<WebDriver> {

    public WebDriver driver;

    @Override
    public WebDriver get() {
        switch (getProp(Props.DRIVER_TYPE)) {
            case "headlessChrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions(true));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            case "headlessFirefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions(true));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions(false));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions(false));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + getProp(Props.DRIVER_TYPE));
        }

        return driver;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
