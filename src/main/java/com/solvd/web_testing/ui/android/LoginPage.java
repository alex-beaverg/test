package com.solvd.web_testing.ui.android;

import com.solvd.web_testing.ui.android.common.ConfirmationPageBase;
import com.solvd.web_testing.ui.android.common.LoginPageBase;
import com.solvd.web_testing.ui.android.models.Account;
import com.solvd.web_testing.ui.android.models.Tab;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.solvd.web_testing.ui.android.models.Tab.REGISTRATION;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Регистрация\"]")
    private ExtendedWebElement registrationButton;
    @FindBy(id = "by.av.client:id/nameEditView")
    private ExtendedWebElement inputName;
    @FindBy(id = "by.av.client:id/phoneEditView")
    private ExtendedWebElement inputPhone;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='by.av.client:id/emailEditView']")
    private ExtendedWebElement inputEmail;
    @FindBy(id = "by.av.client:id/passwordEditView")
    private ExtendedWebElement inputPass;
    @FindBy(id = "by.av.client:id/checkBox")
    private ExtendedWebElement checkBox;
    @FindBy(id = "by.av.client:id/signUpButton")
    private ExtendedWebElement confirmButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='by.av.client:id/chipEmailText']")
    private ExtendedWebElement emailButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ConfirmationPageBase registration(Account account) {

        registrationButton.click();
        switchTo(REGISTRATION);

        if (account.getPhone()==null && account.getEmail() == null) {
            throw new RuntimeException();
        } else if (account.getPhone()==null) {
            emailButton.click();
            inputEmail.type(account.getEmail());
        } else {
            inputPhone.type(account.getPhone());
        }
        inputName.type(account.getName());
        inputPass.type(account.getPass());
        checkBox.click();

        Assert.assertTrue(confirmButton.isPresent());
        confirmButton.click();
        return initPage(driver, ConfirmationPageBase.class);
    }

    public LoginPageBase switchTo(Tab type) {
        return switch (type) {
            case LOGIN -> new LoginPage(driver);
            case REGISTRATION -> new LoginPage(driver);
        };
    }
}
