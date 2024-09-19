package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Registration {
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

    public Registration openPage () {
        open("/automation-practice-form");

        return this;
    }

    public Registration setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public Registration setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public Registration setEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public Registration setGender (String value) {
        $(byText(value)).click();

        return this;
    }

    public Registration setNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public Registration setBirthDate (String month, String year, String day) {
        calendarInput.click();
        calendarComponent.setDate(month, year, day);

        return this;
    }

    public Registration setSubjectsInputByEnter (String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public Registration setHobbies (String value) {
        $(byText(value)).click();

        return this;
    }

    public Registration uploadPicture (String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public Registration setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public Registration setStateByEnter (String value) {
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public Registration setCityByEnter (String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public Registration pressSubmitButton () {
        submitButton.click();

        return this;
    }

    public Registration checkSuccessfulResults (String key, String value) {
        responseTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    public Registration checkUnSuccessfulResultsWithoutPhone () {
        userNumberInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));

        return this;
    }
}
