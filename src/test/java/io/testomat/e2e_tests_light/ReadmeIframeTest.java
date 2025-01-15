package io.testomat.e2e_tests_light;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class ReadmeIframeTest extends BaseTest {

    @ExtendWith(TextReportExtension.class)
    @Test
    void updateReadmeTextInIframe() {
        app.projectsPage.isLoaded()
                .searchForProject(targetProjectName)
                .selectProject(targetProjectName);

        app.projectPage.openReadme()
                .clickOnEdit();

        app.readmePage.isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor(" OLOLOTkachenko ")
                .clickOnUpdate()
                .clickOnReadme()
                .checkUpdatedText(" OLOLOTkachenko ");
    }
}
