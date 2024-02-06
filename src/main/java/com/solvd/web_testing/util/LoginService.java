package com.solvd.web_testing.util;

import com.solvd.web_testing.domain.User;
import com.solvd.web_testing.domain.Users;
import com.solvd.web_testing.pages.HomePage;
import com.solvd.web_testing.pages.SecondPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    public User createUser(Users user) {
        return new User(user.getUsername(), user.getPassword());
    }

    public SecondPage login(User user, WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.typeUsername(user);
        homePage.typePassword(user);
        return homePage.clickLoginButton();
    }
}
