package cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.StudCentrePage;
import cucumber.pages.StudOnlinePage;


import static org.junit.Assert.assertTrue;

public class DoStep {
    StudOnlinePage studOnlinePage = new StudOnlinePage();
    StudCentrePage studCentrePage = new StudCentrePage();
    String f;

    @When("press the button to open the centre page")
    public void StudyCentreClick() {
        studOnlinePage.studCentreClick();
    }

    @And("^press the button to open the page with docs$")
    public void PageWithDocuments() {
        studCentrePage.docsClick();
    }

    @And("^press the button to open the page with examples of documents$")
    public void PageWithExaples() {
        studCentrePage.exampleDocsClick();
    }

    @And("^download the document$")
    public void Download() {
        f = studCentrePage.getFile();
    }

    @Then("^name must be open in the document$")
    public void Result() {
        assertTrue(f.contains("Кандеевой Алины Дамировны"));
    }
}
