package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_03 {

    @Test
    public void verifyValidations() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        String expectedWarningText = "Warning: You must agree to the Privacy Policy!";
        String expectedWarningForFirstName = "First Name must be between 1 and 32 characters!";
        String expectedWarningForLastName = "Last Name must be between 1 and 32 characters!";
        String expectedWarningForEmail = "E-Mail Address does not appear to be valid!";
        String expectedWarningForTelephone = "Telephone must be between 3 and 32 characters!";
        String expectedWarningForPassword= "Password must be between 4 and 20 characters!";




        driver.manage().window().maximize();
        driver.get("https://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),expectedWarningText);
        //First Name must be between 1 and 32 characters!
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div[@class='text-danger']")).getText(),expectedWarningForFirstName);
        //Last Name must be between 1 and 32 characters!
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div[@class='text-danger']")).getText(),expectedWarningForLastName);
        //E-Mail Address does not appear to be valid!
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='email']/following-sibling::div[@class='text-danger']")).getText(),expectedWarningForEmail);
        //Telephone must be between 3 and 32 characters!
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div[@class='text-danger']")).getText(),expectedWarningForTelephone);
        //Password must be between 4 and 20 characters!
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password']/following-sibling::div[@class='text-danger']")).getText(),expectedWarningForPassword);

    }


}
