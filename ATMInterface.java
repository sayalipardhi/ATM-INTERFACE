package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {

    static Scanner sc = new Scanner(System.in);
    static double balance = 1000.0;
    static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        // LOGIN DETAILS 
        String userId = "SayaliPardhi";
        int userPin = 1627;

        System.out.println("===== LOGIN TO ATM =====");

        System.out.print("Enter User ID: ");
        String inputId = sc.next();

        System.out.print("Enter PIN: ");
        int inputPin = sc.nextInt();

        if (!inputId.equals(userId) || inputPin != userPin) {
            System.out.println("Invalid Login! Exiting...");
            return;
        }

        System.out.println("\n===== WELCOME TO ATM =====");

        while (true) {
            System.out.println("\n1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showTransactionHistory();
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wAmt = sc.nextDouble();
                    withdraw(wAmt);
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double dAmt = sc.nextDouble();
                    deposit(dAmt);
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter receiver name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double tAmt = sc.nextDouble();
                    transfer(name, tAmt);
                    break;

                case 5:
                    System.out.println("\nThank you for using ATM!");
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    public static void showTransactionHistory() {
        System.out.println("\n===== TRANSACTION HISTORY =====");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public static void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdraw: -" + amount);
            System.out.println("Withdraw successful. Current balance: " + balance);
        }
    }

    public static void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public static void transfer(String receiver, double amount) {
        if (amount > balance) {
            System.out.println("Transfer failed! Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add("Transfer to " + receiver + ": -" + amount);
            System.out.println("Transferred " + amount + " to " + receiver);
            System.out.println("Current balance: " + balance);
        }
    }
}
