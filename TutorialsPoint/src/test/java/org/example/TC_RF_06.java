package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_06 {

    TC_RF_02 testCase2Object = new TC_RF_02();
    WebDriver driver = new ChromeDriver();

    @Test
    public void verifyRegisteredEmailIdError(){

        String expectedTextWarningMessageForRegisterdEmail = "Warning: E-Mail Address is already registered!";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Global wait of 5 Seconds
        driver.manage().window().maximize();
        driver.get("https://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys(testCase2Object.generateRandomName());
        driver.findElement(By.id("input-lastname")).sendKeys("Patel");
        driver.findElement(By.id("input-email")).sendKeys("amotooricap1@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys(testCase2Object.generateRandomPhoneNumbers());
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox'][@name='agree'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains(expectedTextWarningMessageForRegisterdEmail));

    }
}

