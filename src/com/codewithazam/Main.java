package com.codewithazam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

    private static Logger log = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.debug("Setting chrome driver property.");

        System.setProperty("webdriver.chrome.driver","//Users//codewithazam//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        log.info("Window Maximized.");
        log.debug("Now hitting Ebay server.");

        driver.get("https://www.ebay.com/");
        log.info("Landed on Ebay home page.");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("i#gh-Alerts-i"))).build().perform();
        log.info("Trying to sign in.");
        log.debug("Now hitting sign in tab.");

        a.moveToElement(driver.findElement(By.xpath("//*[@id='ghn-err']/span/a/span"))).click().build().perform();

        log.info("Entering the login tab.");
        driver.findElement(By.id("userid")).sendKeys("hello");

        driver.findElement(By.name("signin-continue-btn")).click();
        log.debug("Entered the login and clicked continue for further action.");

        log.error("Error message.");
        System.out.println(driver.findElement(By.xpath("//p[@id='signin-error-msg']")).getText());


    }
}
