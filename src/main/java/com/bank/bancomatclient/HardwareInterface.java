package com.bank.bancomatclient;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public static String getCreditCardNumber() throws IOException {
        Path path = Paths.get("/sys/devices/pci0000:00/0000:00:14.0/usb3/3-9/serial");
        String content = "";
        if(path.toFile().isFile()){
            content = Files.readString(path);
            System.out.println(" USB serial number " +content);
        }
        return content;
    }

    public static void giveMoney() throws IOException {
        File money = new File("src/main/resources/MoneyDoor/money.txt");
        // Laikina pinigu isdavimo durelese imitacija tiesiog sukuriam faila
        money.createNewFile();
    }


     public static boolean isMoneyTaken() throws FileNotFoundException {
         File money = new File("src/main/resources/MoneyDoor/money.txt");
         if (money.exists()) {
             // Laikina pinigu isdavimo durelese imitacija jei failas egzistuoja yra jei ne pasiimti
             return true;
         }
         return false;
    }

    public static int minusMoney(int moneyToTake){
        if (cachInMacine-moneyToTake >= 0) {
            return cachInMacine-moneyToTake;
        } else {
            return -1;
        }
    }
}
