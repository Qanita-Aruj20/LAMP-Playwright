package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class User_Registration extends BaseTest {

    public static final String APPLICANT_REGISTRATION_MENU =
            "//span[normalize-space()='Applicant Registration']";

    public static final String SEARCH_APPLICANT_SECTION =
            "//h3[contains(text(),'Search Applicant')]";

    @Test
    public void userRegistrationScreenTest(Page page) {

        System.out.println("=== Registration Test Started ===");

        // Step 1: Call Login Method
        login_bypass login = new login_bypass();
        login.loginMethod(page);

        System.out.println("✅ Login completed successfully");

        page.waitForTimeout(7000);
        
		 //Step 2: Expanding Side Navigation bar
        page.locator("//div[@class='sidebar-area bg-white active']//div[@class='ng-scroll-content']").click();

        // Step 3: Click Applicant Registration
        Locator applicantRegistration = page.locator(APPLICANT_REGISTRATION_MENU);

        applicantRegistration.waitFor(
                new Locator.WaitForOptions().setTimeout(30000)
        );

        applicantRegistration.scrollIntoViewIfNeeded();

        applicantRegistration.click();

        System.out.println("✅ Applicant Registration clicked");

        // Step 4: Fill CNIC
        page.locator("//input[@placeholder='Enter CNIC Number']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//input[@placeholder='Enter CNIC Number']")
                .fill("3520225858802");

        // Step 5: Open dropdown
        page.locator("//span[@class='ng-star-inserted']").click();

        // Step 6: Select dropdown value
        page.locator("//li[@id='pn_id_15_1']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//li[@id='pn_id_15_1']").click();

        // Step 7: Click Search/Scan button
        page.locator("//div//div//div//div//div//div//div[2]//div[1]//div[2]//div[5]//p-button[1]//button[1]")
                .click();

        // Step 8: Click Forward
        page.locator("//span[normalize-space()='Forward']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//span[normalize-space()='Forward']").click();
        
        page.waitForTimeout(2000);
        
        // Step 8: Click ESC Button
        page.keyboard().press("Escape");

        System.out.println("✅ Registration flow completed");
    }
}