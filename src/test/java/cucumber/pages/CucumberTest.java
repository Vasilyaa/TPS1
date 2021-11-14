package cucumber.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/java/cucumber/features"},
        glue = {"cucumber.stepdefs"}
)
public class CucumberTest {
    @BeforeClass
    public static void setup(){
        loadTestProperties();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        Configuration.browser = "chrome";
    }
    @After
    public void logOut(){
        $(byText("Выход")).should(Condition.exist).click();
    }

    private static void loadTestProperties(){
        Properties props = System.getProperties();
        try {
            props.load(
                    new FileInputStream(new File("src/main/resources/config.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
