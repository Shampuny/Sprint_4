package ru.yandex.praktikum.pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class RentalPeriodPage {
    WebDriver driver;
    public RentalPeriodPage(WebDriver driver){
        this.driver = driver;
    }

    private final By orderConfirmationButton = By.xpath(".//div[starts-with(@class,'Order_Buttons')]/button[text()='Заказать']");
    private final By yesConfirmationButton = By.xpath(".//div[starts-with(@class,'Order_Buttons')]/button[text()='Да']");
    private final By confirmationWindow = By.xpath(".//div[starts-with(@class,'Order_ModalHeader')]");
    private final static String successfulOrder = "Заказ оформлен";

    public RentalPeriodPage selectDeliveryDate(){
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).sendKeys("21.06.2023");
        driver.findElement(By.xpath(".//div[text()='21']")).click();
        return this;
    }
    public RentalPeriodPage selectRentalPeriod(){
        driver.findElement(By.xpath(".//div[@class='Dropdown-root']")).click();
        driver.findElement(By.xpath(".//div[(@class='Dropdown-option' and text()='сутки')]")).click();
        return this;
    }
    public RentalPeriodPage selectScooterColor(){
        driver.findElement(By.xpath(".//label[@for='black']")).click();
        return this;
    }
    public RentalPeriodPage writeComment(){
        driver.findElement(By.xpath(".//input[@placeholder='Комментарий для курьера']")).sendKeys("Здарова, бро");
        return this;
    }
    public RentalPeriodPage clickOnOrderConfirmationButton(){
        driver.findElement(orderConfirmationButton).click();
        return this;
    }
    public RentalPeriodPage clickOnYesConfirmationButton(){
        driver.findElement(yesConfirmationButton).click();
        return this;
    }

    public void checkIsDisplayedConfirmationWindow(){
        var isDisplayedConfirm = driver.findElement(confirmationWindow).getText();
        MatcherAssert.assertThat(isDisplayedConfirm, containsString(successfulOrder));
    }

    public void successfulOrderCreation(){
        selectDeliveryDate()
                .selectRentalPeriod()
                .selectScooterColor()
                .writeComment()
                .clickOnOrderConfirmationButton()
                .clickOnYesConfirmationButton()
                .checkIsDisplayedConfirmationWindow();
    }

}
