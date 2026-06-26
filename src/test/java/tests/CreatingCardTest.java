package tests;

import base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.CreatingCard;
import pages.CreatingCardFlow;
import pages.CreatingCardSteps.ProductsStep;
import pages.CreatingCardSteps.ProgramTypeStep;
import pages.Login;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatingCardTest extends BaseTest {
    //config 1
    CreatingCard creatingCard;
    CreatingCardFlow creatingCardFlow;
    @BeforeEach
    void setUpCreatingCard() {
        setUpAccountLoggedIn();
        creatingCard = new CreatingCard(driver);
        creatingCardFlow = new CreatingCardFlow(creatingCard);
        creatingCard.waitForUrlMatches();
        driver.get("https://my.stamply.app/store/cards/create");
    }
    String logo = "C:\\Users\\barte\\Downloads\\TestJPG1.jpg";
    String webtitle = "TestingTitle";
    String subtitle = "Testing Subtitle";
    String color = "#000000";
    String background = "C:\\Users\\barte\\Downloads\\TestJPG2.jpg";
    @AfterEach
    void cleanUp() {
        tearDown();
    }


    //Tests
    @Test
public void successfulAddingCard() {
    creatingCardFlow.createValidCardStep1(ProgramTypeStep.Option.STAMPLOYALTY);
  creatingCardFlow.createValidCardStep2(
          "Test1",
          false,
          "12",
          "1",
          "12"
          );
creatingCardFlow.createValidCardStep3(
        "1",
        "1",
        ProductsStep.Product.TESTPRODUCT1,
        ProductsStep.ProductInputField.TESTPRODUCT1FIELD, "5"
        );
creatingCardFlow.createValidCardStep4(
        logo,
        webtitle,
        subtitle,
        color,
        background
        );
creatingCardFlow.createValidCardStep5();
creatingCardFlow.createValidCardStep6();
assertTrue(driver.findElement(By.xpath("//div[@class='flex-1 font-semibold']/span[normalize-space(.)='Test1']")).isDisplayed());
 // creatingCard.deleteCard();
    }
}
