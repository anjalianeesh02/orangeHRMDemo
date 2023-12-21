package PageObjectsHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {

    private WebDriver driver;
    private WebDriverWait wait;

    private By dashboardTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifyDashboardTitle() {
        String expectedTitle = "Dashboard";
        // Verify title of the dashboard page
        verifyPageTitle(expectedTitle);
    }

    private void verifyPageTitle(String expectedTitle) {
        String actualTitle = wait.until(ExpectedConditions.presenceOfElementLocated(dashboardTitle)).getText();
        System.out.println("The actual title is: " + actualTitle);

        // Compare both actual and expected titles
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed: " + actualTitle);
        } else {
            System.out.println("Test failed: The expected page title should be: " + expectedTitle);
        }
    }
}