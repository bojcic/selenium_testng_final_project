package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignUpTests extends BasicTest{
    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignUpPage(){
        navPage.clickOnSignUpButton();
        wait
                .withMessage("Error: URL should be " + baseUrl + "/signup")
                .until(ExpectedConditions.urlContains("/signup"));
    }

    @Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnSignUpButton();
        Assert.assertEquals(signUpPage.getEmailInputType(),"email",
                "Error: Email Input Type should be 'email'");
        Assert.assertEquals(signUpPage.getPasswordInputType(),"password",
                "Error: Password Input Type should be 'password'");
        Assert.assertEquals(signUpPage.getConfirmPasswordInputType(),"password",
                "Error: Confirm Password Input Type should be 'password'");
    }
}
