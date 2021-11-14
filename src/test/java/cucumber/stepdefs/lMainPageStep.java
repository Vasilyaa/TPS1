package cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.MainPage;
import cucumber.pages.StudOnlinePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class lMainPageStep {
    MainPage mainPage = new MainPage();
    StudOnlinePage studOnlinePage = new StudOnlinePage();

    @Given("an open browser with kpfu.ru")
    public void openBrowser(){
        open("https://kpfu.ru/");
    }
    @When("click on the button to open the login form")
    public void enterLoginPassword(){
        mainPage.clickInitLogin();
    }
    @And("^enter a login in input field$")
    public void enterALoginInInputField() {
        mainPage.inputLogin(System.getProperty("login"));
    }
    @And("^enter a password in input field$")
    public void enterAPasswordInInputField() {
        mainPage.inputPassword(System.getProperty("password"));
    }
    @And("^click login button$")
    public void clickLoginButton() {
        mainPage.clickLogin();
    }
    @Then("the personal account page be shown")
    public void checkLogin(){
        assertTrue(studOnlinePage.rightPage());
    }
}
