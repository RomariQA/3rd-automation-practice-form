package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;

public class TextBoxPageTests extends TestBase {
    TextBox textBox = new TextBox ();
    String userName = "Alex";
    String userEmail = "alex@egorov.com";
    String userCurrentAddress = "Some street 1";
    String userPermanentAddress = "Another street 1";

    @Test
    void successfulTextBoxTest () {
        textBox.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setUserCurrentAddress(userCurrentAddress)
                .setUserPermanentAddress(userPermanentAddress)
                .pressSubmitButton()
                .checkName(userName)
                .checkEmail(userEmail)
                .checkCurrentAddress(userCurrentAddress)
                .checkPermanentAddress(userPermanentAddress);
    }

}
