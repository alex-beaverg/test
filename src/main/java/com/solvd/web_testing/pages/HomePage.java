package com.solvd.web_testing.pages;

import com.solvd.web_testing.domain.User;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//input[@id = 'user-name']")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//input[@id = 'password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@id = 'login-button']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//h3[@data-test = 'error']")
    private ExtendedWebElement invalidLoginElement;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public void open() {
        super.openURL(Configuration.getRequired("home_url"));
    }

    public String getInvalidLoginElementText() {
        return invalidLoginElement.getText();
    }

    public HomePage typeUsername(User user) {
        usernameInput.type(user.getUsername());
        return this;
    }

    public HomePage typePassword(User user) {
        passwordInput.type(user.getPassword());
        return this;
    }

    public SecondPage clickLoginButton() {
        loginButton.click();
        return new SecondPage(driver);
    }

    public boolean isUsernameInputElementPresent() {
        return usernameInput.isElementPresent();
    }

    public boolean isPasswordInputElementPresent() {
        return passwordInput.isElementPresent();
    }

    public boolean isLoginButtonElementPresent() {
        return loginButton.isElementPresent();
    }
}
