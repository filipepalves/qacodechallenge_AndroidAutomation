package test.Android.AccountCreation;

import main.java.Android.Android_BaseTest;
import org.testng.annotations.Test;

import static main.java.Android.Android_Locators.*;
import static main.java.Android.Android_TestUtilities.*;
import static main.java.Strings.*;

public class accountcreationfieldsblank extends Android_BaseTest {


    @Test
    public void accountCreation_fieldsBlank() {

        log.info("\u001B[32mStarting Account Creation - Fields Blank\u001B[0m");

        verifyText(qaCodeChallengeTitle, title);
        tapElement(createAccountButton);
        verifyText(qaCodeChallengeTitle, title);
        verifyText(firstNameInput, firstNameTitle);

        // Tap on the "REGISTER" button without filling all fields

        tapElement(createAccountButton);
        verifyText(firstNameInput, firstNameTitle);

        // Fill the each field with some value and keep tapping the "REGISTER" button

        sendKeysToElement(firstNameInput, firstNameToSend);
        tapElement(createAccountButton);
        verifyText(firstNameInput, firstNameToSend);
        sendKeysToElement(lastNameInput, lastNameToSend);
        tapElement(createAccountButton);
        verifyText(lastNameInput, lastNameToSend);
        sendKeysToElement(passwordInput, passwordToSend);
        tapElement(createAccountButton);
        verifyText(passwordInput, "••••••");
        sendKeysToElement(emailInput, emailToSend);
        verifyText(emailInput, emailToSend);
        tapElement(createAccountButton);
        webElementIsNotDisplayed(firstNameInput);

        log.info("All the fields are working as expected.");

        log.info("\u001B[31mFinishing Account Creation - Fields Blank\u001B[0m");

    }
}
