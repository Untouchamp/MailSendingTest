package com.untouchamp.mailsend;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    @FindBy(xpath ="//div//input[@class='email-input svelte-1eyrl7y']")

    @FindBy(xpath ="//input[@name='login']")
    private WebElement loginBox;


    @FindBy(xpath ="//input[@name='password']")
    private WebElement passBox;

    public void clickLog(){
        loginBox.click();
    }

    public void inputLogin(String login) {
        loginBox.sendKeys(login, Keys.ENTER);
    }

    public void inputPassword(String password) {
        passBox.sendKeys(password, Keys.ENTER);
    }



}
