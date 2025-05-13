package main.java.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class Android_Environment {

    public static class EnvironmentFactory {

        private final Logger log;
        private final String environment;

        public EnvironmentFactory(Logger log, String environment) {
            this.environment = environment.toLowerCase();
            this.log = log;
        }

        public AndroidDriver createDriver() throws MalformedURLException {
            return getDriver();
        }

        private AndroidDriver getDriver() throws MalformedURLException {
            log.info("Create environment: " + this.environment);

            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("emulator-5554");
            //options.setDeviceName("2C091JEGR06259");
            options.setCapability("LANGUAGE", "en_EN");
            options.setCapability("LOCALE", "EN");
            options.setCapability("javascriptEnabled", true);
            options.setAppPackage("com.hostelworld.qacodechallenge");
            options.setNoReset(true);
            log.info("Setting environment to: main");

            log.info("Attempting to launch app with options:");
            log.debug(options.toString());

            return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        }
    }
}
