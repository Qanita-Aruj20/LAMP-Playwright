package pages;

import org.testng.annotations.Test;

import base.BaseTest;
import utils.ChallanPayment;

import com.microsoft.playwright.Locator;

public class NPC_creation2 extends BaseTest {

    @Test
    public void NPCCreation() throws Exception {

        // ==========================
        // Registration + Token
        // ==========================

        Serving_Token token = new Serving_Token();
        token.Serving_token3(page);

        System.out.println("=== NPC Creation Started ===");

        // ==========================
        // List View
        // ==========================

        page.locator("button:has-text('List View')")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("button:has-text('List View')").click();

        System.out.println("List View opened successfully.");

        // ==========================
        // Refresh
        // ==========================

        page.reload();
        page.waitForLoadState();

        System.out.println("Page refreshed successfully.");

        // ==========================
        // Open List View Again
        // ==========================

        page.locator("button:has-text('List View')")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("button:has-text('List View')").click();

        System.out.println("List View opened again successfully.");

        // ==========================
        // Wait Parcel Table
        // ==========================

        page.locator("//div[@class='p-5 table-container ng-star-inserted']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        System.out.println("Parcel table displayed.");

        // ==========================
        // Action Button
        // ==========================

        page.locator("//tbody/tr[4]/td[15]/i[1]")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//tbody/tr[4]/td[15]/i[1]").click();

        System.out.println("Action button clicked.");

        // ==========================
        // Property Certificate
        // ==========================

        page.locator("//span[normalize-space()='Property Certificate']").click();

        System.out.println("Property Certificate selected.");

        // ==========================
        // Property Certificate Type
        // ==========================

        page.locator("//span[@aria-label='Property Certificate Type']").click();

        page.locator("//span[normalize-space()='Non-Transactional']").click();

        System.out.println("Non Transactional selected.");

        // ==========================
        // Next
        // ==========================

        page.locator("//span[normalize-space()='Next']").click();

        page.locator("//button[@type='submit']").click();

        page.locator("//span[@class='p-button-label']").click();

        page.locator("//button[@class='p-button-success min-w-[168px] p-button p-component']").click();

        System.out.println("Reached Challan Step.");

        // ==========================
        // Challan Issuance
        // ==========================

        page.locator("//span[normalize-space()='Challan Issuance']").click();

        System.out.println("Challan popup opened.");

        page.waitForTimeout(3000);

        // ==========================
        // Read Challan Number
        // ==========================

        Locator challanLocator = page.locator(
                "//div[@data-pc-section='content']//div[3]//div[1]//div[6]")
                .first();

        challanLocator.waitFor(
                new Locator.WaitForOptions().setTimeout(30000));

        String challanNumber =
                challanLocator.textContent().trim();

        System.out.println("--------------------------------");
        System.out.println("Challan Number : " + challanNumber);

        // ==========================
        // Read Grand Total
        // ==========================

        Locator amountLocator = page.locator(
                "//tr[td[contains(.,'Grand Total')]]/td[2]")
                .first();

        amountLocator.waitFor(
                new Locator.WaitForOptions().setTimeout(30000));

        String totalAmount =
                amountLocator.textContent()
                        .trim()
                        .replace(",", "");

        System.out.println("Grand Total : " + totalAmount);

        System.out.println("--------------------------------");

        // ==========================
        // Pay Challan using API
        // ==========================

        ChallanPayment.payChallan(challanNumber, totalAmount);

        System.out.println("Payment API executed successfully.");

        // Wait for payment to reflect

        page.waitForTimeout(5000);

        // Close Popup

        page.keyboard().press("Escape");

        System.out.println("Popup Closed.");

        Locator nextButton = page.locator(
                "//div[@class='flex justify-end items-center h-full']//button[@class='p-button-success min-w-[168px] p-button p-component']")
                .first();

        nextButton.waitFor(new Locator.WaitForOptions().setTimeout(30000));

        nextButton.click();

        System.out.println("Next button clicked successfully.");

        // Wait for Certificate Screen
        page.waitForLoadState();
        page.waitForTimeout(5000);

        // ==========================
        // Download PDF
        // ==========================

        Locator downloadButton = page.locator("button:has-text('Download PDF')").first();

        downloadButton.waitFor(new Locator.WaitForOptions().setTimeout(30000));

        downloadButton.click();

        System.out.println("Download PDF clicked successfully.");

        // Optional wait for download to start
        page.waitForTimeout(3000);

        System.out.println("==========================================");
        System.out.println("NPC Created Successfully");
        System.out.println("PDF Downloaded Successfully");
        System.out.println("==========================================");

    }

}