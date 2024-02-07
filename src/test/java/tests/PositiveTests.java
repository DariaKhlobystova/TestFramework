package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class PositiveTests extends BaseTest {

    @Test(priority = 1)
    public void loginTest() {
        openPage("homePage");
        clickOnBtn("logIn");
        input("userName");
        input("userPass");
        clickOnBtn("submit");
        expectedResult("expectedLinkHasText");
        clickOnBtn("myMistake");
        expectedResult("expectedUserName");
    }

    @Test(dependsOnMethods = "loginTest")
    public void addCardToMyMistakeTest() {
        openPage("mistakesPage");
        clickOnBtn("card1");
        clickOnBtn("addCard");
//        openPage("mistakesPage");
//        clickOnBtn("card2");
//        clickOnBtn("addCard");
        clickOnBtn("myMistake");
        expectedResult("expectedNumberOfMistakes");
    }
}
