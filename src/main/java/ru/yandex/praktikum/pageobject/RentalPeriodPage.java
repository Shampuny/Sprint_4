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
    private final By DeliveryInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By DeliveryDate = By.xpath(".//div[text()='21']");
    private final By rentalPeriodDropDownField = By.xpath(".//div[@class='Dropdown-root']");
    private final By rentalPeriodDropdownSelectField = By.xpath(".//div[(@class='Dropdown-option' and text()='сутки')]");
    private final By scooterColorCheckBox = By.xpath(".//label[@for='black']");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    public RentalPeriodPage selectDeliveryDate(){
        driver.findElement(DeliveryInput).sendKeys("21.06.2023");
        driver.findElement(DeliveryDate).click();
        return this;
    }
    public RentalPeriodPage selectRentalPeriod(){
        driver.findElement(rentalPeriodDropDownField).click();
        driver.findElement(rentalPeriodDropdownSelectField).click();
        return this;
    }
    public RentalPeriodPage selectScooterColor(){
        driver.findElement(scooterColorCheckBox).click();
        return this;
    }
    public RentalPeriodPage writeComment(){
        driver.findElement(commentField).sendKeys("Здарова, бро");
        return this;
    }
    public RentalPeriodPage clickOnOrderConfirmationButton(){
        driver.findElement(orderConfirmationButton).click();
        return this;
    }
    public void clickOnYesConfirmationButton(){
        driver.findElement(yesConfirmationButton).click();
    }

    public void checkIsDisplayedConfirmationWindow(){
        var isDisplayedConfirm = driver.findElement(confirmationWindow).getText();
        MatcherAssert.assertThat(isDisplayedConfirm, containsString(successfulOrder));
    }

    public RentalPeriodPage successfulOrderCreate(){
        selectDeliveryDate()
                .selectRentalPeriod()
                .selectScooterColor()
                .writeComment()
                .clickOnOrderConfirmationButton()
                .clickOnYesConfirmationButton();
        return this;
    }

}
