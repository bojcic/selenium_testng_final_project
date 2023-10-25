package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest{

    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage(){
        navPage.clickOnLanguageButton();
        navPage.waitForLanguageListToBeVisible();
        navPage.clickOnEnglishButton();
        navPage.clickOnLoginButton();
        wait
                .withMessage("Error: URL should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));
    }

    @Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getEmailInputType(),"email",
                "Error: Email Input Type should be 'email'");
        Assert.assertEquals(loginPage.getPasswordInputType(),"password",
                "Error: Email Input Type should be 'password'");
    }

}
