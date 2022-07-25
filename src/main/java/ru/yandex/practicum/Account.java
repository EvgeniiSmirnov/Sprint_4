package ru.yandex.practicum;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name == null) {
            System.out.println("Имя не задано");
            return false;
        } else if (name.isEmpty()) {
            System.out.println("Имя не задано");
            return false;
        } else if (name.length() < 3 || name.length() > 19) {
            System.out.println("Имя должно содержать от 3 до 19 символов");
            return false;
        } else if (name.length() - name.replace(" ", "").length() != 1) {
            System.out.println("В имени нет пробела или более одного пробела");
            return false;
        } else if (name.startsWith(" ") || name.endsWith(" ")) {
            System.out.println("Имя не должно начинаться или заканчиваться пробелом");
            return false;
        }
        return true;
    }
}