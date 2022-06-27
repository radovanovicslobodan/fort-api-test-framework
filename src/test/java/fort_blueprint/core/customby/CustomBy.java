package fort_blueprint.core.customby;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomBy {

    public static By testId(String testId) {
        return new CustomBy.ByTestId(testId);
    }

    public static class ByTestId extends By {

        String testId;

        public ByTestId(String testId) {
            this.testId = testId;
        }

        @Override
        public WebElement findElement(SearchContext context) {
            return context.findElement(By.cssSelector(String.format("[data-test='%s']", testId)));
        }

        @Override
        public List<WebElement> findElements(SearchContext context) {
            return context.findElements(By.cssSelector(String.format("[data-test='%s']", testId)));
        }

        @Override
        public String toString() {
            return "By.testId: " + testId;
        }
    }
}
