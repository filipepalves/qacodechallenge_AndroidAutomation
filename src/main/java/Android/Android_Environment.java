package main.java.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;

public class Android_Environment {

    public static class EnvironmentFactory {

        private final String environment;

        public EnvironmentFactory(String environment) {
            this.environment = environment.toLowerCase();
        }

        public AndroidDriver createDriver() throws MalformedURLException {
            return getDriver();
        }

        private AndroidDriver getDriver() throws MalformedURLException {

            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("emulator-5554");
            options.setAppPackage("com.hostelworld.qacodechallenge");
            options.setAppActivity("com.hostelworld.qacodechallenge.MainActivity");
            options.setNoReset(true);
            System.out.println("Setting environment to: " + this.environment);

            System.out.println("Attempting to launch app with options: " + options);

            return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        }
    }
}
