package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected void click(By locator)  {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void input(By locator, String text) {
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.CONTROL + "a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

}
