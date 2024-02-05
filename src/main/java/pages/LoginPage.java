package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='page']/div[2]/div/div/form/button")
    private WebElement submitBtn;
    @FindBy(name = "username")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement userPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserName(String inp){ userName.sendKeys(reader.findString(inp));
    }
    public void inputPassword(String inp){
        userPassword.sendKeys(reader.findString(inp));
    }

    public void clickOnSubmitBtn(){ submitBtn.click();}

}
