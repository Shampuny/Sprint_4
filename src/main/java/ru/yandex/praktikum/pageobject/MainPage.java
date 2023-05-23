package ru.yandex.praktikum.pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;



import static ru.yandex.praktikum.Config.AppConfig.URL_APP;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
        driver.get(URL_APP);
    }

    private final By orderButton = By.xpath(".//div[starts-with(@class,'Header_Nav')]/button[text() = 'Заказать']");

    public MainPage clickOnDropDownButton(String dropDownElement){
        WebElement element = driver.findElement(By.xpath(".//div[@class='accordion__item']" + dropDownElement + "//div[@role='button']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }
    public void checkDropDownText(String dropDownFieldWithText, String expectedText){
        var dropDownText = driver.findElement(By.xpath(".//div[@class='accordion__item']" + dropDownFieldWithText + "//div[@class='accordion__panel']"));
        assertTrue(dropDownText.isDisplayed());
        MatcherAssert.assertThat(dropDownText.getText(), containsString(expectedText));
    }
    public void clickOnOrderButton(){
        driver.findElement(orderButton).click();
    }
}