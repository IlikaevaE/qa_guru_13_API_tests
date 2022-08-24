package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.CustomApiListeners.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static tests.TestData.*;

public class UpdateUserProfile extends TestBase{

    @Test
    @Feature("DemoWebShop: Изменение данных в системе API+UI")
    @Story("Изменение пользовательских данных в профиле пользователя")
    @DisplayName("Проверка возможности изменения имени и фамилии")
    void changeUserData() {
        String cookieKey = "NOPCOMMERCE.AUTH";
        String cookieValue = given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .log().all()
                .formParam("Email", EMAIL_AUTH)
                .formParam("Password", PASSWORD_AUTH)
                .when()
                .post("http://demowebshop.tricentis.com/login")
                .then()
                .log().all()
                .statusCode(302)
                .extract()
                .cookie(cookieKey);
        open("");
        Cookie authCookie = new Cookie(cookieKey, cookieValue);
        getWebDriver().manage().addCookie(authCookie);

        step("Открываем профиль пользователя", () -> {
            open("/customer/info");
        });
        step("Вводим новое значение в поле ИМЯ", () -> {
            $("#FirstName").setValue(FIRST_NAME);
        });
        step("Вводим новое значение в поле ФАМИЛИЯ", () -> {
             $("#LastName").setValue(LAST_NAME);
        });
        step("Нажимаем на кнопку СОХРАНИТЬ", () -> {
            $("[name='save-info-button']").click();
        });
        step("Проверяем, что изменения сохранились", () -> {
            $("#FirstName").shouldHave(Condition.value(FIRST_NAME));
        });

    }

}
