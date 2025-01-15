package io.testomat.e2e_tests_light.common;

import io.testomat.e2e_tests_light.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.pages.ReadmePage;
import io.testomat.e2e_tests_light.web.pages.SignInPage;

public class Application {
    public final ProjectsPage projectsPage = new ProjectsPage();
    public final SignInPage signInPage = new SignInPage();
    public final ProjectPage projectPage = new ProjectPage();
    public final ReadmePage readmePage = new ReadmePage();
}
