package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreatingCardSteps.*;

import java.time.Duration;

public class CreatingCard {
    //config
    private WebDriverWait wait;
 public final    ProgramTypeStep programTypeStep;
    public final    CardNameExpirationEconomicsStep cardNameExpirationEconomicsStep;
    public final   ProductsStep productsStep;
    public final   RegistrationPageStep registrationPageStep;
    public final   DesignStep designStep;
    public final  WalletEnrollmentRequirementsStep walletEnrollmentRequirementsStep;

    public CreatingCard(WebDriver driver) {

        this.wait =
                new WebDriverWait(driver, Duration.ofSeconds(3));
        programTypeStep = new ProgramTypeStep(driver);
        cardNameExpirationEconomicsStep =
                new CardNameExpirationEconomicsStep(driver);
        productsStep = new ProductsStep(driver);
        registrationPageStep =
                new RegistrationPageStep(driver);
        designStep = new DesignStep(driver);
        walletEnrollmentRequirementsStep =
                new WalletEnrollmentRequirementsStep(driver);
    }
    public void waitForUrlMatches() {
        wait.until(ExpectedConditions.urlToBe("https://my.stamply.app/"));
    }

    //locators

   /* By deleteCardButton = By.xpath("//buton[@aria-label='Delete']");
    By confirmationDeletion = By.xpath("//button[normalize-space(.)='Yes, delete']");
    */
   By createdCard = By.xpath("//h2/span[normalize-space(.)='Your card is ready']");

    //main

/* public void deleteCard() {
        click(deleteCardButton);
        click(confirmationDeletion);
} */
    public void waitUntilCardCreated() {wait.until(ExpectedConditions.visibilityOfElementLocated(createdCard));}
}

