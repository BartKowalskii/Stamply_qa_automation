package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.actions = new Actions(driver);
    }

    public void click(By locator)  {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void input(By locator, String text) {

        var element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                );

        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

}
