package co.obrio.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    private static Properties properties = null;
    private static UiAutomator2Options capabilities = null;

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        setProperties();
        setCapability();
        setDriver();
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

    private void setProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                FileInputStream fis = new FileInputStream(getPathWithCorrectSeparator("src/test/resources/config.properties"));
                properties.load(fis);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setDriver() {
        try {
            driver = new AndroidDriver(
                    new URL(properties.getProperty("appium.server.url")),
                    capabilities
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setCapability() {
        if (capabilities == null) {
            capabilities = new UiAutomator2Options();
            capabilities.setCapability("platformName", properties.getProperty("platform.name"));
            capabilities.setCapability("platformVersion", properties.getProperty("platform.version"));
            capabilities.setCapability("deviceName", properties.getProperty("device.name"));
            capabilities.setCapability("automationName", properties.getProperty("automationName"));
            capabilities.setCapability("app", getAppAbsolutePath());
        }
    }

    private String getAppAbsolutePath() {
        String appName = properties.getProperty("app.name");
        URL resource = getClass().getClassLoader().getResource(appName);
        if (resource == null) {
            throw new RuntimeException("App not found " + appName + " in resource directory");
        }
        try {
            return new File(resource.toURI()).getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong for app: " + appName);
        }
    }

    private String getPathWithCorrectSeparator(String path) {
        return path.replaceAll("/", File.separator);
    }
}
