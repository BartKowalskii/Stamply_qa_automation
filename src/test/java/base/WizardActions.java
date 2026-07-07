package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WizardActions {

        private WebDriver driver;
        private WebDriverWait wait;

        public WizardActions(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        }

        private By continueButton =
                By.cssSelector("[data-testid='card-creator-button-primary']");

        private By backButton =
                By.cssSelector("[data-testid='card-creator-button-previous']");

        public void clickContinue() {
            wait.until(
                    ExpectedConditions
                            .elementToBeClickable(continueButton)
            ).click();
        }

        public void clickBack() {
            wait.until(
                    ExpectedConditions
                            .elementToBeClickable(backButton)
            ).click();
        }

}
