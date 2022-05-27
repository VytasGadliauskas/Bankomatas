package com.bank.bancomatclient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class NetworkClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String ip;
    private int port;

    public NetworkClient() {
        HashMap<String,String> config = ReadConfig.getConfig();
        this.ip = config.get("SERVER");
        this.port = Integer.parseInt(config.get("PORT"));
    }

    public boolean startConnection() {
        try {
            clientSocket = new Socket(this.ip, this.port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            return true;
        } catch (IOException e) {
            System.out.println("Connecton to server error "+e.getMessage());
            return false;
        }
    }

    public String sendMessage(String msg) {
       // JSONObject json =  new JSONObject(CreditCard.getCard());
        out.println(msg);
        String resp = null;
        try {
            resp = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resp;
    }

    public void stopConnection() {
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.close();
        try {
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

