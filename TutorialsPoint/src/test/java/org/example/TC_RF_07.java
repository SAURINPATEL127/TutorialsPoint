package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.*;
import java.nio.file.Files;
import java.time.Duration;

public class TC_RF_07 {

    /*
            This testcase takes Screenshot for the validation errors that cannot be verified thru DOM
     */

    WebDriver driver = new ChromeDriver();

    @Test
    public void testCase2() throws InterruptedException, IOException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Global wait of 5 Seconds
        driver.manage().window().maximize();
        driver.get("https://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("abc");
        Thread.sleep(4000);
        driver.findElement(By.id("input-lastname")).sendKeys("Par");
        driver.findElement(By.id("input-email")).sendKeys("motoori");
        driver.findElement(By.id("input-telephone")).sendKeys("1223455");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox'][@name='agree'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        takeScreenshot();

         }

    @AfterClass
    public void takeScreenshot() throws IOException {
           File screenshot = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
        String screenshotDir = System.getProperty("user.dir") + "/src/Screenshots";
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs(); // Safely creates nested directories
        }

        File destFile = new File(dir, "screenshot.png");
        FileUtils.copyFile(screenshot, destFile);
    }
    }
