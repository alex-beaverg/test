package com.solvd.web_testing.ui.android;

import com.solvd.web_testing.ui.android.common.LoginPageBase;
import com.solvd.web_testing.ui.android.common.OtherPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OtherPageBase.class)
public class OtherPage extends OtherPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Войти\"]")
    private ExtendedWebElement registrationButton;

    public OtherPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase goToLogin() {
        Assert.assertTrue(registrationButton.isPresent());
        registrationButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

}
