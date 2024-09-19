package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultName = $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddressInput = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");

    public TextBox openPage () {
        open("/text-box");

        return this;
    }

    public TextBox setUserName (String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBox setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBox setUserCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBox setUserPermanentAddress (String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBox pressSubmitButton () {
        submitButton.click();

        return this;
    }

    public TextBox checkName (String value) {
        resultName.shouldHave(text(value));

        return this;
    }

    public TextBox checkEmail (String value) {
        resultEmail.shouldHave(text(value));

        return this;
    }

    public TextBox checkCurrentAddress (String value) {
        resultCurrentAddressInput.shouldHave(text(value));

        return this;
    }

    public TextBox checkPermanentAddress (String value) {
        resultPermanentAddress.shouldHave(text(value));

        return this;
    }



}
