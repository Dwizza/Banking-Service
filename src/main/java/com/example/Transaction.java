package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private int amount;
    private String date;
//    private int balance;

    public Transaction(int amount ){
        this.amount = amount;
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    //        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }


    public String getDate() {
        return date;
    }

//    public int getBalance(){
//        return balance;
//    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount= " + amount +
                ", date= " + date +
//                ", balance= " + balance +
                '}';
    }
}
