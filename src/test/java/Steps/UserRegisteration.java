package Steps;

import Pages.HomePage;
import Pages.UserRegisterationPage;
import Tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;



public class UserRegisteration extends TestBase {

    HomePage homeObj;
    UserRegisterationPage userRegObj;

    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        homeObj=new HomePage();

    }
    @When("I click on Sign up button in Header")
    public void i_click_on_sign_up_button_in_header() throws InterruptedException {
        homeObj.awaitilityWait(3);
        homeObj.openRegisterationpage();


    }
    @When("I entered the {string} , {string}")
    public void i_entered_the(String username, String password) {
        userRegObj=new UserRegisterationPage();
        userRegObj.userregister(username,password);
    }
    @Then("The “Sign up successful.” message appears successfully")
    public void the_sign_up_successful_message_appears_successfully() throws InterruptedException {

        userRegObj.switchToAlert();
        String alerttxt= userRegObj.getAlertText();

        Assert.assertEquals(alerttxt,"Sign up successful.");
        userRegObj.alertDismiss();

        userRegObj.awaitilityWait(3);
    }

}
