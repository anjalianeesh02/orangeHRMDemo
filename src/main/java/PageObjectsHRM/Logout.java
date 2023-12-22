package PageObjectsHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout {

    WebDriver driver;
    WebDriverWait wait;

    public Logout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }


   /* public void logoutClick(){
        By logOutclick = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");

        WebElement clickLogout = wait.until(ExpectedConditions.elementToBeClickable(logOutclick));
        clickLogout.click();
    }*/

    public void logoutClick() {
        By userDropdown = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
        By logoutLink = By.xpath("//a[@class='oxd-userdropdown-link' and contains(text(), 'Logout')]");

        // Click on the user menu dropdown
        WebElement userDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
        userDropdownElement.click();

        // Click on the "Logout" link within the dropdown
        WebElement logoutLinkElement = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLinkElement.click();
        System.out.println("User successfully logged out");
    }


}
