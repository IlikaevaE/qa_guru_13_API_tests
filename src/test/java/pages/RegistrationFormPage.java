package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    SelenideElement
            genderInput = $("#gender-female"),
            firstNameInput = $("#FirstName"),
            lastNameInput = $("#LastName"),
            emailInput = $("#Email"),
            passwordInput = $("#Password"),
            confirmPasswordInput = $("#ConfirmPassword"),
            submitClick = $("#register-button");

    @Step("Открываем стартовую страницу Demowebshop")
    public RegistrationFormPage openPage() {
        open("http://demowebshop.tricentis.com/register");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Выбираем нужный пол")
    public RegistrationFormPage setGender() {
        genderInput.click();
        return this;
    }

    @Step("Вводим имя пользователя")
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вводим фамилию пользователя")
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Вводим адрес электронной почты")
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Задаем новый пароль")
    public RegistrationFormPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Подтверждаем введенный пароль")
    public RegistrationFormPage setConfirmPassword(String value) {
        confirmPasswordInput.setValue(value);
        return this;
    }

    @Step("Нажимаем на кнопку Register")
    public RegistrationFormPage clickSubmit() {
        submitClick.click();
        return this;
    }
    @Step("Проверяем, что регистрация прошла успешно")
    public RegistrationFormPage checkResult() {
        $(".result").shouldHave(Condition.text("Your registration completed"));
        return this;
    }
}
