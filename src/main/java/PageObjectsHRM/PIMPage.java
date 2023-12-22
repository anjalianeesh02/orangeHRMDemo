package PageObjectsHRM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PIMPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
    }


    private By PIMLink = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
    private By addButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");

    // Constructor
    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
    }

    public void PIMLinkSelection() {
        WebElement pimLink = wait.until(ExpectedConditions.elementToBeClickable(PIMLink));
        pimLink.click();
        System.out.println("user successfully navigated to the PIM screen");
    }

    public void AddButton() {
        WebElement addButtonClick = wait.until(ExpectedConditions.elementToBeClickable(addButtonLocator));
        addButtonClick.click();

    }

    public void enterFirstName(String FirstName) {
        By firstNameLocator = By.cssSelector("input.oxd-input.oxd-input--active.orangehrm-firstname");
        WebElement firstNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(firstNameLocator));
        firstNameInput.sendKeys(FirstName);

    }

    public void enterLastName(String LastName) {
        WebElement lastNameLocator = driver.findElement(By.name("lastName"));
        lastNameLocator.sendKeys(LastName);
    }


  /*  public void imageLink(String filePath) {
   //     WebElement imageLocator = driver.findElement(By.xpath("//img[@class='employee-image']"));
   //     imageLocator.click();
   //     String fileInputLoc = "C:\\Users\\AnjaliNarayanan\\OneDrive - PQA\\Desktop\\OrangeHRM\\Image001.png";
    //    WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='file']")));
        By fileInputLoc = By.xpath("//img[@class='employee-image']");
        WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(fileInputLoc));
        fileInput.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().activeElement().sendKeys(filePath);

      /*  WebElement imageLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='employee-image']")));
        imageLocator.click();

        String filePath = "C:\\Users\\AnjaliNarayanan\\OneDrive - PQA\\Desktop\\OrangeHRM\\Image001.png";*/


    //}
    public void imageLink(String filePath) {
        // Assuming there is a file input element associated with the profile picture
        By imgLocator = By.xpath("//img[@class='employee-image']");
        WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(imgLocator));
        imgElement.click();

        // Wait for the file input to be visible
        By fileInputLocator = By.cssSelector("input[type='file']");
        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(fileInputLocator));

        // Send the file path to the file input
        fileInput.sendKeys(filePath);
    }

    public void employeeNum(String number){

        WebElement emplNum = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
        emplNum.clear();
        emplNum.sendKeys(number);
    }

    public void saveDetails(){
        By saveButtonLocator = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveButtonLocator));
        saveButton.click();
    }

    /*    public void scrollDownPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }*/

    public void selectNationality(String nationality) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100);");
        Thread.sleep(1000);

        // Locate the nationality dropdown
        WebElement nationalityDropdown = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));

        // Click on the dropdown to expand it
        nationalityDropdown.click();
        System.out.println("Nationality dropdown clicked and expanded");

        // Simulate typing the nationality into the dropdown input
        nationalityDropdown.sendKeys(nationality);

        // Simulate pressing Enter to select the typed nationality
        nationalityDropdown.sendKeys(Keys.ENTER);
        System.out.println("Selected Nationality: " + nationality);
    }

   /* public void selectMaritalStatus(String desiredStatus) {
        // ... (previous code)

        // Wait for the dropdown options to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By optionLocator = By.xpath(String.format("//div[2]/div/div[2]/div/div/div[2]/i", desiredStatus));
        WebElement maritalStatusOption = wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));

        // Click on the desired marital status option
        maritalStatusOption.click();
        System.out.println("Selected marital status: " + desiredStatus);
    }*/

  //  public void maritalStatus(String desiredStatus) {

     /*   WebElement marital = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
        marital.click();
        System.out.println("Marital status dropdown clicked and expanded");

        By optionLocator = By.xpath(String.format("//div[@class='oxd-select-list']/div[text()='%s']", desiredStatus));
        WebElement maritalStatusOption = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        maritalStatusOption.click();

        System.out.println("Selected marital status: " + desiredStatus);
    }*/

      /*  By maritalStatusDropdownLocator = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
        WebElement maritalStatusDropdown = wait.until(ExpectedConditions.elementToBeClickable(maritalStatusDropdownLocator));

        // Click on the dropdown to expand it
        maritalStatusDropdown.click();
        System.out.println("Marital status dropdown clicked and expanded");

        // Locate and click on the desired option in the dropdown list
        By optionLocator = By.xpath(String.format("//div[@class='oxd-select-list']/div[text()='%s']", desiredStatus));
        WebElement maritalStatusOption = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        maritalStatusOption.click();

        System.out.println("Selected marital status: " + desiredStatus);
    }*/

    public void maritalStatus(String desiredStatus) throws InterruptedException {
        // Locate the marital status dropdown
        By maritalStatusDropdownLocator = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
        WebElement maritalStatusDropdown = wait.until(ExpectedConditions.elementToBeClickable(maritalStatusDropdownLocator));

        // Click on the dropdown to expand it
        maritalStatusDropdown.click();
        System.out.println("Marital status dropdown clicked and expanded");

        maritalStatusDropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        System.out.println("Selected marital status: " + desiredStatus);
    }

    public void sexSelect() {
        // Scroll down by a small amount (e.g., 100 pixels)
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100);");

        // Locate and click on the Female radio button input element
        By femaleRadioInputLocator = By.xpath("//div[2]/div[2]/div/label/span");
        WebElement femaleRadioInput = wait.until(ExpectedConditions.elementToBeClickable(femaleRadioInputLocator));
        femaleRadioInput.click();
        System.out.println("Female option selected");
    }


    public void saveButton(){
        WebElement saveButtonLoc = driver.findElement(By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]"));
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveButtonLoc));
        saveButton.click();
        System.out.println("user details successfully saved");
    }

}

