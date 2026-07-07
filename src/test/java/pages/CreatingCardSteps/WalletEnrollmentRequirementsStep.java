package pages.CreatingCardSteps;

import base.WizardActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;

import java.time.Duration;

public class WalletEnrollmentRequirementsStep  {
    //config

    private BasePage base;
    private WizardActions wizard;

    public WalletEnrollmentRequirementsStep(WebDriver driver) {
        this.base = new BasePage(driver);
        this.wizard = new WizardActions(driver);
    }
    //locators



//main
public void continueStep() {
    wizard.clickContinue();
}

}
