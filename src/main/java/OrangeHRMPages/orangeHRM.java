package OrangeHRMPages;

import PageObjectsHRM.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class orangeHRM {

    private static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        LoginPage log = new LoginPage(driver);
        Thread.sleep(1000);
        log.enterUserName();
        Thread.sleep(1000);
        log.enterPassword();
        Thread.sleep(1000);
        log.clickLoginButton();
        Thread.sleep(1000);


        Dashboard obj = new Dashboard(driver);
        obj.verifyDashboardTitle();

        Admin obj1 = new Admin(driver);
        obj1.adminSelection();
        Thread.sleep(1000);
        obj1.searchUser("Joe.Root");

        obj1.clickPencilIcon();
        obj1.CancelSearch();
        System.out.println("search competed successfully");
        obj1.backButtonClick();
        obj1.addUser();
        Thread.sleep(1000);
       // obj1.backButtonClick();
        obj1.selectDropdownValue("Admin");
        Thread.sleep(1000);
        obj1.setStatusDropdown("Enabled");
        Thread.sleep(1000);
        //obj1.CancelAddUser();
       // obj1.typeEmployeeName("Odis Adalwin");
        obj1.typeEmployeeName("Alexa  Max");
        Thread.sleep(1000);
        obj1.userName("alextdff");
        obj1.enterPassword("admin#12345");
       obj1.enterConfirmPassword();
       obj1.clickSubmitButton();
     //  obj1.searchUser("Oldis");

        PIMPage obj2 = new PIMPage(driver);
        obj2.PIMLinkSelection();
        obj2.AddButton();
        obj2.enterFirstName("Alexand");
        obj2.enterLastName("Maxr");
        obj1.backButtonClick();
        obj2.employeeNum("1256");
        obj2.saveDetails();
        Thread.sleep(3000);
        obj2.selectNationality("Namibian");
        obj2.maritalStatus("Single");
        Thread.sleep(1000);
        obj2.sexSelect();
        Thread.sleep(1000);
        obj2.saveButton();
        Thread.sleep(1000);

        Leave obj3 = new Leave(driver, wait);
        obj3.leaveOption();
        Thread.sleep(1000);
       obj3.clickCheckbox();
        Thread.sleep(1000);
        obj3.approve();


        Time obj4 = new Time(driver,wait);
        obj4.timeOption();
        obj4.viewButton();
        obj4.approveTimeSheet();


     //driver.quit();
    }
}