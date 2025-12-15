package com.example;

import com.example.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account  {

    private final List<Transaction> transactions = new ArrayList<>();

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
//        System.out.println(transactions);
        transactions.add(new Transaction(amount));
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }

        int balance = calculateBalance();
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        transactions.add(new Transaction(-amount));
    }

    public void printStatement() {
        System.out.println("DATE       | AMOUNT | BALANCE");
        Collections.reverse(transactions);

        int totalBalance = 0;
        for (Transaction t : transactions) {
            totalBalance += t.getAmount();
        }
//        System.out.println(totalBalance);
        for (Transaction t : transactions) {
            System.out.println(t.getDate() + " | " + t.getAmount() + "   | " + totalBalance);
            totalBalance -= t.getAmount();
        }
    }

    private int calculateBalance() {
        int balance = 0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }
}
