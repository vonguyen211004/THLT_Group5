package org.o7planning.financemanagement;

public class Transaction {
    private String name;
    private String date;
    private double amount;

    public Transaction(String name, String date, double amount) {
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}