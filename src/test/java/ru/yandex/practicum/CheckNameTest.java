package ru.yandex.practicum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static io.qameta.allure.Allure.step;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameTest {

    private final String checkName;
    private final boolean expected;

    public CheckNameTest(String checkName, boolean expected) {
        this.checkName = checkName;
        this.expected = expected;
    }

    // Параметризация
    @Parameterized.Parameters
    public static Object[][] genData() {
        return new Object[][]{
                // Пробелы
                {" ", false},                   // Только пробел
                {" Морти", false},              // Пробел в начале строки
                {"Морти ", false},              // Пробел в конце строки
                {"Морти", false},               // Нет пробела
                {"Морти Проверкин", true},      // Один пробел в центре
                {"Морти  Проверкин", false},    // Два пробела слитно
                {"1 Морти Проверкин", false},    // Два пробела раздельно
                // Символы
                {"", false},                    // 0 символов
                {"12", false},                  // 2 символа
                {"1 2", true},                  // 3 символа
                {"Морти Проверкин1234", true},  // 19 символов
                {"Морти Проверкин12345", false},// 20 символов
        };
    }

    @Test
    @DisplayName("Проверка имени")
    @Description("Тест проверяет различные варианты имени")
    public void checkNameToEmbossTest() {
        Account account = new Account(checkName);
        step("Вызываем для проверки метод checkNameToEmboss");
        boolean actual = account.checkNameToEmboss();
        step("Сравниваем ОР и ФР вызова метода checkNameToEmboss");
        assertEquals(expected, actual);
    }
}

