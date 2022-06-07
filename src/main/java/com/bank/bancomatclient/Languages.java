package com.bank.bancomatclient;

public class Languages {
    // LT
    private final static String INSERT_CREDIT_CARD_LT="Įdėkite kredito kortelę";
    private final static String ENTER_PIN_LT="Įveskite PIN kodą";
    private final static String YOUR_ACCOUNT_HAVE_LT="Jūsų banko sąskaitoje";
    private final static String TAKE_CARD_LT="Paimkite savo kredito kortelę";
    private final static String TAKE_CARD_BAD_LT="Bloga kredito kortelė";
    private final static String ENTER_VALUE_LT="Įveskite vertę";
    private final static String CHECH_ACCOUNT_LT="Patikrinti sąskaitą";
    private final static String TAKE_MONEY_LT="Paimk pinigus";
    private final static String NO_CECQUE_LT="Nespauzdinti čekio";
    private final static String PRINT_CECQUE_LT="Spauzdinti čekį";
    private final static String BAD_PIN_LT="Neteisingas PIN kodas";
    private final static String NO_MONEY_ON_ACCOUNT_LT="Neužtenka lėšų jūsų sąskaitoje";

    // EN
    private final static String INSERT_CREDIT_CARD_EN="Insert credit card";
    private final static String ENTER_PIN_EN="Enter pin";
    private final static String YOUR_ACCOUNT_HAVE_EN="On your account";
    private final static String TAKE_CARD_EN="Take your credit card";
    private final static String TAKE_CARD_BAD_EN="Bad credit card";
    private final static String ENTER_VALUE_EN="Enter value";
    private final static String CHECK_ACCOUNT_EN="Check account";
    private final static String TAKE_MONEY_EN="Take money";
    private final static String BAD_PIN_EN="Wrong PIN";
    private final static String NO_CECQUE_EN="No check required";
    private final static String PRINT_CECQUE_EN="Printed checks";
    private final static String NO_MONEY_ON_ACCOUNT_EN="There are not enough funds in your account";

    // RU
    private final static String INSERT_CREDIT_CARD_RU="Вставьте кредитную карту";
    private final static String ENTER_PIN_RU="Введите пин-код";
    private final static String YOUR_ACCOUNT_HAVE_RU="На ваш банковский счет";
    private final static String TAKE_CARD_RU="Возьми свою кредитную карту";
    private final static String TAKE_CARD_BAD_RU="Плохая кредитная карта";
    private final static String ENTER_VALUE_RU="Введите значение";
    private final static String CHECK_ACCOUNT_RU="Проверить счет";
    private final static String TAKE_MONEY_RU="Возьми деньги";
    private final static String BAD_PIN_RU="Неверный пин-код";
    private final static String NO_CECQUE_RU="Не распечатывать чек";
    private final static String PRINT_CECQUE_RU="Печатные чеки";
    private final static String NO_MONEY_ON_ACCOUNT_RU="На вашем счете недостаточно средств";

    public static String getINSERT_CREDIT_CARD(String language){
        return switch (language) {
            case "LT" -> INSERT_CREDIT_CARD_LT;
            case "EN" -> INSERT_CREDIT_CARD_EN;
            case "RU" -> INSERT_CREDIT_CARD_RU;
            default -> INSERT_CREDIT_CARD_EN;
        };
    }

    public static String getENTER_PIN(String language){
        return switch (language) {
            case "LT" -> ENTER_PIN_LT;
            case "EN" -> ENTER_PIN_EN;
            case "RU" -> ENTER_PIN_RU;
            default -> ENTER_PIN_EN;
        };
    }

    public static String getYOUR_ACCOUNT_HAVE(String language){
        return switch (language) {
            case "LT" -> YOUR_ACCOUNT_HAVE_LT;
            case "EN" -> YOUR_ACCOUNT_HAVE_EN;
            case "RU" -> YOUR_ACCOUNT_HAVE_RU;
            default -> YOUR_ACCOUNT_HAVE_EN;
        };
    }

    public static String getTAKE_CARD(String language){
        return switch (language) {
            case "LT" -> TAKE_CARD_LT;
            case "EN" -> TAKE_CARD_EN;
            case "RU" -> TAKE_CARD_RU;
            default -> TAKE_CARD_EN;
        };
    }

    public static String getTAKE_BAD_CARD(String language){
        return switch (language) {
            case "LT" -> TAKE_CARD_BAD_LT;
            case "EN" -> TAKE_CARD_BAD_EN;
            case "RU" -> TAKE_CARD_BAD_RU;
            default -> TAKE_CARD_BAD_EN;
        };
    }

    public static String getENTER_VALUE(String language){
        return switch (language) {
            case "LT" -> ENTER_VALUE_LT;
            case "EN" -> ENTER_VALUE_EN;
            case "RU" -> ENTER_VALUE_RU;
            default -> ENTER_VALUE_EN;
        };
    }

    public static String getCHECK_ACCOUNT(String language){
        return switch (language) {
            case "LT" -> CHECH_ACCOUNT_LT;
            case "EN" -> CHECK_ACCOUNT_EN;
            case "RU" -> CHECK_ACCOUNT_RU;
            default -> CHECK_ACCOUNT_EN;
        };
    }

    public static String getTAKE_MONEY(String language){
        return switch (language) {
            case "LT" -> TAKE_MONEY_LT;
            case "EN" -> TAKE_MONEY_EN;
            case "RU" -> TAKE_MONEY_RU;
            default -> TAKE_MONEY_EN;
        };
    }
    public static String getBAD_PIN(String language){
        return switch (language) {
            case "LT" -> BAD_PIN_LT;
            case "EN" -> BAD_PIN_EN;
            case "RU" -> BAD_PIN_RU;
            default -> BAD_PIN_EN;
        };
    }

    public static String getNO_CHECK(String language){
        return switch (language) {
            case "LT" -> NO_CECQUE_LT;
            case "EN" -> NO_CECQUE_EN;
            case "RU" -> NO_CECQUE_RU;
            default -> NO_CECQUE_EN;
        };
    }

    public static String getPRINT_CHECK(String language){
        return switch (language) {
            case "LT" -> PRINT_CECQUE_LT;
            case "EN" -> PRINT_CECQUE_EN;
            case "RU" -> PRINT_CECQUE_RU;
            default -> PRINT_CECQUE_EN;
        };
    }

    public static String getNO_MONEY_ON_ACCOUNT(String language){
        return switch (language) {
            case "LT" -> NO_MONEY_ON_ACCOUNT_LT;
            case "EN" -> NO_MONEY_ON_ACCOUNT_EN;
            case "RU" -> NO_MONEY_ON_ACCOUNT_RU;
            default -> NO_MONEY_ON_ACCOUNT_EN;
        };
    }
}
