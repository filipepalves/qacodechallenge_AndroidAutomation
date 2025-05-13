package main.java.Android;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Collections;


@SuppressWarnings("unused")
public class Android_TestUtilities extends Android_BaseTest {

    private static final int defaultTimeoutInSeconds = 30;

    public static void tapElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void verifyText(By elementLocator, String expectedText) {
        webElementIsDisplayed(elementLocator);
        String expectedTextLowerCase = expectedText.trim().toLowerCase();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String actualTextLowerCase = wait.until((ExpectedCondition<String>) driver -> {
            try {
                WebElement element = driver.findElement(elementLocator);
                return element.getText().trim().toLowerCase();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                return null;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                return null;
            }
        });

        String actualTextOriginal = "";
        try {
            actualTextOriginal = driver.findElement(elementLocator).getText().trim();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            // Element might have disappeared or changed during the wait
            actualTextOriginal = "Element not found after wait";
        }

        String errorMessage = String.format("Text verification failed for element '%s'. Expected text (case-insensitive, trimmed): '%s' but found: '%s'",
                elementLocator, expectedText, actualTextOriginal);

        Assert.assertEquals(actualTextLowerCase, expectedTextLowerCase, errorMessage);
    }

    public static void webElementIsDisplayed(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        WebElement element = driver.findElement(elementLocator);
        Assert.assertTrue(element.isDisplayed(), "Element identified by '" + elementLocator + "' is not displayed!");
    }

    public static void webElementIsNotDisplayed(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
    }

    public static void sendKeysToElement(By elementLocator, String textToSend) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        element.clear();
        element.sendKeys(textToSend);
    }



    public static void verifyTextContains(By elementLocator, String expectedText) {
        webElementIsDisplayed(elementLocator);

        String expectedTextLowerCase = expectedText.trim().toLowerCase();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String actualTextLowerCase = wait.until((ExpectedCondition<String>) driver -> {
            try {
                WebElement element = driver.findElement(elementLocator);
                return element.getText().trim().toLowerCase();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                return null;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                return null;
            }
        });

        String actualTextOriginal = "";
        try {
            actualTextOriginal = driver.findElement(elementLocator).getText().trim();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            actualTextOriginal = "Element not found after wait";
        }

        String errorMessage = String.format("Text verification failed for element '%s'. Expected to contain (case-insensitive, trimmed): '%s' but found: '%s'",
                elementLocator, expectedText, actualTextOriginal);

        Assert.assertTrue(actualTextLowerCase.contains(expectedTextLowerCase), errorMessage);
    }


}