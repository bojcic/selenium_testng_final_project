package tests;

import helper.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected NavPage navPage;
    protected LoginPage loginPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;
    protected SignUpPage signUpPage;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        navPage = new NavPage(driver,wait);
        loginPage = new LoginPage(driver,wait);
        citiesPage = new CitiesPage(driver,wait);
        messagePopUpPage = new MessagePopUpPage(driver,wait);
        signUpPage = new SignUpPage(driver,wait);
    }
    @BeforeMethod
    public void beforeEvery(){
        driver.navigate().to(baseUrl);
    }

    @AfterMethod
    public void afterEvery(ITestResult testResult) throws IOException {
        if (testResult.getStatus()==ITestResult.FAILURE){
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
            String currentTime = dateFormat.format(date);
            Helper.takeAScreenshot(driver,"screenshots/" + testResult.getName() + "_" + currentTime + ".jpg");
        }
    }

    @AfterClass
    public void end(){
        driver.quit();
    }

}
