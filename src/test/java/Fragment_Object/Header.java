package Fragment_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    public WebDriver driver;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "(//div[@class='container'])[2]")
    private WebElement block;
    @FindBy(xpath = "//input[@class='search-keyword']")
    private WebElement fieldSearch;
    @FindBy(xpath = "//button[@class='search-button']")
    private WebElement btnSearch;
    @FindBy(xpath = "//a[@class='cart-icon']")
    private WebElement btnCart;
    public WebElement getBlock() {
        return block;
    }
    public WebElement getFieldSearch() {
        return fieldSearch;
    }
    public void typeRequest(String text) {
        fieldSearch.sendKeys(text);
    }
    public WebElement getBtnSearch() {
        return btnSearch;
    }
    public void clickBtnSearch() {
        btnSearch.click();
    }
    public WebElement getBtnCart() {
        return btnCart;
    }
    public PopupCarts clickBtnCart() {
        btnCart.click();
        return new PopupCarts(driver);
    }
}

