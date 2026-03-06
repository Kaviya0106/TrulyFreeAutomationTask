package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtil {

    private ScreenshotUtil() {
    }

    public static String capture(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String relativeDir = "test-output/screenshots";
        String fileName = testName + "_" + timestamp + ".png";
        File destination = new File(relativeDir, fileName);

        destination.getParentFile().mkdirs();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, destination);
            return destination.getAbsolutePath();
        } catch (IOException e) {
            return "Screenshot capture failed: " + e.getMessage();
        }
    }
}
