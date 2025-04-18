package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;
/*
        This test case automates the registration form of Tutorialsninja website.
        Generates Random Name, Phonenumber.
        Used asserts to verify users are redirected to the appropriate web-pages.
 */
public class TC_RF_02 {

    WebDriver driver = new ChromeDriver();

    @Test
    public void testCase2() throws InterruptedException
    {
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
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

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

    public  String generateRandomName() {
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

    public String generateRandomPassswords(){
        // Define the characters allowed in the password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?";

        // Generate a random password length between 4 and 20 characters
        int length = 4 + new Random().nextInt(17); // 17 is the range (20 - 4 + 1)

        // Create a StringBuilder to store the password
        StringBuilder password = new StringBuilder();

        // Generate the password by selecting random characters
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public void cleanUp(){
        driver.quit();
    }
}
