package co.obrio.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HoroscopePage extends BasePage{
    public HoroscopePage(AndroidDriver driver) {
        super(driver);
    }
    private final By premiumBody = By.id("genesis.nebula:id/premiumBodyContainer");

    public void checkRegistrationSuccessful() {
        Assert.assertTrue(isDisplayed(premiumBody));
    }
}
