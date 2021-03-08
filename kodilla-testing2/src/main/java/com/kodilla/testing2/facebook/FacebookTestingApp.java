package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_ACCEPTCOOKIES = "//div[contains(@class, \"_9o-r\")]/button[2]";
    public static final String XPATH_CREATEACCOUNT = "//div[contains(@class, \"_6ltg\")]/a[1]";

    // temoporarily on hold :
    // public static final String XPATH_WAIT_FOR = "//div[contains(@class, \"_3ixn\")]";

    public static final String NAME_BIRTHDAY = "birthday_day";
    public static final String NAME_BIRTHMONTH = "birthday_month";
    public static final String NAME_BIRTHYEAR = "birthday_year";


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement acceptCookies = driver.findElement(By.xpath(XPATH_ACCEPTCOOKIES));
        acceptCookies.click();

        WebElement createAccount = driver.findElement(By.xpath(XPATH_CREATEACCOUNT));
        createAccount.click();

        // temoporarily on hold :
        // while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed()) ;

        Thread.sleep(500);

        WebElement birthDay = driver.findElement(By.name(NAME_BIRTHDAY));
        Select selectBirthDay = new Select(birthDay);
        selectBirthDay.selectByValue("30");

        WebElement birthMonth = driver.findElement(By.name(NAME_BIRTHMONTH));
        Select selectBirthMonth = new Select(birthMonth);
        selectBirthMonth.selectByValue("12");

        WebElement birthYear = driver.findElement(By.name(NAME_BIRTHYEAR));
        Select selectBirthYear = new Select(birthYear);
        selectBirthYear.selectByValue("1938");

    }

}
