package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import org.testng.annotations.Test;
import data.TestData;

public class LoginPage extends BaseTest {

    private final String LOGIN_URL = "https://qa-lrmispulse.lmkr.com/authentication";

    private final String CNIC_INPUT = "input[placeholder='XXXXX-XXXXXXX-X']";
    private final String CONTINUE_BUTTON = "button:has-text('Continue')";
    private final String PASSWORD_INPUT = "input[placeholder='Enter your password']";
    private final String LOGIN_BUTTON = "button[type='submit']";

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void loginTest(String cnic, String password) {

        System.out.println("Test started");
        System.out.println("CNIC = " + cnic);
        System.out.println("Password = " + password);

        page.navigate(LOGIN_URL, new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));

        page.waitForTimeout(5000);

        System.out.println("Current URL: " + page.url());

        page.locator(CNIC_INPUT).waitFor(new Locator.WaitForOptions()
                .setTimeout(30000));

        page.locator(CNIC_INPUT).fill(cnic);

        page.locator(CONTINUE_BUTTON).click();

        page.locator(PASSWORD_INPUT).waitFor(new Locator.WaitForOptions()
                .setTimeout(30000));

        page.locator(PASSWORD_INPUT).fill(password);

        page.locator(LOGIN_BUTTON).click();

        page.waitForTimeout(5000);

        String currentURL = page.url();

        if (currentURL.contains("/token/queue")) {
            System.out.println("✅ Login Successful");
        } else {
            System.out.println("❌ Login Failed");
            throw new AssertionError(
                    "Login failed for CNIC: " + cnic + " | Password: " + password
            );
        }

        System.out.println("Login attempted with: " + cnic + " | " + password);
    }
}