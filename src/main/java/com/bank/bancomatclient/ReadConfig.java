package com.bank.bancomatclient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadConfig {
    private final static String configFile = "src/main/java/com/bank/bancomatclient/configuration.conf";

    public static HashMap<String, String> getConfig() {
        BufferedReader reader;
        HashMap<String,String> configMap = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(configFile));
            String line = reader.readLine();
            while (line != null) {
                if(!"#".equals(line.substring(0,1))){
                    String[] lineSplit = line.split("=");
                    configMap.put(lineSplit[0],lineSplit[1]);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configMap;
    }
}
