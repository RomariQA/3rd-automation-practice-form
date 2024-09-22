package pages;

import com.codeborne.selenide.SelenideElement;
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

    public RegistrationPage openPage () {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender (String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate (String month, String year, String day) {
        calendarInput.click();
        calendarComponent.setDate(month, year, day);

        return this;
    }

    public RegistrationPage setSubjectsInputByEnter (String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies (String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture (String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateByEnter (String value) {
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCityByEnter (String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage pressSubmitButton () {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkSuccessfulResults (String key, String value) {
        responseTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkUnSuccessfulResultsWithoutPhone () {
        userNumberInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));

        return this;
    }
}
