package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_05 {
    /*
         This testcase verifies entered incorrect password in the confirm password field shoot
         proper validation message or not
         In the testcase used different functionalitites from other class.
  */
    TC_RF_02 testCase2Objects = new TC_RF_02();
    WebDriver driver = new ChromeDriver();

    @Test
    public void verifyRegisterAccountByMismatchingPasswordfield(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        implicitWaitFor4Seconds();
        driver.manage().deleteAllCookies();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.linkText("Register")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Register Account']")).isDisplayed());
        driver.findElement(By.id("input-firstname")).sendKeys(testCase2Objects.generateRandomName());
        driver.findElement(By.id("input-lastname")).sendKeys(testCase2Objects.generateRandomName());
        driver.findElement(By.id("input-email")).sendKeys(testCase2Objects.generateRandomEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(testCase2Objects.generateRandomPhoneNumbers());
        driver.findElement(By.id("input-password")).sendKeys(testCase2Objects.generateRandomPassswords());
        driver.findElement(By.id("input-password")).sendKeys(testCase2Objects.generateRandomPassswords());
        driver.findElement(By.id("input-confirm")).sendKeys(testCase2Objects.generateRandomPassswords());
        implicitWaitFor4Seconds();
        driver.findElement(By.xpath("//input[@value='Continue']")).submit();
        Assert.assertTrue(driver.findElement(By.className("text-danger")).isDisplayed());


    }

    public void implicitWaitFor4Seconds(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }
}
