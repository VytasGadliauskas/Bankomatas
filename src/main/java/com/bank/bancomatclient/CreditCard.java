package com.bank.bancomatclient;

import java.util.HashMap;

public class CreditCard {
    // naudoju HashMap<String,String>, kad butu galima sudeti daugiau informacijos
    // paskui ji naudoju siuntimui i serveri
    private static HashMap<String, String> card = new HashMap();
    public static void setSessionID(String id) {card.put("SESSIONID", id);}
    public static void setLanguage(String language) {card.put("LANGUAGE", language);}
    public static void setCardNumber(String number) {card.put("NUMBER", number);}
    public static void setCommand(String command) {card.put("COMMAND", command);}
    public static void setHwID() {card.put("HWID", HardwareInterface.getHardwareId());}
    public static void setCardPin(String valid) {
        card.put("VALID", valid);
    }
    public static String getSessionId(){
        return card.get("SESSIONID");
    }
    public static String getHwID(){return card.get("HWID");}
    public static String getCardNumber(){
        return card.get("NUMBER");
    }
    public static String getCardValid(){
        return card.get("VALID");
    }
    public static String getLanguage(){
        return card.get("LANGUAGE");
    }
    public static String getCommand(){
        return card.get("COMMAND");
    }
    public static void Clear() {
        card.clear();
    }
    public static HashMap<String, String> getCard() {
        return card;
    }
}
