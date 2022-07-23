package ru.yandex.practicum;

public class Practicum {
    static String cardName;

    public Practicum(String cardName) {
        Practicum.cardName = cardName;
    }

    public static void main(String[] args) {
        Account account = new Account(cardName);
        account.checkNameToEmboss();
    }

}