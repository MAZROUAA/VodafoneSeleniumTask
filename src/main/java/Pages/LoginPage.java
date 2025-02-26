package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends PageBase {


    //Finding Elements


    public void userLogin(String UserName, String Password) {
        WebElement LoginUsernameTextBox = driver.findElement(By.id("loginusername"));
        WebElement LoginPasswordTextBox = driver.findElement(By.id("loginpassword"));
        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));

        setTextElement(LoginUsernameTextBox, UserName);
        setTextElement(LoginPasswordTextBox, Password);
        clickOnElement(LoginButton);
    }


}
