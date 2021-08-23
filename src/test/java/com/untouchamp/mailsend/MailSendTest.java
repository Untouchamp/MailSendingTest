package com.untouchamp.mailsend;

import org.checkerframework.checker.units.qual.C;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MailSendTest {

    public static LoginPage loginPage;
    public static PostboxPage postboxPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("mailrupage"));
        loginPage = new LoginPage(driver);
        postboxPage = new PostboxPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.clickLog();
        //try to enter our login from conf file
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //then password
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        //click on new message button
        postboxPage.newMessage();
        //choose the adressee and past his login
        postboxPage.chooseAddressee(ConfProperties.getProperty("addresseelogin"));
        //click on message body
        postboxPage.messageBodyClick();
        // Now it's time to write smth in the mail body!
        postboxPage.messageText(ConfProperties.getProperty("text"));
        // Push the send button
        postboxPage.send();
    }

    @AfterClass
    public static void closeDown() {
        postboxPage.accBoxClick();
        postboxPage.exitBoxClick();
        if (postboxPage.driver != null) {
            postboxPage.driver.quit();
        }
    }
}