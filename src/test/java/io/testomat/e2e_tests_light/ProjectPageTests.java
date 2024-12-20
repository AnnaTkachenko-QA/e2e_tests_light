package io.testomat.e2e_tests_light;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.e2e_tests_light.utils.StringParsers.parseIntegerFromString;

public class ProjectPageTests extends BaseTest {

    static String baseUrl = env.get("BASE_URL");
    static String username = env.get("USERNAME");
    static String password = env.get("PASSWORD");
    String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin(){
        open(baseUrl);

        loginUser(username, password);
    }

    @BeforeEach
    void openHomePage() {
        open(baseUrl);
    }

    @Test
    public void projectPageTest() {
        searchForProject(targetProjectName);

        selectProject(targetProjectName);

        waitForProjectPageIsLoaded(targetProjectName);
    }

    @Test
    public void newTest() {
        searchForProject(targetProjectName);

        SelenideElement targetProject = countOfProjectsShouldBeEqualTo(1).first();

        countOfTestCasesShouldBeEqualTo(targetProject, 0);

        //totalCountOfTestCasesGraterThan(100);
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

    public static void loginUser(String email, String password) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);
    }

    private static void totalCountOfTestCasesGraterThan(int expectedTotalCount) {
        String totalProjects = $("#container kbd").getText();
        Integer actualCountOfTotalProjects = parseIntegerFromString(totalProjects);
        Assertions.assertTrue(actualCountOfTotalProjects > expectedTotalCount);
    }

    private static void countOfTestCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertEquals(expectedCount, actualCountOfTests);
    }

    @NotNull
    private static ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible).shouldHave(size(expectedSize));
    }

}
