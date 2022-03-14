package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.constants.Credentials;
import cucumber_blueprint.ui.pages.saucedemo.SaucedemoBurgerMenuComponent;
import cucumber_blueprint.ui.pages.saucedemo.SaucedemoInventoryPage;
import cucumber_blueprint.ui.pages.saucedemo.SaucedemoLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;

public class SaucedemoSteps extends BaseUiSteps {

    @Inject
    private SaucedemoLoginPage saucedemoLoginPage;

    @Inject
    private SaucedemoInventoryPage saucedemoInventoryPage;

    @Inject
    private SaucedemoBurgerMenuComponent saucedemoBurgerMenuComponent;

    @Given("I am on the SauceDemo login page")
    public void iAmOnSaucedemoLoginPage() {
        saucedemoLoginPage.goTo();
        saucedemoLoginPage.waitUntilPageIsLoaded();
    }

    @Given("I authenticate using valid credentials")
    public void iAuthenticateUsingValidCredentials() {
        saucedemoLoginPage.login(Credentials.SAUCEDEMO_VALID_USERNAME, Credentials.SAUCEDEMO_VALID_PASSWORD);
    }

    @Given("I can see the inventory page")
    public void iCanSeeInventoryPage() {
        saucedemoInventoryPage.waitUntilPageIsLoaded();
    }

    @Given("I authenticate using invalid credentials")
    public void iAuthenticateUsingInvalidCredentials() {
        saucedemoLoginPage.login(Credentials.SAUCEDEMO_INVALID_USERNAME, Credentials.SAUCEDEMO_INVALID_PASSWORD);
    }

    @Then("I should see an error saying {string}")
    public void iShouldSeeErrorSaying(final String expectedErrorMessage) {
        String errorMessage = "";

        try {
            errorMessage = saucedemoLoginPage.getErrorMessage();
        } catch (TimeoutException timeoutException) {
            Assert.fail("Error message did not appear on the LoginPage");
        }
        assertThat(expectedErrorMessage.equalsIgnoreCase(errorMessage)).isEqualTo("An error message indicating the invalid login should be displayed");
    }

    @Given("I logout from the site")
    public void iLogoutFromSite() {
        saucedemoBurgerMenuComponent.logout();
    }

    @Then("I am redirected to the SauceDemo login page")
    public void iAmRedirectedToSaucedemoLoginPage() {
        saucedemoLoginPage.waitUntilPageIsLoaded();
    }
}
