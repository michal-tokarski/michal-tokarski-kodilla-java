package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://michal-tokarski.github.io";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public  void  cleanUpAfterTest() {
        driver.close();
    }


    public String createCrudAppTestTask() throws InterruptedException {

        // XPath-Absolute :
        // final String XPATH_TASK_NAME = "/html/body/main/section[1]/form/fieldset[1]/input";
        // XPath-Relative :
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;

    }


    private void sendTestTaskToTrello(String taskName) throws InterruptedException {

        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });

        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(5000);

    }


    private boolean checkIfTaskExistsInTrello(String taskName) throws InterruptedException {

        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        String myLogin = "michal_tokarski@wp.pl";
        String myPassword = "Chicamauga_18*63";

        driverTrello.findElement(By.id("user")).sendKeys(myLogin);
        driverTrello.findElement(By.id("password")).sendKeys(myPassword);
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();

        Thread.sleep(4000);

        driverTrello.findElement(By.id("password")).sendKeys(myPassword);
        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(4000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);

        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driverTrello.close();

        return result;

    }

    private void removeTestTaskfromCrudApp (String taskName) throws InterruptedException {

        driver.navigate().refresh();

        while (!driver.findElement(By.xpath(("//select[1]"))).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement deleteButton = theForm.findElement(By.xpath(".//fieldset[contains(@class, \"row-section--button-section\")]/button[4]"));
                    deleteButton.click();
                });

        Thread.sleep(2000);

    }


    private boolean checkIfTaskExistsInCrudApp(String taskName) throws InterruptedException {

        final String CRUDAPP_URL = BASE_URL;
        boolean result = false;
        WebDriver driverCrudApp = driver;
        driverCrudApp.get(CRUDAPP_URL);

        // driverCrudApp.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]")).click();
        driverCrudApp.findElement(By.xpath(".//button[contains(@href, \"/login\")]")).click();

        String myLogin = "michal_tokarski@wp.pl";
        String myPassword = "Chicamauga_18*63";

        driverCrudApp.findElement(By.id("login_field")).sendKeys(myLogin);
        driverCrudApp.findElement(By.id("password")).sendKeys(myPassword);
        WebElement el = driverCrudApp.findElement(By.name("commit"));
        el.submit();

        Thread.sleep(4000);

        result = driverCrudApp.findElements(By.name("label")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driverCrudApp.close();

        return result;

    }


    @Test
    public void test_shouldCreateTrelloCard() throws InterruptedException {

        // Check if the task is created in CrudApp, sent to Trello and exists in Trello :
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkIfTaskExistsInCrudApp(taskName));
        assertTrue(checkIfTaskExistsInTrello(taskName));

        // Check if the task is removed from CrudApp, but still exists in Trello :
        removeTestTaskfromCrudApp(taskName);
        assertFalse(checkIfTaskExistsInCrudApp(taskName));
        assertTrue(checkIfTaskExistsInTrello(taskName));
    }


}
