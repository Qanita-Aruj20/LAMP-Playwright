package pages;

import static org.testng.Assert.assertTrue;
import utils.ChallanPayment;
import org.testng.annotations.Test;
import base.BaseTest;
import com.microsoft.playwright.Locator;

public class Semi_tpc extends BaseTest {

    @Test
    public void SPCCreation() throws Exception {

        // ==========================
        // Registration + Token
        // ==========================

        Serving_Token token = new Serving_Token();
        token.Serving_token3(page);

        System.out.println("==========================================");
        System.out.println("Semi Transactional Property Certificate Started");
        System.out.println("==========================================");

        // ==========================
        // Open List View
        // ==========================

        page.locator("button:has-text('List View')")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("button:has-text('List View')").click();

        System.out.println("List View opened successfully.");

        // ==========================
        // Refresh Page
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
     // Wait for Parcel Table
     // ==========================

     page.locator("//div[@class='p-5 table-container ng-star-inserted']")
             .waitFor(new Locator.WaitForOptions().setTimeout(30000));

     System.out.println("Parcel table displayed.");

     // Wait until rows are fully loaded
     Locator rows = page.locator("//tbody/tr");

     int rowCount = 0;

     for (int i = 0; i < 15; i++) {

         rowCount = rows.count();

         System.out.println("Current Rows = " + rowCount);

         if (rowCount > 1) {
             break;
         }

         page.waitForTimeout(1000);
     }

     System.out.println("Total Parcels : " + rowCount);

     // ==========================
     // Find First Unblocked Parcel
     // ==========================

     boolean parcelFound = false;

     for (int i = 0; i < rowCount; i++) {

         Locator row = rows.nth(i);

         // Check for Green Tick (Unblocked Parcel)
         Locator greenTick = row.locator("i.pi.pi-check.ng-star-inserted");

         if (greenTick.count() > 0 && greenTick.first().isVisible()) {

             System.out.println("--------------------------------");
             System.out.println("Unblocked Parcel Found at Row : " + (i + 1));
             System.out.println("--------------------------------");

          // Click Action button from the same row
             Locator actionButton = row.locator("td:last-child i");

             actionButton.scrollIntoViewIfNeeded();

             actionButton.waitFor(
                 new Locator.WaitForOptions().setTimeout(30000));

             actionButton.click();

             page.waitForTimeout(2000);

             System.out.println("Action Button Clicked.");

             parcelFound = true;
             break;
         }
     }

     assertTrue(parcelFound, "No Unblocked Parcel Found.");
        
        // ==========================
        // Property Certificate
        // ==========================

        page.locator("//span[normalize-space()='Property Certificate']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//span[normalize-space()='Property Certificate']").click();

        System.out.println("Property Certificate selected.");

        // ==========================
        // Property Certificate Type
        // ==========================

        page.locator("//span[@aria-label='Property Certificate Type']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//span[@aria-label='Property Certificate Type']").click();

        page.locator("//span[normalize-space()='Semi-Transactional']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//span[normalize-space()='Semi-Transactional']").click();

        System.out.println("Semi Transactional selected.");

        // ==========================
        // Purpose of Property Certificate
        // ==========================

        page.locator("//span[@aria-label='Purpose of Property Certificate']")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("//span[@aria-label='Purpose of Property Certificate']").click();

        System.out.println("Purpose of Property Certificate dropdown opened.");

	     // ==========================
	     // Select Purpose
	     // ==========================
	
	     page.locator("//span[normalize-space()='Semi Transactional Fard']")
	             .waitFor(new Locator.WaitForOptions().setTimeout(30000));
	
	     page.locator("//span[normalize-space()='Semi Transactional Fard']")
	             .click();
	
	     System.out.println("Semi Transactional Fard selected.");

        // ==========================
        // Next
        // ==========================

        page.locator("button:has-text('Next')")
                .waitFor(new Locator.WaitForOptions().setTimeout(30000));

        page.locator("button:has-text('Next')").click();
        System.out.println("Next button clicked successfully.");
        
	     // ==========================
	     // Next
	     // ==========================
	
	     page.locator("//button[@type='submit']")
	             .waitFor(new Locator.WaitForOptions().setTimeout(30000));
	
	     page.locator("//button[@type='submit']").click();
	
	     System.out.println("Moved to Ownership Details.");
	
	     // ==========================
	     // Select Share
	     // ==========================
	
	     page.locator(":text(\"Select Share\")")
	             .waitFor(new Locator.WaitForOptions().setTimeout(30000));
	
	     page.locator(":text(\"Select Share\")").first().click();
	
	     System.out.println("Select Share clicked successfully.");
	
		  // ==========================
		  // Enter Share
		  // ==========================
	
		  // Wait for Select Portion dialog
		  page.locator("//div[contains(@class,'p-dialog-content')]").waitFor();
	
		  // Share textbox (first editable textbox in the dialog)
		  Locator shareInput = page.locator("//div[contains(@class,'p-dialog-content')]//input[not(@readonly)]").first();
	
		  shareInput.waitFor(new Locator.WaitForOptions().setTimeout(30000));
	
		  shareInput.click();
		  shareInput.fill("1/1");
	
		  System.out.println("Share entered successfully.");
		  
		// ==========================
		// Save
		// ==========================

		page.locator("button:has-text('Save')")
		    .waitFor(new Locator.WaitForOptions().setTimeout(30000));

		page.locator("button:has-text('Save')").click();

		System.out.println("Save button clicked successfully.");

		page.waitForTimeout(2000);
	
	     // ==========================
	     // Next
	     // ==========================
	
	     page.locator("//button[@type='submit']")
	             .waitFor(new Locator.WaitForOptions().setTimeout(30000));
	
	     page.locator("//button[@type='submit']").click();
	
	     System.out.println("Moved to Applicant Details.");
	
	     // ==========================
	     // Next
	     // ==========================
	
	     page.locator("//button[@class='p-button-success min-w-[168px] p-button p-component']")
	             .waitFor(new Locator.WaitForOptions().setTimeout(30000));
	
	     page.locator("//button[@class='p-button-success min-w-[168px] p-button p-component']")
	             .click();
	
	     System.out.println("Moved to Challan Step.");
	
		  // ==========================
		  // Challan Issuance
		  // ==========================
	
		  page.locator("button:has-text('Challan Issuance')")
		          .waitFor(new Locator.WaitForOptions().setTimeout(30000));
	
		  page.locator("button:has-text('Challan Issuance')").click();
	
		  System.out.println("Challan Issuance clicked successfully.");
	
		  page.waitForTimeout(3000);
	
			// ==========================
			// Read Challan Number
			// ==========================
	
			Locator challanLocator = page.locator(
			    "div.text-\\[\\#2F2F2F\\].text-\\[30px\\].leading-none.text-center.mt-6")
			    .first();
	
			challanLocator.waitFor(
			    new Locator.WaitForOptions().setTimeout(30000));
	
			String challanNumber = challanLocator.textContent().trim();
	
			System.out.println("--------------------------------");
			System.out.println("Challan Number : " + challanNumber);
	
			// ==========================
			// Read Grand Total
			// ==========================

			Locator amountLocator = page.locator(
			    "//tr[td[contains(.,'Total')]]/td[2]")
			    .first();

			amountLocator.waitFor(
			    new Locator.WaitForOptions().setTimeout(30000));

			String totalAmount = amountLocator.textContent()
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

		  // Wait for popup to close completely
		  page.waitForTimeout(5000);

		  // ==========================
		  // Next
		  // ==========================

		  page.locator("button:has-text('Next')")
		          .waitFor(new Locator.WaitForOptions().setTimeout(30000));

		  page.locator("button:has-text('Next')").click();

		  System.out.println("Next button clicked successfully.");

		  // Wait for certificate page to load
		  page.waitForLoadState();
		  page.waitForTimeout(8000);

		  // ==========================
		  // Download PDF
		  // ==========================

		  page.locator("button:has-text('Download PDF')")
		          .waitFor(new Locator.WaitForOptions().setTimeout(30000));

		  page.locator("button:has-text('Download PDF')").click();

		  System.out.println("Download PDF clicked successfully.");

		  page.waitForTimeout(3000);
    }
}