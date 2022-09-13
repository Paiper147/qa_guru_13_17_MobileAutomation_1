package qa.guru.tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBaseQaGuru {

    @Test
    @Tag("searchTestQaGuru")
    void searchTest(){
        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        step("Type search", ()-> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("BrowserStack");
        });

        step("Verify content found", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

}
