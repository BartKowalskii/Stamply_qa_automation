package pages.CreatingCardSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.Map;

public class ProgramTypeStep extends BaseStep {
    //config
      public ProgramTypeStep(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.actions = new Actions(driver);
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
        click(options.get(option));
    }



}
