package com.untouchamp.mailsend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class PostboxPage {

    public WebDriver driver;
    public PostboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath ="//span[@class='compose-button__wrapper']")
    private WebElement newMessageBox;

    @FindBy(xpath ="//input[@class='container--H9L5q size_s_compressed--2c-eV']")
    private WebElement addressee;

    @FindBy(xpath ="//div[br]")
    private WebElement messageBody;

    @FindBy(xpath ="//span[text()='Отправить']")
    private WebElement sendButton;


    @FindBy(xpath ="//div[@class='ph-project ph-project__account svelte-a0l97g']")
    private WebElement accBox;

    @FindBy(xpath ="//div[text()='Выйти']")
    private WebElement exitBox;


    public void newMessage(){
        newMessageBox.click();
    }

    public void chooseAddressee(String addresseeLogin){
        addressee.sendKeys(addresseeLogin);
    }

    public void messageBodyClick(){
        messageBody.click();
    }

    public void messageText(String text){
        messageBody.sendKeys(text);
    }

    public void send(){
        sendButton.click();
    }

    public void accBoxClick(){
        accBox.click();
    }

    public void exitBoxClick()
    {
        exitBox.click();
    }
}
