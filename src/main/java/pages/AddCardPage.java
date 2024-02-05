package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCardPage extends BasePage {

    @FindBy(xpath = "//*[@id='pests']/div[2]/div[1]/div[2]")
    private WebElement cardMistake1;
    @FindBy(xpath = "//*[@id='pests']/div[4]/div[1]/div[2]")
    private WebElement cardMistake2;
    @FindBy(xpath = "//*[@id='page']/div[2]/div/div[1]/div/div[2]/a")
    private WebElement addBtn;

    public AddCardPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCardBtn(int cardNumber){
        switch (cardNumber) {
            case 1:
                cardMistake1.click();
                break;
            case 2:
                cardMistake2.click();
                break;
        }
    }

    public void clickOnAddCardBtn(){ addBtn.click(); }

}
