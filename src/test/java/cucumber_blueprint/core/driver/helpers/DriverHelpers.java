package cucumber_blueprint.core.driver.helpers;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverHelpers {

    @Inject
    WebDriver driver;

    @Inject
    WebDriverWait wait;

    private String screenshotPath = "build/allure-results/";

    public void takeScreenshot(String scenarioName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenshotPath + scenarioName + ".png"));
        } catch (Exception e) {
        }
    }

    public void addScreenshotAllure(String scenarioName) {
        Path content = Paths.get(screenshotPath + scenarioName + ".png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(scenarioName, is);
        } catch (Exception e) {
        }
    }

    // getItemFromLocalStorage

    // addItemToLocalStorage
}
