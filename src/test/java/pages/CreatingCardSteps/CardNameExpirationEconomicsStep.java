package pages.CreatingCardSteps;

import base.WizardActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;

import java.time.Duration;

public class CardNameExpirationEconomicsStep {
    //config
    private BasePage base;
    private WizardActions wizard;
    public CardNameExpirationEconomicsStep(WebDriver driver) {
        this.base = new BasePage(driver);
        this.wizard = new WizardActions(driver);
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
        base.input(cardNameField, cardName);
    }
    public void estimatedStampUnitInput(String estimatedSTampUnit) {
        base.input(estimatedStampUnitField, estimatedSTampUnit);
    }
    public void estimatedStampValueInput(String estimatedStampValue) {
        base.input(estimatedStampValueField, estimatedStampValue);
    }
    /*
    public void estimatedOrderValuePerStampInput(String estimatedOrderValuePerStamp) {
        input(estimatedOrderValuePerStampField, estimatedOrderValuePerStamp);
    }
    */
    public void expireAfterMonthsInput(String expireAfterMonths) {
        base.input(expireAfterMonthsField, expireAfterMonths);
    }
    public void clickNoExpirationCheckbox() {
        base.click(noExpirationTimeCheckbox);
    }
    public void continueStep() {
        wizard.clickContinue();
    }

}
