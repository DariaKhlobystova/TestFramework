package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class NegativeTests  extends BaseTest {

    @Test
    public void loginTestWithIncorrectUserName() {
        openPage("homePage");
        clickOnBtn("logIn");
        input("negativeName");
        input("userPass");
        clickOnBtn("submit");
        expectedResult("error");
    }
    @Test
    public void loginTestWithIncorrectUserPassword() {
        openPage("homePage");
        clickOnBtn("logIn");
        input("userName");
        input("negativePass");
        clickOnBtn("submit");
        expectedResult("error");
    }
}
