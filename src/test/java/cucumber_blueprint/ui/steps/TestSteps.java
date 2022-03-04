package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.ui.pages.GooglePage;
import cucumber_blueprint.ui.pages.SpotifyPage;
import cucumber_blueprint.ui.pages.WikipediaPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class TestSteps extends BaseUiSteps {

//    @Inject
//    SoftAssertions assertions;

    @Inject
    GooglePage googlePage;

    @Inject
    SpotifyPage spotifyPage;

    @Inject
    WikipediaPage wikipediaPage;

    @When("Wikipedia page is opened")
    public void openWikipediaPage() {
        driver.get("https://www.wikipedia.org/");
    }

    @Then("Wikipedia logo is present")
    public void checkWikipediaLogo() {
        assertions.assertThat(wikipediaPage.checkLogo().isDisplayed() && wikipediaPage.checkLogo().isEnabled());
    }

    @When("Google page is opened")
    public void openGooglePage() {
        driver.get("https://www.google.com/");
    }

    @Then("Google logo is present")
    public void checkGoogleLogo() {
        assertions.assertThat(googlePage.checkLogo().isDisplayed() && googlePage.checkLogo().isEnabled());
    }

    @When("Spotify page is opened")
    public void openSpotifyPage() {
        driver.get("https://open.spotify.com/");
    }

    @Then("Spotify logo is present")
    public void checkSpotifyLogo() {
        assertions.assertThat(spotifyPage.checkLogo().isDisplayed() && spotifyPage.checkLogo().isEnabled()).isTrue();
    }
}
