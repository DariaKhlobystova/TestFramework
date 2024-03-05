package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AssertionPage extends BasePage {

    @FindBy(xpath = "//*[@id='page']/div[1]/nav/div/div[1]/ul/li[1]/a")
    private WebElement mistakeLink;

    @FindBy(xpath = "//*[@id='page']/div[2]/h2")
    private WebElement userName;

    @FindBy(xpath = "//*[@id='page']/div[2]/div/div[1]/div/div[2]/a[2]")
    private WebElement deleteBtnText;

    @FindBy(xpath = "//*[@id='page']/div[2]/div/div/p")
    private WebElement logoutText;

    @FindBy(xpath = "//*[@id='page']/div[2]/div/div/form/div[1]/ul/li")
    private WebElement errorMessage;

    @FindBy(xpath = "")
    private WebElement errorNotAuth;

    public AssertionPage(WebDriver driver) {
        super(driver);
    }

    public void checkUserName(String result){
        String expectedValue = reader.findString(result);
        Assert.assertEquals(userName.getText().trim(), expectedValue);
//        Assert.assertEquals(userName.getText().trim(), "dummy");
    }
    public void checkMistakeLinkName(String result){
        String expectedValue = reader.findString(result);
        Assert.assertEquals(mistakeLink.getText().trim(), expectedValue);
//        Assert.assertEquals(mistakeLink.getText().trim(), "dummy");
    }
    public void checkOfErrorMessageByIncorrectInputData(String result){
        String expectedMessage = reader.findString(result);
        Assert.assertEquals(errorMessage.getText().trim(), expectedMessage);
//        Assert.assertEquals(errorMessage.getText().trim(), "dummy");
    }
    public void checkDeleteBtnIsPresented(String result) {
        String expectedValue = reader.findString(result);
        Assert.assertEquals(deleteBtnText.getText().trim(), expectedValue);
//        Assert.assertEquals(deleteBtnText.getText().trim(), "dummy");
    }
    public void checkLogoutText(String result) {
        String expectedValue = reader.findString(result);
        Assert.assertEquals(logoutText.getText().trim(), expectedValue);
//        Assert.assertEquals(logoutText.getText().trim(), "dummy");
    }
    // DOESN'T WORK - bug on the site
    public void checkOfErrorMessageByAddingCardWithoutAuth(String result) {
        String expectedMessage = reader.findString(result);
        Assert.assertEquals(errorNotAuth.getText().trim(), expectedMessage);
    }
}
