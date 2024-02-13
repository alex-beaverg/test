package com.solvd.web_testing.ui.android;

import com.solvd.web_testing.ui.android.common.NavigationBarBase;
import com.solvd.web_testing.ui.android.common.OtherPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NavigationBarBase.class)
public class NavigationBar extends NavigationBarBase {

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"by.av.client:id/navigation_bar_item_icon_view\"])[5]")
    private ExtendedWebElement otherButton;

    @FindBy(xpath = "//android.view.View[@resource-id=\"by.av.client:id/overlay\"]")
    private ExtendedWebElement closeRecommendationButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
    private ExtendedWebElement notAllowNotificationButton;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public NavigationBar closeUnnecessaryWindows(){
        notAllowNotificationButton.click();
        closeRecommendationButton.click();
        return this;
    }

    @Override
    public OtherPageBase goToOtherPage() {
        otherButton.click();
        return initPage(driver, OtherPageBase.class);
    }

    public ExtendedWebElement getOtherButton() {
        return otherButton;
    }
}
