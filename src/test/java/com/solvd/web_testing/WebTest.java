package com.solvd.web_testing;

import com.solvd.web_testing.domain.Users;
import com.solvd.web_testing.pages.HomePage;
import com.solvd.web_testing.pages.SecondPage;
import com.solvd.web_testing.util.LoginService;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTest extends AbstractTest {

    @Test(description = "Verify valid login", enabled = false)
    public void verifyValidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        sa.assertTrue(homePage.isUsernameInputElementPresent());
        sa.assertTrue(homePage.isPasswordInputElementPresent());
        sa.assertTrue(homePage.isLoginButtonElementPresent());

        LoginService loginService = new LoginService();
        SecondPage secondPage = loginService.login(loginService.createUser(Users.VALID), getDriver());
        sa.assertTrue(secondPage.isPageOpened());

        sa.assertAll();
    }

    @Test(description = "Verify invalid login")
    public void verifyInvalidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        sa.assertTrue(homePage.isUsernameInputElementPresent());
        sa.assertTrue(homePage.isPasswordInputElementPresent());
        sa.assertTrue(homePage.isLoginButtonElementPresent());

        LoginService loginService = new LoginService();
        SecondPage secondPage = loginService.login(loginService.createUser(Users.INVALID), getDriver());
        sa.assertFalse(secondPage.isPageOpened());
        sa.assertEquals(homePage.getInvalidLoginElementText(), "Epic sadface: Username and password do not match any user in this service");

        sa.assertAll();
    }
}
