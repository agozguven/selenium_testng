package tests;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyManager;

import java.net.MalformedURLException;
import java.time.Duration;

public class ElementsTests {
    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL");



    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test
    public void ButtonsTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        WebElement selectButtons = driver.findElement(By.cssSelector("div.show ul li#item-4"));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementID)));
        wait.until(ExpectedConditions.visibilityOf(selectButtons));
        selectButtons.click();
        WebElement clickMeButton = driver.findElement(By.cssSelector("div:nth-child(2) > div:nth-child(4) > button"));
        Assert.assertTrue(clickMeButton.isDisplayed());
        clickMeButton.click();

        WebElement txtDynamicCLick = driver.findElement(By.id("dynamicClickMessage"));
        wait.until(ExpectedConditions.visibilityOf(txtDynamicCLick));
        Assert.assertTrue(txtDynamicCLick.isDisplayed());


    }

    @Test
    public void WebtablesTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        WebElement selectWebTables = driver.findElement(By.cssSelector("div.show ul li#item-3"));
        wait.until(ExpectedConditions.visibilityOf(selectWebTables));
        selectWebTables.click();
        WebElement addButton = driver.findElement(By.cssSelector("button#addNewRecordButton"));
        Assert.assertTrue(addButton.isDisplayed());
        addButton.click();
        WebElement regisForm = driver.findElement(By.cssSelector("form#userForm"));
        Assert.assertTrue(regisForm.isDisplayed());
        WebElement firstNameInput = driver.findElement(By.cssSelector("input#firstName"));
        Assert.assertTrue(firstNameInput.isDisplayed());
        firstNameInput.clear();
        firstNameInput.sendKeys("Gokce");
        WebElement lastNameInput = driver.findElement(By.cssSelector("input#lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Ozguven");
        WebElement emailInput = driver.findElement(By.cssSelector("input#userEmail"));
        emailInput.clear();
        emailInput.sendKeys("gokce@gmail.com");
        WebElement ageInput = driver.findElement(By.cssSelector("input#age"));
        ageInput.clear();
        ageInput.sendKeys("30");
        WebElement salaryInput = driver.findElement(By.cssSelector("input#salary"));
        salaryInput.clear();
        salaryInput.sendKeys("10000");
        WebElement departmentInput = driver.findElement(By.cssSelector("input#department"));
        departmentInput.clear();
        departmentInput.sendKeys("Test");
        WebElement submitButton = driver.findElement(By.cssSelector("button#submit"));
        submitButton.click();
        WebElement addedItem = driver.findElement(By.cssSelector("div.rt-tbody > div:nth-child(4)"));
        Assert.assertTrue(addedItem.isDisplayed());
        WebElement editButton = driver.findElement(By.cssSelector("span#edit-record-4"));
        Assert.assertTrue(editButton.isDisplayed());
        editButton.click();
        Assert.assertTrue(regisForm.isDisplayed());
        firstNameInput.clear();
        firstNameInput.sendKeys("Umut");
        submitButton.click();
        //Hocam updatedName elementini ancak xpath ile alabildim:( css Selector ile text almayı başaramadım. contains çalışmıyor
        WebElement updatedName = driver.findElement(By.xpath("//div[text()='umut'']"));
        Assert.assertTrue(updatedName.isDisplayed());
    }



    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
