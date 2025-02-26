package UtilityHelper;

import Pages.PageBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import Pages.PageBase.*;


public class Helper {

    public static void takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
        Path destination = Paths.get("./screenshots",screenshotName+".png");
        Files.createDirectories(destination.getParent());
        FileOutputStream out= new FileOutputStream(destination.toString());
        out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        out.close();
    }



}
