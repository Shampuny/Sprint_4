package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.pageobject.MainPage;
import ru.yandex.praktikum.pageobject.OrderDataPage;
import ru.yandex.praktikum.pageobject.RentalPeriodPage;

@RunWith(Parameterized.class)
public class OrderCaseTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroValue;
    private final String phoneNumber;
    public OrderCaseTest(String name, String surname, String address, String metroValue, String phoneNumber){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroValue = metroValue;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] orderData(){
        return new Object[][]{
                {"Артём","Серёгин","ул.Пушкина, дом Колотушкина", "Бульвар Рокоссовского","+79909909090"},
                {"Василий","Зайкин","ул. Ватрушкина, дом Облицушкина", "Балтийская","89909809898"},
        };
    }
    @Test
    public void createOrder(){
        new MainPage(driver)
                .clickOnOrderButton();
        new OrderDataPage(driver)
                .enteringOrderData(name, surname, address, metroValue, phoneNumber);
        new RentalPeriodPage(driver)
                .successfulOrderCreation();

    }
}