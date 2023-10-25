package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasicPage{
    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    private WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }

    private WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    private WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    private WebElement getConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public String getNameInputType(){
        return getNameInput().getAttribute("type");
    }
    public String getEmailInputType(){
        return getEmailInput().getAttribute("type");
    }
    public String getPasswordInputType(){
        return getPasswordInput().getAttribute("type");
    }
    public String getConfirmPasswordInputType(){
        return getConfirmPasswordInput().getAttribute("type");
    }

}
