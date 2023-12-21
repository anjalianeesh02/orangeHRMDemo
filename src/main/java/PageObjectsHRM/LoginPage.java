package PageObjectsHRM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class LoginPage {

        WebDriver driver;
        WebDriverWait wait;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        }

        private void takeScreenshot(String fileName) throws IOException {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            Path destinationPath = Path.of("screenshots", fileName + ".png");
            Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
        }

        By username1 = By.xpath("//input[@class='oxd-input oxd-input--active' and @name='username']");
        By Password = By.xpath("//input[@class='oxd-input oxd-input--active' and @name='password']");

        By loginButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

        public void enterUserName() {


            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-logo']")));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", logo);

            // Now, enter the username
            WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(username1));
            usernameInput.sendKeys("Admin");
        }

        public void enterPassword() {
            driver.findElement(Password).sendKeys("admin123");
        }

        public void clickLoginButton() {
            driver.findElement(loginButton).click();
        }
    }