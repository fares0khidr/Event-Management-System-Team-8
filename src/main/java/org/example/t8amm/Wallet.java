package org.example.t8amm;

public class Wallet {
    private static double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public static boolean deduct(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public static void add(double amount) {
        balance += amount;
    }
}
