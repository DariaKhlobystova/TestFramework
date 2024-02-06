package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static base.BaseTest.driver;

public class Listener implements ITestListener{
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult result)
    {
        LOGGER.info("Test {} - FAILED!", result.getName());
        String screenshotName = result.getName()+
                String.valueOf(System.currentTimeMillis()).substring(9, 13);
        LOGGER.info("trying to trace screenShot... ");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("build/reports/screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            LOGGER.info("Exception on saving screenshot!");
            e.printStackTrace();
        }
//        try {
//            Allure.addAttachment("Test screen", FileUtils.openInputStream(source));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        attachScreenshotToAllure(ts);
    }
//    @Attachment(value = "Failed test screenshot", type = "image/png")
//    public static byte[] attachScreenshotToAllure (TakesScreenshot takesScreenshot) {
//        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
//    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult result)
    {
        LOGGER.info("Test {} - SKIPPED!", result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult result)
    {
        LOGGER.info("Test {} - STARTED", result.getName());
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult result)
    {
        LOGGER.info("Test {} - IS PASSED", result.getName());
    }

}