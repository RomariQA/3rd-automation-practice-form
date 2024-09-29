package tests;
import com.github.javafaker.Faker;

public class RandomTestData {

    public static String
            firstName = firstNameRandom(),
            lastName = lastNameRandom(),
            userEmail = userEmailRandom(),
            phoneNumber = phoneNumberRandom(),
            gender = genderRandom(),
            birthDay = birthDayRandom(),
            birthMonth = birthMonthRandom(),
            birthYear = birthYearRandom(),
            subjects = subjectsRandom(),
            hobbies = hobbiesRandom(),
            picture = imageRandom(),
            currentAddress = currentAddressRandom(),
            state = stateRandom(),
            city = cityForStateRandom(state);


    public static String firstNameRandom() {
        return new Faker().name().firstName();
    }

    public static String lastNameRandom () {
        return new Faker().name().lastName();
    }

    public static String phoneNumberRandom () {
        return new Faker().number().digits(10);
    }

    public static String userEmailRandom () {
        return new Faker().internet().emailAddress();
    }

    public static String birthDayRandom () {
            return new Faker().number().numberBetween(1,28) +"";
    }

    public static String birthYearRandom () {
        return new Faker().number().numberBetween(1900,2024) +"";
    }

    public static String birthMonthRandom () {
        return new Faker().options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December", "January");
    }


    public static String currentAddressRandom () {
        return new Faker().address().fullAddress();
    }

    public static String genderRandom () {
        return new Faker().options().option("Male", "Female", "Other");
    }

    public static String subjectsRandom () {
        return new Faker().options().option("Accounting", "Arts", "Biology",
                "Chemistry", "Civics", "Commerce", "Computer Science",
                "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies");
    }

    public static String hobbiesRandom () {
        return new Faker().options().option("Sports", "Reading", "Music");
    }

    public static String imageRandom(){
        return new Faker().options().option("testUpload.jpg", "testUpload2.jfif");
    }

    public static String stateRandom () {
        return new Faker().options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String cityForStateRandom (String state) {
        return switch (state) {
            case "NCR" -> new Faker().options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> new Faker().options().option("Lucknow", "Merrut", "Agra");
            case "Haryana" -> new Faker().options().option("Panipat", "Karnal");
            default -> new Faker().options().option("Jaipur", "Jaisalmer");
        };
    }
}
