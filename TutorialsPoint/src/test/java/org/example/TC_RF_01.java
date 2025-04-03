package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_01 {

    @Test
    public void automateGmail(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Global wait of 5 Seconds
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
        driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys(""); //Hard-coded email fornow

    }



}
