package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.CustomApiListeners.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static tests.TestData.*;

public class AuthorizationPage {
    @Step("Откроем страницу авторизации")
    public void openLoginPage() {
        open("http://demowebshop.tricentis.com/login");
    }

    @Step("Авторизуем пользователя ")
    public Cookie authUserTest() {
        String authCookieValue = given()
                .contentType("application/x-www-form-urlencoded")
                .filter(withCustomTemplates())
                .formParam("Email", EMAIL_AUTH)
                .formParam("Password", PASSWORD_AUTH)
                .when()
                .post("http://demowebshop.tricentis.com/login")
                .then()
                .statusCode(302)
                .extract()
                .cookie(AUTH_COOKIE_NAME);

        return new Cookie(AUTH_COOKIE_NAME, authCookieValue);
    }

    @Step("Проверяем, что пользователь авторизовался")
    public void checkUserAuthorization() {
        $("a.account").shouldHave(Condition.text(EMAIL_AUTH));
    }
}
