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
public class ElementXpathTests {
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
        WebElement selectButtons = driver.findElement(By.xpath("//*[text()=\"Buttons\"]/parent::li"));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementID)));
        wait.until(ExpectedConditions.visibilityOf(selectButtons));
        selectButtons.click();
        WebElement clickMeButton = driver.findElement(By.xpath("//*[text()=\"Click Me\"]"));
        Assert.assertTrue(clickMeButton.isDisplayed());
        clickMeButton.click();

        WebElement txtDynamicCLick = driver.findElement(By.xpath("//*[@id=\"dynamicClickMessage\"]"));
        wait.until(ExpectedConditions.visibilityOf(txtDynamicCLick));
        Assert.assertTrue(txtDynamicCLick.isDisplayed());


    }

    @Test
    public void WebtablesTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        WebElement selectWebTables = driver.findElement(By.xpath("//*[text()=\"Web Tables\"]/parent::li"));
        wait.until(ExpectedConditions.visibilityOf(selectWebTables));
        selectWebTables.click();
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]"));
        Assert.assertTrue(addButton.isDisplayed());
        addButton.click();
        WebElement regisForm = driver.findElement(By.xpath("//*[@id=\"userForm\"]"));
        wait.until(ExpectedConditions.visibilityOf(regisForm));
        Assert.assertTrue(regisForm.isDisplayed());
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        Assert.assertTrue(firstNameInput.isDisplayed());
        firstNameInput.clear();
        firstNameInput.sendKeys("Gokce");
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Ozguven");
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        emailInput.clear();
        emailInput.sendKeys("gokce@gmail.com");
        WebElement ageInput = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        ageInput.clear();
        ageInput.sendKeys("30");
        WebElement salaryInput = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        salaryInput.clear();
        salaryInput.sendKeys("10000");
        WebElement departmentInput = driver.findElement(By.xpath("//*[@id=\"department\"]"));
        departmentInput.clear();
        departmentInput.sendKeys("Test");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submitButton.click();
        WebElement addedItem = driver.findElement(By.xpath("//*[text()=\"Gokce\"]"));
        Assert.assertTrue(addedItem.isDisplayed());
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]"));
        Assert.assertTrue(editButton.isDisplayed());
        editButton.click();
        WebElement firstNameInput2 = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstNameInput2.clear();
        firstNameInput2.sendKeys("Umut");
        WebElement submitButton2 = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submitButton2.click();
        WebElement updatedName = driver.findElement(By.xpath("//div[text()='Umut']"));
        wait.until(ExpectedConditions.visibilityOf(updatedName));
        Assert.assertTrue(updatedName.isDisplayed());
    }



    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
