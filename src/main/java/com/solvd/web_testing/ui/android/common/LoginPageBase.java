package com.solvd.web_testing.ui.android.common;

import com.solvd.web_testing.ui.android.models.Account;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ConfirmationPageBase registration(Account account);
}
