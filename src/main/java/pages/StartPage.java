package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//*[@id='page']/div[1]/nav/div/div[1]/ul/li[1]/a")
    private WebElement loginBtn;

    public StartPage(WebDriver driver) { super(driver);}

    public void clickOnLoginBtn(){
        loginBtn.click();
    }

}
