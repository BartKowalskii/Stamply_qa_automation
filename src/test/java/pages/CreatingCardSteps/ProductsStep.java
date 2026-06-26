package pages.CreatingCardSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.Map;

public class ProductsStep extends BasePage {
    //config
    public ProductsStep(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.actions = new Actions(driver);
    }

    //locators
    By estimatedRedemptionUnitField = By.cssSelector("[data-testid='card-creator-input-unit-value-units']");
    By estimatedRedemptionCurrencyField = By.cssSelector("[data-testid='card-creator-input-unit-value-currency']");
    By testProduct1 = By.cssSelector("[data-testid='card-creator-product-6a36ecf9cf0be7464bd91c53-toggle']");
    By testProduct1StampsNeeded = By.cssSelector("[data-testid='card-creator-input-product-6a36ecf9cf0be7464bd91c53']");
    By addProductButton = By.cssSelector("[data-testid='card-creator-button-add-product']");

    public enum Product {
       TESTPRODUCT1
    }
    private Map<Product, By> products = Map.of (
            Product.TESTPRODUCT1, By.cssSelector("[data-testid='card-creator-product-6a36ecf9cf0be7464bd91c53-toggle']")
    );
    public enum ProductInputField {
        TESTPRODUCT1FIELD

    }
    private Map<ProductInputField, By> productInputs = Map.of (
            ProductInputField.TESTPRODUCT1FIELD, By.cssSelector("[data-testid='card-creator-input-product-6a36ecf9cf0be7464bd91c53']")
               );
    //main
    public void setEstimatedRedemptionUnitField(String estimatedRedemptionUnit) {
        input(estimatedRedemptionUnitField, estimatedRedemptionUnit);
    }

    public void setEstimatedRedemptionCurrencyField(String estimatedRedemptionCurrency) {
        input(estimatedRedemptionCurrencyField, estimatedRedemptionCurrency);
    }

    public void clickProduct(Product product) {
        click(products.get(product));
    }

    public void StampsNeededInput(ProductInputField productInput, String stampsNeeded) {
        input(productInputs.get(productInput), stampsNeeded);
    }

    public void clickAddProduct() {
        click(addProductButton);
    }
}

