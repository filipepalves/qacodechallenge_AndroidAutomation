package test.Android.AccountCreation;

import main.java.Android.Android_BaseTest;
import org.testng.annotations.Test;
import static main.java.Android.Android_Locators.*;
import static main.java.Android.Android_TestUtilities.*;
import static main.java.Strings.*;

public class accountcreationhappypath extends Android_BaseTest {


    @Test
    public void accountCreation() {

        log.info("\u001B[32mStarting Happy Path for Account Creation\u001B[0m");

        // Verify Main Screen

        verifyText(qaCodeChallengeTitle, title);
        verifyText(createAccountButton, createAccountText);
        verifyText(loginButton, loginButtonText);

        log.info("The Main screen it's as expected.");

        // Create Account

        tapElement(createAccountButton);

        verifyText(qaCodeChallengeTitle, title);
        verifyText(firstNameInput, firstNameTitle);
        verifyText(lastNameInput, lastNameTitle);
        verifyText(passwordInput, passwordTitle);
        verifyText(emailInput, emailTitle);
        verifyText(createAccountButton, createAccountText);

        log.info("The Account Creation screen it's as expected.");

        sendKeysToElement(firstNameInput, "Filipe");
        sendKeysToElement(lastNameInput, "Alves");
        sendKeysToElement(emailInput, "filipepretoalves@gmail.com");
        sendKeysToElement(passwordInput, "123456");
        tapElement(createAccountButton);

        verifyText(qaCodeChallengeTitle, title);
        verifyText(createAccountButton, createAccountText);
        verifyText(loginButton, loginButtonText);

        log.info("The Account Creation is working as expected.");

        log.info("\u001B[31mFinishing Happy Path for Account Creation\u001B[0m");

    }
}
