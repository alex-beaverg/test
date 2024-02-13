package com.solvd.web_testing.ui.android;

import com.solvd.web_testing.ui.android.common.ConfirmationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ConfirmationPageBase.class)
public class ConfirmationPage extends ConfirmationPageBase {

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"by.av.client:id/passwordEditView\"]")
    private ExtendedWebElement inputCodeFromSms;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean containsAllFields() {
        return inputCodeFromSms.isPresent();
    }
}
