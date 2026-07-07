package pages;

import org.openqa.selenium.By;
import pages.CreatingCardSteps.ProductsStep;
import pages.CreatingCardSteps.ProgramTypeStep;

public class CreatingCardFlow {
    CreatingCard creatingCard;

    public CreatingCardFlow(CreatingCard creatingCard) {
        this.creatingCard = creatingCard;
    }

    public void createValidCardStep1(ProgramTypeStep.Option option) {
        creatingCard.programTypeStep.chooseStamp(option);
        creatingCard.programTypeStep.continueStep();

    }
    public void createValidCardStep2( String cardName,
                                      boolean clickCheckbox,
                                      String months,
                                      String estimatedStampUnit,
                                      String estimatedStampValue) {
        creatingCard.cardNameExpirationEconomicsStep.CardNameInput(cardName);
        creatingCard.cardNameExpirationEconomicsStep.estimatedStampUnitInput(estimatedStampUnit);
        creatingCard.cardNameExpirationEconomicsStep.estimatedStampValueInput(estimatedStampValue);
        if (clickCheckbox) {
            creatingCard.cardNameExpirationEconomicsStep.clickNoExpirationCheckbox();
            creatingCard.cardNameExpirationEconomicsStep.expireAfterMonthsInput(months);
        } else {
            creatingCard.cardNameExpirationEconomicsStep.continueStep();
        }
    }
    public void createValidCardStep3(String estimatedRedemptionUnit,
                                     String estimatedRedemptionCurrency,
                                     ProductsStep.Product product,
                                     ProductsStep.ProductInputField productInput, String stampsNeeded) {
        creatingCard.productsStep.setEstimatedRedemptionUnitField(estimatedRedemptionUnit);
        creatingCard.productsStep.setEstimatedRedemptionCurrencyField(estimatedRedemptionCurrency);
        creatingCard.productsStep.clickProduct(product);
        creatingCard.productsStep.StampsNeededInput(productInput, stampsNeeded);
        creatingCard.productsStep.continueStep();
    }
    public void createValidCardStep4( String logo,
                                      String webTitle,
                                      String subtitle,
                                      String color,
                                      String background) {
        creatingCard.registrationPageStep.addLogo(logo);
        creatingCard.registrationPageStep.clickSaveImageButton();
        creatingCard.registrationPageStep.webTitleInput(webTitle);
        creatingCard.registrationPageStep.setSubtitle(subtitle);
        creatingCard.registrationPageStep.accentColorInput(color);
        creatingCard.registrationPageStep.addBackground(background);
        creatingCard.registrationPageStep.clickSaveImageButton();
        creatingCard.registrationPageStep.continueStep();
    }
    public void createValidCardStep5() {
        creatingCard.designStep.continueStep();
    }
    public void createValidCardStep6() {
        creatingCard.walletEnrollmentRequirementsStep.continueStep();
        creatingCard.waitUntilCardCreated();
    }
}
