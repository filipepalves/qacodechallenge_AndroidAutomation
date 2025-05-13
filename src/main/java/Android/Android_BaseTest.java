package main.java.Android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

@SuppressWarnings("unused")
public class Android_BaseTest {

    protected static AndroidDriver driver;
    protected static WebDriverWait wait;

    @Parameters({"environment"})
    @BeforeTest(alwaysRun = true)
    public void setUp(@Optional("main") String environment, ITestContext ctx) throws MalformedURLException {

        String testName = this.getClass().getName();
        System.out.println("Running test: " + testName);

        Android_Environment.EnvironmentFactory environmentFactory = new Android_Environment.EnvironmentFactory(environment);
        try {
            driver = environmentFactory.createDriver();
        } catch (MalformedURLException e) {
            System.err.println("Failed to create driver: " + e.getMessage());
            throw e;
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown() {
        try {
            Runtime.getRuntime().exec("adb shell am force-stop com.hostelworld.qacodechallenge");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to stop app.");
        }
        driver.quit();
    }

}
