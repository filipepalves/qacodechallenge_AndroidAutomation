package main.java.Android;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.time.Duration;

@SuppressWarnings("unused")
public class Android_BaseTest {

    protected static AndroidDriver driver;
    protected static Logger log;
    protected static String Language;
    protected static WebDriverWait wait;

    @Parameters({"environment"})
    @BeforeTest(alwaysRun = true)
    public void setUp(@Optional("main") String environment, ITestContext ctx) throws MalformedURLException {

        String testName = this.getClass().getName();
        log = LogManager.getLogger(testName);

        Android_Environment.EnvironmentFactory environmentFactory = new Android_Environment.EnvironmentFactory(log, environment);
        try {
            driver = environmentFactory.createDriver();
        } catch (MalformedURLException e) {
            log.error("Failed to create driver: " + e.getMessage());
            throw e;
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown() {
        driver.terminateApp("com.hostelworld.qacodechallenge");
        driver.quit();
    }

}
