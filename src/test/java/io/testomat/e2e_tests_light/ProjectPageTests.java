package io.testomat.e2e_tests_light;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    @Test
    public void projectPageTest() {
        open("https://app.testomat.io/");

        //login user
        $("#content-desktop #user_email").setValue("anna.tkachenko1603@gmail.com");
        $("#content-desktop #user_password").setValue("Anna5624787249!");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);

        //search project
        $("#content-desktop #search").setValue("Manufacture light");

        //select project
        $(byText("Manufacture light")).click();

        //wait for project is loaded
        $("h2").shouldHave(text("Manufacture light"));
    }
}
