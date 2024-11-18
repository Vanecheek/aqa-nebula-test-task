package co.obrio.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OnboardingFlowPage extends BasePage{
    public OnboardingFlowPage(AndroidDriver driver) {
        super(driver);
    }
    private final By getName = By.id("genesis.nebula:id/startJobsTypeButton");
    private final By answerCheckboxes = By.id("genesis.nebula:id/optionRadiobutton");
    private final By nextButton = By.id("genesis.nebula:id/primaryButton");
    private final By personalGoalsTitle = By.id("genesis.nebula:id/onboardingGoalsPersonalTitleText");
    private final By yourMotivationTitle = By.id("genesis.nebula:id/onboardingMotivationTitleText");
    private final By birthDatePicker = By.id("genesis.nebula:id/onboardingBirthDatePicker");
    private final By birthTimePicker = By.id("genesis.nebula:id/onboardingBirthTimePicker");
    private final By birthPlaceInput = By.id("genesis.nebula:id/onboardingBirthPlaceEditText");
    private final By birthPlaceOptions = By.id("genesis.nebula:id/secondary_text");
    private final By palmistryTitle = By.id("genesis.nebula:id/onboardingPalmistryTitleText");
    private final By skipButton = By.id("genesis.nebula:id/onboardingSkipButton");
    private final By genderTitles = By.id("genesis.nebula:id/answerSquareButtonTitle");
    private final By enterNameBlock = By.id("genesis.nebula:id/onboardingNameInputView");
    private final By nameInput = By.className("android.widget.EditText");
    private final By relationshipStatusTitles = By.id("genesis.nebula:id/answerSquareButtonTitle");
    private final By interestsTitles = By.id("genesis.nebula:id/name");
    private final By statementYesButton = By.id("genesis.nebula:id/onboardingStatementYesButton");
    private final By timePickerLayout = By.id("android:id/timePickerLayout");
    private final By socialOptionTitles = By.id("genesis.nebula:id/optionTitle");
    private final By onboardingGoalsGraphicScopeList = By.id("genesis.nebula:id/onboardingGoalsGraphicScopeList");
    private final By reviewsScreenPicture = By.id("genesis.nebula:id/onboardingPictureScreenImage");
    private final By authorizationEmailButton = By.id("genesis.nebula:id/authEmailButton");

    public OnboardingFlowPage clickGetStarted(){
        click(getName);
        return this;
    }

    public OnboardingFlowPage clickAnswerCheckbox(int checkbox){
        List<WebElement> checkboxes = findElements(answerCheckboxes);
        click(checkboxes.get(checkbox));
        return this;
    }

    public OnboardingFlowPage clickNext(){
        click(nextButton);
        return this;
    }

    public OnboardingFlowPage checkYourGoalsLayoutAppear(){
        Assert.assertTrue(isDisplayed(personalGoalsTitle));
        return this;
    }

    public OnboardingFlowPage checkInfoLayoutAppear(String layoutTitle){
        String actualText = getText(yourMotivationTitle);
        Assert.assertEquals(actualText,layoutTitle);
        return this;
    }

    public OnboardingFlowPage checkDateOfBirthLayoutAppear(){
        Assert.assertTrue(isDisplayed(birthDatePicker));
        return this;
    }

    public OnboardingFlowPage checkTimeOfBirthLayoutAppear(){
        Assert.assertTrue(isDisplayed(birthTimePicker));
        return this;
    }

    public OnboardingFlowPage setBirthPlace(String place, String placeOption){
        sendKeys(birthPlaceInput,place);
        List<WebElement> options = findElements(birthPlaceOptions);
        for (WebElement option : options) {
            if (option.getText().equals(placeOption)) {
                option.click();
                break;
            }
        }
        return this;
    }

    public OnboardingFlowPage setGender(String genderTitle){
        List<WebElement> genders = findElements(genderTitles);
        for (WebElement gender : genders) {
            if (gender.getText().equals(genderTitle)) {
                gender.click();
                break;
            }
        }
        return this;
    }

    public OnboardingFlowPage setRelationshipStatus(String status){
        List<WebElement> relationshipTitles = findElements(relationshipStatusTitles);
        for (WebElement title : relationshipTitles) {
            if (title.getText().equals(status)) {
                title.click();
                break;
            }
        }
        return this;
    }

    public OnboardingFlowPage setInterest(String title){
        List<WebElement> interests = findElements(interestsTitles);
        for (WebElement interest : interests) {
            if (interest.getText().equals(title)) {
                interest.click();
                break;
            }
        }
        return this;
    }

    public OnboardingFlowPage setSocialOption(String socialTitle){
        List<WebElement> options = findElements(socialOptionTitles);
        for (WebElement option : options) {
            if (option.getText().equals(socialTitle)) {
                option.click();
                break;
            }
        }
        return this;
    }

    public OnboardingFlowPage checkPalmistryTitleAppear(){
        Assert.assertTrue(isDisplayed(palmistryTitle));
        return this;
    }

    public OnboardingFlowPage clickSkip(){
        click(skipButton);
        return this;
    }

    public OnboardingFlowPage setName(String name){
        Assert.assertTrue(isDisplayed(enterNameBlock));
        sendKeys(nameInput,name);
        return this;
    }

    public OnboardingFlowPage clickYes(){
        click(statementYesButton);
        return this;
    }

    public OnboardingFlowPage checkTimePickerLayoutAppear(){
        Assert.assertTrue(isDisplayed(timePickerLayout));
        return this;
    }

    public OnboardingFlowPage checkGoalsGraphicScopeListAppear(){
        Assert.assertTrue(isDisplayed(onboardingGoalsGraphicScopeList));
        return this;
    }

    public OnboardingFlowPage checkReviewsScreenPictureAppear(){
        Assert.assertTrue(isDisplayed(reviewsScreenPicture));
        return this;
    }

    public void clickContinueWithEmailButton(){
        click(authorizationEmailButton);
    }
}
