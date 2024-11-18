package co.obrio.tests;

import co.obrio.pages.HoroscopePage;
import co.obrio.pages.OnboardingFlowPage;
import co.obrio.pages.SignUpPage;
import org.testng.annotations.Test;

public class OnboardingTests extends BaseTest {
    @Test
    public void testOnboardingRegistrationSuccessful(){
        new OnboardingFlowPage(driver)
                .clickGetStarted()
                .clickAnswerCheckbox(2)
                .clickNext()
                .checkYourGoalsLayoutAppear()
                .clickNext()
                .checkInfoLayoutAppear("Let’s personalize your experience")
                .clickNext()
                .checkDateOfBirthLayoutAppear()
                .clickNext()
                .checkTimeOfBirthLayoutAppear()
                .clickNext()
                .setBirthPlace("Kyiv", "Kyiv, KV, Ukraine")
                .checkPalmistryTitleAppear()
                .clickSkip()
                .setGender("Male")
                .setName("Grisha")
                .clickNext()
                .setRelationshipStatus("In relationship")
                .setInterest("love")
                .clickNext()
                .clickYes()
                .checkInfoLayoutAppear("Be ready for what’s coming")
                .clickNext()
                .checkTimePickerLayoutAppear()
                .clickSkip()
                .setSocialOption("Social media (Facebook, Instagram, TikTok)")
                .clickNext()
                .checkGoalsGraphicScopeListAppear()
                .clickNext()
                .checkReviewsScreenPictureAppear()
                .clickNext()
                .clickContinueWithEmailButton();

        new SignUpPage(driver)
                .setEmail("grisha1234@gmail.com")
                .setPassword("grisha123")
                .repeatPassword("grisha123")
                .clickSignUpButton()
                .checkCreatingProgressStarted();

        new HoroscopePage(driver)
                .checkRegistrationSuccessful();
    }
}
