package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login extends BasePage{
    //configuration

    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.actions = new Actions(driver);
    }

    //locators
    By emailField = By.cssSelector("[data-testid='auth-login-input-email']");
    By passwordField = By.cssSelector("[data-testid='auth-login-input-password']");
    By submit = By.cssSelector("[data-testid='auth-login-button-submit']");
    By hideButton = By.xpath("//form//button[contains(@class,'text-darkGray hover:text-dark') and .//*[name()='svg']]");

    //configuration 2
    public  String source() {
        return driver.getPageSource();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public void waitForUrlMatches(String text) {
        wait.until(ExpectedConditions.urlToBe(text));
    }

      public void clickEnter() {
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
    }
    public void waitForError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'bg-light') and .//*[name()='svg']]")));
    }
    public String error() {
         return driver.findElement(By.xpath("//div[contains(@class,'bg-light') and .//*[name()='svg']]")).getText();
    }
    //main
    public void loginInput(String email, String password) {
        input(emailField, email);
    input(passwordField, password);
    }
    public void clickSubmit() {
        click(submit);
    }
    public boolean isLogInClickable() {
        return driver.findElement(submit).isEnabled();
    }
    public boolean isValidEmail(String email) {
        return email != null &&
                email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]");
    }
    public String getPasswordField() {
      return  driver.findElement(passwordField).getAttribute("type");
    }
    public void clickHideButton() {
        click(hideButton);
    }
    public void clearFields() {
     driver.findElement(emailField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(emailField).sendKeys(Keys.DELETE);
        driver.findElement(passwordField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(passwordField).sendKeys(Keys.DELETE);
    }
    public void clickLink(String xpath) {
        click(By.xpath(xpath));
    }
    public void waitForAppFullyLoaded(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
