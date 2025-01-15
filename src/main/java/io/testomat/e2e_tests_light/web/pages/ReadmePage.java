package io.testomat.e2e_tests_light.web.pages;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ReadmePage {

    public ReadmePage isLoaded() {
        $("h2").shouldHave(text("Readme"));
        return this;
    }

    public ReadmePage clickOnEditReadme() {
        $(byText("Edit Readme")).click();
        switchTo().frame($("#modal-overlays iframe[src='/ember-monaco/frame.html']"));
        return this;
    }

    public ReadmePage editFirstLineInEditor(String targetText) {
        $(".view-lines div").click();
        $("textarea").setValue(targetText);
        return this;
    }

    public ReadmePage clickOnUpdate() {
        switchTo().defaultContent();
        $(byText("Update")).click();
        return this;
    }

    public ReadmePage clickOnCancel() {
        switchTo().defaultContent();
        $(byText("Cancel")).click();
        return this;
    }

    public ReadmePage clickOnReadme() {
        $(byLinkText("Readme")).click();
        return this;
    }

    public ReadmePage checkUpdatedText(String targetText) {
        $(".detail-view-content").shouldHave(text(targetText));
        return this;
    }
}
