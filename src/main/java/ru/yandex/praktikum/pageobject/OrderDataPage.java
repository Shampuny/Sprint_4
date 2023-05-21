package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.Config.AppConfig.URL_APP;

public class OrderDataPage {
    WebDriver driver;

    public OrderDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeName(){
        driver.findElement(By.xpath(".//input[@placeholder='* Имя']")).sendKeys("Артём");
    }

    public void writeSurname(){
        driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).sendKeys("Серёгин");
    }

    public void writeAddress(){
        driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys("ул. Пушкина. Дом Колотушкина");
    }
    public void selectMetro(){
        driver.findElement(By.xpath(".//div[@class='select-search']")).click();
        driver.findElement(By.xpath(".//ul[@class='select-search__options']/li[@data-index='3']")).click();
    }
    public void writePhoneNumber(){
        driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys("+79999999898");
    }

    public void orderPositiveCase(){
        writeName();
        writeSurname();
        writeAddress();
        selectMetro();
        writePhoneNumber();
    }


}