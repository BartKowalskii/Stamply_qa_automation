package pages;

import base.BasePage;
import base.WizardActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login  {
    //configuration
    private BasePage base;
    private WizardActions wizard;

    public Login(WebDriver driver) {
        this.base = new BasePage(driver);
        this.wizard = new WizardActions(driver);
    }

    //locators
    By emailField = By.cssSelector("[data-testid='auth-login-input-email']");
    By passwordField = By.cssSelector("[data-testid='auth-login-input-password']");
    By submit = By.cssSelector("[data-testid='auth-login-button-submit']");
    By hideButton = By.xpath("//form//button[contains(@class,'text-darkGray hover:text-dark') and .//*[name()='svg']]");

    //configuration 2
    public  String source() {
        return base.driver.getPageSource();
    }
    public String getCurrentUrl() {
        return base.driver.getCurrentUrl();
    }
    public void waitForUrlMatches(String text) {
        base.wait.until(ExpectedConditions.urlToBe(text));
    }

      public void clickEnter() {
        base.driver.findElement(passwordField).sendKeys(Keys.ENTER);
    }
    public void waitForError() {
        base.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='auth-login-error']")));
    }
    public String error() {
         return base.driver.findElement(By.cssSelector("[data-testid='auth-login-error']")).getText();
    }
    //main
    public void loginInput(String email, String password) {
        base.input(emailField, email);
    base.input(passwordField, password);
    }
    public void clickSubmit() {
        base.click(submit);
    }
    public boolean isLogInClickable() {
        return base.driver.findElement(submit).isEnabled();
    }
    public boolean isValidEmail(String email) {
        return email != null &&
                email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]");
    }
    public String getPasswordField() {
      return  base.driver.findElement(passwordField).getAttribute("type");
    }
    public void clickHideButton() {
        base.click(hideButton);
    }
    public void clearFields() {
     base.driver.findElement(emailField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        base.driver.findElement(emailField).sendKeys(Keys.DELETE);
        base.driver.findElement(passwordField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        base.driver.findElement(passwordField).sendKeys(Keys.DELETE);
    }
    public void clickLink(String xpath) {
        base.click(By.xpath(xpath));
    }
    public void waitForAppFullyLoaded(String xpath) {
        base.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
