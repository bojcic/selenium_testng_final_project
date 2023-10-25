package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
}
