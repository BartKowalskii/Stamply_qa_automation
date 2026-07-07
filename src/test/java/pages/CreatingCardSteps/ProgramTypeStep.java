package pages.CreatingCardSteps;

import base.BasePage;
import base.WizardActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class ProgramTypeStep {
    //config

    private BasePage base;
    private WizardActions wizard;

    public ProgramTypeStep(WebDriver driver) {
        this.base = new BasePage(driver);
        this.wizard = new WizardActions(driver);
    }


    public void continueStep() {
        wizard.clickContinue();
    }

    //locators
    public enum Option {
        STAMPLOYALTY,
        POINTWALLET,
        MEMBERSHIP
    }
    private Map<Option, By> options = Map.of (
            Option.STAMPLOYALTY, By.cssSelector("[data-testid='card-creator-type-stamps']"),
            Option.POINTWALLET, By.cssSelector("[data-testid='card-creator-type-points']"),
            Option.MEMBERSHIP,By.cssSelector("[data-testid='card-creator-type-membership']")
    );

    //main
    public void chooseStamp(Option option) {
        base.click(options.get(option));
    }



}
