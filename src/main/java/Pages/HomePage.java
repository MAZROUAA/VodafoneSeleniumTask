package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;

public class HomePage extends PageBase {


    // Locating elements using findElement








    //Page methods
    public void openRegisterationpage() {
        WebElement SignUpLink = driver.findElement(By.id("signin2"));
        clickOnElement(SignUpLink);
    }

    public void openLoginPage() {
        WebElement LoginInLink = driver.findElement(By.id("login2"));
        clickOnElement(LoginInLink);
    }
    public void GoToHomePage() {
        WebElement LoginInLink = driver.findElement(By.id("login2"));
        clickOnElement(LoginInLink);
    }

    public String getNameofuser() throws InterruptedException {
        WebElement Nameofuser = driver.findElement(By.id("nameofuser"));
        Thread.sleep(2000);
        return Nameofuser.getText();
    }
    public void ChooseLaptops() {
        WebElement Laptops = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]"));
        clickOnElement(Laptops);
    }

    public void addLaptopToCart(int LaptopNumber) {


        String xpath = String.format("/html/body/div[5]/div/div[2]/div/div[%d]/div/a/img",LaptopNumber);
        WebElement LaptopToBeAdded=driver.findElement(By.xpath(xpath));
        clickOnElement(LaptopToBeAdded);

        WebElement AddToCartButton = driver.findElement(By.xpath("//a[text()='Add to cart']"));
        clickOnElement(AddToCartButton);

    }

    public void openCartpage() {
        WebElement CartLink = driver.findElement(By.xpath("//*[@id=\"cartur\"]"));
        clickOnElement(CartLink);
    }

}