package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import java.util.AbstractMap.SimpleEntry;

public class CartPage extends PageBase {


    //Page Methods
    public SimpleEntry<String, String> GetProductTitleAndPriceByProductNumber(int ProductNumber) {

        String xpathOfProductTitle = String.format("/html/body/div[6]/div/div[1]/div/table/tbody/tr[%d]/td[2]", ProductNumber);
        String xpathOfProductPrice = String.format("/html/body/div[6]/div/div[1]/div/table/tbody/tr[%d]/td[3]", ProductNumber);
        WebElement ProductTitle = driver.findElement(By.xpath(xpathOfProductTitle));
        WebElement ProductPrice = driver.findElement(By.xpath(xpathOfProductPrice));
        return new SimpleEntry<>(ProductTitle.getText(), ProductPrice.getText());

    }

    public String GetTotalPrice() {
        WebElement TotalPrice = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div/h3"));
        return TotalPrice.getText();
    }

    public void PlaceOrder() {
        WebElement PlaceOrderButton = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/button"));
        clickOnElement(PlaceOrderButton);

    }


}
