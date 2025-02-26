package Tests;

import Pages.PageBase;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

public class TestBase extends AbstractTestNGCucumberTests {



    @BeforeMethod
    public void startDriver( ) {
        PageBase.startDriver();



    }

    @AfterMethod
    public void stopdriver()  {
        PageBase.stopdriver();

    }


//    @AfterMethod
//    public  void screenshotOnFailure(ITestResult result) throws IOException {
//        if(result.getStatus()==ITestResult.FAILURE)
//        {
//            System.out.println("failed --taking screenshot");
//            Helper.takeScreenShot(driver,result.getName());
//        }
//    }
}
