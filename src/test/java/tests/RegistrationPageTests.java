package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

@Tag("registrationTest")
@DisplayName("Страница формы регистрации")
public class RegistrationPageTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils randomUtils = new RandomUtils();

    public String
            firstName = randomUtils.firstNameRandom(),
            lastName = randomUtils.lastNameRandom(),
            userEmail = randomUtils.userEmailRandom(),
            phoneNumber = randomUtils.phoneNumberRandom(),
            gender = randomUtils.genderRandom(),
            birthDay = randomUtils.birthDayRandom(),
            birthMonth = randomUtils.birthMonthRandom(),
            birthYear = randomUtils.birthYearRandom(),
            subjects = randomUtils.subjectsRandom(),
            hobbies = randomUtils.hobbiesRandom(),
            picture = randomUtils.pictureRandom(),
            currentAddress = randomUtils.currentAddressRandom(),
            state = randomUtils.stateRandom(),
            city = randomUtils.cityForStateRandom(state);

    @DisplayName("Успешное заполнение всех полей формы")
    @Test
    void successfulFullRegistrationTest () {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthDate(birthMonth, birthYear, birthDay)
                .setSubjectsInputByEnter(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setStateByEnter(state)
                .setCityByEnter(city)
                .pressSubmitButton()
                .checkSuccessfulResults ("Student Name", firstName + " " + lastName)
                .checkSuccessfulResults ("Student Email", userEmail)
                .checkSuccessfulResults ("Gender", gender)
                .checkSuccessfulResults ("Mobile", phoneNumber)
                .checkSuccessfulResults ("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkSuccessfulResults ("Subjects", subjects)
                .checkSuccessfulResults ("Hobbies", hobbies)
                .checkSuccessfulResults ("Picture", picture)
                .checkSuccessfulResults ("Address", currentAddress)
                .checkSuccessfulResults ("State and City", state + " " + city);
    }

    @DisplayName("Успешное заполнение только обязательных полей формы")
    @Test
    void  successfulRegistrationOnlyRequiresFieldsTest () {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(phoneNumber)
                .pressSubmitButton()
                .checkSuccessfulResults ("Student Name", firstName + " " + lastName)
                .checkSuccessfulResults ("Gender", gender)
                .checkSuccessfulResults ("Mobile", phoneNumber);

    }

    @DisplayName("Заполнение формы и подтверждение без ввода обязательного номера телефона")
    @Test
    void  unsuccessfulRegistrationWithoutNumberTest () {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .pressSubmitButton()
                .checkUnSuccessfulResultsWithoutPhone();
    }
}
