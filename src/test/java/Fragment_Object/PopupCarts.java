package Fragment_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupCarts {
    public WebDriver driver;

    public PopupCarts(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[@class='cart-preview active']")
    private WebElement block;

    public WebElement getBlock() {
        return block;
    }
    public void deleteProductFromCart(String nameProduct) {
        WebElement element = driver.findElement(By.xpath("//p[@class='product-name' and normalize-space(text())='" + nameProduct + "']/ancestor::li[@class='cart-item']//a[@class='product-remove']"));
        element.click();
    }

}
