package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForErrorPopUpToBeVisible(){
        wait
                .withMessage("Error: Error PopUp not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.error")));
    }

    public String getErrorPopUpText(){
        return driver.findElement(By.cssSelector("div.error li")).getText();
    }

    public WebElement getVerifyAccountDialog(){
        return driver.findElement(By.className("dlgVerifyAccount"));
    }
    public void waitForVerifyAccountDialogToBeVisible(){
        wait
                .withMessage("Error: Verify account dialog not visible.")
                .until(ExpectedConditions.visibilityOf(getVerifyAccountDialog()));
    }
    public String getVerifyAccountDialogText(){
        return getVerifyAccountDialog().getText();
    }


    public WebElement getVerifyAccountDialogCloseButton(){
        return driver.findElement(By.className("btnClose"));
    }

    public void clickOnVerifyDialogCloseButton(){
        getVerifyAccountDialogCloseButton().click();
    }
}
