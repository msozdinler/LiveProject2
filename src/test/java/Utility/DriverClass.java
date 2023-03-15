package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

    public class DriverClass {
        public static WebDriver driver;
        @BeforeClass(alwaysRun = true)
        public void startingSettings(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().getPageLoadTimeout();
        }
        @AfterClass(alwaysRun = true)
        public void finishSettings(){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
          //  driver.quit();
        }
        public void clickElements(WebElement element){
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }
        public void getTextFromElements(WebElement element){
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.getText();
        }
        public void sendKeysElements(WebElement element,String msg){
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(msg);
        }
        public void wait(int time){
            try {
                Thread.sleep(time*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

