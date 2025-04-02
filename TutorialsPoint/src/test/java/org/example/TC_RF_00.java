package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_00 {

@Test
    public void registerWithMandatoryFields() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Global wait of 5 Seconds
        driver.manage().window().maximize();
        driver.get("https://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("ABC");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("XYZ");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generateRandomEmail());
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("2899999999");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

    }

    public String generateRandomEmail(){

        return new Date().toString().replaceAll("\\s","").replaceAll("\\:","").concat("@gmail.com");

    }
}
