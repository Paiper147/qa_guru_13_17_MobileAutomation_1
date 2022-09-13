package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa.guru.drivers.BrowserstackMobileDriverQaGuru;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBaseQaGuru {

    @BeforeAll
    public static void setup(){
        Configuration.browser = BrowserstackMobileDriverQaGuru.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver(){
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    public void afterEach(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

//        Видео (ссылка на видео) генерируется только, когда драйвер в Browserstack закрыт,
//        НО метод getSessionId работает, когда браузер запущен
        String sessionId = Attach.getSessionId();
//        Selenide.closeWebDriver();
        step("Close driver", Selenide::closeWebDriver);
        Attach.video(sessionId);
    }
}
