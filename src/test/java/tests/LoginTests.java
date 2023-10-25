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


}
