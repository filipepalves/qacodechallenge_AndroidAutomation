package main.java.Android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@SuppressWarnings("unused")
public class Android_TestUtilities extends Android_BaseTest {

    private static final int defaultTimeoutInSeconds = 30;

    private static void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));
    }

    private static void scrollUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));
    }


    public static void scrollDownAction(WebElement element) {
        String script = "mobile: scrollGesture";
        HashMap<String, Object> args = new HashMap<>();
        args.put("elementId", ((RemoteWebElement) element).getId());
        args.put("direction", "down");
        args.put("speed", 5000);
        args.put("percent", 100);
        ((JavascriptExecutor) driver).executeScript(script, args);
    }

    public static void scrollDownUntilElementFound(WebElement containerElement, By targetLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        while (true) {
            String script = "mobile: scrollGesture";
            HashMap<String, Object> args = new HashMap<>();
            args.put("elementId", ((RemoteWebElement) containerElement).getId());
            args.put("direction", "down");
            args.put("speed", 5000);
            args.put("percent", 100);
            ((JavascriptExecutor) driver).executeScript(script, args);

            List<WebElement> targetElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(targetLocator));
            if (!targetElements.isEmpty()) {
                break;
            }
        }
    }

    public static void clickElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void verifyText(By elementLocator, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webElementIsDisplayed(elementLocator);
        String expectedTextLowerCase = expectedText.trim().toLowerCase();
        wait.until((ExpectedCondition<Boolean>) driver -> {
            String actualText = driver.findElement(elementLocator).getText().trim().toLowerCase();
            return actualText.equals(expectedTextLowerCase);
        });
        WebElement element = driver.findElement(elementLocator);
        String actualText = element.getText().trim().toLowerCase();
        String errorMessage = String.format("Text verification failed for element '%s'. Expected text (case-insensitive, trimmed): '%s' but found: '%s'", elementLocator, expectedText, actualText);
        Assert.assertEquals(actualText, expectedTextLowerCase, errorMessage);
    }

    public static void webElementIsDisplayed(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        WebElement element = driver.findElement(elementLocator);
        Assert.assertTrue(element.isDisplayed(), "Element identified by '" + elementLocator + "' is not displayed!");
    }

    public static void sendKeysToElement(By elementLocator, String textToSend) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        element.clear();
        element.sendKeys(textToSend);
    }

    public static void tap(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of("x", x, "y", y));
    }

    public static boolean isElementDisplayed(By sessionName) {
        try {
            WebElement element = driver.findElement(sessionName);
            return element.isDisplayed();
        } catch (java.util.NoSuchElementException | ElementNotInteractableException e) {
            return false;
        }
    }

    public static void verifyTextContains(By elementLocator, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        String actualText = element.getText().trim();
        Assert.assertTrue(actualText.contains(expectedText),
                "Text verification failed: expected text to contain '" + expectedText + "'");
    }


}