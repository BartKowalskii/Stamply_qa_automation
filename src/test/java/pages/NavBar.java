package pages;
import base.BasePage;
import base.WizardActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class NavBar  {
    //configuration
    private BasePage base;
    private WizardActions wizard;
    //locators
    By logo = By.xpath("//nav//a/img[@alt='Stamply']");
    By produkty = By.xpath("//nav//a[.//span[normalize-space()='Produkty']]");
    By rozwiazania = By.xpath("//nav//a[.//span[normalize-space()='Rozwiązania']]");
    By zasoby = By.xpath("//nav//a[.//span[normalize-space()='Zasoby']]");
    By cennik = By.xpath("//nav//a[.//span[normalize-space()='Cennik']]");
    By kontakt = By.xpath("//nav//a[.//span[normalize-space()='Kontakt']]");
    By rezerwujDemo = By.xpath("//nav//button[normalize-space(.)='Zarezerwuj demo']");

    By produktydrop = By.xpath("//nav//*[contains(text(),'Kluczowe produkty')]");
    By rozwiazaniadrop = By.xpath("//nav//*[contains(text(),'Dopasowane do Twoich potrzeb')]");
    By zasobydrop = By.xpath("//nav//*[contains(text(),'Materiały edukacyjne')]");
    By rezerwujDemoPopUp = By.xpath("//div//h2[normalize-space(.)='Umów rozmowę']");

    By aplikacjaMobilna = By.xpath("//nav//a[.//div[normalize-space(.)='Aplikacja mobilna']]");

    public NavBar(WebDriver driver) {
        this.base = new BasePage(driver);
        this.wizard = new WizardActions(driver);
    }


    public String getCurrentUrl() {
        return base.driver.getCurrentUrl();
    }
    public boolean waitForUrlContains(String text) {
        return base.wait.until(ExpectedConditions.urlContains(text));
    }
    private WebElement find(By locator) {
        return base.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

     private void hover(By locator) {
        WebElement el = base.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        base.actions.moveToElement(el).perform();
    }



    public void clickLogo() {
        base.click(logo);
    }

    public void hoverProdukty() {
        hover(produkty);
    }
    public boolean dropdownprodukty() {
        return find(produktydrop).isDisplayed();
    }

    public void clickAppMobile() {
        base.click(aplikacjaMobilna);
    }


    public void hoverRozwiazania() {
        hover(rozwiazania);
    }
    public boolean dropdownrozwiazania() {
        return find(rozwiazaniadrop).isDisplayed();
    }

    public void hoverZasoby() {
    hover(zasoby);
}
    public boolean dropdownzasoby() {
return find(zasobydrop).isDisplayed();
}
    public void clickCennik() {
        base.click(cennik);
    }

    public void clickKontakt() {
            base.click(kontakt);
        }

    public void clickRezerwuj() {
      base.click(rezerwujDemo);
    }
    public boolean didRezerwujPopUpOpen() {
        return find(rezerwujDemoPopUp).isDisplayed();
    }
}
