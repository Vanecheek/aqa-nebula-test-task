package co.obrio.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SignUpPage extends BasePage{
    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }
    private final By signUpInputs = By.className("android.widget.EditText");
    private final By signUpButton = By.xpath("//android.widget.Button[@text=\"SIGN UP\"]");
    private final By resultProgressView = By.id("genesis.nebula:id/uploadResultProgressView");

    public SignUpPage setEmail(String email){
        List<WebElement> inputs = findElements(signUpInputs);
        sendKeys(inputs.get(0), email);
        return this;
    }
    public SignUpPage setPassword(String password){
        List<WebElement> inputs = findElements(signUpInputs);
        sendKeys(inputs.get(1), password);
        return this;
    }
    public SignUpPage repeatPassword(String password){
        List<WebElement> inputs = findElements(signUpInputs);
        sendKeys(inputs.get(2), password);
        return this;
    }

    public SignUpPage clickSignUpButton() {
        click(signUpButton);
        return this;
    }

    public void checkCreatingProgressStarted(){
        Assert.assertTrue(isDisplayed(resultProgressView));
    }
}
