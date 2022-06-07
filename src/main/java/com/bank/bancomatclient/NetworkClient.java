package com.bank.bancomatclient;


import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NetworkClient {
    private Socket clientSocket;
    private DataOutputStream dos;
    DataInputStream dis;

    private String ip;
    private int port;

    public NetworkClient() {
        HashMap<String, String> config = ReadConfig.getConfig();
        ip = config.get("SERVER");
        port = Integer.parseInt(config.get("PORT"));
    }

    public String serverConnectResponce(String msg) {
        String serverResponse = "";
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("Connecton to server ... "+clientSocket.isConnected());
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());
            CreditCard.setCommand(msg);
            ObjectMapper mapper = new ObjectMapper();
            String cardJson = mapper.writeValueAsString(CreditCard.getCard());
            if(clientSocket.isConnected()) {
                dos.writeUTF(cardJson);
                System.out.println("JSON sended to server, waiting for responce ...");
            } else {
                System.out.println("Connecton to server lost");
            }
            serverResponse = dis.readUTF();
        } catch (IOException e) {
            System.out.println("Connecton to server error " + e.getMessage());
        }

        try {
            dis.close();
            dos.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return serverResponse;
    }
}

