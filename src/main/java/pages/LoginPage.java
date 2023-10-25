package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    private WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    private WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    private WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("[type='submit']"));
    }
    public String getEmailInputType(){
        return getEmailInput().getAttribute("type");
    }
    public String getPasswordInputType(){
        return getPasswordInput().getAttribute("type");
    }


}
