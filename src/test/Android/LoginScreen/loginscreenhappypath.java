package test.Android.LoginScreen;

import main.java.Android.Android_BaseTest;
import org.testng.annotations.Test;

import static main.java.Android.Android_Locators.*;
import static main.java.Android.Android_TestUtilities.*;
import static main.java.Strings.*;

@SuppressWarnings("unused")
public class loginscreenhappypath extends Android_BaseTest {

    @Test(priority = 1)
    public void LoginScreenTest() throws InterruptedException {

        System.out.println("\u001B[32mStarting LoginScreen Test\u001B[0m");

        // Due to the fact that the app doesn't have DB, I must create an account first.

        tapElement(createAccountButton);
        sendKeysToElement(firstNameInput, "Filipe");
        sendKeysToElement(lastNameInput, "Alves");
        sendKeysToElement(emailInput, "filipepretoalves@gmail.com");
        sendKeysToElement(passwordInput, "123456");
        tapElement(createAccountButton);

        // Field validation Home page

        verifyText(qaCodeChallengeTitle, title);
        verifyText(createAccountButton, createAccountText);
        verifyText(loginButton, loginButtonText);

        // Tap on the "Login" button

        tapElement(loginButton);

        verifyText(qaCodeChallengeTitle, title);
        verifyText(usernameEmailInput, emailTitle);
        verifyText(passwordInput, passwordTitle);
        verifyText(loginButton, loginButtonText);

        // Fill the each field with some value and keep tapping the "Login" button

        sendKeysToElement(usernameEmailInput, emailToSend);
        sendKeysToElement(passwordInput, passwordToSend);
        tapElement(loginButton);

        webElementIsNotDisplayed(usernameEmailInput);

        // Field validation Logged page

        verifyText(qaCodeChallengeTitle, title);
        verifyText(userLogged, userLoggedText);
        verifyTextContains(firstName, firstNameText);
        verifyTextContains(lastName, lastNameText);
        verifyTextContains(email, emailText);
        verifyText(logoutButton, logoutButtonText);

        // Tap on the "Logout" button

        tapElement(logoutButton);
        webElementIsNotDisplayed(logoutButton);

        System.out.println("Home page it's as expected.");

        System.out.println("\u001B[32mFinishing LoginScreen Test\u001B[0m");



    }

}
