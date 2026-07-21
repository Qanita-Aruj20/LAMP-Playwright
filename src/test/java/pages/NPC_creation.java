package pages;

import org.testng.annotations.Test;

import base.BaseTest;
import com.microsoft.playwright.Locator;

public class NPC_creation extends BaseTest {

    @Test
    public void NPCCreation() {

        // Execute Registration + Token Module
        Serving_Token token = new Serving_Token();
        token.Serving_token3(page);
        System.out.println("=== NPC Creation Started ===");

        // Step 1: Click List View
        page.locator("button:has-text('List View')")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("button:has-text('List View')").click();

        System.out.println("List View opened successfully.");

        // Step 2: Refresh the Page
        page.reload();
        page.waitForLoadState();

        System.out.println("Page refreshed successfully.");

        // Step 3: Click List View Again
        page.locator("button:has-text('List View')")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("button:has-text('List View')").click();

        System.out.println("List View opened again successfully.");

        // Step 4: Wait for Parcel Table
        page.locator("//div[@class='p-5 table-container ng-star-inserted']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        System.out.println("Parcel table is displayed.");

        // Step 5: Click Action (3-Dot) Button
        page.locator("//tbody/tr[4]/td[15]/i[1]")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//tbody/tr[4]/td[15]/i[1]").click();

        System.out.println("Action button clicked successfully.");

        // Step 6: Click Property Certificate
        page.locator("//span[normalize-space()='Property Certificate']").click();

        System.out.println("Property Certificate selected.");

        // Step 7: Click Property Certificate Type
        page.locator("//span[@aria-label='Property Certificate Type']").click();

        System.out.println("Property Certificate Type dropdown opened.");

        // Step 8: Select Non-Transactional Property Certificate
        page.locator("//span[normalize-space()='Non-Transactional']").click();

        System.out.println("Non-Transactional Property Certificate selected.");

        // Step 9: Click Next
        page.locator("//span[normalize-space()='Next']").click();

        System.out.println("Next button clicked successfully.");

        // Step 10: Click Next
        page.locator("//button[@type='submit']").click();

        System.out.println("Next button clicked successfully.");

        // Step 11: Click Next
        page.locator("//span[@class='p-button-label']").click();

        System.out.println("Next button clicked successfully.");

        // Step 12: Click Next
        page.locator("//button[@class='p-button-success min-w-[168px] p-button p-component']").click();

        System.out.println("Next button clicked successfully.");

        // Step 13: Click Challan Issuance
        page.locator("//span[normalize-space()='Challan Issuance']").click();

        System.out.println("Challan Issuance clicked successfully.");

        // Step 14: Wait for Manual Challan Payment
        page.waitForTimeout(30000); // Wait while challan is paid manually through Postman

        System.out.println("Waiting for manual challan payment...");

        // Step 15: Press ESC to Close Popup
        page.keyboard().press("Escape");

        System.out.println("Popup closed successfully.");

        // Step 16: Click Next
        page.locator("//div[@class='flex justify-end items-center h-full']//button[@class='p-button-success min-w-[168px] p-button p-component']")
                .click();

        System.out.println("Next button clicked successfully.");

        // Step 17: Click Download PDF
        page.locator("//button[@class='p-ripple p-button p-component p-button-rounded p-button-success']")
                .click();

        System.out.println("Download PDF clicked successfully.");

        System.out.println("=== Non-Transactional Property Certificate Created Successfully ===");
    }
}