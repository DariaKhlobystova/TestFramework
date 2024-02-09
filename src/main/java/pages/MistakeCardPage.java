package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MistakeCardPage extends BasePage {

    @FindBy(xpath = "//*[@id='page']/div[2]/div/div[1]/div/div[2]/a")
    private WebElement addBtn;

    public MistakeCardPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddCardBtn(){
        if(addBtn.isDisplayed()&&addBtn.getText().equals("Добавить к моим ошибкам"))
        {
        addBtn.click();
        driver.navigate().refresh();
        }
        else if(addBtn.isDisplayed()&&addBtn.getText().equals("Вернуть в мои ошибки")){
            System.out.println("Нельзя добавить. Но можно вернуть в список ошибок");
        }
        else System.out.println("Уже добавлено");
    }

}
