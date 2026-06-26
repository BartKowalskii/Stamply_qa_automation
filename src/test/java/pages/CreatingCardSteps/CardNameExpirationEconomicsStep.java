package pages.CreatingCardSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class CardNameExpirationEconomicsStep extends BasePage {
    //config
    public CardNameExpirationEconomicsStep(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.actions = new Actions(driver);
    }
    //locators
    By cardNameField = By.cssSelector("[data-testid='card-creator-input-name']");
    By estimatedStampUnitField = By.cssSelector("[data-testid='card-creator-input-spend-value-units']");
    By estimatedStampValueField = By.cssSelector("[data-testid='card-creator-input-spend-value-currency']");
  //  By estimatedOrderValuePerStampField = By.cssSelector("[data-testid='card-creator-input-estimated-order-value-per-unit']");
    By expireAfterMonthsField = By.cssSelector("[data-testid='card-creator-input-expiration-months']");
    By noExpirationTimeCheckbox = By.cssSelector("[data-testid='card-creator-checkbox-no-expiration']");


    //main
    public void CardNameInput(String cardName) {
        input(cardNameField, cardName);
    }
    public void estimatedStampUnitInput(String estimatedSTampUnit) {
        input(estimatedStampUnitField, estimatedSTampUnit);
    }
    public void estimatedStampValueInput(String estimatedStampValue) {
        input(estimatedStampValueField, estimatedStampValue);
    }
    /*
    public void estimatedOrderValuePerStampInput(String estimatedOrderValuePerStamp) {
        input(estimatedOrderValuePerStampField, estimatedOrderValuePerStamp);
    }
    */
    public void expireAfterMonthsInput(String expireAfterMonths) {
        input(expireAfterMonthsField, expireAfterMonths);
    }
    public void clickNoExpirationCheckbox() {
        click(noExpirationTimeCheckbox);
    }


}
