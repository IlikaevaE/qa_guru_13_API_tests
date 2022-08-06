package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.AuthorizationPage;
import pages.RegistrationFormPage;
import pages.UserFieldsData;

public class TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    UserFieldsData userFieldsData = new UserFieldsData();



    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browser = "chrome";
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1820x980";
     //   Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.addVideo();
    }
}
