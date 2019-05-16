package hw5_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Mantisbt_test {

    private WebDriver driver;
    private ChromeOptions options;

    @BeforeClass

    public void setUpClassTest() {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver");
        options = new ChromeOptions();
    }

    @BeforeMethod

    public void setUpTest() {
        driver = new ChromeDriver(options);
        //Open page
        driver.get("http://khda91.fvds.ru/mantisbt/");
        //Assert browser title
        assertTrue(driver.getTitle().equals("MantisBT"));

        //Enter login and password
        driver.findElement(By.id("username"))
                .sendKeys("administrator");
        driver.findElement(By.cssSelector(".btn-success")).click();

        driver.findElement(By.id("password"))
                .sendKeys("root");
        driver.findElement(By.cssSelector(".btn-success")).click();
    }

    @Test
    public void addProjectTest() {

        //Assert User name in the right-top side of screen that user is loggined
        assertEquals("administrator", driver.findElement(By.className("user-info")).getText());

        //Assert left side menu
        driver.findElement(By.id("sidebar"));

        //Click "Manage" button at left side menu
        driver.findElement(By.partialLinkText("Manage")).click();

        //Click "Manage Projects" button at center part menu
        driver.findElement(By.partialLinkText("Manage Projects")).click();

        //Check "Create New Project" button exist
        assertEquals("Create New Project",
                driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/form/fieldset/button"))
                        .getText());

        //Click 'Create New Project' button
        driver.findElement(By.xpath("//*[@id='main-container']/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/form/fieldset/button")).click();

        //Check "Add Project" fields name exist
        //Project Name
        assertEquals("* Project Name",
                driver.findElement(By.xpath("//*[@id='manage-project-create-form']/div/div[2]/div/div/table/tbody/tr[1]/td[1]"))
                        .getText());

        //Status
        assertEquals("Status",
                driver.findElement(By.xpath("//*[@id='manage-project-create-form']/div/div[2]/div/div/table/tbody/tr[2]/td[1]"))
                        .getText());

        //Inherit Global Categories
        assertEquals("Inherit Global Categories",
                driver.findElement(By.xpath("//*[@id='manage-project-create-form']/div/div[2]/div/div/table/tbody/tr[3]/td[1]"))
                        .getText());

        //View Status
        assertEquals("View Status",
                driver.findElement(By.xpath("//*[@id='manage-project-create-form']/div/div[2]/div/div/table/tbody/tr[4]/td[1]"))
                        .getText());

        //Description
        assertEquals("Description",
                driver.findElement(By.xpath("//*[@id='manage-project-create-form']/div/div[2]/div/div/table/tbody/tr[5]/td[1]"))
                        .getText());

        //Fill project information
        //Add Project Name
        driver.findElement(By.xpath("//*[@id='project-name']")).sendKeys("MegaProject");

        //Add Status
        WebElement selectElem = driver.findElement(By.xpath("//*[@id='project-status']"));
        Select select = new Select(selectElem);
        select.selectByValue("10");

        //Inherit Global Categories
        WebElement checkBox = driver.findElement(By.className("lbl"));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }

        //View Status
        WebElement selectViewElem = driver.findElement(By.xpath("//*[@id='project-view-state']"));
        Select select2 = new Select(selectViewElem);
        select2.selectByValue("10");

        //Description
        driver.findElement(By.id("project-description")).sendKeys("Important and serious work");

        //Click "Add project" button
        driver.findElement(By.xpath("//*[@id='manage-project-create-form']/div/div[3]/input"));
    }

    @Test
    public void addUserTest() {

        //Assert User name in the right-top side of screen that user is loggined
        assertEquals("administrator", driver.findElement(By.className("user-info")).getText());

        //Assert left side menu
        driver.findElement(By.id("sidebar"));

        //Click "Manage" button at left side menu
        driver.findElement(By.partialLinkText("Manage")).click();

        //Click "Manage Users" button at center part menu
        driver.findElement(By.partialLinkText("Manage Users")).click();

        //Check "Create New Account" button exist
        assertEquals("Create New Account",
                driver.findElement(By.xpath("//*[@id='manage-user-div']/div[1]/a"))
                        .getText());

        //Click 'Create New Account' button
        driver.findElement(By.xpath("//*[@id='manage-user-div']/div[1]/a")).click();

        //Check "Create New Account" fields name exist
        //Username
        assertEquals("Username",
                driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[1]/td[1]"))
                        .getText());

        //Real Name
        assertEquals("Real Name",
                driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[2]/td[1]"))
                        .getText());

        //E-mail
        assertEquals("E-mail",
                driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[3]/td[1]"))
                        .getText());

        //Password
        assertEquals("Password",
                driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[4]/td[1]"))
                        .getText());

        //Verify Password
        assertEquals("Verify Password",
                driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[5]/td[1]"))
                        .getText());

        //Access Level
        assertEquals("Access Level",
                driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[6]/td[1]"))
                        .getText());

        //Enabled
        assertEquals("Enabled",
                driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[7]/td[1]"))
                        .getText());

        //Protected
        assertEquals("Protected",
                driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[8]/td[1]"))
                        .getText());

        //Fill Create New Account
        //Add Username
        driver.findElement(By.xpath("//*[@id='user-username']")).sendKeys("Harley");

        //Add Real Name
        driver.findElement(By.xpath("//*[@id='user-realname']")).sendKeys("Davidson");

        //E-mail
        driver.findElement(By.xpath("//*[@id='email-field']")).sendKeys("Davidson@gmail.com");

        //Password
        driver.findElement(By.xpath("//*[@id='user-password']")).sendKeys("MotorBand");

        //Verify Password
        driver.findElement(By.xpath("//*[@id='user-verify-password']")).sendKeys("MotorBand");

        //Access Level
        WebElement selectElem = driver.findElement(By.id("user-access-level"));
        Select select = new Select(selectElem);
        select.selectByValue("25");

        //Enabled
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[7]/td[2]/label/span"));
        if (checkBox.isSelected()) {
            checkBox.click();
        }

        //Protected
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[2]/div/div/table/tbody/tr[8]/td[2]/label/span"));
        if (checkBox2.isSelected()) {
            checkBox2.click();
        }

        //Click 'Create User' button
        driver.findElement(By.xpath("//*[@id='manage-user-create-form']/div/div[3]/input")).click();

        //Logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();

        //User "Harley" is logged
        //Enter "Harley" login and password
        driver.findElement(By.id("username"))
                .sendKeys("Harley");
        driver.findElement(By.cssSelector(".btn-success")).click();

        driver.findElement(By.id("password"))
                .sendKeys("MotorBand");
        driver.findElement(By.cssSelector(".btn-success")).click();

        //Assert User name in the right-top side of screen that user is loggined
        assertEquals("Harley", driver.findElement(By.className("user-info")).getText());
    }

    @AfterMethod
    public void closeBrowser() {
        //Logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
        driver.close();
    }
}