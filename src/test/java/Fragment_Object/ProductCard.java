package Fragment_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductCard {
    public WebDriver driver;

    public ProductCard(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void typeQuantityProducts(String nameProduct, String quantity) {
        WebElement element = driver.findElement(By.xpath("//h4[@class='product-name' and normalize-space(text())='" + nameProduct + "']//ancestor::div[@class='product']//input[@class='quantity']"));
        element.sendKeys(quantity);
    }
    public WebElement getFieldQuantity(String nameProduct) {
        WebElement element = driver.findElement(By.xpath("//h4[@class='product-name' and normalize-space(text())='" + nameProduct + "']//ancestor::div[@class='product']//input[@class='quantity']"));
        return element;
    }
    public void clickBtnIncrement(String nameProduct) {
        WebElement element = driver.findElement(By.xpath("//h4[@class='product-name' and normalize-space(text())='" + nameProduct + "']//ancestor::div[@class='product']//a[@class='increment']"));
        element.click();
    }
    public WebElement getBtnAddToCart(String nameProduct) {
        WebElement element = driver.findElement(By.xpath("//h4[@class='product-name' and normalize-space(text())='" + nameProduct + "']//ancestor::div[@class='product']//button[text()='ADD TO CART']"));
        return element;
    }
    public void clickBtnAddToCart(String nameProduct) {
        WebElement element = driver.findElement(By.xpath("//h4[@class='product-name' and normalize-space(text())='" + nameProduct + "']//ancestor::div[@class='product']//button[text()='ADD TO CART']"));
        element.click();
    }

}
