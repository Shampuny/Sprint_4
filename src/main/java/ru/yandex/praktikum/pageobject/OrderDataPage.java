package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDataPage {
    WebDriver driver;
    public OrderDataPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nextPageButton = By.xpath(".//button[text()='Далее']");
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//div[@class='select-search']");
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    public OrderDataPage writeName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    public OrderDataPage writeSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }
    public OrderDataPage writeAddress(String address){
        driver.findElement(addressField).sendKeys(address);
        return this;
    }
    public OrderDataPage selectMetro(String metroValue){
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//ul[@class='select-search__options']/li//div[text()='" + metroValue + "']/parent::button")).click();
        return this;
    }
    public OrderDataPage writePhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }
    public void clickNextPageButton(){
        driver.findElement(nextPageButton).click();
    }

    public void enterOrderData(String name, String surname, String address, String metroValue, String phoneNumber){
        writeName(name)
                .writeSurname(surname)
                .writeAddress(address)
                .selectMetro(metroValue)
                .writePhoneNumber(phoneNumber)
                .clickNextPageButton();
    }


}