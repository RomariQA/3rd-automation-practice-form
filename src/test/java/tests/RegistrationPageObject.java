package tests;

import org.junit.jupiter.api.Test;
import pages.Registration;

public class RegistrationPageObject extends TestBase {

    Registration registration = new Registration();
    String firstName = "Keks";
    String lastname = "Keksik";
    String email = "Kek@Kek.com";
    String phoneNumber = "0123456789";


    @Test
    void successfulFullRegistrationTest () {
        registration.openPage()
                .setFirstName(firstName)
                .setLastName(lastname)
                .setEmail(email)
                .setGender("Female")
                .setNumber(phoneNumber)
                .setBirthDate("August", "1993", "26")
                .setSubjectsInputByEnter("History")
                .setHobbies("Reading")
                .uploadPicture("testUpload.jpg")
                .setCurrentAddress("Street")
                .setStateByEnter("NCR")
                .setCityByEnter("Del")
                .pressSubmitButton()
                .checkSuccessfulResults ("Student Name", firstName + " " + lastname)
                .checkSuccessfulResults ("Student Email", email)
                .checkSuccessfulResults ("Gender", "Female")
                .checkSuccessfulResults ("Mobile", phoneNumber)
                .checkSuccessfulResults ("Date of Birth", "26 August,1993")
                .checkSuccessfulResults ("Subjects", "History")
                .checkSuccessfulResults ("Hobbies", "Reading")
                .checkSuccessfulResults ("Picture", "testUpload.jpg")
                .checkSuccessfulResults ("Address", "Street")
                .checkSuccessfulResults ("State and City", "NCR Delhi");
    }

    @Test
    void  successfulRegistrationOnlyRequiresFieldsTest () {
        registration.openPage()
                .setFirstName(firstName)
                .setLastName(lastname)
                .setGender("Female")
                .setNumber(phoneNumber)
                .pressSubmitButton()
                .checkSuccessfulResults ("Student Name", firstName + " " + lastname)
                .checkSuccessfulResults ("Gender", "Female")
                .checkSuccessfulResults ("Mobile", phoneNumber);

    }

    @Test
    void  unsuccessfulRegistrationWithoutNumberTest () {
        registration.openPage()
                .setFirstName(firstName)
                .setLastName(lastname)
                .setGender("Female")
                .pressSubmitButton()
                .checkUnSuccessfulResultsWithoutPhone();
    }
}
