package io.testomat.e2e_tests_light;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class CollectionOfElementsTest extends BaseTest {

    @Test
    @DisplayName("find all product experiments")
    public void findAllProductExperiments() {
        ElementsCollection labelCountOfTests = $$("ul li p")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement labelCountOfTest : labelCountOfTests) {
            labelCountOfTest.shouldHave(Condition.text("14 tests").or(Condition.text("0 tests")).or(Condition.text("13 tests")));
        }

        $$(Selectors.byText("13 tests")).shouldHave(CollectionCondition.size(1));
        $$(Selectors.byText("0 tests")).shouldHave(CollectionCondition.size(101));

        labelCountOfTests.filter(Condition.text("13 tests")).shouldHave(CollectionCondition.size(1));
        labelCountOfTests.filter(Condition.text("0 tests")).shouldHave(CollectionCondition.size(101));

        //$$("").forEach(element -> {element.$("li").shouldHave(Condition.exist);});
        //$("").$$("ul li").shouldHave(CollectionCondition.size(1));
    }

    @Test
    @DisplayName("Clipboard")
    public void clipboard(){
        Selenide.clipboard().setText("mfvkedrgnv");
        Selenide.clipboard().shouldHave(ClipboardConditions.content("mfvkedrgnv"));
        Selenide.clipboard().getText();

        Selenide.localStorage().setItem("olo","olo");
        Selenide.localStorage().shouldHave(LocalStorageConditions.itemWithValue("name", "target name"));

        webdriver().shouldHave(WebDriverConditions.cookie("name","target value"));
    }
}
