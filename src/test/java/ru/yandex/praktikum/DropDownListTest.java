package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.pageobject.MainPage;

@RunWith(Parameterized.class)
public class DropDownListTest extends BaseTest {
    private final String dropDownElement;
    private final String dropDownText;
    public DropDownListTest(String dropDownElement, String dropDownText){
        this.dropDownElement = dropDownElement;
        this.dropDownText = dropDownText;
    }

    @Parameterized.Parameters
    public static Object[][] dropDownData(){
        return new Object[][]{
                {"[1]","[1]"},
                {"[2]","[2]"},
                {"[3]","[3]"},
                {"[4]","[4]"},
                {"[5]","[5]"},
                {"[6]","[6]"},
                {"[7]","[7]"},
        };
    }
    @Test
    public void checkDropDownList() {
        new MainPage(driver)
                .clickOnDropDownButton(dropDownElement)
                .checkIsDisplayedDropDownText(dropDownText);
    }
}
