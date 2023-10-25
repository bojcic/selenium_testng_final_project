package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public void clickOnLanguageButton(){
         getLanguageButton().click();
    }
    public WebElement getLanguageList(){
        return driver.findElement(By.className("v-menu__content"));
    }
    public void waitForLanguageListToBeVisible(){
        wait
                .withMessage("Error: Language list not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("v-menu__content")));
    }
    public WebElement getEnglishButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public void clickOnEnglishButton(){
        getEnglishButton().click();
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("[href='/login'].btnLogin"));
    }

    public void clickOnLoginButton(){
        getLoginButton().click();
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    public void waitForLogoutButtonToBeVisible(){
        wait
                .withMessage("Error: Logout button not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("btnLogout")));
    }
    public void clickOnLogoutButton(){
        getLogoutButton().click();
    }

}
