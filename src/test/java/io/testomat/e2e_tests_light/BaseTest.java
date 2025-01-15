package io.testomat.e2e_tests_light;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light.common.Application;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static Dotenv env = Dotenv.load();
    protected static String username = env.get("USERNAME");
    protected static String password = env.get("PASSWORD");
    protected String targetProjectName = "Manufacture light";

    protected static Application app = new Application();

    @BeforeAll
    static void openTestomatAndLogin() {
        app.signInPage.open();
        app.signInPage.loginUser(username, password);
        app.projectsPage.signInSuccess();
    }

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }
}
