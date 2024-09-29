package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


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
