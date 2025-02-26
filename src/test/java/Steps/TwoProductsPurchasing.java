package Steps;

import Pages.*;
import Tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import java.util.AbstractMap;


public class TwoProductsPurchasing extends TestBase {

    HomePage homeObj;
    UserRegisterationPage userRegObj;
    LoginPage LoginObj;
    CartPage cartObj;
    PlaceOrderPage placeOrderObj;



    @Given("the user has registered successfully using {string} , {string}")
    public void the_user_has_registered_successfully_using(String username, String password) throws InterruptedException {

        homeObj=new HomePage();
        homeObj.openRegisterationpage();

        userRegObj=new UserRegisterationPage();
        userRegObj.userregister(username,password);

        userRegObj.switchToAlert();
        String alerttxt= userRegObj.getAlertText();


        Assert.assertEquals(alerttxt,"Sign up successful.");
        userRegObj.alertDismiss();

        Thread.sleep(4000);


    }
    @When("The user clicks on Log in button in Header")
    public void the_user_clicks_on_Log_in_button_in_header() {

        homeObj.openLoginPage();


    }
    @When("Fill {string} , {string} in Log in Form")
    public void fill_in_log_in_form(String username, String password) throws InterruptedException {
        LoginObj=new LoginPage();
        LoginObj.userLogin(username,password);
        Thread.sleep(3000);

    }
    @Then("The account should open Successfully")
    public void the_account_should_open_successfully() throws InterruptedException {
        System.out.println(homeObj.getNameofuser());
        Assert.assertTrue(homeObj.getNameofuser().contains("Welcome"));


    }
    @When("The user Clicks on Laptops in categories in home page.")
    public void the_user_clicks_on_laptops_in_categories_in_home_page() throws InterruptedException {

        homeObj.ChooseLaptops();
        Thread.sleep(2000);
    }
    @When("Chooses product one and Clicks on Add to cart button")
    public void chooses_product_one_and_clicks_on_add_to_cart_button()  {
        homeObj.addLaptopToCart(1);

    }
    @Then("The product is successfully added")
    public void the_product_is_successfully_added() throws InterruptedException {
        userRegObj.switchToAlert();
        String alerttxt= userRegObj.getAlertText();


        Assert.assertEquals(alerttxt,"Product added.");
        userRegObj.alertDismiss();

        userRegObj.awaitilityWait(3);
        userRegObj.navigate_back();
        userRegObj.navigate_back();
        homeObj.ChooseLaptops();
        homeObj.awaitilityWait(3);


    }
    @When("The user Chooses product two and Clicks on Add to cart button")
    public void the_user_chooses_product_two_and_clicks_on_add_to_cart_button() {
        homeObj.addLaptopToCart(2);

    }
    @Then("The other product is successfully added")
    public void the_other_product_is_successfully_added() throws InterruptedException {
        userRegObj.switchToAlert();
        String alerttxt= userRegObj.getAlertText();


        Assert.assertEquals(alerttxt,"Product added.");
        userRegObj.alertDismiss();

        userRegObj.awaitilityWait(3);
        userRegObj.navigate_back();
        userRegObj.navigate_back();
    }
    @When("The user Clicks on Cart button in header")
    public void the_user_clicks_on_cart_button_in_header() {
        homeObj.openCartpage();
    }
    @Then("The two products which include \\(title and Price) are successfully should be added in products page and the total amount is calculated correctly")
    public void the_two_products_which_include_title_and_price_are_successfully_should_be_added_in_products_page_and_the_total_amount_is_calculated_correctly() throws InterruptedException {
        cartObj=new CartPage();
        AbstractMap.SimpleEntry<String, String> product1Details= cartObj.GetProductTitleAndPriceByProductNumber(1);
        String product1Title = product1Details.getKey();
        String product1Price = product1Details.getValue();

        AbstractMap.SimpleEntry<String, String> product2Details= cartObj.GetProductTitleAndPriceByProductNumber(2);
        String product2Title = product2Details.getKey();
        String product2Price = product2Details.getValue();

        String TotalPrice=cartObj.GetTotalPrice();
        Thread.sleep(3000);



        Assert.assertTrue(product1Title.equals("Sony vaio i5") || product1Title.equals("Sony vaio i7"));
        Assert.assertEquals(product1Price,"790");
        Assert.assertTrue(product2Title.equals("Sony vaio i5") || product2Title.equals("Sony vaio i7"));
        Assert.assertEquals(product2Price,"790");
        Assert.assertEquals(TotalPrice,"1580");


    }
    @When("The user Clicks on Place order button")
    public void the_user_clicks_on_place_order_button() throws InterruptedException {

        cartObj.PlaceOrder();
        Thread.sleep(2000);
    }
    @Then("The total amount should be calculated correctly in place order page")
    public void the_total_amount_should_be_calculated_correctly_in_place_order_page() {
       placeOrderObj= new PlaceOrderPage();
       System.out.println(placeOrderObj.GetTotalAmount());

        Assert.assertTrue(placeOrderObj.GetTotalAmount().contains("1580"));

    }
    @When("The user Fills the \\(Name, Country, City, Credit Card, Month and Year)")
    public void the_user_fills_the_name_country_city_credit_card_month_and_year() {
        placeOrderObj.FillPlaceORderData("ggggg", "Egypt","Giza","546565","3","2020");
    }
    @When("The user Clicks on Purchase button in place holder Form")
    public void the_user_clicks_on_purchase_button_in_place_holder_form() {
        placeOrderObj.PurchaseYourOrder();
    }
    @Then("The message ‘Thank you for your purchase!’ should be displayed")
    public void the_message_thank_you_for_your_purchase_should_be_displayed() throws InterruptedException {

        Assert.assertEquals(placeOrderObj.GetPurchaseSuccessMessage(),"Thank you for your purchase!");
        placeOrderObj.awaitilityWait(3);
    }


}
