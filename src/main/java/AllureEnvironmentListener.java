package main.java;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class AllureEnvironmentListener implements ITestListener {

    private static final String DEFAULT_ENVIRONMENT = "main";

    @Override
    public void onStart(ITestContext context) {
        String environment = context.getCurrentXmlTest().getParameter("environment");

        if (environment == null || environment.isEmpty()) {
            environment = System.getProperty("environment", DEFAULT_ENVIRONMENT);
        }

        System.out.println("Environment: " + environment);
        System.out.println("Test running in environment: " + environment);
        Allure.parameter("Environment", environment);
    }
}