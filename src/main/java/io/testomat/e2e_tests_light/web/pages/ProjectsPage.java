package io.testomat.e2e_tests_light.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private final SelenideElement searchInput = $("#search");


    public void open() {
        Selenide.open("");
    }

    //pattern loadable component
    public void isLoaded() {
        searchInput.shouldBe(visible);
    }

    public void searchForProject(String targetProjectName) {
        searchInput.setValue(targetProjectName);
    }

    public void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
    }

    public static ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible).shouldHave(size(expectedSize));
    }

    public static void countOfTestCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        targetProject.shouldHave(text(expectedCount + " tests"));

        /*String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertEquals(expectedCount, actualCountOfTests);*/
    }

    public static void totalCountOfProjectsIsVisible() {
        $("#container kbd").shouldBe(visible);
    }

    public static String getTotalCountOfProjects() {
        return $("#container kbd").getText();
    }
}
