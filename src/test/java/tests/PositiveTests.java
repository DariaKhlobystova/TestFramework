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
    public void addCardToMyMistakeTestWithLogin() {
        openPage("mistakePage");
        clickOnBtn("addCard");
        expectedResult("expectedDeleteBtnIsPresented");
    }

    @Test(dependsOnMethods = "loginTest")
    public void logOutTest(){
        openPage("homePage");
        clickOnBtn("logOut");
        expectedResult("expectedLogoutText");
    }

}
