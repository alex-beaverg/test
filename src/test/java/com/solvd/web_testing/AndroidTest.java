package com.solvd.web_testing;

import com.solvd.web_testing.ui.android.NavigationBar;
import com.solvd.web_testing.ui.android.common.ConfirmationPageBase;
import com.solvd.web_testing.ui.android.common.LoginPageBase;
import com.solvd.web_testing.ui.android.common.OtherPageBase;
import com.solvd.web_testing.ui.android.models.Account;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidTest extends AbstractTest {

    @Test
    public void verifyRegistration(){
        SoftAssert sa = new SoftAssert();
        NavigationBar navigationBar = new NavigationBar(getDriver());
        navigationBar.closeUnnecessaryWindows();
        sa.assertTrue(navigationBar.getOtherButton().isPresent(), "Button not found");

        OtherPageBase otherPageBase = navigationBar.goToOtherPage();

        LoginPageBase loginPageBase = otherPageBase.goToLogin();

        Account account = new Account();
        account.setName("Тест");
        account.setPhone("+37529 111 11 11");
        account.setPass("pass11111111!");

        ConfirmationPageBase confirmationPageBase = loginPageBase.registration(account);
        sa.assertTrue(confirmationPageBase.containsAllFields());
        sa.assertAll();

    }
}
