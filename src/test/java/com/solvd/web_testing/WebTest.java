package com.solvd.web_testing;

import com.solvd.web_testing.domain.ItemSorts;
import com.solvd.web_testing.domain.Users;
import com.solvd.web_testing.pages.HomePage;
import com.solvd.web_testing.pages.SecondPage;
import com.solvd.web_testing.util.LoginService;
import com.solvd.web_testing.util.SortService;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebTest extends AbstractTest {

    private final LoginService loginService = new LoginService();

    @Test(description = "Verify valid login")
    public void verifyValidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        sa.assertTrue(homePage.isUsernameInputElementPresent());
        sa.assertTrue(homePage.isPasswordInputElementPresent());
        sa.assertTrue(homePage.isLoginButtonElementPresent());

        SecondPage secondPage = loginService.login(loginService.createUser(Users.VALID), getDriver());
        sa.assertTrue(secondPage.isPageOpened());

        sa.assertAll();
    }

    @Test(description = "Verify invalid login")
    public void verifyInvalidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        sa.assertTrue(homePage.isUsernameInputElementPresent());
        sa.assertTrue(homePage.isPasswordInputElementPresent());
        sa.assertTrue(homePage.isLoginButtonElementPresent());

        SecondPage secondPage = loginService.login(loginService.createUser(Users.INVALID), getDriver());
        sa.assertFalse(secondPage.isPageOpened(1));
        sa.assertEquals(homePage.getInvalidLoginElementText(), "Epic sadface: Username and password do not match any user in this service");

        sa.assertAll();
    }

    @Test
    public void verifySortTest() {
        getHomePage();

        SortService sortService = new SortService();
        SoftAssert softAssert = new SoftAssert();

        SecondPage secondPage = loginService.login(loginService.createUser(Users.VALID), getDriver());

        List<String> beforeSort = secondPage.getItemNames();

        secondPage.sortOption(ItemSorts.ASC);
        List<String> actualAfterASCSort = secondPage.getItemNames();
        softAssert.assertEquals(actualAfterASCSort, sortService.ascSort(beforeSort));

        secondPage.sortOption(ItemSorts.DESC);
        List<String> actualAfterDESCSort = secondPage.getItemNames();
        softAssert.assertEquals(actualAfterDESCSort, sortService.descSort(beforeSort));
    }

    private HomePage getHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        return homePage;
    }
}
