package com.solvd.web_testing.ui.android.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class OtherPageBase extends AbstractPage {

    public OtherPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase goToLogin();

}
