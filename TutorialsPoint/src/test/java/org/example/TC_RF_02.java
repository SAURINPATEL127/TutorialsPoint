package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class TC_RF_02 {

    @Test
    public void testCase2() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Global wait of 5 Seconds
        driver.manage().window().maximize();
        driver.get("https://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("SAURIN");
        Thread.sleep(4000);
        driver.findElement(By.id("input-lastname")).sendKeys("Patel");
        driver.findElement(By.id("input-email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(generateRandomPhoneNumbers());
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox'][@name='agree'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

    }

    public String generateRandomEmail(){

        return new Date().toString().replaceAll("\\s","").replaceAll("\\:","").concat("@gmail.com");

    }

    public String generateRandomPhoneNumbers(){
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10)); // Append a random digit
        }
        return phoneNumber.toString();
    }

}
