package base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.*;
import utils.*;

@Listeners(Listener.class)
public class BaseTest {
    public static WebDriver driver;
    private static Reader reader;
    public static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    StartPage startPage;
    LoginPage loginPage;
    AddCardPage addCardPage;
    AssertionPage assertionPage;
    MyMistakesPage myMistakesPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(Browser.CHROME);
        driver.manage().window().maximize();
        reader = new Reader();
        startPage = new StartPage(driver);
        loginPage = new LoginPage(driver);
        addCardPage = new AddCardPage(driver);
        assertionPage = new AssertionPage(driver);
        myMistakesPage = new MyMistakesPage(driver);
        logger.info("test");
    }

    @AfterClass
    public void tearDown() {
        if(!Config.HOLD_BROWSER_OPEN){
        driver.quit();
        }
    }

    /**
     * @page is a key-parameter which value method sets in url and open it
     */
    public void openPage(String page) {
        for (String line : reader.lines) {
            if (line.contains(page)) {
                switch (page) {
                    case "homePage", "mistakesPage":
//                        driver.get(reader.findString(page));
                        driver.navigate().to(reader.findString(page));
                        break;
                }
            }
        }
    }

    /**
     * @btn is a key-parameter with it method chooses which button to click
     */
    public void clickOnBtn(String btn) {
        switch (btn) {
            case "logIn":
                startPage.clickOnLoginBtn();
                break;
            case "submit":
                loginPage.clickOnSubmitBtn();
                break;
            case "card1":
                addCardPage.clickOnCardBtn(1);
                break;
//            case "card2":
//                addCardPage.clickOnCardBtn(2);
//                break;
            case "addCard":
                addCardPage.clickOnAddCardBtn();
                break;
            case "myMistake":
                myMistakesPage.clickOnMyMistakeBtn();
                break;
        }
    }

    /**
     * @inp is a key-parameter which value method sets in input-field
     */
    public void input(String inp) {
        for (String line : reader.lines) {
            if (line.contains(inp)) {
                switch (inp) {
                    case "userName":
                        loginPage.inputUserName(inp);
                        break;
                    case "userPass":
                        loginPage.inputPassword(inp);
                        break;
                }
            }
        }
    }

    /**
     * @result is a key-parameter which value we expect to see like right value output
     */
    public void expectedResult(String result) {
        for (String line : reader.lines) {
            if (line.contains(result)) {
                switch (result) {
                    case "expectedLinkHasText":
                        assertionPage.checkMistakeLinkName(result);
                        break;
                    case "expectedUserName":
                        assertionPage.checkUserName(result);
                        break;
                    case "expectedNumberOfMistakes":
                        assertionPage.checkAmountOfAddedMistakes(result);
                        break;
                }
            }
        }
    }
}

