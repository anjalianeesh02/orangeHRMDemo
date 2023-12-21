package PageObjectsHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Time {
    private WebDriver driver;
    private WebDriverWait wait;


    public Time(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void timeOption() {

        By timeLinkLocator = By.xpath("//a[contains(@href, '/web/index.php/time/viewTimeModule')]");

        WebElement timeLink = wait.until(ExpectedConditions.elementToBeClickable(timeLinkLocator));
        timeLink.click();
        System.out.println("User navigated to the Time screen");
    }

    public void viewButton(){
        By viewButtonLocator = By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--text oxd-table-cell-action-space'])[1]");

        WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(viewButtonLocator));
        viewButton.click();

    }

    public void approveTimeSheet(){
        By approveTime = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--success orangehrm-left-space']");

        WebElement approveTimeSheet1 = wait.until(ExpectedConditions.elementToBeClickable(approveTime));
        approveTimeSheet1.click();
        System.out.println("Timesheet Approved");
    }

}
