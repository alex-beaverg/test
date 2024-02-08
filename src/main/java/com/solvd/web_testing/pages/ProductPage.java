package com.solvd.web_testing.pages;

import com.solvd.web_testing.domain.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//*[@class='inventory_details_name large_size']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//*[@class='inventory_details_desc large_size']")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = "//*[@class='inventory_details_price']")
    private ExtendedWebElement productPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productName);
    }

    public ProductCard getProduct() {
        ProductCard productCard = new ProductCard();
        productCard.setTitle(productName.getText());
        productCard.setDescription(productDescription.getText());
        String price = productPrice.getText().replace("$", "");
        productCard.setPrice(Double.parseDouble(price));

        return productCard;
    }
}
