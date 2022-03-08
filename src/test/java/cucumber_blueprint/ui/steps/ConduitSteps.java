package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.ui.pages.conduit.ConduitHomePage;
import cucumber_blueprint.ui.pages.conduit.ConduitLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ConduitSteps extends BaseUiSteps {

    @Inject
    ConduitHomePage homePage;

    @Inject
    ConduitLoginPage loginPage;

    @When("User navigates to Conduit home page")
    public void userNavigatesToConduitHomePage() {
        driver.get("https://redux.productionready.io/");
    }

    @And("User clicks on sign in button")
    public void userClickOnSignInButton() {
        homePage.goToLogin();
    }

    @And("User enters {string} and {string} in login form fields")
    public void userEnterUsernamePassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("Users avatar is displayed in header")
    public void usersAvatarIsDisplayed() {
        assertThat(homePage.checkUserAvatar()).isTrue();
    }
}
