package com.solvd.web_testing.pages;

import com.solvd.web_testing.domain.ItemSorts;
import com.solvd.web_testing.domain.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SecondPage extends AbstractPage {

    @FindBy(className = "shopping_cart_link")
    private ExtendedWebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    private ExtendedWebElement cartIconWithItems;

    @FindBy(className = "//button[@class='btn btn_primary btn_small btn_inventory '][%d]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@class = 'app_logo']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    private List<ExtendedWebElement> itemNames;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private ExtendedWebElement sortContainer;

    @FindBy(xpath = "//div[@class='inventory_item_name '][%d]")
    private ExtendedWebElement productNameByIndex;

    @FindBy(xpath = "//div[@class='inventory_item_desc'][%d]")
    private ExtendedWebElement productDescriptionByIndex;

    @FindBy(xpath = "//div[@class='inventory_item_price'][%d]")
    private ExtendedWebElement productPriceByIndex;

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

    public ProductCard getProductByIndex(int index) {
        ProductCard productCard = new ProductCard();
        productCard.setTitle(productNameByIndex.format(index).getText());
        productCard.setDescription(productDescriptionByIndex.format(index).getText());
        String price = productPriceByIndex.format(index).getText().replace("$", "");
        productCard.setPrice(Double.parseDouble(price));

        return productCard;
    }

    public ProductPage clickOnProduct(int index) {
        productNameByIndex.format(index).click();

        return new ProductPage(driver);
    }

    public boolean isCartEmpty() {
        return !cartIconWithItems.isPresent();
    }

    public int getProductQuantity() {
        return Integer.parseInt(cartIconWithItems.getText());
    }

    public ProductCard addProductToCart(int index) {
        addToCartButton.format(index).click();
        return getProductByIndex(index);
    }

    public CartPage openCart() {
        cartIcon.click();
        return new CartPage(getDriver());
    }
}
