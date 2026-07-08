package tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import base.BaseTest;
import pages.NavBar;

public class NavBarTest extends BaseTest {

    NavBar navbar;

    @BeforeEach
    void setUp() {
        setup();
        navbar = new NavBar(driver);
    }

    @AfterEach
    void cleanUp() {
        tearDown();
    }

    @Test
    public void testLogoRedirect() {
        navbar.clickLogo();
        assertEquals("https://stamply.pl/", navbar.getCurrentUrl());
    }

      @Test
              public void testHoverProdukty() {
          navbar.hoverProdukty();
          assertTrue(navbar.dropdownprodukty());
      }
      @Test
        public void testClickAplikacjeMobilne() {
        navbar.hoverProdukty();
        navbar.clickAppMobile();
        assertEquals("https://stamply.pl/products/stamply-app/", navbar.getCurrentUrl());
      }

      @Test
              public void testHoverRoziwazania() {
          navbar.hoverRozwiazania();
          assertTrue(navbar.dropdownrozwiazania());
      }
      @Test
              public void testHoverZasoby() {
          navbar.hoverZasoby();
          assertTrue(navbar.dropdownzasoby());
      }
      @Test
              public void testClickCennik() {
          navbar.clickCennik();
          assertTrue(navbar.waitForUrlContains("pricing"));
      }
      @Test
              public void testClickKontakt() {
          navbar.clickKontakt();
          assertTrue(navbar.waitForUrlContains("contact"));
      }
      @Test
              public void  testClickRezerwuj() {
        navbar.clickRezerwuj();
          handleNewWindow();
          assertTrue(navbar.waitForUrlContains("https://calendly.com/dioxymeta/stamply-presentation"));
        }


}
