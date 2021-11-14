package cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.pages.AboutMe;

import static org.junit.Assert.assertTrue;

public class PictureStep {
    AboutMe aboutMe = new AboutMe();
    @And("click on the button to put picture")
    public void uploadPicture() {
        aboutMe.putPicture();
    }

    @Then("^the picture must be shown$")
    public void thePictureMustBeShown() {
        assertTrue(aboutMe.checkPicture());
    }
}
