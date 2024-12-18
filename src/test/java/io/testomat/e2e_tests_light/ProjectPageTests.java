package io.testomat.e2e_tests_light;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    String baseUrl = "https://app.testomat.io/";
    String username = "anna.tkachenko1603@gmail.com";
    String password = "Anna5624787249!";
    String targetProjectName = "Manufacture light";

    @Test
    public void projectPageTest() {
        open(baseUrl);

        loginUser(username, password);

        searchForProject(targetProjectName);

        selectProject(targetProjectName);

        waitForProjectPageIsLoaded(targetProjectName);
    }

    private void waitForProjectPageIsLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    private void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    private void searchForProject(String targetProjectName) {
        $("#content-desktop #search").setValue(targetProjectName);
    }

    @Test
    public void newTest(){
        open(baseUrl);
    }

    public void loginUser(String email, String password){
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);
    }
}
