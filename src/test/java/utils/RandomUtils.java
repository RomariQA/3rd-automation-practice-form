package utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    Faker faker = new Faker();

    public String firstNameRandom() {
        return faker.name().firstName();
    }

    public String lastNameRandom() {
        return faker.name().lastName();
    }

    public String phoneNumberRandom() {
        return faker.number().digits(10);
    }

    public String userEmailRandom() {
        return faker.internet().emailAddress();
    }

    public String birthYearRandom() {
        return faker.number().numberBetween(1900, 2024) + "";
    }

    public String birthMonthRandom() {
        return faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December", "January");
    }

    public String birthDayRandom() {
        return faker.number().numberBetween(1, 28) + "";
    }

    public String currentAddressRandom() {
        return faker.address().fullAddress();
    }

    public String genderRandom() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String subjectsRandom() {
        return faker.options().option("Accounting", "Arts", "Biology",
                "Chemistry", "Civics", "Commerce", "Computer Science",
                "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies");
    }

    public String hobbiesRandom() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String pictureRandom() {
        return faker.options().option("testUpload.jpg", "testUpload2.jfif");
    }

    public String stateRandom() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String cityForStateRandom(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Lucknow", "Merrut", "Agra");
            case "Haryana" -> faker.options().option("Panipat", "Karnal");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaisalmer");
            default -> ("Invalid" + state);
        };
    }
}