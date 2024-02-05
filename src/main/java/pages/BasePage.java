package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Reader;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    protected Reader reader;
    WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.reader = new Reader();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

//    public void switchToPage(){
//        driver.switchTo().defaultContent();
//    }
}
