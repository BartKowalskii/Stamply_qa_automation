package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreatingCardSteps.*;

import java.time.Duration;

public class CreatingCard extends BasePage{
    //config
 public final    ProgramTypeStep programTypeStep;
    public final    CardNameExpirationEconomicsStep cardNameExpirationEconomicsStep;
    public final   ProductsStep productsStep;
    public final   RegistrationPageStep registrationPageStep;
    public final   DesignStep designStep;
    public final  WalletEnrollmentRequirementsStep walletEnrollmentRequirementsStep;

    public CreatingCard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.actions = new Actions(driver);

        this.programTypeStep = new ProgramTypeStep(driver);
        this.cardNameExpirationEconomicsStep = new CardNameExpirationEconomicsStep(driver);
        this.productsStep = new ProductsStep(driver);
        this.registrationPageStep = new RegistrationPageStep(driver);
        this.designStep = new DesignStep(driver);
        this.walletEnrollmentRequirementsStep = new WalletEnrollmentRequirementsStep(driver);

    }
    public void waitForUrlMatches() {
        wait.until(ExpectedConditions.urlToBe("https://my.stamply.app/"));
    }

    //locators

   /* By deleteCardButton = By.xpath("//buton[@aria-label='Delete']");
    By confirmationDeletion = By.xpath("//button[normalize-space(.)='Yes, delete']");
    */
   By createdCard = By.xpath("//div[@class='flex-1 font-semibold']/span[normalize-space(.)='Test1']");

    //main

/* public void deleteCard() {
        click(deleteCardButton);
        click(confirmationDeletion);
} */
    public void waitUntilCardCreated() {wait.until(ExpectedConditions.visibilityOfElementLocated(createdCard));}
}

