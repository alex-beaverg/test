package com.solvd.web_testing.pages;

import com.solvd.web_testing.domain.ItemSorts;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SecondPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'app_logo']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    private List<ExtendedWebElement> itemNames;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private ExtendedWebElement sortContainer;

    public SecondPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (ExtendedWebElement itemName : itemNames) {
            names.add(itemName.getText());
        }
        return names;
    }

    public SecondPage sortOption(ItemSorts sort) {
        sortContainer.select(sort.getSortType());
        return this;
    }
}
