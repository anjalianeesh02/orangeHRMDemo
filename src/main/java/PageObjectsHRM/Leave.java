package PageObjectsHRM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Leave {

    private WebDriver driver;
    private WebDriverWait wait;


    public Leave(WebDriver driver, WebDriverWait wait) {
            this.driver = driver;
            this.wait = wait;
    }

    public void leaveOption() {

        WebElement leaveLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/web/index.php/leave/viewLeaveModule')]")));
        leaveLink.click();
        System.out.println("Leave option selected");
    }

    public void clickCheckbox() {

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100);");
        try {
            // Wait for the element to be present in the DOM
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label/span/i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[1]")));

            // Use JavaScript to click the element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

            System.out.println("Checkbox clicked successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void approve() throws InterruptedException {

        WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-success']")));

        // Click the "Approve" button
        approveButton.click();
        System.out.println("Approve option has been clicked");
        Thread.sleep(1000);

        WebElement cancelApprove = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]")));
        cancelApprove.click();
        System.out.println("Approval Canceled");
    }
}

