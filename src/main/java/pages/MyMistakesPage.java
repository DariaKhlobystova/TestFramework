package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyMistakesPage extends BasePage{

    @FindBy(xpath = "//*[@id='page']/div[1]/nav/div/div[1]/ul/li[1]/a")
    private WebElement myMistakesBtn;

    public MyMistakesPage(WebDriver driver) { super(driver);}

    public void clickOnMyMistakeBtn(){ myMistakesBtn.click();}

}
