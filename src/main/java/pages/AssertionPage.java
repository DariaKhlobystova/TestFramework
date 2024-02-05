package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AssertionPage extends BasePage {

    @FindBy(xpath = "//*[@id='page']/div[1]/nav/div/div[1]/ul/li[1]/a")
    private WebElement mistakeLink;

    @FindBy(xpath = "//*[@id='page']/div[2]/h2")
    private WebElement userName;

//    @FindBy(xpath = "//*[@id='page']/div[2]/div/div[1]/div/div[2]/a[1]")
//    private WebElement deleteMistakeBtn;

    @FindBy(xpath = "//*[@id='page']/div[2]/div/div")
    private List<WebElement> mistakes;

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

//    public void checkCardWasAdded(String result) {
//        String expectedValue = reader.findString(result);
//        Assert.assertEquals(deleteMistakeBtn.getText().trim(), expectedValue);
//        Assert.assertEquals(deleteMistakeBtn.getText().trim(), "dummy");
//    }

    public void checkAmountOfAddedMistakes(String result){
        int expectedInt = Integer.parseInt(reader.findString(result));
        int actualSizeOfList = mistakes.size();
        Assert.assertEquals(actualSizeOfList, expectedInt);
//        Assert.assertEquals(actualSizeOfList, 2);
    }


}
