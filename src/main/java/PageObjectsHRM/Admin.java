package PageObjectsHRM;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Admin {

    WebDriver driver;
    WebDriverWait wait;

    private By adminLinkLocator = By.xpath("//a[contains(@class, 'oxd-main-menu-item') and contains(@href, '/web/index.php/admin/viewAdminModule')]/span[text()='Admin']");
    private By searchLocator = By.xpath("//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active' and @data-v-1f99f73c]");
    private By searchButtonLocator = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--medium') and contains(@class, 'oxd-button--secondary') and contains(@class, 'orangehrm-left-space') and @data-v-10d463b7]");
    private By pencilIconLocator = By.xpath("//i[contains(@class,'bi-pencil-fill')]");
    private By inputElementLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");

    private By userDropl = By.xpath("(//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div/div/div[2]/div/div/div)[1]");

    private By drpClick = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[3]/div/div[2]/div/div/div");

    private By statusDropdownl = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");

    private By userNameloc = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

    private By submitButton = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--medium')]");

    public Admin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void adminSelection() {
        WebElement adminLink = wait.until(ExpectedConditions.elementToBeClickable(adminLinkLocator));
        adminLink.click();
    }

    public void searchUser(String userName) {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchLocator));
        search.sendKeys(userName);

        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
    }

    public void clickPencilIcon() {
        WebElement pencilIconElement = wait.until(ExpectedConditions.presenceOfElementLocated(pencilIconLocator));
        pencilIconElement.click();
    }

    public void CancelSearch() {
        By cancelButtonLocator = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]");
        WebElement cancelButton = wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonLocator));
        cancelButton.click();
    }


    public void backButtonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By backButtonLocator = By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button' and @type='button']");
        WebElement backButton = wait.until(ExpectedConditions.presenceOfElementLocated(backButtonLocator));
        backButton.click();
    }


    public void addUser() {

        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(inputElementLocator));
        inputElement.click();


        WebElement userDrop = wait.until(ExpectedConditions.elementToBeClickable(userDropl));
        System.out.println("User dropdown is clickable. Clicking on it now.");

        // Click on the user dropdown to expand it
        userDrop.click();
    }


    public void selectDropdownValue(String admin) throws InterruptedException {
        try {
            // Click on the user dropdown to expand it
            WebElement userDrop = wait.until(ExpectedConditions.elementToBeClickable(userDropl));
            userDrop.click();
            System.out.println("User dropdown is clicked");

            // Explicitly wait for the presence of the dropdown
            // WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='listbox']")));
            //  System.out.println("Dropdown is present");

            // Use Actions class to simulate keyboard actions on the dropdown
            Actions actions = new Actions(driver);

            // Press arrow down key to navigate to the Admin option
            actions.sendKeys(userDrop, Keys.ARROW_DOWN).perform();

            // Wait for a short duration to ensure the option is highlighted
            Thread.sleep(1000);

            // Press Enter key to select the highlighted option
            actions.sendKeys(Keys.ENTER).perform();
            System.out.println("Admin option selected");
        } catch (Exception e) {
            System.out.println("Unable to select Admin option: " + e.getMessage());
            // Handle the exception as needed
            throw e;
        }
    }

    public void setStatusDropdown(String optionText) throws InterruptedException {
        WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(statusDropdownl));
        System.out.println("Status dropdown is clickable");

        // Click to open the dropdown
        statusDropdown.click();

        // Wait for the dropdown options to appear (adjust the wait time as needed)
        WebDriverWait optionsWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        optionsWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));

        // Locate the dropdown options
        List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']"));

        // Loop through the options and click the one that matches the desired text
        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                option.click();
                System.out.println("Option '" + optionText + "' selected from the dropdown");
                return; // Exit the loop once the option is found and clicked
            }
        }

        // If the loop completes without finding the option, print an error message
        System.out.println("Option '" + optionText + "' not found in the dropdown");
    }

    public void typeEmployeeName(String employeeName) throws InterruptedException {
        try {
            WebElement employeeNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Type for hints...' and @data-v-75e744cd]")));
            employeeNameField.sendKeys(employeeName);

            // Use explicit wait for the dropdown options to appear
            By dropdownOptionsLocator = By.xpath("//div[@role='option']");
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownOptionsLocator));
            Thread.sleep(2000);

            // Use Actions class to press down arrow and Enter to select the first option
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();

            // Wait for a short delay to ensure the option is selected (if needed)
             Thread.sleep(2000);

            // Print the selected option
            System.out.println("Option '" + employeeName + "' selected from the dropdown");
        } catch (TimeoutException | InterruptedException e) {
            // Log the error and any relevant information
            System.out.println("TimeoutException while waiting for dropdown options: " + e.getMessage());
            System.out.println("Page Source: " + driver.getPageSource());
            throw e; // Rethrow the exception to signal the failure
        }
    }


    public void userName(String usermame) throws InterruptedException {

        WebElement enterUserName = wait.until(ExpectedConditions.presenceOfElementLocated(userNameloc));
        enterUserName.click();
        Thread.sleep(1000);
        enterUserName.sendKeys(usermame);
     //   enterUserName.sendKeys("OdisAdalwin1");
        Thread.sleep(2000);
        System.out.println("Username entered correctly");

    }


    public void enterPassword(String password) {
        try {
            // Locate the password input field
            By passwordLocator = By.cssSelector("input[type='password'][data-v-1f99f73c]");
            WebElement passwordInput = driver.findElement(passwordLocator);

            // Enter the password
            passwordInput.sendKeys(password);
            System.out.println("Password entered");

            // Use Actions class to simulate pressing the Tab key
            new Actions(driver).sendKeys(Keys.TAB).perform();
            System.out.println("Tab key pressed to navigate to the confirm password field");

            // Use JavaScript to focus on the confirm password field
            JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                // Execute JavaScript only if the confirm password field is present
                js.executeScript("var confirmPasswordField = document.querySelector('div[data-v-1f99f73c] input[type=password]'); if(confirmPasswordField) confirmPasswordField.focus();");
            } catch (JavascriptException e) {
                // Log the error, but continue execution
                System.out.println("Error while focusing on the confirm password field: " + e.getMessage());
            }

            // Simulate entering the confirm password
          //  passwordInput.sendKeys(password);
            System.out.println("Confirm password entered");
        } catch (NoSuchElementException e) {
            // Log the error and any relevant information
            System.out.println("Error locating password input field: " + e.getMessage());
            System.out.println("Page Source: " + driver.getPageSource());
            throw e; // Rethrow the exception to signal the failure
        }
    }


    public void enterConfirmPassword() {
        WebElement confirmPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")));
        confirmPasswordInput.sendKeys("admin#12345");
    }

    public void clickSubmitButton(){

        WebElement submitButtonClick = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButtonClick.click();
        System.out.println("User successfully added");
    }

    }





