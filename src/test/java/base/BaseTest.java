package base;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.*;
import utils.Browser;
import utils.DriverFactory;
import utils.Listener;
import utils.Reader;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static utils.Config.*;

@Listeners(Listener.class)
public class BaseTest {
    public static WebDriver driver;
    private static Reader reader;
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    StartPage startPage;
    LoginPage loginPage;
    MistakeCardPage mistakeCardPage;
    AssertionPage assertionPage;
    MyMistakesPage myMistakesPage;

    static {
        LOGGER.info("START TIME: " + LocalTime.now());
        LOGGER.info("START clear reports dir: build/reports ... ");
        File allureResults = new File("allure-results");
        if (allureResults.isDirectory()) {
            for (File item : Objects.requireNonNull(allureResults.listFiles())) {
                item.delete();
            }
        }
        if (CLEAR_REPORTS_DIR) {
            File allureScreenshots = new File("build/reports/screenshots");
            for (File item : Objects.requireNonNull(allureScreenshots.listFiles())) {
                item.delete();
            }
        }
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(Browser.CHROME);
        driver.manage().window().maximize();
        reader = new Reader();
        startPage = new StartPage(driver);
        loginPage = new LoginPage(driver);
        mistakeCardPage = new MistakeCardPage(driver);
        assertionPage = new AssertionPage(driver);
        myMistakesPage = new MyMistakesPage(driver);
    }

    /**
     * @page is a key-parameter which value method sets in url and open it
     */
    public void openPage(String page) {
        for (String line : reader.lines) {
            if (line.contains(page)) {
                switch (page) {
                    case "homePage", "mistakePage":
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
            case "logOut":
                startPage.clickOnLogOutBtn();
                break;
            case "submit":
                loginPage.clickOnSubmitBtn();
                break;
            case "addCard":
                mistakeCardPage.clickOnAddCardBtn();
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
                    case "userName", "negativeName":
                        loginPage.inputUserName(inp);
                        break;
                    case "userPass", "negativePass":
                        loginPage.inputPassword(inp);
                        break;
                }
            }
        }
    }

    /**
     * @expectedResult is a key-parameter which value we expect to see like right value output
     */
    public void expectedResult(String expectedResult) {
        for (String line : reader.lines) {
            if (line.contains(expectedResult)) {
                switch (expectedResult) {
                    case "expectedLinkHasText":
                        assertionPage.checkMistakeLinkName(expectedResult);
                        break;
                    case "expectedUserName":
                        assertionPage.checkUserName(expectedResult);
                        break;
                    case "expectedDeleteBtnIsPresented":
                        assertionPage.checkDeleteBtnIsPresented(expectedResult);
                        break;
                    case "expectedLogoutText":
                        assertionPage.checkLogoutText(expectedResult);
                        break;
                    case "errorMessage":
                        assertionPage.checkOfErrorMessageByIncorrectInputData(expectedResult);
                        break;
                    case "errorNotAuth":
                        assertionPage.checkOfErrorMessageByAddingCardWithoutAuth(expectedResult);
                }
            }
        }
    }


    /**
     * Clear reports from log and screenshots
     */
    @AfterEach
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterClass
    public void tearDown() {
        if (!HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}

