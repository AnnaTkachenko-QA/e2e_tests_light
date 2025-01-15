package io.testomat.e2e_tests_light;

import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest {

    @BeforeEach
    void openProjectsPage() {
        app.projectsPage.open();
        app.projectsPage.isLoaded();
    }

    @Test
    public void projectPageTest() {
        app.projectsPage.searchForProject(targetProjectName);

        app.projectsPage.selectProject(targetProjectName);

        app.projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void countersOnProjectsPageTest() {
        app.projectsPage.searchForProject(targetProjectName);

        SelenideElement targetProject = ProjectsPage.countOfProjectsShouldBeEqualTo(1).first();

        ProjectsPage.countOfTestCasesShouldBeEqualTo(targetProject, 0);

        /*projectsPage.totalCountOfProjectsIsVisible();
        var totalProjects = projectsPage.getTotalCountOfProjects();
        Integer actualCountOfTotalProjects = parseIntegerFromString(totalProjects);
        Assertions.assertTrue(actualCountOfTotalProjects > 100);*/
    }
}
