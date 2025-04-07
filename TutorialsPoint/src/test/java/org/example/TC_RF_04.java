package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

/*
        This testcase verifies newsletter selection Yes/No on Newsletter Page once registration is completed.
 */
public class TC_RF_04{

    WebDriver driver = new ChromeDriver();

    @Test
    public void verifyNewsLetterSelection() throws InterruptedException{

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Global wait of 5 Seconds
        driver.manage().window().maximize();
        driver.get("https://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys(generateRandomName());
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
        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='radio'][@value='0'][@checked='checked']")).isSelected());
        System.out.print("No newsletter has been selected");

        cleanUp();
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

    public static String generateRandomName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomName = new StringBuilder();
        int nameLength = random.nextInt(5) + 5; // Random name length between 5 and 10 characters

        for (int i = 0; i < nameLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomName.append(characters.charAt(randomIndex));
        }

        return randomName.toString();
    }

    public void cleanUp(){
        driver.quit();
    }
}
