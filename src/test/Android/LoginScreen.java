package test.Android;

import main.java.Android.Android_BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

import static main.java.Android.Android_Locators.*;
import static main.java.Android.Android_TestUtilities.*;
import static main.java.Strings.*;

@SuppressWarnings("unused")
public class LoginScreen extends Android_BaseTest {

    @Test(priority = 1)
    public void LoginScreenTest() throws InterruptedException {

        log.info("\u001B[32mStarting LoginScreen\u001B[0m");

        // Field validation Home page

        verifyText(qaCodeChallengeTitle, title);

        log.info("Home page it's as expected.");



    }

}
