package pages.CreatingCardSteps;

import base.WizardActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;

import java.time.Duration;
import java.util.Map;

public class ProductsStep {

    //config
    private BasePage base;
    private WizardActions wizard;

    public ProductsStep(WebDriver driver) {
        this.base = new BasePage(driver);
        this.wizard = new WizardActions(driver);
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
        base.input(estimatedRedemptionUnitField, estimatedRedemptionUnit);
    }

    public void setEstimatedRedemptionCurrencyField(String estimatedRedemptionCurrency) {
        base.input(estimatedRedemptionCurrencyField, estimatedRedemptionCurrency);
    }

    public void clickProduct(Product product) {
        base.click(products.get(product));
    }

    public void StampsNeededInput(ProductInputField productInput, String stampsNeeded) {
        base.input(productInputs.get(productInput), stampsNeeded);
    }

    public void clickAddProduct() {
        base.click(addProductButton);
    }
    public void continueStep() {
        wizard.clickContinue();
    }

}

