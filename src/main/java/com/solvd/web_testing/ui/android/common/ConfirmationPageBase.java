package com.solvd.web_testing.ui.android.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ConfirmationPageBase extends AbstractPage {

    public ConfirmationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean containsAllFields();
}
