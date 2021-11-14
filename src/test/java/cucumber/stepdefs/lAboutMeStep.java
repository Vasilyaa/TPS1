package cucumber.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.AboutMe;
import cucumber.pages.MainPage;
import cucumber.pages.StudOnlinePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class lAboutMeStep {
    MainPage mainPage = new MainPage();
    StudOnlinePage studOnlinePage = new StudOnlinePage();
    AboutMe aboutMe = new AboutMe();

    @Given("the user is logged in")
    public void logIn(){
        open("https://kpfu.ru/");
        mainPage.clickInitLogin();
        mainPage.inputLogin(System.getProperty("login"));
        mainPage.inputPassword(System.getProperty("password"));
        mainPage.clickLogin();
    }

    @When("^click on the button to open the page with lk info$")
    public void lkInfoClick() {
        studOnlinePage.lkInfoClick();
    }

    @Then("^the lk info page be shown$")
    public void LkInfoPageBeShown() {
        assertTrue(aboutMe.rightPage());
    }
}
