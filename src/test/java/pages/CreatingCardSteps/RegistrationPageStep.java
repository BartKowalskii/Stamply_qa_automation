package pages.CreatingCardSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class RegistrationPageStep extends BasePage {
    //config

    public RegistrationPageStep(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.actions = new Actions(driver);
    }
    //locators
    By webTitleField = By.cssSelector("[data-testid='card-creator-input-web-title']");
    By subtitleField = By.cssSelector("[data-testid='card-creator-input-web-subtitle']");
    By accentColorInputField = By.cssSelector("[data-testid='card-creator-color-web-accent']");
    By logoContainer = By.cssSelector("[data-testid='card-creator-file-web-logo']");
    By pictureInput = By.xpath("./preceding-sibling::input[@type='file']");
    By backgroundContainer = By.cssSelector("[data-testid='card-creator-file-web-background']");
    By saveImageButton = By.xpath("//button[normalize-space(.)='Save image']");


    //main
    public void addLogo(String logoJPG) {
        driver.findElement(logoContainer).findElement(pictureInput).sendKeys(logoJPG);
    }
    public void webTitleInput(String webTitle) {
        input(webTitleField, webTitle);
    }
    public void setSubtitle(String subtitle) {
        input(subtitleField, subtitle);
    }
    public void accentColorInput(String accentColor) {
        input(accentColorInputField, accentColor);
    }
public void addBackground(String backgroundJPG) {
        driver.findElement(backgroundContainer).findElement(pictureInput).sendKeys(backgroundJPG);
}
public void clickSaveImageButton() {
        click(saveImageButton);
}

}
