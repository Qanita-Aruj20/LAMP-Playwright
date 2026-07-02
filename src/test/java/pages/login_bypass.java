/*package pages;

import base.BaseTest;
import org.testng.annotations.Test;

public class login_bypass extends BaseTest {

    // Make variables accessible everywhere
    public static final String LOGIN_URL = "https://qa-lrmispulse.lmkr.com/authentication";

    public static final String CNIC_INPUT = "input[placeholder='XXXXX-XXXXXXX-X']";
    public static final String CONTINUE_BUTTON = "button:has-text('Continue')";
    public static final String SCAN_BUTTON = "//body//app-root//div[@data-pc-section='content']//div//div[2]//div[1]//div[2]//div[5]//p-button[1]//button[1]//span[1]";

    @Test
    public void simpleLoginTest() {

        System.out.println("Test started");

        page.navigate(LOGIN_URL);
        page.fill(CNIC_INPUT, "3520225858802");
        page.click(CONTINUE_BUTTON);
        page.waitForLoadState();

        page.locator(SCAN_BUTTON).click();

        System.out.println("Clicked on Scan successfully");
    }
}*/

package pages;

import com.microsoft.playwright.Page;

public class login_bypass {

    public void loginMethod(Page page) {

        page.navigate("https://qa-lrmispulse.lmkr.com/authentication");

        page.fill("input[placeholder='XXXXX-XXXXXXX-X']", "3520225858802");

        page.click("button:has-text('Continue')");

        page.waitForLoadState();

        page.locator("//body//app-root//div[@data-pc-section='content']//div//div[2]//div[1]//div[2]//div[5]//p-button[1]//button[1]//span[1]").click();

        System.out.println("Login successful");
    }
}

