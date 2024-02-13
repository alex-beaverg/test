package com.solvd.web_testing.ui.android.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NavigationBarBase extends AbstractPage {

    public NavigationBarBase(WebDriver driver) {
        super(driver);
    }

    public abstract OtherPageBase goToOtherPage();
}
