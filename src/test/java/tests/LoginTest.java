package tests;

import base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.Login;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {
    //configuration
    Login login;

    String wrongEmail = "wrongemail@gmail.com";
    String wrongPassword = "Wrongpassword123!";
    String emptyField = "";
    String[] payloads = {
            "' OR '1'='1",
            "'; DROP TABLE users; --",
            "<script>alert(1)</script>",
            "' onmouseover='alert(1)",
            "../../../etc/passwd",
            "' UNION SELECT * FROM users --"
    };
    String[] forbiddenResponses = {
            "SQLException",
            "SQLSyntaxErrorException",
            "ORA-",
            "syntax error",
            "stack trace",
            "Internal Server Error"
    };

    @BeforeEach
    void setUpLogin() {
        setupLogin();
        login = new Login(driver);
    }
    @AfterEach
    void cleanUp() {
        tearDown();
    }

    //Tests
    @Test
    public void correctLogin() {
        login.loginInput(getTestEmail(), getTestPassword());
        login.clickSubmit();
       login.waitForUrlMatches("https://my.stamply.app/");
        assertEquals("https://my.stamply.app/", login.getCurrentUrl());
    }

    @Test
    public void wrongPassword() {
        login.loginInput(getTestEmail(), wrongPassword);
        login.clickSubmit();
        login.waitForError();
        assertEquals("https://my.stamply.app/auth/login", login.getCurrentUrl());
        assertEquals("Invalid password", login.error());
    }
    @Test
    public void wrongEmail() {
        login.loginInput(wrongEmail, getTestPassword());
        login.clickSubmit();
        login.waitForError();
        assertEquals("https://my.stamply.app/auth/login", login.getCurrentUrl());
        assertEquals("User with provided email and password does not exist", login.error());
    }
    @Test
    public void wrongPassAndEmail() {
        login.loginInput(wrongEmail, wrongPassword);
        login.clickSubmit();
        login.waitForError();
        assertEquals("https://my.stamply.app/auth/login", login.getCurrentUrl());
        assertEquals("User with provided email and password does not exist", login.error());
    }
    @Test
    public void emptyEmail() {
        login.loginInput(emptyField, wrongPassword);
        assertFalse(login.isLogInClickable());
    }
    @Test
    public void emptyPassword() {
        login.loginInput(getTestEmail(), emptyField);
        assertFalse(login.isLogInClickable());
    }
    @Test
    public void shouldLoginButtonUnactive() {
        login.loginInput(emptyField, emptyField);
        assertFalse(login.isLogInClickable());
    }
    @Test
    public void shouldRejectEmailWithoutAtSign() {
        assertFalse(login.isValidEmail("bartstestusergmail.com"));
    }
    @Test
    public void shouldRejectEmailWithoutDomain() {
        assertFalse(login.isValidEmail("bartstestuser@"));
    }
    @Test
    public void shouldRejectEmailWithoutUser() {
        assertFalse(login.isValidEmail("@gmail.com"));
    }
    @Test
    public void shouldRejectEmailWithSpace() {
        assertFalse(login.isValidEmail("barts testuser@gmail.com"));
    }
    @Test
    public void shouldAllowEmailWithUpperCase() {
        login.loginInput("BartsTestUser@gmail.com", getTestPassword());
        login.clickSubmit();
        login.waitForUrlMatches("https://my.stamply.app/");
        assertEquals("https://my.stamply.app/", login.getCurrentUrl());
    }
    @Test
    public void isPasswordMasked() {
        assertEquals("password", login.getPasswordField());
    }
     @Test
    public void isHideButtonWorking() {
        login.loginInput(getTestEmail(), getTestPassword());
        login.clickHideButton();
        assertEquals("text", login.getPasswordField());
        login.clickHideButton();
        assertEquals("password", login.getPasswordField());
    }
    @Test
    public void isEnterSubmittingForm() {
        login.loginInput(getTestEmail(), getTestPassword());
        login.clickEnter();
        login.waitForUrlMatches("https://my.stamply.app/");
        assertEquals("https://my.stamply.app/", login.getCurrentUrl());
    }
    @Test
    public void doesSqlAndScriptInjectionCrushTheApp() {
        for (String payload : payloads) {
            login.clearFields();
            login.loginInput(payload, payload);
            login.clickSubmit();
            // App should still function
            assertTrue(driver.findElement(By.tagName("body")).isDisplayed());
            //Login should fail
            assertEquals("https://my.stamply.app/auth/login", login.getCurrentUrl());

            assertAll(
                    Arrays.stream(forbiddenResponses).map(forbidden -> () ->
                            assertFalse(login.source().contains(forbidden), "Found forbidden text: " + forbidden))
            );

        }
    }
    @Test
    public void didForgotPasswordLinkWork() {
        login.clickLink("//a[normalize-space(.)='Forgot Password?']");
        login.waitForUrlMatches("https://my.stamply.app/auth/recover-password");
        assertEquals("https://my.stamply.app/auth/recover-password", login.getCurrentUrl());
     login.waitForAppFullyLoaded("//h1[normalize-space()='Forgot your password?']");
        assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Forgot your password?']")).isDisplayed());
    }
    @Test
    public void didTermsAndConditionsLinkWork() throws InterruptedException {
        login.clickLink("//a[normalize-space(.)='Terms and Conditions']");
      handleNewWindow();
        login.waitForUrlMatches("https://stamply.pl/terms-and-conditions/");
        assertEquals("https://stamply.pl/terms-and-conditions/", login.getCurrentUrl());
    }
    @Test
    public void didCreateAccountLinkWork() {
        login.clickLink("//a[normalize-space(.)='Create an account!']");
        login.waitForUrlMatches("https://my.stamply.app/auth/register");
        assertEquals("https://my.stamply.app/auth/register", login.getCurrentUrl());
        login.waitForAppFullyLoaded("//h1[normalize-space()='Tell us about your business']");
        assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Tell us about your business']")).isDisplayed());
    }
}
