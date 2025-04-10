package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static void takeScreenshot(String testName, WebDriver driver) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "src/test/resources/screenshots/" + testName + "_" + timeStamp + ".png";
        try {
            FileUtils.copyFile(src, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}