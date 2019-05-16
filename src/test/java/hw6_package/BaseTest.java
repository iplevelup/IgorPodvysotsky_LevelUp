package hw6_package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseTest {


    protected WebDriver driver;
    private ChromeOptions options;

    @BeforeSuite(alwaysRun = true)

    protected void setUpSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass(alwaysRun = true)

    public void setUpClassTest() {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver");
        options = new ChromeOptions();
    }

    @BeforeMethod(alwaysRun = true)

    public void setUpTest() {
        // TODO Для каких целей здесь второй раз создаётся драйвера?
        driver = new ChromeDriver(options);

        //Open page
        driver.get("http://khda91.fvds.ru/mantisbt/");

        //Assert browser title
        assertTrue(driver.getTitle().equals("MantisBT"));

        //Login
        new LoginPage(driver).login("administrator","root");

        //Assert User name in the right-top side of screen that user is loggined
        assertEquals("administrator", driver.findElement(By.className("user-info")).getText());

        //Assert left side menu
        driver.findElement(By.id("sidebar"));

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        //Logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
        driver.close();
    }


}
