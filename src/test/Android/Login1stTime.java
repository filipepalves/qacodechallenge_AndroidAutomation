package test.Android;

import main.java.Android.Android_BaseTest;
import org.testng.annotations.Test;
import static main.java.Android.Android_Locators.*;
import static main.java.Android.Android_TestUtilities.*;
import static main.java.Strings.*;


@SuppressWarnings({"unused", "NewClassNamingConvention"})
public class Login1stTime extends Android_BaseTest {


    @Test
    public void login1sttimeTest() {

        log.info("\u001B[32mStarting Login1stTime\u001B[0m");

        // Field validation page 1

        verifyText(qaCodeChallengeTitle, title);

        log.info("Onboarding to start a session available it's as expected.");

        log.info("\u001B[31mFinishing Login1stTime\u001B[0m");

    }
}
