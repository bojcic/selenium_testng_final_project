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

    @Test(priority = 3,retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist(){
     String email = "non-existing-user@gmal.com";
     String password = "password123";

     navPage.clickOnLoginButton();
     loginPage.completeLogin(email,password);
     messagePopUpPage.waitForErrorPopUpToBeVisible();
     Assert.assertEquals(messagePopUpPage.getErrorPopUpText(),"User does not exists",
             "Error: PopUp text should be 'User does not exists'");

        wait
                .withMessage("Error: URL should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

    }

    @Test(priority = 4,retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.completeLogin(email,password);
        messagePopUpPage.waitForErrorPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getErrorPopUpText(),"Wrong password",
                "Error: PopUp text should be 'Wrong password'");

        wait
                .withMessage("Error: URL should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

    }

    @Test(priority = 5,retryAnalyzer = RetryAnalyzer.class)
    public void login(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.completeLogin(email,password);

        wait
                .withMessage("Error: URL should be " + baseUrl + "/home")
                .until(ExpectedConditions.urlContains("/home"));

    }
}
