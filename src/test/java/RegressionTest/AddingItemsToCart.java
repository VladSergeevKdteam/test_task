package RegressionTest;

import Fragment_Object.Header;
import Fragment_Object.PopupCarts;
import Fragment_Object.ProductCard;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingItemsToCart {
    public static String browser = "chrome";
    public WebDriver driver;
    public ChromeOptions options;
    public Header header;
    public ProductCard productCard;
    public PopupCarts popupCarts;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--headless=new", "--disable-gpu", "--no-sandbox", "--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().deleteAllCookies();

        header = new Header(driver);
        productCard = new ProductCard(driver);
        popupCarts = new PopupCarts(driver);

    }
    @Test
    public void editUserName()  throws Exception {
        try {
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
            String firstRequest = "ro";
            String secondRequest = "Mushroom";
            String nameFirstProduct = "Carrot - 1 Kg";
            String nameSecondProduct = "Mushroom - 1 Kg";
            header.typeRequest(firstRequest);
            header.clickBtnSearch();
            productCard.getFieldQuantity(nameFirstProduct).clear();
            productCard.typeQuantityProducts(nameFirstProduct, "5");
            Thread.sleep(1000);
            productCard.clickBtnAddToCart(nameFirstProduct);
            header.getFieldSearch().clear();
            header.typeRequest(secondRequest);
            header.getBtnSearch();
            for (int i = 0; i < 2; i++) {
                productCard.clickBtnIncrement(nameSecondProduct);
            }
            Thread.sleep(1000);
            productCard.clickBtnAddToCart(nameSecondProduct);
            header.clickBtnCart();
            Thread.sleep(500);
            popupCarts.deleteProductFromCart(nameFirstProduct);
        } catch (Exception error) {
            Assert.fail(String.valueOf(error));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                // Закрыть все открытые вкладки
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                    driver.close();
                }

                // Небольшая пауза, чтобы дать браузеру завершиться
                Thread.sleep(1000);

                // Завершить сессию WebDriver
                driver.quit();
            } catch (Exception e) {
                System.out.println("Ошибка при завершении WebDriver: " + e.getMessage());
            }
        }
    }

}
