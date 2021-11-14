package cucumber.pages;//allure serve C:\Users\User\IdeaProjects\SelenideEx\target\surefire-reports
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class SelenideTests {

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver","C:/Users/User/Desktop/chromedriver.exe");
        Configuration.browser = "chrome";
    }

    @Before
    public void loadMainPage(){
 SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        open("https://kpfu.ru/");
        MainPage mainPage = new MainPage();
        mainPage.clickInitLogin();
        mainPage.inputLogin("VRAsyanova");
        mainPage.inputPassword("h77ydl88");
        mainPage.clickLogin();
    }

    @Test
    public void checkLogin(){
        StudOnlinePage studOnlinePage = new StudOnlinePage();

        assertTrue(studOnlinePage.rightPage());
    }

    @Test
    public void lkInfoTest(){
        StudOnlinePage studOnlinePage = new StudOnlinePage();
        AboutMe aboutMe = new AboutMe();

        studOnlinePage.lkInfoClick();
        assertTrue(aboutMe.rightPage());
    }

    @Test
    public void StudyTest(){
        StudOnlinePage studOnlinePage = new StudOnlinePage();
        Performance performance = new Performance();

        studOnlinePage.studyClick();
        assertTrue(performance.rightPage());
    }

    @Test
    public void docTest(){
        StudOnlinePage studOnlinePage = new StudOnlinePage();
        StudCentrePage studCentrePage = new StudCentrePage();

        studOnlinePage.studCentreClick();
        studCentrePage.docsClick();
        studCentrePage.exampleDocsClick();
        assertTrue(studCentrePage.getFile().contains("Асяновой Васили Равилевны"));
    }

    @Test
    public void pictureTest(){
        StudOnlinePage studOnlinePage = new StudOnlinePage();
        AboutMe aboutMe = new AboutMe();

        studOnlinePage.lkInfoClick();
        aboutMe.putPicture();
        assertTrue(aboutMe.checkPicture());
        aboutMe.deletePicture();
    }

    @After
    public void logOut(){
        $(byText("Выход")).should(Condition.exist).click();
    }
}
