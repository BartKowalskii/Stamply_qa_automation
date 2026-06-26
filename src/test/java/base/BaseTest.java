package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class BaseTest {
    protected WebDriver driver;

    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.stamply.pl/");
        try {
            WebElement accept = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Akceptuj')]")
                    ));
            accept.click();
        } catch (Exception ignored) {}
    }
public void handleNewWindow() {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until((d -> d.getWindowHandles().size() > 1));
    Set<String> handles = driver.getWindowHandles();

    String newWindow = handles.stream()
            .filter(h -> !h.equals(originalWindow))
            .findFirst()
            .orElseThrow();

    driver.switchTo().window(newWindow);
}
    public void setupLogin() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://my.stamply.app/auth/login");
        try {
            WebElement accept = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Akceptuj')]")
                    ));
            accept.click();
        } catch (Exception ignored) {}
    }
    public void setUpAccountLoggedIn() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://my.stamply.app/auth/login");
        try {
            WebElement accept = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Akceptuj')]")
                    ));
            accept.click();
        } catch (Exception ignored) {}
        String testEmail = "bartstestuser@gmail.com";
        String testPassword = "TestingUs3r!";
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(testEmail);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(testPassword);
        driver.findElement(By.xpath("//form//button[normalize-space(.)='Log In']")).click();
    }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
