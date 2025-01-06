package io.testomat.e2e_tests_light;

import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest {

    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final SignInPage signInPage = new SignInPage();
    private static final ProjectPage projectPage = new ProjectPage();
    static String username = env.get("USERNAME");
    static String password = env.get("PASSWORD");
    String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        signInPage.open();

        signInPage.loginUser(username, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectsPage() {
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @Test
    public void projectPageTest() {
        projectsPage.searchForProject(targetProjectName);

        projectsPage.selectProject(targetProjectName);

        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void countersOnProjectsPageTest() {
        projectsPage.searchForProject(targetProjectName);

        SelenideElement targetProject = ProjectsPage.countOfProjectsShouldBeEqualTo(1).first();

        ProjectsPage.countOfTestCasesShouldBeEqualTo(targetProject, 0);

        /*projectsPage.totalCountOfProjectsIsVisible();
        var totalProjects = projectsPage.getTotalCountOfProjects();
        Integer actualCountOfTotalProjects = parseIntegerFromString(totalProjects);
        Assertions.assertTrue(actualCountOfTotalProjects > 100);*/
    }
}
