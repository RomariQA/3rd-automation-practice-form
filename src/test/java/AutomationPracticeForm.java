package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import javax.swing.*;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AutomationPracticeForm {

    private File media;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void AutomationPracticeForm() {

        // заполнение формы
        open("/automation-practice-form");
        $("#firstName").setValue("Keks"); // имя
        $("#lastName").setValue("Keksik"); // фамилия
        $("#userEmail").setValue("Kek@Kek.com"); // мыло
        $(byText("Female")).click(); // пол
        $("#userNumber").setValue("0123456789"); //номер
        $("#dateOfBirthInput").click(); // открыть календарь
        $(".react-datepicker__month-select").click();
        $(byText("August")).click(); // месяц
        $(".react-datepicker__year-select").click();
        $(byText("1993")).click(); // год
        $(".react-datepicker__month").click();
        $(byText("26")).click(); // дата
        $("#subjectsInput").setValue("History").pressEnter(); // предметы
        $(byText("Reading")).click(); //хобби
        $(By.id("uploadPicture")).uploadFile(new File("src/test/media/testUpload.jpg")); // пикча
        $("#currentAddress").setValue("Street"); //адрес
        $("#react-select-3-input").setValue("NCR").pressEnter(); // стейт
        $("#react-select-4-input").setValue("Del").pressEnter(); // город
        $("#submit").click();

        // проверки
        $(".table-responsive").shouldHave(text("Keks Keksik"));
        $(".table-responsive").shouldHave(text("Kek@Kek.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("26 August,1993"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("testUpload.jpg"));
        $(".table-responsive").shouldHave(text("Street"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}