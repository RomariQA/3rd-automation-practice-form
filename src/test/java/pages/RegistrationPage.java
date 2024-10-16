package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            uploadPicture =  $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton =  $("#submit"),
            responseTable = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу формы")
    public RegistrationPage openPage () {
        open("/automation-practice-form");

        return this;
    }

    @Step("Убираем баннеры")
    public RegistrationPage removeBanner (){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вводим имя")
    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вводим фамилию")
    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вводим емейл")
    public RegistrationPage setEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage setGender (String value) {
        $(byText(value)).click();

        return this;
    }

    @Step("Вводим номер телефона")
    public RegistrationPage setNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Вводим дату рождения")
    public RegistrationPage setBirthDate (String month, String year, String day) {
        calendarInput.click();
        calendarComponent.setDate(month, year, day);

        return this;
    }

    @Step("Выбираем предметы")
    public RegistrationPage setSubjectsInputByEnter (String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage setHobbies (String value) {
        $(byText(value)).click();

        return this;
    }

    @Step("Загружаем картинку")
    public RegistrationPage uploadPicture (String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Вводим адрес проживания")
    public RegistrationPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage setStateByEnter (String value) {
        stateInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем город штата")
    public RegistrationPage setCityByEnter (String value) {
        cityInput.setValue(value).pressEnter();
        sleep(5000);

        return this;
    }

    @Step("Кликаем на кнопку сабмита")
    public RegistrationPage pressSubmitButton () {
        submitButton.click();

        return this;
    }

    @Step("Проверяем соответствие полей вводу на таблице результатов")
    public RegistrationPage checkSuccessfulResults (String key, String value) {
        responseTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверяем отображения незаполненного обязательного поля")
    public RegistrationPage checkUnSuccessfulResultsWithoutPhone () {
        userNumberInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));

        return this;
    }
}
