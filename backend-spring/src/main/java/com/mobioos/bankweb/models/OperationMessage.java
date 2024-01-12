package com.mobioos.bankweb.models;

public class OperationMessage {
    private static String OK_STATUS = "ok";
    private static String KO_STATUS = "ko";
    private String status;
    private String title;
    private String message;
    private double balance;

    public static OperationMessage createOkMessage(double balance) {
        return new OperationMessage(OperationMessage.OK_STATUS, "", "", balance);
    }

    public static OperationMessage createKoMessage(String title, String message, double balance) {
        return new OperationMessage(OperationMessage.KO_STATUS, title, message, balance);
    }

    private OperationMessage(String status, String title, String message, double balance) {
        this.status = status;
        this.title = title;
        this.message = message;
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public double getBalance() {
        return balance;
    }
}