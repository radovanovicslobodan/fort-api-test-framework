package cucumber_blueprint.ui.steps;

import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import cucumber_blueprint.constants.Credentials;
import cucumber_blueprint.ui.pages.saucedemo.Product;
import cucumber_blueprint.ui.pages.saucedemo.SaucedemoBurgerMenuComponent;
import cucumber_blueprint.ui.pages.saucedemo.SaucedemoInventoryPage;
import cucumber_blueprint.ui.pages.saucedemo.SaucedemoLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

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
        assertThat(errorMessage).isEqualTo(expectedErrorMessage);
    }

    @Given("I logout from the site")
    public void iLogoutFromSite() {
        saucedemoBurgerMenuComponent.logout();
    }

    @Then("I am redirected to the SauceDemo login page")
    public void iAmRedirectedToSaucedemoLoginPage() {
        saucedemoLoginPage.waitUntilPageIsLoaded();
    }

    @Given("I sort the products using criteria {string} using the sort dropdown")
    public void iSortProductsUsingDropdown(final String sortCriteria) {
        saucedemoInventoryPage.sortProductsByCriteria(sortCriteria);
    }

    @Then("The products are sorted by price \\(low to high)")
    public void productsAreSortedByPriceLowToHigh() {
        List<Product> products = saucedemoInventoryPage.getProducts();

        List<Double> prices = products.stream().map(Product::getPrice).collect(Collectors.toList());

        assertThat(Ordering.natural().isOrdered(prices));
    }
}
