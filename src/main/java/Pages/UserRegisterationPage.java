package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.time.Duration;

public class UserRegisterationPage extends PageBase {


    //Finding Elements


    public void userregister(String UserName, String Password) {
        WebElement UsernameTextBox = driver.findElement(By.id("sign-username"));
        WebElement PassswordTextBox = driver.findElement(By.id("sign-password"));
        WebElement SignUpButton = driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));

        setTextElement(UsernameTextBox, UserName);
        setTextElement(PassswordTextBox, Password);
        clickOnElement(SignUpButton);
    }


}
