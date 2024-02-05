package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static base.BaseTest.driver;

public class Screenshots {
    public static boolean takeScreenshot() {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
//        FileUtils.copyFile(file, new File("reports/screenshots/"+ System.currentTimeMillis() + ".png"));
            FileUtils.copyFile(file, new File("reports/screenshots/" + generateRandomString(4) + ".png"));
            return true;
        } catch (IOException e){
            return false;
        }
    }
    private static String generateRandomString(int length){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random random = new Random();
        while (i<length){
            sb.append(chars.charAt(random.nextInt(chars.length())));
            i++;
        }
        return sb.toString();
    }
}
