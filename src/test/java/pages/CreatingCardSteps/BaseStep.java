package pages.CreatingCardSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class BaseStep extends BasePage {
    private final By continueButton = By.cssSelector("[data-testid='card-creator-button-primary']");
    private final By backButton = By.cssSelector("[data-testid='card-creator-button-previous']");
    public BaseStep(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public void clickBack() {
        click(backButton);
    }
    public void clickContinue() {
        click(continueButton);
    }
}
