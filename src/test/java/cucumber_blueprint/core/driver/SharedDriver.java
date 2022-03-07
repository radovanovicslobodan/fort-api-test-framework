package cucumber_blueprint.core.driver;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static cucumber_blueprint.utils.ConfigUtils.getDriverType;

@ScenarioScoped
public class SharedDriver implements WebDriver {

    private WebDriver delegate;

    private WebDriver getDelegate() {

        if (delegate == null) {
            System.out.println("Creating lazy initialization...");

            switch (getDriverType()) {
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
                    throw new IllegalStateException("Unexpected value: " + getDriverType());
            }
        }

        System.out.println("DELEGATE " + delegate);
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

    public static ChromeOptions chromeOptions(boolean headless) {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\src\\test\\resources\\downloaded_files");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(headless);
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        //     chromeOptions.addArguments("window-size=1920,1080");
        return chromeOptions;
    }

    public static FirefoxOptions firefoxOptions(boolean headless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.setHeadless(headless);
        // FIXME: headless???
        firefoxOptions.setAcceptInsecureCerts(headless);
        return firefoxOptions;
    }
}
