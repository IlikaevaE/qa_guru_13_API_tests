package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class DemoWebShopTests extends TestBase {
    @Test
    @Feature("DemoWebShop: Регистрация нового пользователя в системе")
    @Story("Заполнение формы регистрации нового пользователя с использованием UI")
    @DisplayName("Проверяем возможность регистрации нового пользователя")
    void registerNewUser() {
        registrationFormPage
                .openPage()
                .setGender()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setConfirmPassword(PASSWORD)
                .clickSubmit()
                .checkResult();
    }

    @Test
    @Feature("DemoWebShop: Изменение данных в системе API+UI")
    @Story("Авторизация существующего пользователя с API и актуализация его профиля с UI")
    @DisplayName("Проверка возможности изменения данных профиля у авторизованного пользователя")
    void updateUserProfile() {
        Cookie authCookie = authorizationPage.authUserTest();

        authorizationPage.openLoginPage();
        getWebDriver().manage().addCookie(authCookie);
        open("http://demowebshop.tricentis.com");
        authorizationPage.checkUserAuthorization();

        step("Открываем профиль пользователя", () -> {
            open("http://demowebshop.tricentis.com/customer/info");
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

