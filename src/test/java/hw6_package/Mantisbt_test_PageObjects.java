package hw6_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
// TODO А где PageObjects?
public class Mantisbt_test_PageObjects extends hw6_package.BaseTest {

    @Test
    public void addProjectTest() {

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
    public void setFiltersTest() {

        //Click "View Issues" at left menu
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();

        //Set filer values
        driver.findElement(By.id("show_priority_filter")).click();
        driver.findElement(By.id("show_severity_filter")).click();
        driver.findElement(By.id("show_status_filter")).click();
        driver.findElement(By.id("do_filter_by_date_filter")).click();

        //Set Priority "high"
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//*[@id='show_priority_filter_target']/select"))).click();
        Action mouseOverAndClick = builder.build();
        mouseOverAndClick.perform();

        //Set Severity "tweak"
        WebElement selectSeverityElem = driver.findElement(By.name("severity[]"));
        Select select2 = new Select(selectSeverityElem);
        select2.selectByValue("40");

        //Set Status "assigned"
        WebElement selectStatusElem = driver.findElement(By.name("status[]"));
        Select select3 = new Select(selectStatusElem);
        select3.selectByValue("50");

        //Set Date
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[1]/td/label/span"));
        if (checkBox.isSelected()) {
            checkBox.click();
        }

        WebElement selectStartYear = driver.findElement(By.name("start_year"));
        Select select4= new Select(selectStartYear);
        select4.selectByValue("2019");

        WebElement selectStartMonth = driver.findElement(By.name("start_month"));
        Select select5= new Select(selectStartMonth);
        select5.selectByValue("3");

        WebElement selectStartDay = driver.findElement(By.name("start_day"));
        Select select6= new Select(selectStartDay);
        select6.selectByValue("27");

        WebElement selectEndYear = driver.findElement(By.name("end_year"));
        Select select7= new Select(selectEndYear);
        select7.selectByValue("2019");

        WebElement selectEndMonth = driver.findElement(By.name("end_month"));
        Select select8= new Select(selectEndMonth);
        select8.selectByValue("4");

        WebElement selectEndDay = driver.findElement(By.name("end_day"));
        Select select9= new Select(selectEndDay);
        select9.selectByValue("1");

        //Click Apply Filter
        driver.findElement(By.xpath("//*[@id='filters_form_open']/div[2]/div/div/input[2]")).click();

        //Check results

    }
}