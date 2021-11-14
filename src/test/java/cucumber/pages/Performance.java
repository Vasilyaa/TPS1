package cucumber.pages;

import com.codeborne.selenide.WebDriverRunner;

public class Performance {
    public boolean rightPage(){
        return WebDriverRunner.url().equals("https://shelly.kpfu.ru/e-ksu/SITE_STUDENT_SH_PR_AC.student_personal_marks?p_menu=8");
    }
}