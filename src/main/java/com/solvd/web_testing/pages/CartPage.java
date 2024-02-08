package com.solvd.web_testing.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//*[@class='title' and text() ='Your Cart']")
    public ExtendedWebElement cartTitle;

    @FindBy(className = "inventory_item_name")
    public List<ExtendedWebElement> cartItemNames;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cartTitle);
    }

    public List<String> getProductsFromCart() {
        return cartItemNames.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }
}
