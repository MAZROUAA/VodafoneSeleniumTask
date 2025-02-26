package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PlaceOrderPage extends PageBase {


    //Page Methods
    public String GetTotalAmount() {

        WebElement TotalAmount = driver.findElement(By.id("totalm"));
        return TotalAmount.getText();
    }


    public void FillPlaceORderData(String Name, String Country, String City, String CreditCard, String Month, String Year) {
        WebElement NameField = driver.findElement(By.id("name"));
        WebElement CountryField = driver.findElement(By.id("country"));
        WebElement CityField = driver.findElement(By.id("city"));
        WebElement CreditCardField = driver.findElement(By.id("card"));
        WebElement MonthField = driver.findElement(By.id("month"));
        WebElement yearField = driver.findElement(By.id("year"));

        setTextElement(NameField, Name);
        setTextElement(CountryField, Country);
        setTextElement(CityField, City);
        setTextElement(CreditCardField, CreditCard);
        setTextElement(MonthField, Month);
        setTextElement(yearField, Year);
    }

    public void PurchaseYourOrder() {

        WebElement PurchaseButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));
        clickOnElement(PurchaseButton);
    }

    public String GetPurchaseSuccessMessage() {

        WebElement PurchaseSuccessMessage = driver.findElement(By.xpath("/html/body/div[10]/h2"));
        return PurchaseSuccessMessage.getText();
    }


}
