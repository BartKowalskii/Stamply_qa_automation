package pages.CreatingCardSteps;

import base.WizardActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;

import java.time.Duration;

public class RegistrationPageStep  {
    //config
    private BasePage base;
    private WizardActions wizard;

    public RegistrationPageStep(WebDriver driver) {
        this.base = new BasePage(driver);
        this.wizard = new WizardActions(driver);
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
        base.driver.findElement(logoContainer).findElement(pictureInput).sendKeys(logoJPG);
    }
    public void webTitleInput(String webTitle) {
        base.input(webTitleField, webTitle);
    }
    public void setSubtitle(String subtitle) {
        base.input(subtitleField, subtitle);
    }
    public void accentColorInput(String accentColor) {
        base.input(accentColorInputField, accentColor);
    }
public void addBackground(String backgroundJPG) {
        base.driver.findElement(backgroundContainer).findElement(pictureInput).sendKeys(backgroundJPG);
}
public void clickSaveImageButton() {
        base.click(saveImageButton);
}
    public void continueStep() {
        wizard.clickContinue();
    }

}
