package tests;

import org.junit.jupiter.api.Test;
import pages.Registration;

public class RegistrationPageTests extends TestBase {

    Registration registration = new Registration();
    String firstName = "Keks";
    String lastname = "Keksik";
    String email = "Kek@Kek.com";
    String phoneNumber = "0123456789";
    String gender = "Female";
    String birthDay = "26";
    String birthMonth = "August";
    String birthYear = "1993";
    String subjects = "History";
    String hobbies = "Reading";
    String picture = "testUpload.jpg";
    String currentAddress = "Street";
    String state = "NCR";
    String city = "Delhi";



    @Test
    void successfulFullRegistrationTest () {
        registration.openPage()
                .setFirstName(firstName)
                .setLastName(lastname)
                .setEmail(email)
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
                .checkSuccessfulResults ("Student Name", firstName + " " + lastname)
                .checkSuccessfulResults ("Student Email", email)
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
        registration.openPage()
                .setFirstName(firstName)
                .setLastName(lastname)
                .setGender(gender)
                .setNumber(phoneNumber)
                .pressSubmitButton()
                .checkSuccessfulResults ("Student Name", firstName + " " + lastname)
                .checkSuccessfulResults ("Gender", gender)
                .checkSuccessfulResults ("Mobile", phoneNumber);

    }

    @Test
    void  unsuccessfulRegistrationWithoutNumberTest () {
        registration.openPage()
                .setFirstName(firstName)
                .setLastName(lastname)
                .setGender(gender)
                .pressSubmitButton()
                .checkUnSuccessfulResultsWithoutPhone();
    }
}
