package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.awaitility.Awaitility;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PageBase {

    static final String websiteLink = "https://www.demoblaze.com/index.html";
    Alert alert;

    public static WebDriver driver;

    public static void startDriver() {
        // Initialize WebDriver
        driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to(websiteLink);


    }


    public static void stopdriver() {
        driver.quit();
    }


    // Generic Methods to use
    protected void clickOnElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void setTextElement(WebElement txtElement, String value) {
        txtElement.clear();
        txtElement.sendKeys(value);
    }

    public void navigate_back() {
        driver.navigate().back();
    }

    // Function to set implicit wait
    public static void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    public static void awaitilityWait(int TimeOut) {
        Awaitility.await().atLeast(TimeOut, TimeUnit.SECONDS);
    }


    public void switchToAlert() {
        WebDriverWait wait = new WebDriverWait(PageBase.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
    }

    public void alertDismiss() {
        alert.dismiss();
    }

    public String getAlertText() {

        return alert.getText();
    }
}
