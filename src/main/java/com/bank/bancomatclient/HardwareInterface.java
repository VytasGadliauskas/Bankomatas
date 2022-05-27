package com.bank.bancomatclient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  Klase imituojanti rysi su banko masina
 *  1. emuliuoja korteles idejima/isemima
 *  2. emuliuoja pinigu isdavima
 *  3. emuliuoja pasilikusiu pinigu informacija
 *  4. emuliuoja masinos hardwarini id
 */
public class HardwareInterface {
    private final static String hardwareId = "HW0000001";
    private static int cachInMacine = 1000;

    public static int getCachInMacine() {
        return cachInMacine;
    }

    public static String getHardwareId() {
        return hardwareId;
    }

    public static boolean insertCreditCard() throws FileNotFoundException {
        File cereditCard = new File("src/main/resources/BankomatCardEntry/creditcard.txt");
        if (cereditCard.exists()) {
            Scanner card = new Scanner(cereditCard);
            CreditCard.setCardNumber(card.nextLine());
            card.close();
            System.out.println("Press any key");
            Scanner scanner = new Scanner(System.in);
            String resp = scanner.nextLine();
            scanner.close();
            return true;
        }
        return false;
    }

    public static boolean takeCreditCard() {
            System.out.println("Press any key");
            Scanner scanner = new Scanner(System.in);
            String resp = scanner.nextLine();
            scanner.close();
            return true;
    }

    public static boolean takeMoney() {
        System.out.println("Press any key");
        Scanner scanner = new Scanner(System.in);
        String resp = scanner.nextLine();
        scanner.close();
        return true;
    }

    public static String minusMoney(int moneyToTake){
        if (cachInMacine-moneyToTake <= 0) {
            return "DONE";
        } else {
            return "NOTMONEY";
        }
    }
}
