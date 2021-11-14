package cucumber.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.StudOnlinePage;
import cucumber.pages.Performance;

import static org.junit.Assert.assertTrue;

public class pPerformanceStep {
    StudOnlinePage studOnlinePage = new StudOnlinePage();
    Performance performance = new Performance();

    @When("click on the button to open the page with study info")
    public void studyInfoClick() {
        studOnlinePage.studyClick();
    }

    @Then("^the study info page be shown$")
    public void StudyInfoPageBeShown() {
        assertTrue(performance.rightPage());
    }
}
