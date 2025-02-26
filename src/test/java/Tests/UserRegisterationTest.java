//package Tests;
//
//import Pages.HomePage;
//import Pages.UserRegisterationPage;
//import data.LoadPropertiesFile;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.time.Duration;
//import static org.testng.Assert.assertTrue;
//
//
//public class UserRegisterationTest extends TestBase {
//
//    HomePage homeobj;
//
//    UserRegisterationPage registerobj;
//
//    String UserName= LoadPropertiesFile.userData.getProperty("UserName");
//    String Password= LoadPropertiesFile.userData.getProperty("Password");
//
//
//    @Test(priority = 1,alwaysRun = true)
//    public void userRegisterSuccesfully() throws InterruptedException {
//        homeobj=new HomePage();
//        homeobj.openRegisterationpage();
//
//        registerobj=new UserRegisterationPage();
//        registerobj.userregister(UserName,Password);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alert=driver.switchTo().alert();
//        String alerttxt=alert.getText();
//
//        Assert.assertEquals(alerttxt,"Sign up successful.");
//
//    }
//}
