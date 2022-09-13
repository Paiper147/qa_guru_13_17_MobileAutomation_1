package home.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("testHome")
public class AndroidHomeTests extends TestBaseHome {

    String searchWord = "Appium";

    @Test
    void searchTest(){
        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        step("Skip settings", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });

        step("Type search", ()-> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys(searchWord);
        });

        step("Verify content found", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    void openArticleTest(){
        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        step("Skip settings", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });

        step("Type search", ()-> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys(searchWord);
        });

        step("Verify content found", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0)));

        step("First article click", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click());

        step("Verify content found", () ->
            $$(AppiumBy.className("android.widget.TextView"))
                    .first()
                    .shouldHave(Condition.text(searchWord)));
    }

    @Test
    void tabBarNamesTest(){
        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        step("Skip settings", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });

        step("Preparation", ()-> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys(searchWord);
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });

        step("\"Save\" button check", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_save"))
                    .shouldHave(Condition.exactText("Save"));
        });

        step("\"Language\" button check", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_language"))
                    .shouldHave(Condition.exactText("Language"));
        });

        step("\"Find in article\" button check", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_find_in_article"))
                    .shouldHave(Condition.exactText("Find in article"));
        });

        step("\"Theme\" button check", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_theme"))
                    .shouldHave(Condition.exactText("Theme"));
        });

        step("\"Contents\" button check", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_contents"))
                    .shouldHave(Condition.exactText("Contents"));
        });
    }
}
