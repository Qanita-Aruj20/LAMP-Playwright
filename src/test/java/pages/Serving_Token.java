package pages;

import base.BaseTest;
import com.microsoft.playwright.Page;

public class Serving_Token extends BaseTest {

    public void Serving_token3(Page page) {

        // Step 1: Call Registration Method
        User_Registration registration = new User_Registration();
        registration.userRegistrationScreenTest(page);

        // Step 2: Expanding Side Navigation bar
        page.locator("//div[@class='sidebar-area bg-white active']//div[@class='ng-scroll-content']").click();

        // Step 3: Clicking on the Token Menu
        page.locator("//span[contains(text(),'Token')]").click();

        // Step 4: Clicking on the Now Serving SubMenu
        page.locator("//a[normalize-space()='Now Serving']").click();

        // Step 5: Clicking on the Serve Action Button
        page.locator("//span[@class='p-button-label']").click();

        // Step 6: Clicking on the View Identity Button
        page.locator("//button[@class='p-ripple p-button p-component']").click();

        System.out.println("Token Serving Screen Opened Successfully");
    }
}