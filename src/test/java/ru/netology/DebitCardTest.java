package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DebitCardTest {
    @BeforeEach
    public void openForm() {
        open("http://localhost:9999/");
    }

    @Test
    void shouldValid() {
        $("[data-test-id=name] input").setValue("Вася Пупкин");
        $("[data-test-id=phone] input").setValue("+79162139988");
        $("[data-test-id=agreement]").click();//чек бокс
        $("[type=button]").click();           //Кнопка
        $("[data-test-id=order-success]").shouldHave(exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}